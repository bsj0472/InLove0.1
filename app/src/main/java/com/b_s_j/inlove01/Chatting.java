package com.b_s_j.inlove01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class Chatting extends AppCompatActivity {
    ArrayList<Tab3MessageItem> messageItems= new ArrayList<>();
    ListView listView;
    Tab3ChatAdapter chatAdapter;

    EditText etMsg;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference chatRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);


        etMsg= findViewById(R.id.et);

        listView= findViewById(R.id.listview);
        chatAdapter= new Tab3ChatAdapter(this, messageItems);
        listView.setAdapter(chatAdapter);


        firebaseDatabase= FirebaseDatabase.getInstance();

        chatRef= firebaseDatabase.getReference("chat");


        chatRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


                Tab3MessageItem item= snapshot.getValue(Tab3MessageItem.class);


                messageItems.add(item);


                chatAdapter.notifyDataSetChanged();
                listView.setSelection(messageItems.size()-1);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void clickSend(View view) {

        String message= etMsg.getText().toString();
        String profileUrl= Tab3G.profileUrl;


        Calendar calendar= Calendar.getInstance();
        String time= calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);


        Tab3MessageItem item= new Tab3MessageItem( message, time, profileUrl);

        chatRef.push().setValue(item);


        etMsg.setText("");


        InputMethodManager imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);



    }
}