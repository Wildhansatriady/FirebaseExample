package id.web.androidhyper.firebaseexample.auth.register;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/17/2017.
 */

public interface RegisterPresenter {
    void validateRegis(Activity activity, FirebaseAuth mAuth, String email, String password);
    void onDestroy();
}
