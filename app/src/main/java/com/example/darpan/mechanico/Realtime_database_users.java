package com.example.darpan.mechanico;

public class Realtime_database_users {
    String user_name;
    String user_number;
    String user_email;




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




}


