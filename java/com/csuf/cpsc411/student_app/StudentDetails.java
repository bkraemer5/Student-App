package com.csuf.cpsc411.student_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.csuf.cpsc411.student_app.model.StudentDB_;
import com.csuf.cpsc411.student_app.model.Student_;

import java.util.ArrayList;

public class StudentDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // The Layout file we will use for our Activity
        setContentView(R.layout.activity_student_details);


        // Gets the Item No. of the Student that was clicked on
        int studentIndex = getIntent().getIntExtra("StudentIndex", 0);


        // Grabs Instance of Student by finding the student at studentIndex
        Student_ pObj = StudentDB_.getOurInstance().getStudentList().get(studentIndex);


        // Grabs TextView that displays Student CWID
        TextView tv = findViewById(R.id.display_string_id);


        // display add student's CWID to original text
        int studentCWID = pObj.getCWID();
        String origStr = (String) tv.getText();
        tv.setText(origStr + studentCWID);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(15);


        // set EditText view to display the student's first name
        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(pObj.getFirstName());


        // set EditText view to display the student's last name
        editView = findViewById(R.id.p_last_name_id);
        editView.setText(pObj.getLastName());


        // creates a ListView for student courses
        ListView lv = findViewById(R.id.course_list_id);


        // An array that displays the Course and Grade of the student
        int sizeOfCourseList = pObj.getCourseEnrollments().size();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < sizeOfCourseList; i++) {
            list.add("Course: " + pObj.getCourseEnrollments().get(i).getCourseID() +
                    "    Grade: " + pObj.getCourseEnrollments().get(i).getGrade());
        }


        // An adapter to arrange the list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list
        );


        // applies the adapter to the course_list ListView
        lv.setAdapter(arrayAdapter);


        // sets the click activity for the button to return to the StudentSummary page
        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), StudentSummary.class);
                view.getContext().startActivity(intent);
            }
        });
    }

}
