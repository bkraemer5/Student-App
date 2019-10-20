package com.csuf.cpsc411.student_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.csuf.cpsc411.student_app.adapter.StudentSummaryAdapter;
import com.csuf.cpsc411.student_app.model.CourseEnrollment_;
import com.csuf.cpsc411.student_app.model.Student_;
import com.csuf.cpsc411.student_app.model.StudentDB_;

import java.util.ArrayList;

public class StudentSummary extends Activity {


    // creates a ListView for Student objects
    protected ListView mSummaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // The Layout file we will use for our Activity
        setContentView(R.layout.activity_student_summary);


        // call of the function that will use to create the Students
        createStudentObjects();


        // Applies the StudentAdapter to the ListView object
        mSummaryView = findViewById(R.id.summary_list_id);
        StudentSummaryAdapter ad = new StudentSummaryAdapter();
        mSummaryView.setAdapter(ad);

        }


    // Main function that will create the student objects
    protected void createStudentObjects() {


        // Array of Student Objects
        ArrayList<Student_> students = new ArrayList<Student_>();


        // STUDENT #1 ----------------------------------------------------------------
        Student_ student = new Student_("Student", "One", 192039);
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
        student = new Student_("Student", "Two", 1888293);
        courseEnrollments.add(new CourseEnrollment_("CPSC223", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC440", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC332", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC471", "F"));
        courseEnrollments.add(new CourseEnrollment_("CPSC301", "F"));
        student.setCourseEnrollments(courseEnrollments);
        students.add(student);


        // STUDENT #3 ----------------------------------------------------------------
        courseEnrollments = new ArrayList<CourseEnrollment_>();
        student = new Student_("Student", "Three", 1483920);
        courseEnrollments.add(new CourseEnrollment_("CPSC440", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC335", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC411", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC131", "F"));
        courseEnrollments.add(new CourseEnrollment_("CPSC121", "B"));
        student.setCourseEnrollments(courseEnrollments);
        students.add(student);


        // Add Student objects from ArrayList 'students' to our StudentDB instance
        StudentDB_.getOurInstance().setStudentList(students);
    }
}
