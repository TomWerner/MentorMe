package com.wernerapps.mentorme.Login;

/**
 * Created by Tom on 4/18/2015.
 */
public interface LoginPresenter {
    public void login(String username, String password);

    public interface LoginListener {
        public void onSuccess();
        public void onFailure(String errorMessage);
    }
}
