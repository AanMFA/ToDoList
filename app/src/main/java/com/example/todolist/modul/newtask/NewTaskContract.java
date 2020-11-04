package com.example.todolist.modul.newtask;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface NewTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
    }
}
