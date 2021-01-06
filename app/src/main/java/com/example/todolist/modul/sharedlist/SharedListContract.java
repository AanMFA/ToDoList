package com.example.todolist.modul.sharedlist;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.RequestTask;

import java.util.ArrayList;

/**
 * Created by fahrul on 13/03/19.
 */

public interface SharedListContract {
    interface View extends BaseView<Presenter> {
        void goToTaskDetail(int indeks);
        void updateList(ArrayList<RequestTask> taskDataset);
    }

    interface Presenter extends BasePresenter {
        void refreshData();
    }
}
