package com.softwareEng.Daycare;

public class Staff extends Person {

    String telNo1;
    String telNo2;
    String id;
    Role role;
    public String username;
    private String password;

    public Staff(String firstName,String lastName,String surName, String telNo1, String telNo2, String id, Role role,String username,String password) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Surname = surName;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
    }
}
