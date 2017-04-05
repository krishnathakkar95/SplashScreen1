package com.example.mcccafe.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcccafe.splashscreen.AsyncTask.AsyncResponse;
import com.example.mcccafe.splashscreen.AsyncTask.WebserviceCall;
import com.example.mcccafe.splashscreen.Helper.Utils;
import com.example.mcccafe.splashscreen.Model.ChangePasswordModel;
import com.example.mcccafe.splashscreen.Model.ForgetPasswordModel;
import com.example.mcccafe.splashscreen.Model.LoginModel;
import com.google.gson.Gson;

public class ChangePassword extends AppCompatActivity {
LoginModel dj=new LoginModel();
    int kri=dj.getUserId();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText oldpwd=(EditText)findViewById(R.id.id_chg_pwd_old);
        final EditText newpwd=(EditText)findViewById(R.id.id_new_pw);
        Button button=(Button)findViewById(R.id.button_chng_pw);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_oldpwd=oldpwd.getText().toString();
                String str_newpwd=newpwd.getText().toString();
                if(str_oldpwd.isEmpty()){
                    Toast.makeText(ChangePassword.this, "Please enter current password", Toast.LENGTH_SHORT).show();
                }
                else if(str_newpwd.isEmpty()){
                    Toast.makeText(ChangePassword.this, "Please enter new password", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    String[] keys = new String[]{"mode","userId", "password","newPassword"};
                    String[] values = new String[]{"changePassword", String.valueOf(kri),str_oldpwd,str_newpwd};
                    final String jsonRequest = Utils.createJsonRequest(keys, values);
                    final String URL = "http://development.ifuturz.com/core/FLAT_TEST/ecart_new/admin/webservice.php";
                    new WebserviceCall(ChangePassword.this, URL, jsonRequest, "Loadding...", true, new AsyncResponse() {

                        @Override
                        public void onCallback(String response) {

                            Log.d("myapp", response);
                            ChangePasswordModel pm = new Gson().fromJson(response, ChangePasswordModel.class);
                            if (pm.getStatus() == 1) {
                                Log.d("myapp", pm.getMessage());


                                Intent i = new Intent(ChangePassword.this, HomeActivity.class);
                                startActivity(i);

                                Toast.makeText(getApplicationContext(), "Successfully done ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "your password changed", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }).execute();

                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
