package com.example.todolist.modul.newtask;


import com.example.todolist.data.local.TableHandler;
import com.example.todolist.data.model.Task;
import com.example.todolist.data.source.SessionRepository;

/**
 * Created by fahrul on 13/03/19.
 */

public class NewTaskPresenter implements NewTaskContract.Presenter{
    private final NewTaskContract.View view;                                         //new
    private final TableHandler tableHandler;

    public NewTaskPresenter(NewTaskContract.View view, TableHandler tableHandler) {           //add
        this.view = view;
        this.tableHandler = tableHandler;
    }
    @Override
    public void start() {}

    @Override
    public void saveData(final String title, final String description){
        Task newTask = new Task("3", title, description);
        //save new task
        tableHandler.create(newTask);
        //then go back to task list
        view.redirectToTaskList();
    }

}
