package com.example.todolist.modul.detailTask;


import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public interface DetailTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
        void redirectToEditList();
        void showData(Task task);
        void setId(String id);
        void shareTaskToAnotherDevice(Task task);
    }

    interface Presenter extends BasePresenter {
        void loadData(String id);
        void deleteData(String id);
        void shareTaskOnline(String userEmail, String id);
        void shareTaskToAnotherDevice(String id);
    }
}
