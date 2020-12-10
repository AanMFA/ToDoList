package com.example.todolist.modul.newtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.data.local.TaskTableHandler;
import com.example.todolist.modul.todolist.TodoListActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * Created by fahrul on 13/03/19.
 */

public class NewTaskFragment extends BaseFragment<NewTaskActivity, NewTaskContract.Presenter> implements NewTaskContract.View {

    EditText etTaskTitle;
    EditText etTaskDescription;
    FloatingActionButton btnSave;


    public NewTaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_edit, container, false);
        mPresenter = new NewTaskPresenter(this, new TaskTableHandler(getActivity()));
        mPresenter.start();

        etTaskTitle = fragmentView.findViewById(R.id.etTaskTitle);
        etTaskDescription = fragmentView.findViewById(R.id.etTaskDescription);
        btnSave = fragmentView.findViewById(R.id.btSaveToDo);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtSaveClick();
            }
        });

        setTitle("Add New Task");

        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = etTaskTitle.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(NewTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
            Intent intent = new Intent(activity, TodoListActivity.class);
            startActivity(intent);
            activity.finish();
    }


}
