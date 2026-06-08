package com.taskify.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskify.domain.PersonalTask;
import com.taskify.domain.ReminderTask;
import com.taskify.domain.Task;
import com.taskify.domain.WorkTask;
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

    @GetMapping("/new")
    public String newForm() {
        return "new";
    }

    @PostMapping("/tasks")
    public String create(
            @RequestParam String type,
            @RequestParam String title,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String deadline,
            @RequestParam(required = false) String reminderTime) {

        int id = taskManager.nextId();
        Task task = switch (type) {
            case "work" -> new WorkTask(id, title, deadline);
            case "reminder" -> new ReminderTask(id, title, reminderTime);
            default -> new PersonalTask(id, title, category);
        };
        taskManager.add(task);
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/delete")
    public String delete(@PathVariable int id) {
        taskManager.remove(id);
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/done")
    public String markDone(@PathVariable int id) {
        taskManager.markDone(id);
        return "redirect:/";
    }
}
