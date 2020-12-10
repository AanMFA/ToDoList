package com.example.todolist.data.source;

import android.content.SharedPreferences;

import com.example.todolist.data.model.Task;
import com.google.gson.Gson;

import java.util.ArrayList;

public class TaskRepository implements SessionRepository<ArrayList<Task>> {
    private static String SESSION_TASK = "SessionTask";
    private SharedPreferences sharedPref;

    @Override
    public ArrayList<Task> initialize(ArrayList<Task> sessionData) {
        //save to shared preference
        setSessionData(sessionData);

        //load from shared preference
        return getSessionData();
    }

    @Override
    public ArrayList<Task> getSessionData() {
        String sessionDataJson = sharedPref.getString(SESSION_TASK, null);
        if (sessionDataJson != null) {
            return new Gson().fromJson(sessionDataJson, new ArrayList<Task>().getClass());
        }
        return null;
    }

    @Override
    public void setSessionData(ArrayList<Task> sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SESSION_TASK, new Gson().toJson(sessionData));
        editor.apply();
    }

    @Override
    public void destroy() {
        sharedPref.edit().clear().apply();
    }

    @Override
    public void update(ArrayList<Task> sessionData) {
        destroy();
        setSessionData(sessionData);
    }
}
