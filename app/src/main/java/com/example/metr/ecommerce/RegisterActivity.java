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

public class RegisterActivity extends AppCompatActivity {

    Button CreateAccountBtn;
    EditText InputName,InputPassword,InputPhoneNumber;
    ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CreateAccountBtn=(Button)findViewById(R.id.register_btn);
        InputName=(EditText) findViewById(R.id.register_username_input);
        InputPhoneNumber=(EditText) findViewById(R.id.regesiter_phone_number_input);
        InputPassword=(EditText) findViewById(R.id.register_password_input);
        loadingBar=new ProgressDialog(this);

        CreateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });


    }

    private void CreateAccount() {
        String Name=InputName.getText().toString();
        String PhoneNumber=InputPhoneNumber.getText().toString();
        String Password=InputPassword.getText().toString();

        if(TextUtils.isEmpty(Name)){
            Toast.makeText(this,"please write your name...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(PhoneNumber)){
            Toast.makeText(this,"please write your Phone number...",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"please write your Password...",Toast.LENGTH_SHORT).show();
        }else{
            loadingBar.setTitle("CreateAccount");
            loadingBar.setMessage("please wait,while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            validatePhoneNumber(Name,PhoneNumber,Password);
        }



    }

    private void validatePhoneNumber(final String name, final String phoneNumber,final String password) {

        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(phoneNumber).exists())){

                    HashMap<String , Object> UserDataMap =new HashMap<>();
                    UserDataMap.put("phone",phoneNumber);
                    UserDataMap.put("name",name);
                    UserDataMap.put("password",password);

                    //OnCompleteListener<TResult> onCompleteListener = ;
                    RootRef.child("Users").child(phoneNumber).updateChildren(UserDataMap)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(RegisterActivity.this,"Congratulation, your account created sucessufully",Toast.LENGTH_SHORT).show();
                                            loadingBar.dismiss();

                                            Intent intent1=new Intent (RegisterActivity.this,LoginActivity.class);
                                            startActivity(intent1);
                                        }else {
                                            Toast.makeText(RegisterActivity.this,"Network Error please try again after some times...",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                }else{
                    Toast.makeText(RegisterActivity.this,"This "+phoneNumber+" already exist",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"please try again with anther number ",Toast.LENGTH_SHORT).show();


                    Intent intenet=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intenet);
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
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    public void create(MenuItem item){
        Intent intent1= new Intent(RegisterActivity.this,LoginActivity.class);
        //intent.putExtra("EXTRA_TEXT","1");
        startActivity(intent1);


    }
}
