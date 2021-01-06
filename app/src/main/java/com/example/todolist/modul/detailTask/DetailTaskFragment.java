package com.example.todolist.modul.detailTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.data.local.TaskTableHandler;
import com.example.todolist.data.model.Task;
import com.example.todolist.modul.edittask.EditTaskActivity;
import com.example.todolist.modul.todolist.TodoListActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * Created by fahrul on 13/03/19.
 */

public class DetailTaskFragment extends BaseFragment<DetailTaskActivity, DetailTaskContract.Presenter> implements DetailTaskContract.View {
    TextView tvTaskTitle;
    TextView tvTaskDescription;
    FloatingActionButton btEdit;
    String id;


    public DetailTaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);
        mPresenter = new DetailTaskPresenter(this, new TaskTableHandler(getActivity()));
        mPresenter.start();

        tvTaskTitle = fragmentView.findViewById(R.id.tvToDoTitle);
        tvTaskDescription = fragmentView.findViewById(R.id.tvTaskDescription);
        btEdit = fragmentView.findViewById(R.id.btEditToDo);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtEditClick();
            }
        });
        setBtDeleteClick();
        setBtShareClick();

        setTitle("Task Detail");
        mPresenter.loadData(this.id);

        return fragmentView;
    }

    private void setBtShareClick() {
        FloatingActionButton btShare = fragmentView.findViewById(R.id.btShareToDo);
        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.shareTask(account.getEmail(), id);
            }
        });

    }

    private void setBtDeleteClick() {
        FloatingActionButton btDelete = fragmentView.findViewById(R.id.btDeleteToDo);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.deleteData(id);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadData(this.id);
    }

    public void setBtEditClick(){
        redirectToEditList();
    }

    @Override
    public void setPresenter(DetailTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
            Intent intent = new Intent(activity, TodoListActivity.class);
            startActivity(intent);
            activity.finish();
    }

    @Override
    public void showData(Task task) {
        this.tvTaskTitle.setText(task.getTitle());
        this.tvTaskDescription.setText(task.getDescription());
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

    @Override
    public void redirectToEditList() {
        Intent intent = new Intent(activity, EditTaskActivity.class);
        intent.putExtra("TaskId", id);
        startActivity(intent);
    }


}
