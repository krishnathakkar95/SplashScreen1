package com.example.mcccafe.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrepaidVodafone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepaid_vodafone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText ed_pre_V=(EditText)findViewById(R.id.ed_pre_V);
        TextView txt_preplan_V=(TextView)findViewById(R.id.txt_preplan_V);
        Button bt_pre_V=(Button)findViewById(R.id.bt_pre_V);
        txt_preplan_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrepaidVodafone.this,VodafonePlans.class);
                startActivity(intent);
            }
        });

        bt_pre_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stramount=ed_pre_V.getText().toString();
                if(stramount.isEmpty()){
                    Toast.makeText(PrepaidVodafone.this, "Please enter amount", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });
 }

}
