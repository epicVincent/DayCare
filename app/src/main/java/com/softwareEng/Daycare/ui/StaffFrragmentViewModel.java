package com.softwareEng.Daycare.ui;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softwareEng.Daycare.DayCareDB;
import com.softwareEng.Daycare.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffFrragmentViewModel extends ViewModel {
    private MutableLiveData<List<Staff>> staff;
    public LiveData<List<Staff>> getStaff(Context context) {
        if (staff == null) {
            staff = new MutableLiveData<List<Staff>>();
            loadStaff(context);
        }
        return staff;
    }

    private void loadStaff(Context context) {
        // Do an asynchronous operation to fetch users.
        try {
            DayCareDB dayCareDB = new DayCareDB(context);
            dayCareDB.open();
            staff.setValue(dayCareDB.getStaff());
            ArrayList<Staff> mystaff =(ArrayList<Staff>) staff.getValue();
            Log.i("size",""+mystaff.size());
            dayCareDB.close();
        }
        catch (SQLException e){
            Log.i("sqlstaffEr",e.getMessage());
        }
    }
}