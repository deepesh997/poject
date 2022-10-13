package com.example.b01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Jayad extends AppCompatActivity {
    RecyclerView recyclerView;

    private DatabaseReference myRef;

    private ArrayList<Message> messageList;
    private Adapter adapter;
    private Context mContext;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jayad);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference();

        messageList = new ArrayList<>();

        GetDataFromFirebase();
    }

    private void GetDataFromFirebase() {

        Query query = myRef.child("message");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Message message = new Message();
                    message.setImageUrl(snapshot.child("image").getValue().toString());
                    message.setName(snapshot.child("name").getValue().toString());

                    messageList.add(message);
                }
                adapter = new Adapter(getApplicationContext(),messageList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void clearAll()
    {
        if(messageList!=null)
        {
            messageList.clear();

            if(adapter!=null)
            {
                adapter.notifyDataSetChanged();
            }
        }
        messageList = new ArrayList<>();

        clearAll();

    }

}


