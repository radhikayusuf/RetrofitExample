package radhika.yusuf.id.retrofitexample.ui.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import radhika.yusuf.id.retrofitexample.R;
import radhika.yusuf.id.retrofitexample.api.ApiClient;
import radhika.yusuf.id.retrofitexample.dao.LoginResponse;
import radhika.yusuf.id.retrofitexample.dao.body.LoginBody;
import radhika.yusuf.id.retrofitexample.helper.StringHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textUsername, textPassword;
    private Button btnLogin;
    private ScrollView scrollView;
    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponent();
        setAutoScroll();
    }

    private void setAutoScroll() {
        /**
         * ignore
         * fungsinya pas klik edittext auto scroll
         * di pelajari boleh :)
         */

        final View activityRootView = getWindow().getDecorView().findViewById(android.R.id.content);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int a = activityRootView.getRootView().getHeight();
                int b = activityRootView.getHeight();
                int heightDiff = a - b;
                if (heightDiff > 100) {
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.scrollTo(0, textPassword.getBottom());
                        }
                    });

                }
            }
        });
    }

    private void initComponent() {
        textUsername = (EditText) findViewById(R.id.login_username);
        textPassword = (EditText) findViewById(R.id.login_password);
        btnLogin = (Button) findViewById(R.id.login_button_login);
        scrollView = (ScrollView)findViewById(R.id.scroll_login);
        mDialog = new ProgressDialog(this);


        mDialog.setMessage("Please wait ...");
        mDialog.setCancelable(false);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button_login:
                requestLogin();
                break;
        }
    }

    private void requestLogin() {
        if(!TextUtils.isEmpty(textUsername.getText().toString().trim()) &&
                !TextUtils.isEmpty(textPassword.getText().toString().trim())){
            //show dialog
            mDialog.show();

            //ini ngebuat obj buat di jadiin request POST nya
            LoginBody body = new LoginBody(textUsername.getText().toString(), StringHelper.md5(textPassword.getText().toString()));

            //ngebuat request retrofit
            Call<LoginResponse> call = ApiClient.service().loginUser(body);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(call.isExecuted() && response.isSuccessful()){
                        for (LoginResponse.LoginData loginData : response.body().getData()) {
                            Toast.makeText(LoginActivity.this, "Hello "+loginData.getFirst_name()+"!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    mDialog.dismiss();
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Ups! "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                }
            });
        }else{
            Toast.makeText(this, "Isi username dan password", Toast.LENGTH_SHORT).show();
        }
    }
}
