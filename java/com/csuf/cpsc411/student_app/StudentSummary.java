package com.csuf.cpsc411.student_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.csuf.cpsc411.student_app.adapter.StudentSummaryAdapter;

public class StudentSummary extends Activity {


    // creates a ListView for Student objects
    protected ListView mSummaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // The Layout file we will use for our Activity
        setContentView(R.layout.activity_student_summary);


        // Applies the StudentAdapter to the ListView object
        mSummaryView = findViewById(R.id.summary_list_id);
        StudentSummaryAdapter ad = new StudentSummaryAdapter();
        mSummaryView.setAdapter(ad);
        }
}
