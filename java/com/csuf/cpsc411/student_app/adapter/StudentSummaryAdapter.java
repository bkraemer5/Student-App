package com.csuf.cpsc411.student_app.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csuf.cpsc411.student_app.R;
import com.csuf.cpsc411.student_app.StudentDetails;
import com.csuf.cpsc411.student_app.model.StudentDB_;
import com.csuf.cpsc411.student_app.model.Student_;

// ADAPTER class for StudentSummary Activity
public class StudentSummaryAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        // returns how many students are in the list
        return StudentDB_.getOurInstance().getStudentList().size();
    }

    @Override
    public Object getItem(int i) {
        // returns a specific student from list
        return StudentDB_.getOurInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        // return id of item
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        // View we are going to use
        View row_view;


        // Create new view
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_rows, viewGroup, false);
        }

        // Use current view
        else row_view = view;


        // Generate student_row layout
        Student_ s = StudentDB_.getOurInstance().getStudentList().get(i);
        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());


        // Sets a tag for each Student Item
        row_view.setTag(new Integer(i));


        // Generates instruction for when a Student Item is clicked on
        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // Page Navigation to StudentDetails Activity
                        Intent intent = new Intent(view.getContext(), StudentDetails.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);

                    }
                }
        );

        return row_view;
    }
}
