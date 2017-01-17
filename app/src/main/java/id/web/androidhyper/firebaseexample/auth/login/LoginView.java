package id.web.androidhyper.firebaseexample.auth.login;

/**
 * Created by WILDHAN2 on 1/16/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void setFaildedLogin();

    void navigateToHome();

}
