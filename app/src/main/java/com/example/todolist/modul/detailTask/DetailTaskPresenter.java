package com.example.todolist.modul.detailTask;


import android.util.Log;

import com.example.todolist.data.firebase.SharedTaskDatabase;
import com.example.todolist.data.local.TableHandler;
import com.example.todolist.data.model.RequestTask;
import com.example.todolist.data.model.Task;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by fahrul on 13/03/19.
 */

public class DetailTaskPresenter implements DetailTaskContract.Presenter{
    private final DetailTaskContract.View view;
    private final TableHandler tableHandler;

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
        Task task = (Task) tableHandler.readById(id);
        view.showData(task);
    }

    @Override
    public void deleteData(String id) {
        tableHandler.delete(tableHandler.readById(id));
        view.redirectToTaskList();
    }

    @Override
    public void shareTask(String userEmail, String id) {
        Task task = (Task) tableHandler.readById(id);
        final RequestTask sentTask = new RequestTask(task, userEmail);

        SharedTaskDatabase.dbReference
                .push()
                .setValue(task)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Firebase", "share task" + sentTask.isChecked());
                    }
                });
    }
}
