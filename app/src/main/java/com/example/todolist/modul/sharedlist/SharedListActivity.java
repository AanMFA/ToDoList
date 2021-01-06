package com.example.todolist.modul.sharedlist;

import android.view.View;

import com.example.todolist.base.BaseFragmentHolderActivity;

public class SharedListActivity extends BaseFragmentHolderActivity {
    SharedListFragment sharedListFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        sharedListFragment = new SharedListFragment();
        setCurrentFragment(sharedListFragment, false);
    }
}
