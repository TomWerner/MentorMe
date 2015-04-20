package com.wernerapps.mentorme.MenteeView;

import com.wernerapps.mentorme.API.Mentor;

import java.util.List;

/**
 * Created by Tom on 4/18/2015.
 */
public class MainPresenterImpl implements MainPresenter {
    private final MainView mainView;
    private final GetMentors mentorsInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.mentorsInteractor = new GetMentorsImpl();
    }

    @Override
    public void getMentors(String username) {
        mentorsInteractor.getMentors(username, new GetMentors.OnFinishedListener() {
            @Override
            public void onSuccess(List<Mentor> mentors) {
                mainView.setMentors(mentors);
                mainView.hideProgress();
            }

            @Override
            public void onFailure(String errorMessage) {
                mainView.displayErrorMessage(errorMessage);
                mainView.hideProgress();
            }
        });
    }

    @Override
    public void onItemClicked(Mentor mentor) {
        mainView.displayMentorDetails(mentor);
    }
}
