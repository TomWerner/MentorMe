package com.wernerapps.mentorme.MentorView;

import com.wernerapps.mentorme.API.API;
import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;

import java.util.ArrayList;
import java.util.Collections;

import retrofit.RestAdapter;

/**
 * Created by Tom on 3/29/2015.
 */
public class GetMenteesImpl implements GetMentees {
    @Override
    public void getMentors(String username, final OnFinishedListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API.API_URL)
                .build();

        API service = restAdapter.create(API.class);

        Mentee[] mentees = {
                new Mentee("Tom W.", "Computer Science", "Class Recommendations", 5),
                new Mentee("Dylan P.", "Business", "Internship Advice", 3),
                new Mentee("Abby R.", "Math", "Research Opportunities", 4)
        };

        ArrayList<Mentee> menteeList = new ArrayList<Mentee>();
        for (int i = 0; i < mentees.length; i++)
            menteeList.add(mentees[i]);

        Collections.sort(menteeList);
        listener.onSuccess(menteeList);

//        service.getMentors(username, new Callback<List<Mentor>>() {
//
//            @Override
//            public void success(List<Mentor> mentors, Response response) {
//                listener.onSuccess(mentors);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                if (error.getKind().equals(RetrofitError.Kind.NETWORK))
//                    listener.onFailure("Network Failure.\nTap to try again.");
//                else
//                    listener.onFailure(error.toString() + ",, " + error.getKind());
//            }
//        });
    }
}
