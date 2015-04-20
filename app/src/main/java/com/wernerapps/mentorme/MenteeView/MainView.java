package com.wernerapps.mentorme.MenteeView;

import com.wernerapps.mentorme.API.Mentor;

import java.util.List;

/**
 * Created by Tom on 4/18/2015.
 */
public interface MainView {
    public void setName(String name);
    public void setMentors(List<Mentor> mentorList);
    public void hideProgress();
    public void showProgress();
    public void displayErrorMessage(String errorMessage);
    public void displayMentorDetails(Mentor mentor);
}
