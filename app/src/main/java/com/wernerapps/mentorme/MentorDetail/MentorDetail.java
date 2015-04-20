package com.wernerapps.mentorme.MentorDetail;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wernerapps.mentorme.API.Mentor;
import com.wernerapps.mentorme.MenteeView.GetMentors;
import com.wernerapps.mentorme.MenteeView.GetMentorsImpl;
import com.wernerapps.mentorme.MenteeView.MenteeHome;
import com.wernerapps.mentorme.R;

import java.util.List;

public class MentorDetail extends ActionBarActivity {

    private TextView mentorNameView;
    private RatingBar ratingBar;
    private TextView bioView;
    private Button mentorMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_detail);

        final String mentorName = getIntent().getStringExtra(MenteeHome.NAME);
        setTitle(mentorName);
        mentorNameView = (TextView) findViewById(R.id.mentor_name);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        bioView = (TextView) findViewById(R.id.bioTextView);
        mentorMeButton = (Button) findViewById(R.id.mentorButton);
        mentorMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MentorDetail.this, "Arranging meeting!", Toast.LENGTH_LONG).show();
            }
        });

        new GetMentorsImpl().getMentors("username", new GetMentors.OnFinishedListener() {
            @Override
            public void onSuccess(List<Mentor> mentors) {
                for (Mentor mentor : mentors)
                    if (mentor.name.equals(mentorName))
                        displayMentorDetails(mentor);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    private void displayMentorDetails(final Mentor mentor) {
        mentorNameView.post(new Runnable() {
            @Override
            public void run() {
                mentorNameView.setText(mentor.name);
            }
        });
        ratingBar.post(new Runnable() {
            @Override
            public void run() {
                ratingBar.setMax(5);
                ratingBar.setRating(mentor.rating);
            }
        });
        bioView.post(new Runnable() {
            @Override
            public void run() {
                String result = mentor.name + " is a promising " + ((int)(Math.random() * 2) + 3) + " year student majoring in " + mentor.major + ". With a " + mentor.gpa + " GPA and a rating of " + mentor.rating
                        + " out of 5, they are a perfect mentor for any freshman. They had an internship with Microsoft and Google, and are excited to pass their knowledge along!";
                bioView.setText(result);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
        }
        return true;
    }
}
