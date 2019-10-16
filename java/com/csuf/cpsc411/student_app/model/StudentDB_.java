package com.csuf.cpsc411.student_app.model;

import java.util.ArrayList;

public class StudentDB_ {
    private static final StudentDB_ ourInstance = new StudentDB_();

    private ArrayList<Student_> mStudentList = new ArrayList<Student_>();

    public static StudentDB_ getOurInstance() {
        return ourInstance;
    }

    public ArrayList<Student_> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student_> studentList) {
        mStudentList = studentList;
    }

    public StudentDB_() {
    }
}
