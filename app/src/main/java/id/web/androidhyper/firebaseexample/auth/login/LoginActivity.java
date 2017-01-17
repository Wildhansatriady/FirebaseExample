package id.web.androidhyper.firebaseexample.auth.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.web.androidhyper.firebaseexample.MainActivity;
import id.web.androidhyper.firebaseexample.R;
import id.web.androidhyper.firebaseexample.auth.register.RegisterActivity;
import id.web.androidhyper.firebaseexample.utility.Util;

public class LoginActivity extends AppCompatActivity implements LoginView {

    public static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.bt_login)
    Button login;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private FirebaseAuth mAuth;


    private LoginPresenter loginPresenter;


    @Override
    protected void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(loginPresenter.getmAuthListener());
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_auth);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        loginPresenter = new LoginPresenterImpl(this);



    }

    @OnClick(R.id.toRegister)
    void toRegister(){
        startActivity(new Intent(this,RegisterActivity.class));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        login.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        login.setEnabled(true);
    }

    @Override
    public void setUsernameError() {
        username.setError("Isi Username Terlebih Dahulu!");
    }

    @Override
    public void setPasswordError() {
        password.setError("Isi Password Terlebih Dahulu!");
    }

    @Override
    public void setFaildedLogin() {
        Util.showToast(this,"Username dan Password Salah");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }



    @OnClick(R.id.bt_login)
    void onLogin(){
        loginPresenter.validateCredentials(this,mAuth,username.getText().toString(),password.getText().toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
