package com.wernerapps.mentorme.Login;

/**
 * Created by Tom on 4/18/2015.
 */
import com.wernerapps.mentorme.API.LoginInteractor;

public class LoginPresenterImpl implements LoginPresenter {

    private final LoginView view;
    private final LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        this.loginInteractor = new LoginInteratorImpl();
    }

    @Override
    public void login(final String username, final String password) {
        view.showProgress();

        new Thread(new Runnable() {
            @Override
            public void run() {
                loginInteractor.login(username, password, new LoginListener() {
                    @Override
                    public void onSuccess() {
                        view.hideProgress();
                        view.loginSuccess(username);
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        view.hideProgress();
                        view.loginFailure(errorMessage);
                    }
                });
            }
        }).start();

    }
}
