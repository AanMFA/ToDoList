package com.example.todolist.modul.edittask;


import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public interface EditTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToDetailTask();
        void showData(Task task);
        void setId(String id);
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
        void loadData(String id);
    }
}
