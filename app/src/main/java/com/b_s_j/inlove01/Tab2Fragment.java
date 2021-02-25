package com.b_s_j.inlove01;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Tab2Fragment extends Fragment {
    ArrayList<Tab2Item> items= new ArrayList<>();
    RecyclerView recyclerView;
    Tab2Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab2,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        items.add(new Tab2Item("2020.17","왕십리",R.drawable.ic_launcher_foreground));
        recyclerView= getActivity().findViewById(R.id.tab2recycler);
        adapter= new Tab2Adapter(getActivity(), items);
        recyclerView.setAdapter(adapter);



        FloatingActionButton fab =getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivity(intent);

            }
        });
    }



}
