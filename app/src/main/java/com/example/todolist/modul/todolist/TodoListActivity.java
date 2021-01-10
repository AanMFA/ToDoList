package com.example.todolist.modul.todolist;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class TodoListActivity extends BaseFragmentHolderActivity {
    TodoListFragment todoListFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        overflowMenu.setVisibility(View.GONE);

        todoListFragment = new TodoListFragment();
        setCurrentFragment(todoListFragment, false);
    }



}
