package com.taskify.domain;

public class WorkTask extends Task {

    private String deadline;

    public WorkTask(int id, String title, String deadline) {
        super(id, title);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String showDetail() {
        return "[Work] " + title + " (deadline: " + deadline + ")" + (isDone ? " - DONE" : "");
    }
}
