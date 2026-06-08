package com.taskify.domain;

public class ReminderTask extends Task implements Remindable {

    private String reminderTime;

    public ReminderTask(int id, String title, String reminderTime) {
        super(id, title);
        this.reminderTime = reminderTime;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    @Override
    public void setReminder(String time) {
        this.reminderTime = time;
    }

    @Override
    public String showDetail() {
        return "[Reminder] " + title + " (at " + reminderTime + ")" + (isDone ? " - DONE" : "");
    }
}
