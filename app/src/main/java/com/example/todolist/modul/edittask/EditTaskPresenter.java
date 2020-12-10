package com.example.todolist.modul.edittask;


import com.example.todolist.data.local.TableHandler;
import com.example.todolist.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public class EditTaskPresenter implements EditTaskContract.Presenter{
    private final EditTaskContract.View view;
    private final TableHandler tableHandler;
    Task editedTask;

    public EditTaskPresenter(EditTaskContract.View view, TableHandler tableHandler) {
        this.view = view;
        this.tableHandler = tableHandler;
    }

    @Override
    public void start() {
    }

    @Override
    public void saveData(final String title, final String description){
        editedTask.setTitle(title);
        editedTask.setDescription(description);

        tableHandler.update(editedTask);
        //then go back to task list
        view.redirectToDetailTask();
    }

    @Override
    public void loadData(String id) {
        //load data task by id
        //then send data to fragment

        editedTask = (Task) tableHandler.readById(id);
        view.showData(editedTask);
    }

}
