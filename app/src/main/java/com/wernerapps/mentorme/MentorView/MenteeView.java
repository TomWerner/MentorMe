package com.wernerapps.mentorme.MentorView;

import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;

import java.util.List;

/**
 * Created by Tom on 4/18/2015.
 */
public interface MenteeView {
    public void setName(String name);
    public void setMentees(List<Mentee> mentorList);
    public void hideProgress();
    public void showProgress();
    public void displayErrorMessage(String errorMessage);
    public void displayMenteeDetails(Mentee mentee);
}
