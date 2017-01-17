package id.web.androidhyper.firebaseexample.auth.login;




import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by WILDHAN2 on 1/16/2017.
 */

 class LoginPresenterImpl implements LoginPresenter,LoginInteractor.onLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;
    public static final String TAG = LoginPresenterImpl.class.getSimpleName();

     LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onUsernameError() {
        if(loginView !=null){
            loginView.hideProgress();
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView !=null){
            loginView.hideProgress();
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if(loginView !=null){
            loginView.hideProgress();
            loginView.navigateToHome();
        }
    }

    @Override
    public void onFailedLogin() {
        if(loginView !=null){
            loginView.hideProgress();
            loginView.setFaildedLogin();
        }
    }


    @Override
    public void validateCredentials(Activity activity,FirebaseAuth mAuth,String username, String password) {
        if(loginView !=null){
            loginView.showProgress();
        }
        loginInteractor.login(activity,mAuth,username,password,this);
    }



    @Override
    public void onDestroy() {
        loginView =null;
    }




}
