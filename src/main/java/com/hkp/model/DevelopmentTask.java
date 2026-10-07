/**
 * Copyright (c) 2026 Hrushikesh Panda.
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

/**
 * Development Task : Calculates the efforts given by user based on condition and print it.
 */
public class DevelopmentTask extends Task{

    /**
     * Create a Development task by using the Task Constructor.
     * @param taskID  unique id to represent the task
     * @param taskTitle name of the task
     * @param taskPriority priority of the task
     * @param status object of TaskStatus enum
     * @param user object of User class
     * @param estimatedHours effort estimation for completion of task
     */
    public DevelopmentTask(int taskID, String taskTitle, String taskPriority, TaskStatus status, User user, int estimatedHours) {
        super(taskID, taskTitle, taskPriority,status,user,estimatedHours);
    }

    /**
     * calculateEfforts() method is used to print the user estimatedHours based on conditions and calculations
     */
    @Override
    public void calculateEfforts(){
        System.out.println("Development Task: "+ super.getTaskID());
        double effort = super.getEstimatedHours();
        if(effort > 25){
            effort = effort * 5;
        }
        System.out.println("Effort : "+ effort +"\n");
    }
}
