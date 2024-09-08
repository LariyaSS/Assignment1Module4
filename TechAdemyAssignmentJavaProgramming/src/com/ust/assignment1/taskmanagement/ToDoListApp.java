package com.ust.assignment1.taskmanagement;
import java.util.ArrayList;
import java.util.List;


public class ToDoListApp {

	public static List<String> tasks = new ArrayList<>();
	 
	// Method to add a task
	public static void addTask(String task) {
		tasks.add(task);
		System.out.println("Task added successfully.");
	}
 
	// Method to remove a task by index
	public static void removeTaskByIndex(int index) {
		if (index < 0 || index >= tasks.size()) {
			System.out.println("Invalid task index.");
		} else {
			tasks.remove(index);
			System.out.println("Task removed successfully.");
		}
	}
 
	// Method to view all tasks
	public static void viewTasks() {
		if (tasks.isEmpty()) {
			System.out.println("To-do list is empty.");
		} else {
			System.out.println("Your to-do list:");
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println((i + 1) + ". " + tasks.get(i));
			}
		}
	}
 
	public static void main(String[] args) {
		// Example usage of the app
		addTask("Buy groceries");
		addTask("Complete homework");
		viewTasks();
		removeTaskByIndex(0);
		viewTasks();
	}
}