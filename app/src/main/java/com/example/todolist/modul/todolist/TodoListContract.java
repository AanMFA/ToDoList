package com.example.todolist.modul.todolist;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.Task;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public interface TodoListContract {
    interface View extends BaseView<Presenter> {
        void goToNewTask();
        void goToTaskDetail(String id);
        void goToSharedList();
        void goToLogin();
    }

    interface Presenter extends BasePresenter {
        ArrayList<Task> getDataSet();
        void logout(GoogleSignInClient mGoogleSignInClient);
    }
}
