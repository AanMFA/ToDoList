package com.example.todolist.modul.detailsharedtask;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class DetailSharedTaskActivity extends BaseFragmentHolderActivity {
    DetailSharedTaskFragment detailSharedTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();
        overflowMenu.setVisibility(View.GONE);

        int indeks = getIntent().getExtras().getInt("Task Indeks");
        detailSharedTaskFragment = new DetailSharedTaskFragment(indeks);
        setCurrentFragment(detailSharedTaskFragment, false);
    }
}
