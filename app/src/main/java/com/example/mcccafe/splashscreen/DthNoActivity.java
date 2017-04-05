package com.example.mcccafe.splashscreen;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DthNoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dth_no);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        EditText enter_dth_no_id=(EditText)findViewById(R.id.enter_dth_no_id);
        final Spinner spinner=(Spinner)findViewById(R.id.spinnerDth);
        Resources res=getResources();
        String[] operator=res.getStringArray(R.array.DthOperator);
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
        Button next_dth_id=(Button)findViewById(R.id.next_dth_id);
        next_dth_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItemPosition()==0)
                {

                }
                if(spinner.getSelectedItemPosition()==1){

                }
                if(spinner.getSelectedItemPosition()==2)
                {

                }
                if(spinner.getSelectedItemPosition()==3){

                }
                if(spinner.getSelectedItemPosition()==4){

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
