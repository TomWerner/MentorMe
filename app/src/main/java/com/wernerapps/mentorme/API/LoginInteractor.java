package com.wernerapps.mentorme.API;

import com.wernerapps.mentorme.Login.LoginPresenter;

/**
 * Created by Tom on 4/18/2015.
 */
public interface LoginInteractor {
    public void login(String username, String password, LoginPresenter.LoginListener listener);
}
