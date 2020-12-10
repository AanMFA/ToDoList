package com.example.todolist.modul.edittask;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;


public class EditTaskActivity extends BaseFragmentHolderActivity {
    EditTaskFragment editTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        editTaskFragment = new EditTaskFragment();
        String id = getIntent().getExtras().getString("TaskId");
        editTaskFragment.setId(id);
        setCurrentFragment(editTaskFragment, false);

    }
}
