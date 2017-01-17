package id.web.androidhyper.firebaseexample.auth.login;


import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/16/2017.
 */

public interface LoginPresenter {
    void validateCredentials(Activity activity, FirebaseAuth mAuth,String username, String password);

    void onDestroy();

}
