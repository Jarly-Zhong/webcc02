package com.webcc.model;

public class Course {
    private Integer courseId;

    private String courseName;

    private String courseTime;

    private Integer teacherid;

    private Integer current_size;

    private Integer max_size;

    private Integer status;

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    private String examTime;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCurrent_size() {
        return current_size;
    }

    public void setCurrent_size(Integer current_size) {
        this.current_size = current_size;
    }

    public Integer getMax_size() {
        return max_size;
    }

    public void setMax_size(Integer max_size) {
        this.max_size = max_size;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}