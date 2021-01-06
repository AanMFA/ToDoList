package com.example.todolist.modul.sharedlist;

import com.example.todolist.data.firebase.SharedTaskDatabase;
import com.example.todolist.data.model.RequestTask;
import com.example.todolist.data.source.RequestTaskRepository;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class SharedListPresenter implements SharedListContract.Presenter{
    SharedListContract.View view;
    RequestTaskRepository repository;

    public SharedListPresenter(SharedListContract.View view, RequestTaskRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void refreshData() {
        SharedTaskDatabase.dbReference.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                ArrayList<RequestTask> listSharedTask = new ArrayList<RequestTask>();
                for(DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    listSharedTask.add(childSnapshot.getValue(RequestTask.class));
                }
                repository.initialize(listSharedTask);
                view.updateList(listSharedTask);
            }
        });
    }

    @Override
    public void start() {
        refreshData();
    }
}
