package com.wernerapps.mentorme.MentorView;

import com.wernerapps.mentorme.API.Mentee;

import java.util.List;

/**
 * Created by Tom on 4/18/2015.
 */
public class MenteePresenterImpl implements MenteePresenter {
    private final MenteeView mainView;
    private final GetMentees mentorsInteractor;

    public MenteePresenterImpl(MenteeView mainView) {
        this.mainView = mainView;
        this.mentorsInteractor = new GetMenteesImpl();
    }

    @Override
    public void getMentors(String username) {
        mentorsInteractor.getMentors(username, new GetMentees.OnFinishedListener() {
            @Override
            public void onSuccess(List<Mentee> mentees) {
                mainView.setMentees(mentees);
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
    public void onItemClicked(Mentee mentee) {
        mainView.displayMenteeDetails(mentee);
    }
}
