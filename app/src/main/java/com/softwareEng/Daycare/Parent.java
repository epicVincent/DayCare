package com.softwareEng.Daycare;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;

public class Parent extends Person {

    String telNo1;
    String telNo2;
    String NatId;
    String Occupation;
    Context context;

    public Parent(Context context, String firstName, String lastName, String surName, String telNo1, String telNo2, String NatId, String occupation, int id) {
        super(surName,firstName,lastName);
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.NatId = NatId;
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

    public String getNatId() {
        return NatId;
    }

    public void setNatId(String id) {
        this.NatId = NatId;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public interface addParent {
        public long addparent(String firstName,String lastName,String surName, String telNo1, String telNo2, String NatId, String occupation);
    }
    public void save(){
        try {
            DayCareDB dayCareDB = new DayCareDB(context);
            dayCareDB.open();
            dayCareDB.addparent(FirstName,LastName,Surname,telNo1,telNo2,NatId,Occupation);
            dayCareDB.close();
        }
        catch (SQLException e){
            Log.i("roleSQLEx",e.getMessage());
            Toast.makeText(context,"Oops something went wrong!!",Toast.LENGTH_LONG).show();

        }
    }
}
