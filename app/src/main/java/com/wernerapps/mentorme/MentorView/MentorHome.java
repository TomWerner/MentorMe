package com.wernerapps.mentorme.MentorView;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;
import com.wernerapps.mentorme.MenteeDetail.MenteeDetail;
import com.wernerapps.mentorme.MentorDetail.MentorDetail;
import com.wernerapps.mentorme.R;

import java.util.List;

public class MentorHome extends ActionBarActivity implements MenteeView {

    public static final String NAME = "NAME";
    private MenteePresenter presenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AbsListView listView;
    private Button errorButton;
    private String username = "username";


    @Override
    public void onResume() {
        super.onResume();
        presenter.getMentors(username);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mentee Listing");
        this.presenter = new MenteePresenterImpl(this);

//        welcomeTextView = (TextView) findViewById(R.id.welcomeView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getMentors(username);
            }
        });

        listView = (AbsListView) findViewById(R.id.mentors_listview);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int topRowVerticalPosition =
                        (listView == null || listView.getChildCount() == 0) ?
                                0 : listView.getChildAt(0).getTop();
                swipeRefreshLayout.setEnabled(firstVisibleItem == 0 && topRowVerticalPosition >= 0);
            }
        });

        errorButton = (Button) findViewById(R.id.predictions_error_display);
        errorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getMentors(username);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mentor mentor = (Mentor) listView.getAdapter().getItem(position);
                Intent intent = new Intent(MentorHome.this, MentorDetail.class);
                intent.putExtra(NAME, mentor.name);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setName(String name) {
//        welcomeTextView.setText("Welcome, " + name + "!");
        setTitle(name + "'s Mentors");
    }

    @Override
    public void setMentees(final List<Mentee> menteeListing) {
        if (menteeListing.size() > 0) {
            listView.setVisibility(View.VISIBLE);
            errorButton.setVisibility(View.GONE);

            MenteeAdapter adapter = new MenteeAdapter(listView.getContext(), presenter, menteeListing);
            AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
            animationAdapter.setAbsListView(listView);
            listView.setAdapter(animationAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    presenter.onItemClicked(menteeListing.get(position));
                }
            });
        }
        else {
            listView.setVisibility(View.GONE);
            errorButton.setVisibility(View.VISIBLE);

            errorButton.setText("No Mentors Available.\nTap to refresh.");
        }
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void displayErrorMessage(String errorMessage) {
        listView.setVisibility(View.GONE);
        errorButton.setVisibility(View.VISIBLE);
        System.out.println(errorMessage);
        errorButton.setText(errorMessage);
    }

    @Override
    public void displayMenteeDetails(Mentee mentee) {
        Intent intent = new Intent(this, MenteeDetail.class);
        intent.putExtra(NAME, mentee.name);

        // Use TaskStackBuilder to build the back stack and get the PendingIntent
        PendingIntent pendingIntent =
                TaskStackBuilder.create(this)
                        // add all of DetailsActivity's parents to the stack,
                        // followed by DetailsActivity itself
                        .addNextIntentWithParentStack(intent)
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
