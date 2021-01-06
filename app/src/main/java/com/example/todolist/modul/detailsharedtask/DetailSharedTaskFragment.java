package com.example.todolist.modul.detailsharedtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todolist.R;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.data.model.RequestTask;
import com.example.todolist.data.source.RequestTaskRepository;

/**
 * Created by fahrul on 13/03/19.
 */

public class DetailSharedTaskFragment extends BaseFragment<DetailSharedTaskActivity, DetailSharedTaskContract.Presenter> implements DetailSharedTaskContract.View {
    private int indeks;

    public DetailSharedTaskFragment(int indeks) {
        indeks = this.indeks;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_shared_detail, container, false);
        mPresenter = new DetailSharedTaskPresenter(this, new RequestTaskRepository(getContext()));
        mPresenter.start();

        setTitle("Shared Task Detail");
        mPresenter.loadData(indeks);

        return fragmentView;
    }

    @Override
    public void setPresenter(DetailSharedTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showData(RequestTask task) {
        TextView title = (TextView) fragmentView.findViewById(R.id.tvSharedTitle);
        TextView description = (TextView) fragmentView.findViewById(R.id.tvSharedDescription);
        TextView writer = (TextView) fragmentView.findViewById(R.id.tvTaskWriter);

        title.setText(task.getTitle());;
        description.setText(task.getDescription());
        writer.setText(task.getSenderEmail());
    }
}
