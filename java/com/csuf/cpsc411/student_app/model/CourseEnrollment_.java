package com.csuf.cpsc411.student_app.model;

public class CourseEnrollment_ {

    // Member variables for CourseEnrollment
    protected String mCourseID;
    protected String mGrade;


    // Constructor for CourseEnrollment
    public CourseEnrollment_(String courseid, String grade) {
        mCourseID = courseid;
        mGrade = grade;
    }


    // Getter + Setter for CourseID
    public String getCourseID() {
        return mCourseID;
    }
    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }


    // Getter + Setter for CourseID
    public String getGrade() {
        return mGrade;
    }
    public void setGrade(String grade) {
        mGrade = grade;
    }

}
