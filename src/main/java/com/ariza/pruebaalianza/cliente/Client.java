package com.ariza.pruebaalianza.cliente;

import java.util.Date;

public class Client {
    private String sharedKey;
    private String name;
    private String phone;
    private String email;
    private Date starDate;
    private Date endDate;

    public Client() {
    }

    public Client(String sharedKey, String name, String phone, String email, Date starDate, Date endDate) {
        this.sharedKey = sharedKey;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.starDate = starDate;
        this.endDate = endDate;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getStarDate() {
        return starDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
