package com.example.random;

public class re_fields {
    private String re_pass;
    private String re_email;
    private String re_phone;
    private String re_name;
    private String re_addr;
    private boolean check;

    //欄位
    public re_fields(String re_pass, String re_email) {
        this.re_pass = re_pass;
        this.re_email = re_email;
    }

    public re_fields(String re_pass, String re_email, boolean check) {
        this.re_pass = re_pass;
        this.re_email = re_email;
        this.check = check;
    }

    public re_fields(String re_pass, String re_email, String re_phone, String re_name, String re_addr) {
        this.re_pass = re_pass;
        this.re_email = re_email;
        this.re_phone = re_phone;
        this.re_name = re_name;
        this.re_addr = re_addr;
    }

    public re_fields(String re_name) {
        this.re_name = re_name;
    }

    public String getPassword() {
        return re_pass;
    }

    public String getEmail() {
        return re_email;
    }

    public String getPhone() {
        return re_phone;
    }

    public String getName() {
        return re_name;
    }

    public String getAddr() {
        return re_addr;
    }

    public boolean getCheck(){return check;}

    public void setAddr(String re_addr) {
        this.re_addr = re_addr;
    }

    public void setPassword(String re_pass) {
        this.re_pass = re_pass;
    }

    public void setEmail(String re_email) {
        this.re_email = re_email;
    }

    public void setPhone(String re_phone) {
        this.re_phone = re_phone;
    }

    public void setName(String re_name) {
        this.re_name = re_name;
    }
}
