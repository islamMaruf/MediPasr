package com.example.maruf.mydoctor;



import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class DashboardFragment extends Fragment {
    private CardView doctorInfo,viewDoctorInfo,precriptionInfo,viewPrescriptionInfo;


 private  Fragment doctorFragment, viewDoctorFragment, prescriptionFragment,viewPrescriptionFragment;



    public DashboardFragment() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        doctorInfo =  view.findViewById(R.id.addDoctorId);
        viewDoctorInfo = view.findViewById(R.id.viewDoctorId);
        precriptionInfo = view.findViewById(R.id.prescriptionId);
        viewPrescriptionInfo = view.findViewById(R.id.viewPrescriptionId);

        initialization();
        onClick();

        return view;
    }
        //on click method
    private void onClick(){
        doctorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(doctorFragment);
            }
        });

        viewDoctorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(viewDoctorFragment);
            }
        });

        precriptionInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(prescriptionFragment);
            }
        });

        viewPrescriptionInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(viewPrescriptionFragment);
            }
        });



    }

    private void initialization(){
        doctorFragment = new CreateDoctorFragment();
        viewDoctorFragment = new ViewDoctorFragment();
        prescriptionFragment = new CreatePrescriptionFragment();
        viewPrescriptionFragment = new ViewPrescriptionFragment();
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm= getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayoutId,fragment);
        ft.addToBackStack(null);
        ft.commit();
        }



















}
