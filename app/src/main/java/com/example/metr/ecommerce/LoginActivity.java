package com.example.metr.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class
LoginActivity extends AppCompatActivity {

    Button  loginButton;
    RadioGroup checked_type_user;
    RadioButton check_user_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=(Button)findViewById(R.id.login_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 checked_type_user =(RadioGroup)findViewById(R.id.type_user);
                int selectedID=checked_type_user.getCheckedRadioButtonId();

                check_user_button=(RadioButton)findViewById(selectedID);
                 if(selectedID==R.id.market_admin_panal_link){

                    Intent intent=new Intent(LoginActivity.this,Market_HomeActivity.class);
                    startActivity(intent);
                } else if(selectedID==R.id.admin_panal_link){

                    Intent intent=new Intent(LoginActivity.this,Admin_homeActivity.class);
                    startActivity(intent);
                }else{
                     Intent intent=new Intent(LoginActivity.this,Customer_HomeActivity.class);
                     startActivity(intent);
                   // Toast.makeText(LoginActivity.this,check_user_button.getText().toString(),Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
