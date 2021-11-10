package com.softwareEng.Daycare;

public abstract class Person {
    protected String Surname;
    protected String FirstName;
    protected String LastName;
    protected int id;
//    String Residence;

    public Person(String FirstName,String LastName,String Surname){
        this.LastName =LastName;
        this.Surname = Surname;
        this.LastName = LastName;
    }
    public Person(){

    }
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
