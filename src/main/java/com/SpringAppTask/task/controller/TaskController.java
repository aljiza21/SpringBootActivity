package com.SpringAppTask.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringAppTask.task.model.Task;
import com.SpringAppTask.task.service.TaskService;

@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("task", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/showTaskForm")
	public String showTaskForm(Model model) {
		// create model attribute to bind form data
		Task task = new Task();
		model.addAttribute("task", task);
		return "new_task";
	}

    @PostMapping("/saveTask")
    public String saveTasks(@ModelAttribute("task") Task task){
       taskService.saveTasks(task);
       return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Task task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "update_task";
	}
   
    @GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value = "id") long id) {
		this.taskService.deleteTaskById(id);
		return "redirect:/";
	}

}
