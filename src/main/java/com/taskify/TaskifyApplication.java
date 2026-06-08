package com.taskify;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.taskify.domain.PersonalTask;
import com.taskify.domain.ReminderTask;
import com.taskify.domain.WorkTask;
import com.taskify.service.TaskManager;

@SpringBootApplication
public class TaskifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskifyApplication.class, args);
	}

	@Bean
	CommandLineRunner seedSampleTasks(TaskManager taskManager) {
		return args -> {
			taskManager.add(new PersonalTask(taskManager.nextId(), "Read OOP chapter 5", "Study"));
			taskManager.add(new WorkTask(taskManager.nextId(), "Submit Taskify proposal", "2026-06-15"));
			taskManager.add(new ReminderTask(taskManager.nextId(), "Take medicine", "09:00"));
		};
	}
}
