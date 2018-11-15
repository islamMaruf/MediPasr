package com.example.maruf.mydoctor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context context;
    private List<Doctor> doctorList;


    public CustomAdapter(Context context, List<Doctor> doctorList){
        this.context = context;
        this.doctorList = doctorList;

    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_doctor_list, null);
        return new CustomViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder customViewHolder, int i) {
        Doctor currentDoctor = doctorList.get(i);
        customViewHolder.doctorName.setText(currentDoctor.getName());
        customViewHolder.doctorDetails.setText(currentDoctor.getDetails());
        customViewHolder.doctorAppoinment.setText(currentDoctor.getAppoinment());
        customViewHolder.doctorEmail.setText(currentDoctor.getEmail());
        customViewHolder.doctorPhone.setText(currentDoctor.getPhone());

        customViewHolder.optionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,customViewHolder.optionMenu);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.popUpEdit:
                                Toast.makeText(context, "edit clicked", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.popUpDelete:
                                Toast.makeText(context,"delete clicked",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }


                        return false;
                    }
                });
                popupMenu.show();
            }
        });


        }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView doctorName,doctorDetails,doctorAppoinment,doctorEmail,doctorPhone,optionMenu;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            optionMenu = itemView.findViewById(R.id.popUpMenuTV);
            doctorName = itemView.findViewById(R.id.doctorNameTV);
            doctorDetails = itemView.findViewById(R.id.doctorDetailsTV);
            doctorAppoinment = itemView.findViewById(R.id.doctorAppoinmentTV);
            doctorEmail = itemView.findViewById(R.id.doctorEmailTV);
            doctorPhone = itemView.findViewById(R.id.doctorMobileTv);
            }


    }


}
