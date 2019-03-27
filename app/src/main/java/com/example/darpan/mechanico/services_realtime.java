package com.example.darpan.mechanico;

public class services_realtime {

   public String CNG;
   public String Denting;
    public String Service;
    public String Tyre;
    public String nothing, donothing, again_nothing;

    public services_realtime() {

    }

    public services_realtime(String CNG, String nothing) {
        this.CNG = CNG;
        this.nothing = nothing;
    }

    public services_realtime(String Denting) {
        this.Denting = Denting;
    }

    public services_realtime(String Service, String nothing, String donothing, String again_nothing) {
        this.Service = Service;
        this.nothing = nothing;
        this.donothing = donothing;
        this.again_nothing = again_nothing;
    }

    public services_realtime(String Tyre, String nothing, String donothing) {
        this.Tyre = Tyre;
        this.nothing = nothing;
        this.donothing = donothing;
    }

    public String getCNG() {
        return CNG;
    }

    public void setCNG(String CNG) {
        this.CNG = CNG;
    }

    public String getDenting() {
        return Denting;
    }

    public String setDenting(String Denting) {
        this.Denting = Denting;
        return Denting;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }


    public String getTyre() {
        return Tyre;
    }

    public void setTyre(String Tyre) {
        this.Tyre = Tyre;
    }
}


