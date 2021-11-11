package com.softwareEng.Daycare;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;

public class Staff extends Person {

    String telNo1;
    String telNo2;
    String NatId;
    Role role;
    Context context;
    public String username;
    private String password;

    public Staff(Context context,String firstName,String lastName,String surName, String telNo1, String telNo2,Role role,String username,String password,String NatId) {
        super(firstName,lastName,surName);
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Surname = surName;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.NatId = NatId;
        this.role = role;
        this.username = username;
        this.password = password;
        this.context = context;
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

    public void setNatId(String natId) {
        NatId = natId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Staff(Context context, String firstName, String lastName, String surName, String telNo1, String telNo2, String NatId, Role role) {
        super(firstName,lastName,surName);
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Surname = surName;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.NatId = NatId;
        this.role = role;
        this.context = context;
    }
    public Staff(){
        super();

    }

    public interface addStaff {
        public long addstaff(String mfirstName,String mlastName,String msurName, String mtelNo1, String
                mtelNo2,Role mrole,String musername,String mpassword,String mNatId);
    }
    public long save(){
        try {
            DayCareDB dayCareDB = new DayCareDB(context);
            dayCareDB.open();
            long dBSig = dayCareDB.addstaff(FirstName,LastName,Surname,telNo1,telNo2,role,username,password,NatId);
            dayCareDB.close();
            return dBSig;
        }
        catch (SQLException e){
            Log.i("roleSQLEx",e.getMessage());
            Toast.makeText(context,"Oops something went wrong!!",Toast.LENGTH_LONG).show();
            return 789;
        }

    }

}
