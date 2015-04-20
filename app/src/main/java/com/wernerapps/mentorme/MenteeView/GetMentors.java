package com.wernerapps.mentorme.MenteeView;

import com.wernerapps.mentorme.API.Mentor;

import java.util.List;

/**
 * Created by Tom on 3/29/2015.
 */
public interface GetMentors {
    public void getMentors(String user, OnFinishedListener listener);

    public interface OnFinishedListener {
        void onSuccess(List<Mentor> mentors);
        void onFailure(String errorMessage);
    }
}
