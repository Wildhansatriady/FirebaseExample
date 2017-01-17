package id.web.androidhyper.firebaseexample.auth.register;

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
import id.web.androidhyper.firebaseexample.auth.login.LoginActivity;
import id.web.androidhyper.firebaseexample.utility.Util;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.bt_regist)
    Button regis;

    private RegisterPresenter registerPresenter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        registerPresenter = new RegisterPresenterImpl(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.toLogin)
    void toLogin(){
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.bt_regist)
    void register(){
        String txtEmail = email.getText().toString();
        String txtPass = password.getText().toString();
        registerPresenter.validateRegis(this,mAuth,txtEmail,txtPass);
    }

    @Override
    public void showProgress() {
        regis.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        regis.setEnabled(true);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        email.setError("Isi Username !");
    }

    @Override
    public void setPasswordError() {
        password.setError("Isi Password !");
    }

    @Override
    public void onSuccessRegis() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onFailedRegis() {
        Util.showToast(this,"Gagal Registrasi !");
    }

}
