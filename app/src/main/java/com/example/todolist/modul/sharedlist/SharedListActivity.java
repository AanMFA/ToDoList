package com.example.todolist.modul.sharedlist;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;

public class SharedListActivity extends BaseFragmentHolderActivity {
    SharedListFragment sharedListFragment;

    @Override
    protected void initializeFragment() {
        initializeView();
        overflowMenu.setVisibility(View.GONE);

        sharedListFragment = new SharedListFragment();
        setCurrentFragment(sharedListFragment, false);
    }
}
