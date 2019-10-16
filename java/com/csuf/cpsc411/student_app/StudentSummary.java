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


    protected ListView mSummaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_summary);

        createStudentObjects();
        mSummaryView = findViewById(R.id.summary_list_id);
        StudentSummaryAdapter ad = new StudentSummaryAdapter();
        mSummaryView.setAdapter(ad);

        }


    protected void createStudentObjects() {
        Student_ student = new Student_("Brittany", "Kraemer", 192039);
        ArrayList<CourseEnrollment_> courseEnrollments = new ArrayList<CourseEnrollment_>();
        courseEnrollments.add(new CourseEnrollment_("CPSC131", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC120", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC121", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC301", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC411", "D"));

        student.setCourseEnrollments(courseEnrollments);
        ArrayList<Student_> students = new ArrayList<Student_>();
        students.add(student);

        courseEnrollments = new ArrayList<CourseEnrollment_>();
        student = new Student_("Pal", "Damo", 1888293);
        courseEnrollments.add(new CourseEnrollment_("CPSC223", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC440", "A"));
        courseEnrollments.add(new CourseEnrollment_("CPSC332", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC471", "F"));
        courseEnrollments.add(new CourseEnrollment_("CPSC301", "F"));



        student.setCourseEnrollments(courseEnrollments);
        students.add(student);

        courseEnrollments = new ArrayList<CourseEnrollment_>();
        student = new Student_("OtherPal", "CorgiPup", 1483920);
        courseEnrollments.add(new CourseEnrollment_("CPSC440", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC335", "B"));
        courseEnrollments.add(new CourseEnrollment_("CPSC411", "C"));
        courseEnrollments.add(new CourseEnrollment_("CPSC131", "F"));
        courseEnrollments.add(new CourseEnrollment_("CPSC121", "B"));

        student.setCourseEnrollments(courseEnrollments);
        students.add(student);

        StudentDB_.getOurInstance().setStudentList(students);
    }
}
