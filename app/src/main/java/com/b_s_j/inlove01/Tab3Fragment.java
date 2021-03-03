package com.b_s_j.inlove01;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

public class Tab3Fragment extends Fragment {
    ArrayList<Tab3MessageItem> messageItems= new ArrayList<>();
    ListView listView;
    Tab3ChatAdapter chatAdapter;

    EditText etMsg;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference chatRef;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab3,container,false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent intent = new Intent(getActivity(), Chatting.class);
        startActivity(intent);




    }
}
