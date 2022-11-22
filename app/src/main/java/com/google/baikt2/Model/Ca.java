package com.google.baikt2.Model;

public class Ca {
    String tenthuonggoi,tenkhoahoc,url,dactinh,mauca;

    Ca(){

    }

    public Ca(String tenthuonggoi, String tenkhoahoc, String url, String dactinh, String mauca) {
        this.tenthuonggoi = tenthuonggoi;
        this.tenkhoahoc = tenkhoahoc;
        this.url = url;
        this.dactinh = dactinh;
        this.mauca = mauca;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getMauca() {
        return mauca;
    }

    public void setMauca(String mauca) {
        this.mauca = mauca;
    }
}
