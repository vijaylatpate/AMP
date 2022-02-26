package com.sbvc.amp2022;

public class Employee {
    int id;
    String sname;

    public Employee() {

    }

    public Employee(int id, String sname) {
        this.id = id;
        this.sname = sname;
    }

    public Employee(String sname) {
        this.sname = sname;
    }

    public int getnId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSName() {
        return sname;
    }

    public void setSName(String sname) {
        this.sname = sname;
    }
}
