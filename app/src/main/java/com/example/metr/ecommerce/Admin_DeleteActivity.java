package com.example.metr.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Admin_DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__delete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.back_menu,menu);
        return true;
    }

    public void create_back(MenuItem item){
        Intent intent1= new Intent(Admin_DeleteActivity.this,Admin_homeActivity.class);
        //intent.putExtra("EXTRA_TEXT","1");
        startActivity(intent1);


    }
}
