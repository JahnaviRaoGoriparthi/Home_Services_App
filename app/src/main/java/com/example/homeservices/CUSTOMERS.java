package com.example.homeservices;

public class CUSTOMERS {
    String name;
    String num;
    String add;

    public CUSTOMERS(String name, String num, String add) {
        this.name = name;
        this.num = num;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getAdd() {
        return add;
    }
}
