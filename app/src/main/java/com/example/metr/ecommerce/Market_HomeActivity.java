package com.example.metr.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Market_HomeActivity extends AppCompatActivity {

    Button Show_all_Cate,Cate_setting,Show_all_Prod,Prod_setting, Chnge_market_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market__home);

        Show_all_Cate=(Button)findViewById(R.id.market_category_show_all);
        Cate_setting=(Button)findViewById(R.id.market_category_setting);
        Show_all_Prod=(Button)findViewById(R.id.market_product_show_all);
        Prod_setting=(Button)findViewById(R.id.market_product_setting);
        Chnge_market_data=(Button)findViewById(R.id.market_change_data);

        Show_all_Cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Market_HomeActivity.this, Market_Show_All_CategoryActivity.class);
                startActivity(intent);

            } });

        Cate_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Market_HomeActivity.this, Market_CategoryActivity.class);
                startActivity(intent);

            } });

        Show_all_Prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Market_HomeActivity.this, Market_Show_All_ProductActivity.class);
                startActivity(intent);

            } });

        Prod_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Market_HomeActivity.this, Market_ProductActivity.class);
                startActivity(intent);

            } });

        Chnge_market_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Market_HomeActivity.this, Market_Change_DataActivity.class);
                startActivity(intent);

            } });
    }
}
