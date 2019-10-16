package com.csuf.cpsc411.student_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.csuf.cpsc411.student_app.model.StudentDB_;
import com.csuf.cpsc411.student_app.model.Student_;

public class StudentDetails extends AppCompatActivity {

    protected Menu detailMenu;
    //protected int personIndex;
    protected Student_ pObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        int personIndex = getIntent().getIntExtra("PersonIndex", 0);
        TextView tv = findViewById(R.id.display_string_id);
        // display the person index
        String origStr = (String) tv.getText();
        tv.setText(origStr + personIndex);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(15);
        //
        pObj = StudentDB_.getOurInstance().getStudentList().get(personIndex);
        //
        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(pObj.getFirstName());
        editView.setEnabled(false); // make it read only (not editable)
        editView = findViewById(R.id.p_last_name_id);
        editView.setText(pObj.getLastName());
        editView.setEnabled(false);
        //

    }
    /*
    Button button = (Button)findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener {
        public void onClick(View v) {
            // Do something in response to button click
        }
    });
     */

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // custom menu inflation
        getMenuInflater().inflate(R.menu.detail_screen_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_first_name_id);
            editView.setEnabled(true); // make it read only (not editable)
            editView = findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        }
        else if (item.getItemId() == R.id.action_done) {
            EditText editView = findViewById(R.id.p_first_name_id);
            pObj.setFirstName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.p_last_name_id);
            pObj.setLastName(editView.getText().toString());
            editView.setEnabled(false);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);

        }
        return super.onOptionsItemSelected(item);
    }
     */

}
