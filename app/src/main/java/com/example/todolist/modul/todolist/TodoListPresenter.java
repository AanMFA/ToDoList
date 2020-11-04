package com.example.todolist.modul.todolist;

import com.example.todolist.data.model.Task;

import java.util.ArrayList;


/**
 * Created by fahrul on 13/03/19.
 */

public class TodoListPresenter implements TodoListContract.Presenter{
    private final TodoListContract.View view;



    public TodoListPresenter(TodoListContract.View view) {
        this.view = view;
    }
    @Override
    public void start() {}

    @Override
    public ArrayList<Task> getDataSet() {
        //get Data from DB
        ArrayList<Task> data = new ArrayList<Task>();
        data.add(new Task("1","Task 1", "Kerjakan task satu"));
        data.add(new Task("2", "Task 2", "Kerjakan task dua"));
        return data;
    }

}
