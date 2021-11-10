package com.softwareEng.Daycare.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softwareEng.Daycare.DayCareDB;
import com.softwareEng.Daycare.R;
import com.softwareEng.Daycare.Staff;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StaffFrragment extends Fragment {

    private StaffFrragmentViewModel mViewModel;
    RecyclerView rvStafflist;
    StaffRecyAdapter staffRecyAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Staff> mStaff;
    Context context;

    public static StaffFrragment newInstance() {
        return new StaffFrragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.staff_frragment_fragment, container, false);
        rvStafflist = (RecyclerView) view.findViewById(R.id.rvStaffList);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = this.getActivity();
        layoutManager = new LinearLayoutManager(this.getContext());

        rvStafflist.setHasFixedSize(true);
        try {
            DayCareDB dayCareDB = new DayCareDB(this.getActivity());
            dayCareDB.open();
            mStaff = dayCareDB.getStaff();
            dayCareDB.close();
            staffRecyAdapter = new StaffRecyAdapter(context,mStaff);
            staffRecyAdapter.notifyDataSetChanged();
            layoutManager = new LinearLayoutManager(this.getContext());
            rvStafflist.setLayoutManager(layoutManager);
            rvStafflist.setAdapter(staffRecyAdapter);
        }
        catch (SQLException e){
            Log.i("sqlerrr",e.getMessage());
        }



    }
}