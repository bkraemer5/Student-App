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

    protected Menu detailMenu;
    protected int studentIndex;
    protected Student_ pObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);
        TextView tv = findViewById(R.id.display_string_id);
        pObj = StudentDB_.getOurInstance().getStudentList().get(studentIndex);
        // display the person index
        int studentCWID = pObj.getCWID();
        String origStr = (String) tv.getText();
        tv.setText(origStr + studentCWID);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(15);

        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(pObj.getFirstName());
        editView = findViewById(R.id.p_last_name_id);
        editView.setText(pObj.getLastName());
        //
        ListView lv = findViewById(R.id.course_list_id);

        int sizeOfCourseList = pObj.getCourseEnrollments().size();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < sizeOfCourseList; i++) {
            list.add("Course: " + pObj.getCourseEnrollments().get(i).getCourseID() +
                    "    Grade: " + pObj.getCourseEnrollments().get(i).getGrade());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list
        );
        lv.setAdapter(arrayAdapter);


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
