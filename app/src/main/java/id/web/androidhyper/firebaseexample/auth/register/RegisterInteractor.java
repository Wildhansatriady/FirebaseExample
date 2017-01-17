package id.web.androidhyper.firebaseexample.auth.register;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/17/2017.
 */

public interface RegisterInteractor {
    interface onRegisterFinished{
        void onUsernameError();
        void onPasswordError();
        void onRegisterFailed();
        void onSuccess();
    }

    void Register(Activity activity, FirebaseAuth mAuth,String email, String password,onRegisterFinished listener);
}
