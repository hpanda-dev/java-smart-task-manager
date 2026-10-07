/**
 * Copyright (c) 2026 Hrushikesh Panda.
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  Task Management System : Create, Validates, Display a Task with user specific inputs
 */
public class Task {

    private int taskID;
    private String taskTitle;
    private String taskPriority;
    private TaskStatus status ;
    private User user;
    private double estimatedHours;

    /**
     *
     * Creates a TASK with the required details
     *
     * @param taskID  unique id to represent the task
     * @param taskTitle  name of the task
     * @param taskPriority priority of the task
     * @param status object of TaskStatus enum
     * @param user object of User class
     * @param estimatedHours effort estimation for completion of task
     *
     */
    public Task(int taskID, String taskTitle, String taskPriority, TaskStatus status, User user, int estimatedHours) {
        if(taskDetailsValidation(taskID, taskTitle, taskPriority, estimatedHours)) {
            this.taskID = taskID;
            this.taskTitle = taskTitle;
            this.taskPriority = taskPriority;
            this.status = status;
            this.user = user;
            this.estimatedHours = estimatedHours;
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
        this.estimatedHours = 0.0;
        this.user = new User(0, "Default User");
    }

    /**
        Main Method
     */
    public static void main(String args[]){

        Task task1 = new DevelopmentTask(101, "Code Java", "HIGH", TaskStatus.TODO, new User(1, "Ravi"), 10);
        Task task2 = new MaintenanceTask(102, "Read Book", "MEDIUM", TaskStatus.IN_PROGRESS, new User(2, "Priya"), 6);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        for(Task t : taskList){
            if(t instanceof DevelopmentTask){
                DevelopmentTask developmentTask = (DevelopmentTask) t;
                developmentTask.calculateEfforts();
            }
            else
                t.calculateEfforts();
        }
    }

    /**
     *
     * Validates the tasks details which was given by user
     *
     * @param id task id given by user
     * @param title task title name given by user
     * @param priority task priority given by user
     * @param estimatedHours effort estimation given by user
     *
     * @return true if all inputs are valid, otherwise return false
     *
     */
    public static boolean taskDetailsValidation(int id, String title, String priority, double estimatedHours) {
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
        else if(estimatedHours < 0){
            System.out.println("Effort estimation validation is failed, because it needs to be greater than or equals to 0 for Task " + id);
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
        System.out.println("\n" + "Task ID: " + this.taskID + " - " + this.taskTitle + " - " + this.user.displayUser());
        System.out.println("Priority: " + this.taskPriority);
        System.out.println("Status: " + this.status);
    }

    /**
     *
     * returns the taskId which is given by user
     *
     * @return taskId
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     *
     * returns the estimatedHours which is given by user
     *
     * @return taskId
     */
    public double getEstimatedHours() {
        return estimatedHours;
    }

    /**
     *
     * returns the task name which is given by user
     *
     * @return taskTitle
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     *
     * returns the task priority which is given by user
     *
     * @return taskPriority
     */
    public String getTaskPriority() {
        return taskPriority;
    }

    /**
     *  updateStatus() method is used modify the status.
     */

    public void updateStatus(TaskStatus status){
        this.status = status;
    }

    /**
     * complete() method is used to mark the task status as DONE
     */
    public void complete(){
        this.status = TaskStatus.DONE;
        System.out.println("Completed Task → Status: " + this.status);
    }

    /**
     * reopen() method is used to mark the task status as TODO
     */
    public void reopen(){
        this.status = TaskStatus.TODO;
        System.out.println("Reopen Task → Status: " + this.status);
    }

    /**
     * initial() method is used to show the current status of the task.
     */
    public void initial() {
        System.out.println("Initial Status: " + this.status);
    }

    /**
     *  calculateEfforts() method is used to print the estimatedHours which is given by user
     */
    public void calculateEfforts(){
        System.out.println("Effort : "+this.getEstimatedHours());
    }
}
