package com.user.model;

import java.sql.Date;

public class Assignment {
    private int assignmentId;
    private int courseId;
    private String courseName;
    private String assignment;
    private Date createdDate;
    private Date lastDate;

    // Getters and Setters
    public int getAssignmentId() { return assignmentId; }
    public void setAssignmentId(int assignmentId) { this.assignmentId = assignmentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getAssignment() { return assignment; }
    public void setAssignment(String assignment) { this.assignment = assignment; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Date getLastDate() { return lastDate; }
    public void setLastDate(Date lastDate) { this.lastDate = lastDate; }
}
