package com.example.darpan.mechanico;

public class bookrealtime extends Realtime_database_users
{

    String car, car_model, fuel_type, address, date, time, otp,user_name,user_email,user_number;


    public bookrealtime() {

    }
   public bookrealtime(Realtime_database_users rtos)
    {
        this.user_name=rtos.user_name;
        this.user_email=rtos.user_email;
        this.user_number=rtos.user_number;
    }


    public bookrealtime(String car, String car_model, String fuel_type, String address, String date, String time, String otp) {
        this.car = car;
        this.car_model = car_model;
        this.fuel_type = fuel_type;
        this.address = address;
        this.date = date;
        this.time = time;
        this.otp = otp;

    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String getUser_name() {
        return user_name;
    }

    @Override
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String getUser_email() {
        return user_email;
    }

    @Override
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String getUser_number() {
        return user_number;
    }

    @Override
    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

   /*public String uname1()
   {
      user_name1=r.getUser_name();
      return user_name1;
   }*/
}
