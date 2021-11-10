package com.softwareEng.Daycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class OriginActivity extends AppCompatActivity {
    EditText etSirname,etFirstName,etLastName,etNatId,etEmail,etPhone1,etPhone2,etOusername,etOpass1,etOpass2;
    Button btnSubmit;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin);
        context = this;
        etSirname = findViewById(R.id.etSirname);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etNatId = findViewById(R.id.etNatId);
        etEmail = findViewById(R.id.etEmail);
        etPhone1 = findViewById(R.id.etPhone1);
        etPhone2 = findViewById(R.id.etPhone2);
        etOusername = findViewById(R.id.etOUserName);
        etOpass1 = findViewById(R.id.etOpass1);
        etOpass2 = findViewById(R.id.etOpass2);
        btnSubmit = findViewById(R.id.btnSubmit);
        AtomicInteger genId = new AtomicInteger();
        int id = genId.incrementAndGet();
        Role role = MyApplication.getStaffroles().get(0);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sirname = etSirname.getText().toString().trim();
                String FirstName = etFirstName.getText().toString().trim();
                String LastName = etLastName.getText().toString().trim();
                String natId = etNatId.getText().toString().trim();
                String Email = etEmail.getText().toString().trim();
                String Phone1 = etPhone1.getText().toString().trim();
                String Phone2 = etPhone2.getText().toString().trim();
                String username = etOusername.getText().toString().trim();
                String pass1 = etOpass1.getText().toString().trim();
                String pass2 = etOpass2.getText().toString().trim();

                Staff staff = new Staff(context,FirstName,LastName,sirname,Phone1,Phone2,role,username,pass1,natId);
                staff.save();
                Toast.makeText(context,"Data saved ",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,AdminDrawer.class);
                startActivity(intent);
            }
        });


    }
}