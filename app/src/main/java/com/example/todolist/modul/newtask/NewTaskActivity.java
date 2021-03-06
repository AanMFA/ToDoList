package com.example.todolist.modul.newtask;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class NewTaskActivity extends BaseFragmentHolderActivity {
    NewTaskFragment newTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        overflowMenu.setVisibility(View.GONE);

        newTaskFragment = new NewTaskFragment();
        setCurrentFragment(newTaskFragment, false);
    }
}
