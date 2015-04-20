package com.wernerapps.mentorme.Login;

import com.wernerapps.mentorme.API.LoginInteractor;

/**
 * Created by Tom on 4/18/2015.
 */
public class LoginInteratorImpl implements LoginInteractor{
    @Override
    public void login(String username, String password, LoginPresenter.LoginListener listener) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (password.equals("0123"))
            listener.onSuccess();
        else
            listener.onFailure("Wrong password...");
    }
}
