package com.example.finalexam_yoursecno_yourid;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class JobApplication implements Serializable {
    private int applicationNo, yearOfExperience;
    private String name, designationAppliedFor;
    private LocalDate dateOfApplication;
    private boolean isFreshGraduate;
    private ArrayList<String> expertiseList;

    public JobApplication(int applicationNo, int yearOfExperience, String name, String designationAppliedFor, LocalDate dateOfApplication, boolean isFreshGraduate, ArrayList<String> expertiseList) {
        this.applicationNo = applicationNo;
        this.yearOfExperience = yearOfExperience;
        this.name = name;
        this.designationAppliedFor = designationAppliedFor;
        this.dateOfApplication = dateOfApplication;
        this.isFreshGraduate = isFreshGraduate;
        this.expertiseList = expertiseList;
    }

    public int getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(int applicationNo) {
        this.applicationNo = applicationNo;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignationAppliedFor() {
        return designationAppliedFor;
    }

    public void setDesignationAppliedFor(String designationAppliedFor) {
        this.designationAppliedFor = designationAppliedFor;
    }

    public LocalDate getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(LocalDate dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public boolean isFreshGraduate() {
        return isFreshGraduate;
    }

    public void setFreshGraduate(boolean freshGraduate) {
        isFreshGraduate = freshGraduate;
    }

    public ArrayList<String> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(ArrayList<String> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationNo=" + applicationNo +
                ", yearOfExperience=" + yearOfExperience +
                ", name='" + name + '\'' +
                ", designationAppliedFor='" + designationAppliedFor + '\'' +
                ", dateOfApplication=" + dateOfApplication +
                ", isFreshGraduate=" + isFreshGraduate +
                ", expertiseList=" + expertiseList +
                '}';
    }

    public void showApplicationDetailAsAlert(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("JobApplication{" +
                "applicationNo=" + applicationNo +
                ", yearOfExperience=" + yearOfExperience +
                ", name='" + name + '\'' +
                ", designationAppliedFor='" + designationAppliedFor + '\'' +
                ", dateOfApplication=" + dateOfApplication +
                ", isFreshGraduate=" + isFreshGraduate +
                ", expertiseList=" + expertiseList +
                '}');
        a.showAndWait();
    }
}
