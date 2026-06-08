package com.taskify.domain;

public abstract class Task {

    protected int id;
    protected String title;
    protected boolean isDone;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return isDone;
    }

    public abstract String showDetail();
}
