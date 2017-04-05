package com.example.mcccafe.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcccafe.splashscreen.AsyncTask.AsyncResponse;
import com.example.mcccafe.splashscreen.AsyncTask.WebserviceCall;
import com.example.mcccafe.splashscreen.Helper.Utils;
import com.example.mcccafe.splashscreen.Model.LoginModel;
import com.google.gson.Gson;

public class  LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView sign_up = (TextView) findViewById(R.id.sign_up);
        final EditText Username = (EditText) findViewById(R.id.Username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login_event = (Button) findViewById(R.id.login_event);
        TextView Forgot_password = (TextView) findViewById(R.id.Forgot_password);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });
        Forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Forgetpassword.class);
                startActivity(intent);
            }
        });
        login_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lg_username = Username.getText().toString();
                String pw_password = password.getText().toString();
                if (lg_username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "EmailId cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (pw_password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    String[] keys = new String[]{"mode", "emailId", "password"};
                    String[] values = new String[]{"loginUser", lg_username, pw_password};
                    final String jsonRequest = Utils.createJsonRequest(keys, values);
                    final String URL = "http://development.ifuturz.com/core/FLAT_TEST/ecart_new/admin/webservice.php";
                    new WebserviceCall(LoginActivity.this, URL, jsonRequest, "Loading...", true, new AsyncResponse() {
                        @Override
                        public void onCallback(String response) {
                            Log.d("myapp", response);
                            LoginModel pojologin = new Gson().fromJson(response, LoginModel.class);
                            if (pojologin.getStatus() == 1) {
                                Log.d("myapp", pojologin.getMessage());
                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(i);
                            }


                        }
                    }).execute();


                }


            }

        });
    }
}