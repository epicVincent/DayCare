package com.softwareEng.Daycare;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class AddStaff extends Fragment {
    TextInputLayout FirstName;
    TextInputLayout LastName;
    TextInputLayout Surname;
    TextInputLayout telNo1;
    TextInputLayout telNo2;
    TextInputLayout id;
    Spinner roles;
    SpinnerAdapter spinnerAdapter;
    Button btnAddStaff;
    List<String> availableroles;
    MyApplication myApplication;
    Context context;

    public AddStaff() {
        // Required empty public constructor
    }


    public static AddStaff newInstance(String param1, String param2) {
        AddStaff fragment = new AddStaff();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApplication = (MyApplication) getActivity().getApplication();
        availableroles = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_staff, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirstName = (TextInputLayout) view.findViewById(R.id.TiFirstname);
        LastName = (TextInputLayout) view.findViewById(R.id.TiLastName);
        Surname = (TextInputLayout) view.findViewById(R.id.TiSurName);
        telNo1 =  (TextInputLayout) view.findViewById(R.id.TiTel1);
        telNo2 = (TextInputLayout) view.findViewById(R.id.TiTel2);
        id = (TextInputLayout) view.findViewById(R.id.TiD);
        roles = (Spinner) view.findViewById(R.id.sRole);
        btnAddStaff = view.findViewById(R.id.btnAddStaff);
        context = this.getContext();
        try {

        }
        catch (SQLException e){
            Log.i("roErr",e.getMessage());
        }
        for (Role role:myApplication.getStaffroles()
             ) {
            if(role.role!="Parent")
                availableroles.add(role.role);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_dropdown_item,(List) availableroles);
        arrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        roles.setAdapter(arrayAdapter);
        String myrole = (String) roles.getSelectedItem();
        Log.i("myrole",myrole);

        Role mRole = new Role();
        for (Role role:MyApplication.getStaffroles()
        ) {
            if(role.getRole()== (String) myrole){
                mRole = (Role) role;
            }
        }

        Role finalMRole = mRole;
        btnAddStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mFirstName = FirstName.getEditText().getText().toString().trim();
                String mLastName = LastName.getEditText().getText().toString().trim();
                String mSurname = Surname.getEditText().getText().toString().trim();
                String mTelNo1 = telNo1.getEditText().getText().toString().trim();
                String mTelNo2 = telNo2.getEditText().getText().toString().trim();
                String mId = id.getEditText().toString().trim();

                Staff staff = new Staff(context,mFirstName,mLastName,mSurname,mTelNo1,mTelNo2,mId, finalMRole);
                staff.save();
            }
        });
    }
}