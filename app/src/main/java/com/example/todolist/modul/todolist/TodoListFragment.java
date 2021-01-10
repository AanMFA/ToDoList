package com.example.todolist.modul.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.data.local.TaskTableHandler;
import com.example.todolist.data.model.Task;
import com.example.todolist.modul.detailTask.DetailTaskActivity;
import com.example.todolist.modul.newtask.NewTaskActivity;
import com.example.todolist.modul.sharedlist.SharedListActivity;
import com.example.todolist.utils.RecyclerViewAdapterTodolist;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public class TodoListFragment extends BaseFragment<TodoListActivity, TodoListContract.Presenter> implements TodoListContract.View {
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FloatingActionButton buttonAdd;

    public TodoListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        mPresenter = new TodoListPresenter(this, new TaskTableHandler(getActivity()));
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewTodolist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        refreshList();
        mRecyclerView.setAdapter(mAdapter);
        setTitle("Todo List");

        buttonAdd = fragmentView.findViewById(R.id.btAddToDo);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNewTask();
            }
        });
        setBtShareOnClick();
        bindMenuButtonListener();

        return fragmentView;
    }

    private void setBtShareOnClick() {
        FloatingActionButton button = fragmentView.findViewById(R.id.btSharedWithYou);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSharedList();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshList();
    }

    private void refreshList(){
        final ArrayList<Task> data = mPresenter.getDataSet();

        mAdapter = new RecyclerViewAdapterTodolist(data);
        mRecyclerView.setAdapter(mAdapter);
        ((RecyclerViewAdapterTodolist) mAdapter).setOnItemClickListener(new RecyclerViewAdapterTodolist.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String id = data.get(position).getId();
                Log.d("BELAJAR ACTIVITY",">>>>>"+ position);
                goToTaskDetail(id);
            }
        });
    }

    @Override
    public void setPresenter(TodoListContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void goToNewTask() {
        Intent intent = new Intent(activity, NewTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToTaskDetail(String id) {
        Intent intent = new Intent(activity, DetailTaskActivity.class);
        intent.putExtra("TaskId", id);
        startActivity(intent);
    }

    @Override
    public void goToSharedList(){
        Intent intent = new Intent(activity, SharedListActivity.class);
        startActivity(intent);
    }

    private void bindMenuButtonListener() {
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        };

        activity.setMenuOnClick(onclick);
    }

    private void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);

        popupMenu.getMenuInflater().inflate(R.menu.todolist_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                menuAction(menuItem.getItemId());
                return false;
            }
        });
        popupMenu.show();
    }

    private void menuAction(int viewId){
        switch (viewId){
            case R.id.sharedTask:
                goToSharedList();
                break;
            default:
                break;
        }
    }
}
