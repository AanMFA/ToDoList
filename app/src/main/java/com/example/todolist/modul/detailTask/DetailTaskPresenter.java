package com.example.todolist.modul.detailTask;


import com.example.todolist.data.local.TableHandler;
import com.example.todolist.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public class DetailTaskPresenter implements DetailTaskContract.Presenter{
    private final DetailTaskContract.View view;
    private final TableHandler tableHandler;
    Task task;

    public DetailTaskPresenter(DetailTaskContract.View view, TableHandler tableHandler) {
        this.view = view;
        this.tableHandler = tableHandler;
    }

    @Override
    public void start() {
    }

    @Override
    public void loadData(String id) {
        //load data task by id
        //then send data to fragment
        task = (Task) tableHandler.readById(id);
        view.showData(task);
        view.showData(task);
    }

    @Override
    public void deleteData(String id) {
        tableHandler.delete(tableHandler.readById(id));
        view.redirectToTaskList();
    }
}
