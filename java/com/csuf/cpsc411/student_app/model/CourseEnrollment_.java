package com.csuf.cpsc411.student_app.model;

public class CourseEnrollment_ {

    protected String mCourseID;
    protected String mGrade;

    public CourseEnrollment_(String courseid, String grade) {
        mCourseID = courseid;
        mGrade = grade;
    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }
}
