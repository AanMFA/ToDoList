package com.example.todolist.data.model;

public class RequestTask extends Task{
    private String senderEmail;

    public RequestTask(Task task, String senderEmail) {
        super(task.getId(), task.getTitle(), task.getDescription(), task.isChecked());
        this.senderEmail = senderEmail;
    }

    public RequestTask(){
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}
