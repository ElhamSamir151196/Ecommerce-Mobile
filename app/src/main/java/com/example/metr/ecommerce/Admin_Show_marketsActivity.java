package com.example.metr.ecommerce;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Admin_Show_marketsActivity extends AppCompatActivity {

    DatabaseReference reff;
    TextView x;
    ListView listView,listView1;

    private ArrayList<String> mUsernames,mUsernames1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__show_markets);

        listView=(ListView)findViewById(R.id.list_view_id);
        listView1=(ListView)findViewById(R.id.list_view_name);
        reff=FirebaseDatabase.getInstance().getReference().child("Markets");
        mUsernames=new ArrayList<>();
        mUsernames1=new ArrayList<>();



        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames);
        final ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames1);

        listView.setAdapter(arrayAdapter);

        listView1.setAdapter(arrayAdapter1);

        reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String value= dataSnapshot.child("MarketName").getValue(String.class);
               String value1= dataSnapshot.child("E_mail").getValue(String.class);

                mUsernames.add(value);
                arrayAdapter.notifyDataSetChanged();

                mUsernames1.add(value1);
                arrayAdapter1.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


/*        x=(TextView)findViewById(R.id.show_market_name);

        reff= FirebaseDatabase.getInstance().getReference().child("Markets").child("14523656");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("MarketName").getValue().toString();
                x.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.back_menu,menu);
        return true;
    }

    public void create_back(MenuItem item){
        Intent intent1= new Intent(Admin_Show_marketsActivity.this,Admin_homeActivity.class);
        //intent.putExtra("EXTRA_TEXT","1");
        startActivity(intent1);


    }
}
