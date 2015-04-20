package com.wernerapps.mentorme.MentorView;

import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;

/**
 * Created by Tom on 4/18/2015.
 */
public interface MenteePresenter {

    public void getMentors(String username);
    public void onItemClicked(Mentee mentee);
}
