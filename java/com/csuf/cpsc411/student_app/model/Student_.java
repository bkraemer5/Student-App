package com.csuf.cpsc411.student_app.model;

import java.util.ArrayList;

public class Student_ {
    protected String mFirstName;
    protected String mLastName;
    protected int mCWID;

    protected ArrayList<CourseEnrollment_> mCourseEnrollments = new ArrayList<CourseEnrollment_>();

    public Student_(String fname, String lname, int cwid ) {
        mFirstName = fname;
        mLastName = lname;
        mCWID = cwid;
    }


    public Student_(String firstName) {
        mFirstName = firstName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getCWID() {
        return mCWID;
    }

    public void setCWID(int CWID) {
        mCWID = CWID;
    }

    public ArrayList<CourseEnrollment_> getCourseEnrollments() {
        return mCourseEnrollments;
    }

    public void setCourseEnrollments(ArrayList<CourseEnrollment_> courseEnrollments) {
        mCourseEnrollments = courseEnrollments;
    }
}
