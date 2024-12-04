package com.example.metr.ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Admin_Add_marketActivity extends AppCompatActivity {

    Button CreateAccountBtn;
    EditText InputAdminName,InputMarketName,InputPassword,InputConfirmedPassword,InputE_mail,Inputdescribtion;
    ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__add_market);


        CreateAccountBtn=(Button)findViewById(R.id.add_market_btn);

        InputAdminName=(EditText) findViewById(R.id.market_admin_username_input);
        InputMarketName=(EditText) findViewById(R.id.market_username_input);
        InputPassword=(EditText) findViewById(R.id.market_password_input);
        InputConfirmedPassword=(EditText) findViewById(R.id.market_confirm_password_input);
        //InputPhoneNumber=(EditText) findViewById(R.id.market_phone_number_input);
        InputE_mail=(EditText) findViewById(R.id.market_e_mail_input);
       // InputAddress=(EditText) findViewById(R.id.market_address_input);
        Inputdescribtion=(EditText) findViewById(R.id.market_description_input);



        loadingBar=new ProgressDialog(this);
        CreateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String AdminName=InputAdminName.getText().toString();
        String MarketName=InputMarketName.getText().toString();
        String Password=InputPassword.getText().toString();
        String ConfirmedPassword=InputConfirmedPassword.getText().toString();
        //String PhoneNumber=InputPhoneNumber.getText().toString();
        String E_mail=InputE_mail.getText().toString();
       // String Address=InputAddress.getText().toString();
        String describtion=Inputdescribtion.getText().toString();


        if(TextUtils.isEmpty(AdminName)){
            Toast.makeText(this,"please write your Admin Name...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(MarketName)){
            Toast.makeText(this,"please write your Market Name...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"please write your Password...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(ConfirmedPassword)){
            Toast.makeText(this,"please write your Confirm Password...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(E_mail)){
            Toast.makeText(this,"please write your E_mail...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(describtion)){
            Toast.makeText(this,"please write your describtion...",Toast.LENGTH_SHORT).show();
        }else if(!Password.equals(ConfirmedPassword)){
            Toast.makeText(this,"Password not equal Confirmed Password",Toast.LENGTH_SHORT).show();
        }else{
            loadingBar.setTitle("CreateAccount");
            loadingBar.setMessage("please wait,while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            validateE_mailMarket(AdminName,MarketName,Password,E_mail,describtion);
        }



    }

    private void  validateE_mailMarket(final String AdminName,final String MarketName,final String Password,final String
            E_mail,final String describtion)
    {

        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Markets").child(E_mail).exists())){

                    HashMap<String , Object> UserDataMap =new HashMap<>();
                    UserDataMap.put("E_mail",E_mail);
                    UserDataMap.put("AdminName",AdminName);
                    UserDataMap.put("MarketName",MarketName);
                    UserDataMap.put("Password",Password);
                 //   UserDataMap.put("PhoneNumber",PhoneNumber);
                   // UserDataMap.put("Address",Address);
                    UserDataMap.put("describtion",describtion);

                    //OnCompleteListener<TResult> onCompleteListener = ;
                    RootRef.child("Markets").child(E_mail).updateChildren(UserDataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Admin_Add_marketActivity.this,"Congratulation, your Market created sucessufully",Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();

                                        Intent intent1=new Intent (Admin_Add_marketActivity.this,Admin_homeActivity.class);
                                        startActivity(intent1);
                                    }else {
                                        Toast.makeText(Admin_Add_marketActivity.this,"Network Error please try again after some times...",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }else{
                    Toast.makeText(Admin_Add_marketActivity.this,"This "+E_mail+" already exist",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(Admin_Add_marketActivity.this,"please try again with anther number ",Toast.LENGTH_SHORT).show();


                  /*  Intent intenet=new Intent(Admin_Add_marketActivity.this,Admin_homeActivity.class);
                    startActivity(intenet);*/
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
        Intent intent1= new Intent(Admin_Add_marketActivity.this,Admin_homeActivity.class);
        //intent.putExtra("EXTRA_TEXT","1");
        startActivity(intent1);


    }
}
