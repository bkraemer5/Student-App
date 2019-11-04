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
        createStudentObjects();
    }


    // Main function that will create the student objects
    protected void createStudentObjects() {


        // Array of Student Objects
        ArrayList<Student_> students = new ArrayList<Student_>();


        // STUDENT #1 ----------------------------------------------------------------
        Student_ student = new Student_("Student", "One", "192039");
        ArrayList<CourseEnrollment_> courseEnrollments = new ArrayList<CourseEnrollment_>();
        courseEnrollments.add(new CourseEnrollment_("CPSC131", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC120", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC121", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC301", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC411", "D"));
        student.setCourseEnrollments(courseEnrollments);
        students.add(student);


        // STUDENT #2 ----------------------------------------------------------------
        courseEnrollments = new ArrayList<CourseEnrollment_>();
        student = new Student_("Student", "Two", "888293");
        courseEnrollments.add(new CourseEnrollment_("CPSC223", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC440", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC332", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC471", "F"));
        courseEnrollments.add(new CourseEnrollment_("CPSC301", "F"));
        student.setCourseEnrollments(courseEnrollments);
        students.add(student);


        // STUDENT #3 ----------------------------------------------------------------
        courseEnrollments = new ArrayList<CourseEnrollment_>();
        student = new Student_("Student", "Three", "1483920");
        courseEnrollments.add(new CourseEnrollment_("CPSC440", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC335", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC411", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC131", "F"));
        courseEnrollments.add(new CourseEnrollment_("CPSC121", "B"));
        student.setCourseEnrollments(courseEnrollments);
        students.add(student);


        // Add Student objects from ArrayList 'students' to our StudentDB instance
        setStudentList(students);
    }
}
