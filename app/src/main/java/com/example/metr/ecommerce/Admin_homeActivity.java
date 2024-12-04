package com.example.metr.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Admin_homeActivity extends AppCompatActivity {

    Button Add_market_btn, ShowMarkets_btn,ChangeData_btn, ShowDetails_btn,Update_btn,Delete_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        Add_market_btn=(Button)findViewById(R.id.admin_add_market);
        ShowMarkets_btn=(Button)findViewById(R.id.admin_show_markets);
        ChangeData_btn=(Button)findViewById(R.id.admin_change_data);
        ShowDetails_btn=(Button)findViewById(R.id.admin_show_details_market);
        Delete_btn=(Button)findViewById(R.id.admin_delete_market);
        Update_btn=(Button)findViewById(R.id.admin_update_market);


        Add_market_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(Admin_homeActivity.this,Admin_Add_marketActivity.class);
                    startActivity(intent);
            }
        });
        ShowMarkets_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_homeActivity.this,Admin_Show_marketsActivity.class);
                startActivity(intent);
            }
        });
        ChangeData_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_homeActivity.this,Admin_Change_DataActivity.class);
                startActivity(intent);
            }
        });
        ShowDetails_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_homeActivity.this,Admin_Show_Detils_MarketActivity.class);
                startActivity(intent);
            }
        });
        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_homeActivity.this,Admin_DeleteActivity.class);
                startActivity(intent);
            }
        });
        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_homeActivity.this,Admin_UpdateActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.back_menu,menu);
        return true;
    }

    public void create_back(MenuItem item){
        Intent intent1= new Intent(Admin_homeActivity.this,LoginActivity.class);
        //intent.putExtra("EXTRA_TEXT","1");
        startActivity(intent1);


    }


}
