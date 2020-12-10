package com.example.todolist.modul.todolist;

import com.example.todolist.data.local.TableHandler;
import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.SessionRepository;

import java.util.ArrayList;


/**
 * Created by fahrul on 13/03/19.
 */

public class TodoListPresenter implements TodoListContract.Presenter{
    private final TodoListContract.View view;                                           //new
    private final TableHandler tableHandler;

    public TodoListPresenter(TodoListContract.View view, TableHandler tableHandler) {           //add
        this.view = view;
        this.tableHandler = tableHandler;
    }

    @Override
    public void start() {}

    @Override
    public ArrayList<Task> getDataSet() {
        //get Data from DB
        ArrayList<Task> data = tableHandler.readAll();
        return data;
    }

}
