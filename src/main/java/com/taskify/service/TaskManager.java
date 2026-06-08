package com.taskify.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskify.domain.Task;

@Service
public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public int nextId() {
        return nextId++;
    }

    public Task add(Task task) {
        tasks.add(task);
        return task;
    }

    public void remove(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }

    public void markDone(int id) {
        findById(id).ifPresent(Task::markDone);
    }

    public List<Task> findAll() {
        return List.copyOf(tasks);
    }

    public List<Task> filter(String status) {
        if ("done".equalsIgnoreCase(status)) {
            return tasks.stream().filter(Task::isDone).toList();
        }
        if ("pending".equalsIgnoreCase(status)) {
            return tasks.stream().filter(t -> !t.isDone()).toList();
        }
        return findAll();
    }

    public Optional<Task> findById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }
}
