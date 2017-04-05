package com.example.mcccafe.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostpaidTelenor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpaid_telenor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent = getIntent();
        intent.getIntExtra("network",0);

        setSupportActionBar(toolbar);
        final EditText ed_post_T=(EditText)findViewById(R.id.ed_post_T);
        Button bt_post_T=(Button)findViewById(R.id.bt_post_T);
        bt_post_T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stramount=ed_post_T.getText().toString();
                if(stramount.isEmpty()){
                    Toast.makeText(PostpaidTelenor.this, "Please enter amount", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });
    }

}
