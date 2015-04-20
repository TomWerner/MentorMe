package com.wernerapps.mentorme.MenteeView;

import com.wernerapps.mentorme.API.API;
import com.wernerapps.mentorme.API.Mentor;

import java.util.ArrayList;
import java.util.Collections;

import retrofit.RestAdapter;

/**
 * Created by Tom on 3/29/2015.
 */
public class GetMentorsImpl implements GetMentors {
    @Override
    public void getMentors(String username, final OnFinishedListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API.API_URL)
                .build();

        API service = restAdapter.create(API.class);

        Mentor[] mentors = {
                new Mentor("John C.", 3.7, 5, "Computer Science"),
                new Mentor("Ryan S.", 3.8, 5, "Math"),
                new Mentor("Sarah J.", 3.5, 4, "Computer Science"),
                new Mentor("Dylan M.", 3.3, 4, "Computer Science"),
                new Mentor("James P.", 3.5, 3, "Computer Science"),
                new Mentor("Connor R.", 3.4, 3, "Computer Science"),
                new Mentor("Sammy W.", 3.6, 3, "Informatics"),
                new Mentor("Julia T.", 4.0, 5, "Computer Engineering"),
                new Mentor("Pablo C.", 3.0, 2, "Computer Engineering"),
                new Mentor("Adrian G.", 3.4, 3, "Computer Science"),
        };
        ArrayList<Mentor> mentorList = new ArrayList<Mentor>();
        for (int i = 0; i < mentors.length; i++)
            if (Math.random() < .8)
                mentorList.add(mentors[i]);

        Collections.sort(mentorList);
        Collections.reverse(mentorList);
        listener.onSuccess(mentorList);

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
