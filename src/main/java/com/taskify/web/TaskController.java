package com.taskify.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taskify.domain.Task;
import com.taskify.service.TaskManager;

@Controller
public class TaskController {

    private final TaskManager taskManager;

    public TaskController(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Task> tasks = taskManager.findAll();
        model.addAttribute("tasks", tasks);
        return "list";
    }
}
