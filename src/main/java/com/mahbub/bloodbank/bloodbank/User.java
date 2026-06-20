package com.mahbub.bloodbank.bloodbank;

public class User {
    private String name, bloodGroup, district, mobile;

    public User(String name, String bloodGroup, String district, String mobile) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.district = district;
        this.mobile = mobile;
    }

    public String getName() { return name; }
    public String getBloodGroup() { return bloodGroup; }
    public String getDistrict() { return district; }
    public String getMobile() { return mobile; }
}