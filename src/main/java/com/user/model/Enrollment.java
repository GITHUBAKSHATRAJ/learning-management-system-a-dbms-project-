package com.user.model;

public class Enrollment {
    private int id; // User ID
    private int courseId;
    private int studentId;

    // Constructors
    public Enrollment() {}

    public Enrollment(int id, int courseId, int studentId) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
