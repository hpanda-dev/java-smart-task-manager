/*
 * Copyright (c) 2026 Hrushikesh Panda.
 *
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

import java.util.Scanner;

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
    private boolean isCompleted;
    static Task[] task = null;

    /**
     *
     * Creates a TASK with the required details
     *
     * @param taskID  unique id to represent the task
     * @param taskTitle  name of the task
     * @param taskPriority priority of the task
     * @param isCompleted task completion status
     *
     */
    public Task(int taskID, String taskTitle, String taskPriority, boolean isCompleted) {
        this.taskID = taskID;
        this.taskTitle = taskTitle;
        this.taskPriority = taskPriority;
        this.isCompleted = isCompleted;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n, id;
        String title, priority;
        Boolean completed;

        while(true) {
            System.out.println("Enter number of tasks : ");
            n = sc.nextInt();
            if (n >= 2)
                break;
            System.out.println("The given number is Invalid, please give a number more than or equal to 2");
        }

        task = new Task[n]; //assing the no of tasks which needs to created

        for (int i=0; i < n ; i++){
            System.out.println("Enter details of task " + (i+1));
            System.out.println("=========================");

            System.out.println("Enter task id : ");
            id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter task title : ");
            title = sc.nextLine();

            System.out.println("Enter task priority : ");
            priority = sc.nextLine();

            System.out.println("Enter task completed : ");
            completed = sc.nextBoolean();

            if(Task.taskDetailsValidation(i, id, title, priority, completed)){
                task[i] = new Task(id, title, priority, completed);

            }
            else {
                System.err.println("Task details validation failed and details are not stored, " +
                        "provide proper details");
            }
        }
        Task.displayTaskDetails();
    }

    /**
     *
     * Validates the tasks details which was given by user
     *
     * @param i  used to represent the task number if any case all the details are wrong.
     * @param id task id given by user
     * @param name task name given by user
     * @param priority task priority given by user
     * @param completed task completion status given by user
     *
     * @return true if all inputs are valid, otherwise return false
     *
     */
    public static boolean taskDetailsValidation(int i, int id, String name, String priority, Boolean completed) {
        if (id < 0){
            System.out.println("Id validation is failed, because it needs to be greater than 0 for Task " + (i+1));
            return false;
        }
        else if(name.isEmpty()) {
            System.out.println("Name validation is failed, because it is empty for Task " + (i+1));
            return false;
        }
        else if(!(priority.equalsIgnoreCase("LOW") || priority.contains("MEDIUM") || priority.contains("HIGH"))) {
            System.out.println("Priority validation is failed because it does not contains LOW , MEDIUM or HIGH" +
                    " Task " + (i+1));
            return false;
        }
        else if(completed || !completed)
            return true;
        else {
            System.out.println("completed validation is failed, because its should be true or false" +
                    " Task " + (i+1));
            return false;
        }

    }

    /**
     *
     * Displays the task details which are stored.
     *
     */
    public static void displayTaskDetails(){
        for(Task tk : task){
            System.out.println("\n"+"Task ID :"+tk.getTaskID());
            System.out.println("Title :"+tk.getTaskTitle());
            System.out.println("Priority :"+tk.getTaskPriority());
            System.out.println("Completed :"+tk.isCompleted()+"\n");
        }
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

    /**
     *
     * returns the status of task which is shared by user as input and assigned in constructure
     *
     * @return isCompleted
     */
    public boolean isCompleted() {
        return isCompleted;
    }
}
