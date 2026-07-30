package com.example.demoproject;

import java.io.Serializable;

public class RegCourse implements Serializable {
    private String studentID;
    private String courseName;

    public RegCourse(String studentID, String courseName) {
        this.studentID = studentID;
        this.courseName = courseName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
