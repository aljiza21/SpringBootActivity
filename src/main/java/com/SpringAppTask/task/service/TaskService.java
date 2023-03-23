package com.SpringAppTask.task.service;

import java.util.List;
import com.SpringAppTask.task.model.Task;

public interface TaskService {
    List<Task> getAllTasks();
    void saveTasks(Task task);
    Task getTaskById(long id);
    void deleteTaskById(long id);
}
