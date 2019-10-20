package com.csuf.cpsc411.student_app.model;

import java.util.ArrayList;

public class Student_ {

    // member variables for Student
    protected String mFirstName;
    protected String mLastName;
    protected int mCWID;


    // Array for the Courses the Student is taking
    protected ArrayList<CourseEnrollment_> mCourseEnrollments = new ArrayList<CourseEnrollment_>();


    // Student Constructor
    public Student_(String fname, String lname, int cwid ) {
        mFirstName = fname;
        mLastName = lname;
        mCWID = cwid;
    }


    // Getter + Setter for member variable: FirstName
    public String getFirstName() {
        return mFirstName;
    }
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }


    // Getter + Setter for member variable: LastName
    public String getLastName() {
        return mLastName;
    }
    public void setLastName(String lastName) {
        mLastName = lastName;
    }


    // Getter + Setter for member variable: CWID
    public int getCWID() {
        return mCWID;
    }
    public void setCWID(int CWID) {
        mCWID = CWID;
    }


    // Getter + Setter for CourseEnrollment ArrayList
    public ArrayList<CourseEnrollment_> getCourseEnrollments() {
        return mCourseEnrollments;
    }
    public void setCourseEnrollments(ArrayList<CourseEnrollment_> courseEnrollments) {
        mCourseEnrollments = courseEnrollments;

    }
}
