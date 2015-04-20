package com.wernerapps.mentorme.Login;

/**
 * Created by Tom on 4/18/2015.
 */
public interface LoginView {
    public void showProgress();
    public void hideProgress();
    public void loginSuccess(String user);
    public void loginFailure(String errorMessage);
}
