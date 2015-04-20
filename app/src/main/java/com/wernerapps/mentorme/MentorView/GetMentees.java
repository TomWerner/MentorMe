package com.wernerapps.mentorme.MentorView;

import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;

import java.util.List;

/**
 * Created by Tom on 3/29/2015.
 */
public interface GetMentees {
    public void getMentors(String user, OnFinishedListener listener);

    public interface OnFinishedListener {
        void onSuccess(List<Mentee> mentors);
        void onFailure(String errorMessage);
    }
}
