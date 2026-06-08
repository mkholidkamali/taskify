package com.taskify.domain;

public class PersonalTask extends Task {

    private String category;

    public PersonalTask(int id, String title, String category) {
        super(id, title);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String showDetail() {
        return "[Personal] " + title + " (" + category + ")" + (isDone ? " - DONE" : "");
    }
}
