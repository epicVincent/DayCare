package com.softwareEng.Daycare;

public class Parent extends Person {

    String telNo1;
    String telNo2;
    String id;
    String Occupation;


    public Parent(String firstName,String lastName,String surName, String telNo1, String telNo2, String id, String occupation) {
        this.FirstName =firstName;
        this.LastName = lastName;
        this.Surname = surName;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.id = id;
        Occupation = occupation;
    }


    public String getTelNo1() {
        return telNo1;
    }

    public void setTelNo1(String telNo1) {
        this.telNo1 = telNo1;
    }

    public String getTelNo2() {
        return telNo2;
    }

    public void setTelNo2(String telNo2) {
        this.telNo2 = telNo2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }
}
