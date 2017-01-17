package id.web.androidhyper.firebaseexample.auth.register;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/17/2017.
 */

public class RegisterInteractorImpl implements RegisterInteractor{
    @Override
    public void Register(Activity activity, FirebaseAuth mAuth, String email, String password, final onRegisterFinished listener) {
        if(email.isEmpty()){
            listener.onUsernameError();
        }else if(password.isEmpty()){
            listener.onPasswordError();
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            listener.onRegisterFailed();
                        }else{
                            listener.onSuccess();
                        }

                        // ...
                    }
                });
    }
}
