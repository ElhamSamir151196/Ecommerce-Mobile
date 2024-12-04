package com.example.metr.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Admin_UpdateActivity extends AppCompatActivity {

    Button Update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__update);

        Update_btn=(Button)findViewById(R.id.market_update_btn);

        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Admin_UpdateActivity.this, Admin_Update_marketActivity.class);
                startActivity(intent);

            } });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.back_menu,menu);
        return true;
    }

    public void create_back(MenuItem item){
        Intent intent1= new Intent(Admin_UpdateActivity.this,Admin_homeActivity.class);
        //intent.putExtra("EXTRA_TEXT","1");
        startActivity(intent1);


    }
}
