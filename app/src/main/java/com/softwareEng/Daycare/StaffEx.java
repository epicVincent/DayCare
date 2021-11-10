package com.softwareEng.Daycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;

import com.softwareEng.Daycare.ui.StaffRecyAdapter;

import java.util.ArrayList;

public class StaffEx extends AppCompatActivity {
    RecyclerView rvStList;
    RecyclerView.LayoutManager layoutManager;
    StaffRecyAdapter mStaffAdapter;
    ArrayList<Staff> staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_ex);
        rvStList = findViewById(R.id.rvStList);
        rvStList.setHasFixedSize(true);
        Role role = new Role(this,"Test");
        Staff mStaff = new Staff(this,"John","Wamuyu","Kimani","0715404205","073456244","34556765",role);
        staff = new ArrayList<Staff>();
        staff.add(mStaff);
//        try {
//            DayCareDB dayCareDB = new DayCareDB(this);
//            dayCareDB.open();
//            staff = (ArrayList<Staff>) dayCareDB.getStaff();
//            dayCareDB.close();
//        }
//        catch (SQLException e){
//            Log.i("sqSt",e.getMessage());
//        }

        layoutManager = new LinearLayoutManager(this);
        mStaffAdapter = new StaffRecyAdapter(this,staff);
        rvStList.setLayoutManager(layoutManager);
        rvStList.setAdapter(mStaffAdapter);


    }
}