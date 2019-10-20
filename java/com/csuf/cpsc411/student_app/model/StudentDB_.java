package com.csuf.cpsc411.student_app.model;

import java.util.ArrayList;

public class StudentDB_ {

    // Instance of StudentDB
    private static final StudentDB_ ourInstance = new StudentDB_();


    // Generates list of Students
    private ArrayList<Student_> mStudentList = new ArrayList<Student_>();


    // Getter function for StudentDB Instance
    public static StudentDB_ getOurInstance() {
        return ourInstance;
    }


    // Getter + Setter for Student List
    public ArrayList<Student_> getStudentList() {
        return mStudentList;
    }
    public void setStudentList(ArrayList<Student_> studentList) {
        mStudentList = studentList;
    }


    // Constructor for StudentDB
    public StudentDB_() {
    }
}
