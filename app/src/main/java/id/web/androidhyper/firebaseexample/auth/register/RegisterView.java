package id.web.androidhyper.firebaseexample.auth.register;

/**
 * Created by WILDHAN2 on 1/17/2017.
 */

public interface RegisterView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void onSuccessRegis();
    void onFailedRegis();
}
