/**
 * Copyright (c) 2026 Hrushikesh Panda.
 *
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

/**
 * Task Action is an interface with execute() and undo() methods.
 */
public interface TaskAction {

    public abstract void execute();

    public abstract void undo();
}
