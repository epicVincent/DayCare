package com.softwareEng.Daycare;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;

//name 'Role' can be substituted with StaffType
public class Role {
    int id;
    String role;
    Context context;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }
    public Role(Context context,int id, String role){
        this.id = id;
        this.role = role;
        this.context = context;
    }
    public Role(Context context,String role){
        this.context = context;
        this.role = role;
    }
    public Role(){

    }

    public interface addRoles {
        public long addroles(String role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void save(){
        try {
            DayCareDB dayCareDB = new DayCareDB(context);
            dayCareDB.open();
            dayCareDB.addroles(role);
            dayCareDB.close();
        }
        catch (SQLException e){
            Log.i("roleSQLEx",e.getMessage());
            Toast.makeText(context,"Oops something went wrong!!",Toast.LENGTH_LONG).show();

        }

    }

//    @Override
//    public long addroles() {
//        DayCareDB dbInstance = MyApplication.
//    }
}
