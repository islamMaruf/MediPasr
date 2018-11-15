package com.example.maruf.mydoctor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewDoctorFragment extends Fragment   {
private RecyclerView recyclerView;
private List<Doctor> docList;
private CustomAdapter docAdapter;
private DbManager dbManager;


    public ViewDoctorFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_view_doctor, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dbManager = new DbManager(getActivity());
        List<Doctor> doctors = dbManager.getAllDoctor();
        docAdapter = new CustomAdapter(getActivity(),doctors);
        recyclerView.setAdapter(docAdapter);
        return view;
    }






}
