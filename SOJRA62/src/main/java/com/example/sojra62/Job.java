package com.example.sojra62;

import java.time.LocalDate;

public class Job {
    private String jobTitle;
    private String companyName;
    private double salary;
    private String location;
    private String employmentType;
    private LocalDate deadline;
    private LocalDate postedDate;

    public Job(String jobTitle, String companyName, double salary, String location, String employmentType, LocalDate deadline, LocalDate postedDate) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.salary = salary;
        this.location = location;
        this.employmentType = employmentType;
        this.deadline = deadline;
        this.postedDate = postedDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", deadline=" + deadline +
                ", postedDate=" + postedDate +
                '}';
    }
}
