package com.example.todolist.data.model;

import androidx.annotation.NonNull;

public class Task{
    private String id;
    private String title;
    private String description;
    private boolean isChecked;

    public Task(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Task(){

    }

    public Task(String id, String title, String description, boolean isChecked) {
        this(id, title, description);
        this.isChecked = isChecked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @NonNull
    @Override
    public String toString() {
        return "Todo List Task\n" +
                "Title : " + title + "\n" +
                "Description : " + description + "\n" +
                "Status : " + (isChecked ? "" : "not ") + "finished";
    }
}
