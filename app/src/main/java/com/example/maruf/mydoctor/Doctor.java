package com.example.maruf.mydoctor;

public class Doctor {
    private int id;
    private String name;
    private String details;
    private String appoinment;
    private String phone;
    private String email;

    public Doctor(int id, String name, String details, String appoinment, String phone, String email) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.appoinment = appoinment;
        this.phone = phone;
        this.email = email;
    }

    public Doctor(String name, String details, String appoinment, String phone, String email) {
        this.name = name;
        this.details = details;
        this.appoinment = appoinment;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getAppoinment() {
        return appoinment;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
