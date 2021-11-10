package com.softwareEng.Daycare;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;

public class Child extends Person {

    Parent parent;
    int age;
    Condition condition;
    Context context;

    public Child(Context context,String Surname,String FirstName,String LastName,Parent parent, int age) {
        super(Surname,FirstName,LastName);
        this.parent = parent;
        this.age = age;
        this.context = context;
    }
    public Child(Context context,String Surname,String FirstName,String LastName,Parent parent, int age,Condition condition) {
        super(Surname,FirstName,LastName);
        this.parent = parent;
        this.age = age;
        this.condition = condition;
        this.context = context;
    }

    public Parent getParent() {
        return parent;
    }

    public interface addChild {
        public long addchild(String Surname,String FirstName,String LastName,Parent parent, int age);
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void save(){
        try {
            DayCareDB dayCareDB = new DayCareDB(context);
            dayCareDB.open();
            dayCareDB.addchild(Surname,FirstName,LastName,parent,age);
            dayCareDB.close();
        }
        catch (SQLException e){
            Log.i("roleSQLEx",e.getMessage());
            Toast.makeText(context,"Oops something went wrong!!",Toast.LENGTH_LONG).show();

        }

    }
}
