package com.wernerapps.mentorme.Login;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wernerapps.mentorme.MenteeView.MenteeHome;
import com.wernerapps.mentorme.MentorView.MentorHome;
import com.wernerapps.mentorme.R;


public class LoginActivity extends ActionBarActivity implements LoginView {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.presenter = new LoginPresenterImpl(this);

        final EditText username = (EditText) findViewById(R.id.emailAddressView);
        final EditText password = (EditText) findViewById(R.id.passwordView);

        final Button login = (Button) findViewById(R.id.signInButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(username.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
//        progress = null;
//        progress = new ProgressDialog(this);
//        progress.setTitle("Loading");
//        progress.setMessage("Wait while loading...");
//        progress.show();
    }

    @Override
    public void hideProgress() {
//
//        if (progress != null) {
//            progress.getCurrentFocus().post(new Runnable() {
//                @Override
//                public void run() {
//                    progress.hide();
//                }
//            });
//        }
    }

    @Override
    public void loginSuccess(final String user) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                if (!user.equals("tom"))
                    startActivity(new Intent(LoginActivity.this, MenteeHome.class));
                else
                    startActivity(new Intent(LoginActivity.this, MentorHome.class));
            }
        });
    }

    @Override
    public void loginFailure(final String errorMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
