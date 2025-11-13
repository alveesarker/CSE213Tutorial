package com.example.sojra62;

public class Candidate extends User{
    private String address;
    private String education;
    private String skill;
    private int experience;

    public Candidate(String id, String name, String email, String password, String phone, String address, String education, String skill, int experience) {
        super(id, name, email, password, phone);
        this.address = address;
        this.education = education;
        this.skill = skill;
        this.experience = experience;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", skill='" + skill + '\'' +
                ", experience=" + experience +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
