package com.csuf.cpsc411.student_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.csuf.cpsc411.student_app.model.CourseEnrollment_;
import com.csuf.cpsc411.student_app.model.StudentDB_;
import com.csuf.cpsc411.student_app.model.Student_;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {

    // Grabs Instance of Student by finding the student at studentIndex
    protected Student_ pObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The Layout file we will use for our Activity
        setContentView(R.layout.activity_student_details);


        // Gets the Item No. of the Student that was clicked on
        int studentIndex = getIntent().getIntExtra("StudentIndex", 0);


        // Grabs the instance of selected student
        pObj = StudentDB_.getOurInstance().getStudentList().get(studentIndex);


        // set EditText view to display the student's first name
        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(pObj.getFirstName());
        editView.setEnabled(false);


        // set EditText view to display the student's last name
        editView = findViewById(R.id.p_last_name_id);
        editView.setText(pObj.getLastName());
        editView.setEnabled(false);


        // set EditText view to display student's cwid
        editView = findViewById(R.id.cwid_id);
        editView.setText(pObj.getCWID());
        editView.setEnabled(false);


        // creates a ListView for student courses
        final ListView lv = findViewById(R.id.course_list_id);


        // An array that displays the Course and Grade of the student
        int sizeOfCourseList = pObj.getCourseEnrollments().size();
        final ArrayList<String> list = new ArrayList<String>();
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


        // creates a button to allow the addition of courses
        final Button button = findViewById(R.id.course_button);
        button.setText("Add Course");


        // Hides the course editor view
        final LinearLayout courseEdit = findViewById(R.id.edit_enrollment_layout);
        courseEdit.setVisibility(View.GONE);

        /* When the button is clicked on, it switches from the course enrollment list view
        to the course editor view. */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button.getText() == "Add Course") {
                    button.setText("Done");
                    lv.setVisibility(View.GONE);
                    courseEdit.setVisibility(View.VISIBLE);
                }
                else if (button.getText() == "Done") {
                    button.setText("Add Course");
                    EditText editCourse = findViewById(R.id.add_course_id);
                    EditText editGrade = findViewById(R.id.add_grade);
                    String newCourseID = editCourse.getText().toString();
                    String newGrade = editGrade.getText().toString();

                    // updates the course list as long as neither the courseID or grade is empty
                    if (!(newCourseID.matches("") || newGrade.matches(""))) {
                        ArrayList<CourseEnrollment_> temp = pObj.getCourseEnrollments();
                        temp.add(new CourseEnrollment_(newCourseID, newGrade));
                        list.add("Course: " + newCourseID + "    Grade: " + newGrade);
                        lv.invalidateViews();
                    }

                    // if null, it will print an error message to the screen and the list will remain the same
                    else {
                        Toast.makeText(view.getContext(), "Invalid inputs", Toast.LENGTH_SHORT).show();
                    }

                    courseEdit.setVisibility(View.GONE);
                    lv.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    Menu detailMenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // custom menu inflation
        getMenuInflater().inflate(R.menu.studentdetails_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        /* When user clicks on Menu Item "Edit", the EditText views will then
        become open to changes */
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_first_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.cwid_id);
            editView.setEnabled(true);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        }

        /* When user clicks on Menu Item "Done", the EditText views will
        close and what was modified will be stored in the StudentDB instance */
        else if (item.getItemId() == R.id.action_done) {
            EditText editView = findViewById(R.id.p_first_name_id);
            pObj.setFirstName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.p_last_name_id);
            pObj.setLastName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.cwid_id);
            pObj.setCWID(editView.getText().toString());
            editView.setEnabled(false);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);
        }

        /* When user clicks on Menu Item "Back", the student details activity will
        switch back to the Student summary list activity */
        else if (item.getItemId() == R.id.action_back) {
            Intent intent = new Intent(this, StudentSummary.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
