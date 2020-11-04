package com.example.todolist.modul.detailTask;


import com.example.todolist.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public class DetailTaskPresenter implements DetailTaskContract.Presenter{
    private final DetailTaskContract.View view;

    public DetailTaskPresenter(DetailTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void loadData(String id) {
        //load data task by id
        //then send data to fragment
        Task task = new Task("3", "title of taskIndex:"+id, "description of taskIndex:"+id);
        view.showData(task);
    }

}
