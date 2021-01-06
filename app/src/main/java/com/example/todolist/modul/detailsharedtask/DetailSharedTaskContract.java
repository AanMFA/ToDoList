package com.example.todolist.modul.detailsharedtask;


import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.data.model.RequestTask;

/**
 * Created by fahrul on 13/03/19.
 */

public interface DetailSharedTaskContract {
    interface View extends BaseView<Presenter> {
        void showData(RequestTask task);
    }

    interface Presenter extends BasePresenter {
        void loadData(int indeks);
    }
}
