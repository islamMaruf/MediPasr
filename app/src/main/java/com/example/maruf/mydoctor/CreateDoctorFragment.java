package com.example.maruf.mydoctor;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;




public class CreateDoctorFragment extends Fragment  {
    private AwesomeValidation awesomeValidation;
    private Button showBTN, saveBTN;
    private EditText nameET,detailsET,phoneET,appoinmentET,emailET;

    public CreateDoctorFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_create_doctor, container, false);

        initialization(view);
        com.example.maruf.mydoctor.DatePicker date = new com.example.maruf.mydoctor.DatePicker();
        date.datePicker(appoinmentET,getActivity());


        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMethod();

            }
        });


        showBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frameLayoutId,new ViewDoctorFragment()).addToBackStack(null).commit();
            }
        });

        return  view;
    }



    private void initialization(View view) {
        nameET = view.findViewById(R.id.docName);
        emailET = view.findViewById(R.id.docEmail);
        phoneET = view.findViewById(R.id.docMobile);
        appoinmentET = view.findViewById(R.id.docAppoinment);
        detailsET = view.findViewById(R.id.docDetails);
        showBTN = view.findViewById(R.id.showBtn);
        saveBTN = view.findViewById(R.id.saveBtn);

    }

    private void saveMethod(){
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(getActivity(),R.id.docName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameError);
        awesomeValidation.addValidation(getActivity(),R.id.docDetails, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.detailsError);
        awesomeValidation.addValidation(getActivity(), R.id.docEmail, Patterns.EMAIL_ADDRESS, R.string.emailError);
        awesomeValidation.addValidation(getActivity(), R.id.docMobile, "^(((\\+)?880)|0)(\\d){10}$", R.string.mobileError);
        awesomeValidation.addValidation(getActivity(), R.id.docAppoinment, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateError);

        if(awesomeValidation.validate()){
            String name = nameET.getText().toString();
            String email = emailET.getText().toString();
            String phone = phoneET.getText().toString();
            String appoinment = appoinmentET.getText().toString();
            String details = detailsET.getText().toString();
            Doctor doctor = new Doctor(name,details,appoinment,phone,email);
            DbManager manager = new DbManager(getActivity());
            boolean insert = manager.insertDoctor(doctor);
            if(insert){
                nameET.setText("");
                emailET.setText("");
                phoneET.setText("");
                appoinmentET.setText("");
                detailsET.setText("");
                Toast.makeText(getActivity(), "Data are inserted successfully", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getActivity(),"Some error occur",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
