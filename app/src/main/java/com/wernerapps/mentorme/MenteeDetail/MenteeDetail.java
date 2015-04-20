package com.wernerapps.mentorme.MenteeDetail;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;
import com.wernerapps.mentorme.MenteeView.GetMentors;
import com.wernerapps.mentorme.MenteeView.GetMentorsImpl;
import com.wernerapps.mentorme.MenteeView.MenteeHome;
import com.wernerapps.mentorme.MentorView.GetMentees;
import com.wernerapps.mentorme.MentorView.GetMenteesImpl;
import com.wernerapps.mentorme.R;

import java.util.List;

public class MenteeDetail extends ActionBarActivity {

    private TextView menteeNameView;
    private RatingBar ratingBar;
    private TextView bioView;
    private Button mentorMeButton;
    private TextView menteeMajorView;
    private TextView menteeReasonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_detail);

        final String menteeName = getIntent().getStringExtra(MenteeHome.NAME);
        setTitle(menteeName);
        menteeNameView = (TextView) findViewById(R.id.mentee_name);
        menteeMajorView = (TextView) findViewById(R.id.mentee_major);
        menteeReasonView = (TextView) findViewById(R.id.mentee_reason);
        mentorMeButton = (Button) findViewById(R.id.mentorButton);
        mentorMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenteeDetail.this, "Arranging meeting!", Toast.LENGTH_LONG).show();
            }
        });

        new GetMenteesImpl().getMentors("username", new GetMentees.OnFinishedListener() {
            @Override
            public void onSuccess(List<Mentee> mentees) {
                for (Mentee mentee: mentees)
                    if (mentee.name.equals(menteeName))
                        displayMentorDetails(mentee);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    private void displayMentorDetails(final Mentee mentee) {
        menteeNameView.post(new Runnable() {
            @Override
            public void run() {
                menteeNameView.setText(mentee.name);
            }
        });
        menteeMajorView.post(new Runnable() {
            @Override
            public void run() {
                menteeMajorView.setText(mentee.major);
            }
        });
        menteeReasonView.post(new Runnable() {
            @Override
            public void run() {
                menteeReasonView.setText(mentee.reason);
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
