package com.softwareEng.Daycare;

public class Child extends Person {

    Parent parent;
    int age;
    Condition condition;

    public Child(String Surname,String FirstName,String LastName,Parent parent, int age) {

        this.parent = parent;
        this.age = age;
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.LastName = LastName;
    }
    public Child(String Surname,String FirstName,String LastName,Parent parent, int age,Condition condition) {

        this.parent = parent;
        this.age = age;
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.LastName = LastName;
        this.condition = condition;
    }
}
