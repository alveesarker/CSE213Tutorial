package com.example.midpreparation;

import javafx.scene.control.Alert;

public class CourseOutline {
    private String courseId, courseTitle, prReq1, preReq2, preReq3, semester, description ;
    private int noOfCredits, year;

    public CourseOutline(String courseId, String courseTitle, String prReq1, String preReq2, String preReq3, String semester, String description, int noOfCredits, int year) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.prReq1 = prReq1;
        this.preReq2 = preReq2;
        this.preReq3 = preReq3;
        this.semester = semester;
        this.description = description;
        this.noOfCredits = noOfCredits;
        this.year = year;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getPrReq1() {
        return prReq1;
    }

    public void setPrReq1(String prReq1) {
        this.prReq1 = prReq1;
    }

    public String getPreReq2() {
        return preReq2;
    }

    public void setPreReq2(String preReq2) {
        this.preReq2 = preReq2;
    }

    public String getPreReq3() {
        return preReq3;
    }

    public void setPreReq3(String preReq3) {
        this.preReq3 = preReq3;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(int noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CourseOutline{" +
                "courseId='" + courseId + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", prReq1='" + prReq1 + '\'' +
                ", preReq2='" + preReq2 + '\'' +
                ", preReq3='" + preReq3 + '\'' +
                ", semester='" + semester + '\'' +
                ", description='" + description + '\'' +
                ", noOfCredits=" + noOfCredits +
                ", year=" + year +
                '}';
    }

    public void showCourseType(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if(this.courseId.endsWith("L")){
            a.setContentText("This is a lab course");
        } else {
            a.setContentText("This is a Theory course");
        }
        a.showAndWait();
    }
}
