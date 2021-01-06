package com.example.todolist.data.source;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.todolist.data.model.RequestTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class RequestTaskRepository implements SessionRepository<ArrayList<RequestTask>> {
    private static String SESSION_TASK = "SessionTask";
    private SharedPreferences sharedPref;

    public RequestTaskRepository(Context context) {
        sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public ArrayList<RequestTask> initialize(ArrayList<RequestTask> sessionData) {
        //save to shared preference
        setSessionData(sessionData);

        //load from shared preference
        return getSessionData();
    }

    @Override
    public ArrayList<RequestTask> getSessionData() {
        String sessionDataJson = sharedPref.getString(SESSION_TASK, null);
        if (sessionDataJson != null) {
            return new Gson().fromJson(sessionDataJson, new TypeToken<ArrayList<RequestTask>>(){}.getType());
        }
        return null;
    }

    @Override
    public void setSessionData(ArrayList<RequestTask> sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        String jsonString = new Gson().toJson(sessionData);
        Log.d("Task Repository", jsonString);
        editor.putString(SESSION_TASK, jsonString);
        editor.apply();
    }

    @Override
    public void destroy() {
        sharedPref.edit().clear().apply();
    }

    @Override
    public void update(ArrayList<RequestTask> sessionData) {
        destroy();
        setSessionData(sessionData);
    }
}
