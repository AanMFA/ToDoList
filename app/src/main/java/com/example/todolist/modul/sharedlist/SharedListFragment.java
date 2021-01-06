package com.example.todolist.modul.sharedlist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.data.model.RequestTask;
import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.RequestTaskRepository;
import com.example.todolist.modul.detailsharedtask.DetailSharedTaskActivity;
import com.example.todolist.utils.RecyclerViewAdapterTodolist;

import java.util.ArrayList;

public class SharedListFragment extends BaseFragment<SharedListActivity, SharedListContract.Presenter> implements SharedListContract.View{
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_shared_list, container, false);
        mPresenter = new SharedListPresenter(this, new RequestTaskRepository(getActivity()));
        initializeRecylerView();
        mPresenter.start();
        setTitle("Shared Todo");

        return fragmentView;
    }

    private void initializeRecylerView(){
        ArrayList<Task> data = new ArrayList<>();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewSharedlist);
        RecyclerViewAdapterTodolist mAdapter = new RecyclerViewAdapterTodolist(data);
        mRecyclerView.setAdapter(mAdapter);
        ((RecyclerViewAdapterTodolist) mAdapter).setOnItemClickListener(new RecyclerViewAdapterTodolist.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d("BELAJAR ACTIVITY",">>>>>"+ position);
                goToTaskDetail(position);
            }
        });
        mRecyclerView = fragmentView.findViewById(R.id.recyclerViewSharedlist);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void goToTaskDetail(int indeks) {
        Intent intent = new Intent(activity, DetailSharedTaskActivity.class);
        intent.putExtra("Task Indeks", indeks);
        startActivity(intent);
    }

    @Override
    public void updateList(ArrayList<RequestTask> taskDataset){
        final ArrayList<Task> data = (ArrayList<Task>) ((ArrayList<?>)taskDataset);
        RecyclerViewAdapterTodolist recyclerAdapter = (RecyclerViewAdapterTodolist)mRecyclerView.getAdapter();

        recyclerAdapter.setmDataset(data);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void setPresenter(SharedListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
