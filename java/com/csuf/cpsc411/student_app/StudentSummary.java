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
        courseEnrollments.add(new CourseEnrollment_("102A", "B"));
        courseEnrollments.add(new CourseEnrollment_("103C", "A"));
        student.setCourseEnrollments(courseEnrollments);
        ArrayList<Student_> students = new ArrayList<Student_>();
        students.add(student);

        student = new Student_("Pal", "Damo", 1888293);
        courseEnrollments.add(new CourseEnrollment_("105K", "A"));
        courseEnrollments.add(new CourseEnrollment_("101D", "A"));
        student.setCourseEnrollments(courseEnrollments);
        students.add(student);

        StudentDB_.getOurInstance().setStudentList(students);
    }
}
