package id.web.androidhyper.firebaseexample.auth.register;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/17/2017.
 */

public class RegisterPresenterImpl implements RegisterPresenter,RegisterInteractor.onRegisterFinished{

    private RegisterView registerView;
    private RegisterInteractor registerInteractor;

    public RegisterPresenterImpl(RegisterView registerView){
        this.registerView = registerView;
        registerInteractor = new RegisterInteractorImpl();
    }

    @Override
    public void validateRegis(Activity activity, FirebaseAuth mAuth, String email, String password) {
        if(registerView!=null){
            registerView.showProgress();
        }
        registerInteractor.Register(activity,mAuth,email,password,this);
    }

    @Override
    public void onDestroy() {
        registerView=null;
    }

    @Override
    public void onUsernameError() {
        if(registerView!=null){
            registerView.hideProgress();
            registerView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(registerView!=null){
            registerView.hideProgress();
            registerView.setPasswordError();
        }
    }

    @Override
    public void onRegisterFailed() {
        if(registerView!=null){
            registerView.hideProgress();
            registerView.onFailedRegis();
        }
    }

    @Override
    public void onSuccess() {
        if(registerView!=null){
            registerView.hideProgress();
            registerView.onSuccessRegis();
        }
    }
}
