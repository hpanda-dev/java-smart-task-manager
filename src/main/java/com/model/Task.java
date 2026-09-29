/**
 * Copyright (c) 2026 Hrushikesh Panda.
 *
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

/**
 *
 *  Task Management System
 * 1. Create a Task with user specific inputs
 * 2. Validates it, if valid task is created and data is stored
 * 3. if not valid, it will throw error why it is not valid
 * 4. Display all the tasks
 *
 */
public class Task {

    private int taskID;
    private String taskTitle;
    private String taskPriority;
    private TaskStatus status ;
    private User user;

    /**
     *
     * Creates a TASK with the required details
     *
     * @param taskID  unique id to represent the task
     * @param taskTitle  name of the task
     * @param taskPriority priority of the task
     * @param status task completion status
     *
     */
    public Task(int taskID, String taskTitle, String taskPriority, TaskStatus status, User user) {
        if(taskDetailsValidation(taskID, taskTitle, taskPriority)) {
            this.taskID = taskID;
            this.taskTitle = taskTitle;
            this.taskPriority = taskPriority;
            this.status = status;
            this.user = user;
        }else
            throw new IllegalArgumentException("Invalid Task Details");
    }

    /**
     * Creates for learning overloading
     */
    public Task(){
        this.taskID = 1;
        this.taskTitle = "Default Task";
        this.taskPriority = "LOW";
        this.status = TaskStatus.TODO;
        this.user = new User(0, "Default User");
    }

    /**
        Main Method
     */
    public static void main(String args[]){

        Task task1 = new Task(101, "Learn Java", "HIGH", TaskStatus.TODO, new User(1, "Ravi"));
        Task task2 = new Task(102, "Read Book", "MEDIUM", TaskStatus.IN_PROGRESS, new User(2, "Priya"));
        task1.updateStatus(TaskStatus.DONE);
        task1.displayTaskDetails();
        task2.displayTaskDetails();
    }

    /**
     *
     * Validates the tasks details which was given by user
     *
     * @param id task id given by user
     * @param title task title name given by user
     * @param priority task priority given by user
     *
     * @return true if all inputs are valid, otherwise return false
     *
     */
    public static boolean taskDetailsValidation(int id, String title, String priority) {
        if (id <= 0){
            System.out.println("Id validation is failed, because it needs to be greater than 0 for Task " + id);
            return false;
        }
        else if(title == null || title.trim().isEmpty()) {
            System.out.println("Title validation is failed, because it is empty for Task " + id);
            return false;
        }
        else if(!(priority.equalsIgnoreCase("LOW") || priority.equalsIgnoreCase("MEDIUM") ||
                priority.equalsIgnoreCase("HIGH"))) {
            System.out.println("Priority validation is failed because it does not contains LOW , MEDIUM or HIGH" +
                    " Task " + id);
            return false;
        }

        return true;

    }

    /**
     *
     * Displays the task details which are stored.
     *
     */
    public void displayTaskDetails(){
        System.out.println("\n" + "Task ID: " + this.getTaskID() + " - " + this.getTaskTitle() + " - " + this.user.displayUser());
        System.out.println("Priority: " + this.getTaskPriority());
        System.out.println("Status: " + this.status);
    }

    /**
     *
     * returns the taskId which is shared by user as input and assigned in constructure
     *
     * @return taskId
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     *
     * returns the task name which is shared by user as input and assigned in constructure
     *
     * @return taskTitle
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     *
     * returns the task priority which is shared by user as input and assigned in constructure
     *
     * @return taskPriority
     */
    public String getTaskPriority() {
        return taskPriority;
    }

    public void updateStatus(TaskStatus status){
        this.status = status;
    }
}
