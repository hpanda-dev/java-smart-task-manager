/**
 * Copyright (c) 2026 Hrushikesh Panda.
 *
 * All rights are reserved . Reproduction in whole and in part is prohibited
 * without writing consent to the copyright owner.
 *
 */

package com.hkp.model;

/**
 * User is a class used to store & validate the name, userId 
 * */
public class User {
    private String name;
    private int userId;

    public User(int userId, String name) {
        this.userId =userId;
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        else
            this.name = name;
    }

    public String displayUser(){
        return this.name;
    }

}
