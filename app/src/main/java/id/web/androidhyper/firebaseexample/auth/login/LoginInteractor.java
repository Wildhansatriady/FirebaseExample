package id.web.androidhyper.firebaseexample.auth.login;


import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/16/2017.
 */

public interface LoginInteractor {

    interface onLoginFinishedListener{
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
        void onFailedLogin();
    }


    void login(Activity activity, FirebaseAuth mAuth,String username, String password, onLoginFinishedListener listener);

}
