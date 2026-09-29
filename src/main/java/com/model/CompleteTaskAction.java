/**
 * Copyright (c) 2026 Hrushikesh Panda.
 *
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

/**
 * Complete Task Action is a class implemented from Task Action interface.
 */
public class CompleteTaskAction implements TaskAction{

    private Task task;

    public CompleteTaskAction(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        task.complete();
        System.out.println(
                "CompleteTaskAction: EXECUTED");
    }

    @Override
    public void undo() {
        task.reopen();
        System.out.println(
                "CompleteTaskAction: UNDONE");
    }

}
