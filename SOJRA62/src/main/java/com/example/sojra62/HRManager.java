package com.example.sojra62;

public class HRManager extends User{
    private String companyName;
    private String designation;

    public HRManager(String id, String name, String email, String password, String phone, String companyName, String designation) {
        super(id, name, email, password, phone);
        this.companyName = companyName;
        this.designation = designation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "HRManager{" +
                "companyName='" + companyName + '\'' +
                ", designation='" + designation + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
