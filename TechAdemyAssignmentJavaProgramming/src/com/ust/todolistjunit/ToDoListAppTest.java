package com.ust.todolistjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ust.assignment1.taskmanagement.ToDoListApp;
 

 
public class ToDoListAppTest {
 
	@BeforeEach
	public void setUp() {
		// Clear tasks before each test case
		ToDoListApp.tasks.clear();
	}
 
	@Test
	public void testAddTask() {
		ToDoListApp.addTask("Buy groceries");
		ToDoListApp.addTask("Complete homework");
 
		// Validate the tasks were added correctly
		assertEquals(2, ToDoListApp.tasks.size());
		assertEquals("Buy groceries", ToDoListApp.tasks.get(0));
		assertEquals("Complete homework", ToDoListApp.tasks.get(1));
	}
 
	@Test
	public void testRemoveTaskByIndex_ValidIndex() {
		ToDoListApp.addTask("Buy groceries");
		ToDoListApp.addTask("Complete homework");
 
		// Remove first task
		ToDoListApp.removeTaskByIndex(0);
 
		// Validate the first task was removed
		assertEquals(1, ToDoListApp.tasks.size());
		assertEquals("Complete homework", ToDoListApp.tasks.get(0));
	}
 
	@Test
	public void testRemoveTaskByIndex_InvalidIndex() {
		ToDoListApp.addTask("Buy groceries");
 
		// Try to remove a task with an invalid index
		ToDoListApp.removeTaskByIndex(10);
 
		// Validate that task list is unaffected
		assertEquals(1, ToDoListApp.tasks.size());
	}
 
	@Test
	public void testViewTasks_EmptyList() {
		// Call viewTasks when list is empty
		ToDoListApp.viewTasks();
 
		// Validate that the list is empty
		assertTrue(ToDoListApp.tasks.isEmpty());
	}
 
	@Test
	public void testViewTasks_WithTasks() {
		ToDoListApp.addTask("Buy groceries");
		ToDoListApp.addTask("Complete homework");
 
		// Call viewTasks when there are tasks
		ToDoListApp.viewTasks();
 
		// Validate that tasks are in the correct order
		List<String> expectedTasks = List.of("Buy groceries", "Complete homework");
		assertEquals(expectedTasks, ToDoListApp.tasks);
	}
}