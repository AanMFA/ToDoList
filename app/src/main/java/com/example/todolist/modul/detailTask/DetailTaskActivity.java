package com.example.todolist.modul.detailTask;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class DetailTaskActivity extends BaseFragmentHolderActivity {
    DetailTaskFragment detailTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        detailTaskFragment = new DetailTaskFragment();
        String id = getIntent().getExtras().getString("TaskId");
        detailTaskFragment.setId(id);
        setCurrentFragment(detailTaskFragment, false);

    }




}
