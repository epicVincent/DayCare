package com.softwareEng.Daycare;

import android.app.Application;
import android.database.SQLException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    public static  List<Role> staffroles = new ArrayList<>();

    public DayCareDB dayCareDB;
    public  static List<Role> getStaffroles() {
        return staffroles;
    }

    public void setStaffroles(List<Role> staffroles) {
        this.staffroles = staffroles;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            dayCareDB = new DayCareDB(this);
            dayCareDB.open();
            if(dayCareDB.getRoles().size()==0 || dayCareDB.getRoles()==null){
                Role roleAdmin = new Role(getApplicationContext(),"Admin");
                Role careGiver = new Role(getApplicationContext(),"Caregiver");
                Role parentRole = new Role(getApplicationContext(),"Parent");
                roleAdmin.save();
                careGiver.save();
                parentRole.save();
                staffroles = (ArrayList<Role>) dayCareDB.getRoles();
            }
            else{
                staffroles = (ArrayList<Role>) dayCareDB.getRoles();
            }

            dayCareDB.close();
        }
        catch (SQLException e){
            Log.i("roErr",e.getMessage());
        }


//        Role roleAdmin = new Role(1,"Admin");
//        Role roleCaregiver = new Role(2 ,"Caregiver");
//        Role roleParent = new Role(1,"Parent");
//
//
//        staffroles = new ArrayList<>();
//        staffroles.add(roleAdmin);
//        staffroles.add(roleCaregiver);
//        staffroles.add(roleParent);
//        try {
//            DayCareDB dayCareDB = new DayCareDB(this);
//            dayCareDB.open();
//            dayCareDB.addroles("Admin");
//            dayCareDB.addroles("caregiver");
//            dayCareDB.close();
//        }
//        catch (SQLException exception){
//            Log.i("sqlExc",exception.getMessage());
//        }


    }
}
