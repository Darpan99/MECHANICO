package com.example.darpan.mechanico;

public class bookrealtime {

    String Car,Car_model,Fuel_type,Address,Date,Time,OTP,user_name;
    public bookrealtime()
    {

    }

    public bookrealtime(String Car, String Car_model, String Fuel_type, String Address, String Date, String Time, String OTP,String user_name) {
        this.Car = Car;
        this.Car_model =Car_model;
        this.Fuel_type = Fuel_type;
        this.Address = Address;
       this.Date = Date;
       this.Time =Time;
        this.OTP = OTP;
        this.user_name=user_name;
    }


    public String getCar() {
        return Car;
    }

    public void setCar(String Car) {
        this.Car = Car;
    }

    public String getCar_model() {
        return Car_model;
    }

    public void setCar_model(String Car_model) {
        this.Car_model = Car_model;
    }

    public String getFuel_type() {
        return Fuel_type;
    }

    public void setFuel_type(String Fuel_type) {
        this.Fuel_type = Fuel_type;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

   public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
