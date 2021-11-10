package com.softwareEng.Daycare;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.softwareEng.Daycare.databinding.ActivityAdminDrawerBinding;
import com.softwareEng.Daycare.ui.StaffFrragment;

public class AdminDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityAdminDrawerBinding binding;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarAdminDrawer.toolbar);

        binding.appBarAdminDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int fragmentId =  navController.getCurrentDestination().getId();
                if(fragmentId == R.id.staffFrragment){
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    AddStaff addStaff = new AddStaff();
                    navController.navigate(R.id.addStaff);
//                    fragmentTransaction.replace(R.id.staffFrragment,addStaff);
                    Log.i("Commited","COmmited");
                }
                else{
                    Snackbar.make(view, "Functionality to be added soon", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.staffFrragment, R.id.payment, R.id.kidsFragment,R.id.suppliers,R.id.addStaff)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Log.i("navId",""+navController.getCurrentDestination().getId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}