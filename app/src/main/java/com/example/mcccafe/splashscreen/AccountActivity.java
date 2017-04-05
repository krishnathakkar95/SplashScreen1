package com.example.mcccafe.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView=(ListView)findViewById(R.id.account_list_id);
        final String[] Acclistitem=getResources().getStringArray(R.array.AccList);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Acclistitem);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(AccountActivity.this,YourProfile.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent=new Intent(AccountActivity.this,EditProfile.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent=new Intent(AccountActivity.this,ViewTransactionHistory.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                Intent intent=new Intent(AccountActivity.this,ChangePassword.class);
                    startActivity(intent);
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
