package com.example.darpan.mechanico;

public class Realtime_database_users {
    String user_name;
    String user_number;
    String user_email;
    String denting_services;
    String car_name,car_model,fuel_type,date,time,address;
    String car_services,nothing,donothing,againnothing,tyre_service,nothing1;

    public String getDenting_services() {
        return denting_services;
    }

    public void setDenting_services(String denting_services) {
        this.denting_services = denting_services;
    }

    public Realtime_database_users(){

    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_number() {
        return user_number;
    }


    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Realtime_database_users(String user_name, String user_number, String user_email) {
        this.user_name = user_name;
        this.user_number = user_number;
        this.user_email = user_email;


    }
    public Realtime_database_users(String denting_services)
    {
        this.denting_services=denting_services;
    }

    public Realtime_database_users(String car_name,String car_model,String fuel_type,String date, String time, String address)
    {
        this.car_name=car_name;
        this.car_model=car_model;
        this.fuel_type=fuel_type;
        this.date=date;
        this.time=time;
        this.address=address;

    }
   public Realtime_database_users(String car_services,String nothing)
   {
       this.car_services=car_services;
       this.nothing=nothing;

   }
   public Realtime_database_users(String tyre_service,String donothing,String agiannothing,String nothing1)
   {
       this.tyre_service=tyre_service;
       this.donothing=donothing;
       this.againnothing=agiannothing;
       this.nothing1=nothing1;


   }



}


