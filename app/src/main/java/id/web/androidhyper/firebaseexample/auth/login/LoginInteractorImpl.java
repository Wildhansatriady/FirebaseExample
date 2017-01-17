package id.web.androidhyper.firebaseexample.auth.login;


import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/16/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(Activity activity,FirebaseAuth mAuth,String username, String password, final onLoginFinishedListener listener) {

        if(username.isEmpty()){
            listener.onUsernameError();
        }else if(password.isEmpty()){
            listener.onPasswordError();
        }else{
            mAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                               listener.onFailedLogin();
                            }else{
                                listener.onSuccess();
                            }

                            // ...
                        }
                    });

        }

    }

}
