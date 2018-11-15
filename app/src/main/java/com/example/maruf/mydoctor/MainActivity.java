package com.example.maruf.mydoctor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Fragment dashboardFragment, doctorFragment, viewDoctorFragment, prescriptionFragment,viewPrescriptionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        replaceFragment(dashboardFragment);

    }




    private void initialization(){
        dashboardFragment = new DashboardFragment();
        doctorFragment = new CreateDoctorFragment();
        viewDoctorFragment = new ViewDoctorFragment();
        prescriptionFragment = new CreatePrescriptionFragment();
        viewPrescriptionFragment = new ViewPrescriptionFragment();
    }

     public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayoutId,fragment);
        ft.addToBackStack(fragment.toString());
        ft.commit();


    }

    @Override
    public void onBackPressed() {
        int backStackCount = getSupportFragmentManager().getBackStackEntryCount();
        if(backStackCount>1){

            super.onBackPressed();
        }else {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();

        }


    }
}
