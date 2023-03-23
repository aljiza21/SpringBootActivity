package com.SpringAppTask.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringAppTask.task.model.Task;
import com.SpringAppTask.task.repository.TaskRepository;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
	private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
	public void saveTasks(Task task) {
		this.taskRepository.save(task);
	}

    @Override
	public Task getTaskById(long id) {
		Optional<Task> optional = taskRepository.findById(id);
		Task task = null;
		if (optional.isPresent()) {
			task = optional.get();
		} else {
			throw new RuntimeException(" Task not found for id :: " + id);
		}
		return task;
	}

	@Override
	public void deleteTaskById(long id) {
		this.taskRepository.deleteById(id);
	}

}
