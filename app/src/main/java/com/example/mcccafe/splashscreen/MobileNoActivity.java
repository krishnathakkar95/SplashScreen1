package com.example.mcccafe.splashscreen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MobileNoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_no);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText enter_mobile_no=(EditText)findViewById(R.id.enter_mobile_no);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton radioButton=(RadioButton)findViewById(R.id.radioButton);
        final RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButton2);
        Button next_button=(Button)findViewById(R.id.next_button);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        Resources res=getResources();
       String[] operator=res.getStringArray(R.array.Operator);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,operator);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner.setAdapter(aa);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String str_mono=enter_mobile_no.getText().toString();
                if(str_mono.isEmpty()){
                    Toast.makeText(MobileNoActivity.this, "Please enter MobileNo", Toast.LENGTH_SHORT).show();
                }
                else if(spinner.getSelectedItemPosition()==0)
                {
                    if (radioButton.isChecked()) {

                        Intent intent = new Intent(MobileNoActivity.this, PrepaidVodafone.class);
                        startActivity(intent);
                    } else if (radioButton1.isChecked()) {
                        Intent intent = new Intent(MobileNoActivity.this, PostpaidTelenor.class);
                        startActivity(intent);
                    }
                }
                else if(spinner.getSelectedItemPosition()==1)
                {
                    if (radioButton.isChecked()) {

                        Intent intent = new Intent(MobileNoActivity.this, PrepaidVodafone.class);
                        startActivity(intent);
                    } else if (radioButton1.isChecked()) {
                        Intent intent = new Intent(MobileNoActivity.this, PostpaidTelenor.class);
                        startActivity(intent);
                    }
                }
                else if(spinner.getSelectedItemPosition()==2)
                {
                    if (radioButton.isChecked()) {

                        Intent intent = new Intent(MobileNoActivity.this, PrepaidVodafone.class);
                        startActivity(intent);
                    } else if (radioButton1.isChecked()) {
                        Intent intent = new Intent(MobileNoActivity.this, PostpaidTelenor.class);
                        startActivity(intent);
                    }
                }
                else if(spinner.getSelectedItemPosition()==3)
                {
                    if (radioButton.isChecked()) {

                        Intent intent = new Intent(MobileNoActivity.this, PrepaidVodafone.class);
                        startActivity(intent);
                    } else if (radioButton1.isChecked()) {
                        Intent intent = new Intent(MobileNoActivity.this, PostpaidTelenor.class);
                        startActivity(intent);
                    }
                }
                else if(spinner.getSelectedItemPosition()==4)
                {
                    if (radioButton.isChecked()) {

                        Intent intent = new Intent(MobileNoActivity.this, PrepaidVodafone.class);
                        startActivity(intent);
                    } else if (radioButton1.isChecked()) {
                        Intent intent = new Intent(MobileNoActivity.this, PostpaidTelenor.class);
//                        intent.putExtra("network",spinner.getSelectedItemId());
//                        intent.putExtra("state",)
                        startActivity(intent);
                    }
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
