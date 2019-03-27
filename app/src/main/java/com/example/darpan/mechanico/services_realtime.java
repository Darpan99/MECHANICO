package com.example.darpan.mechanico;

public class services_realtime {

    public String cng;
    public String denting;
    public String service;
    public String tyre;
    public String nothing, donothing, again_nothing;

    public services_realtime() {

    }

    public services_realtime(String cng, String nothing) {
        this.cng = cng;
        this.nothing = nothing;
    }

    public services_realtime(String denting) {
        this.denting = denting;
    }

    public services_realtime(String service, String nothing, String donothing, String again_nothing) {
        this.service = service;
        this.nothing = nothing;
        this.donothing = donothing;
        this.again_nothing = again_nothing;
    }

    public services_realtime(String tyre, String nothing, String donothing) {
        this.tyre = tyre;
        this.nothing = nothing;
        this.donothing = donothing;
    }



    public String getDenting() {
        return denting;
    }

    public String setDenting(String denting) {
        this.denting = denting;
        return denting;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public String getCng() {
        return cng;
    }

    public void setCng(String cng) {
        this.cng = cng;
    }
}


