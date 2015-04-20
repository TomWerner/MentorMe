package com.wernerapps.mentorme.MenteeView;

import com.wernerapps.mentorme.API.Mentor;

/**
 * Created by Tom on 4/18/2015.
 */
public interface MainPresenter {

    public void getMentors(String username);
    public void onItemClicked(Mentor mentor);
}
