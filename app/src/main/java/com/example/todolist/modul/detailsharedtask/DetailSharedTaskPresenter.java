package com.example.todolist.modul.detailsharedtask;

import com.example.todolist.data.model.RequestTask;
import com.example.todolist.data.source.RequestTaskRepository;

import java.util.ArrayList;

public class DetailSharedTaskPresenter implements DetailSharedTaskContract.Presenter {
    private final DetailSharedTaskContract.View view;
    private final RequestTaskRepository repository;

    public DetailSharedTaskPresenter(DetailSharedTaskContract.View view, RequestTaskRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadData(int indeks) {
        ArrayList<RequestTask> listTask = repository.getSessionData();
        RequestTask requestTask = listTask.get(indeks);

        view.showData(requestTask);
    }

    @Override
    public void start() {
    }
}
