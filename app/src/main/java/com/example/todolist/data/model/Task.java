package com.example.todolist.data.model;

import com.example.todolist.base.BaseModel;

public class Task extends BaseModel {
    private String id;
    private String title;
    private String description;
    private boolean isChecked;

    public Task(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
}
