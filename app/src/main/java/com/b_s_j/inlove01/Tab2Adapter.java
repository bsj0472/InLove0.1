package com.b_s_j.inlove01;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab2Adapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<Tab2Item> items;
    public Tab2Adapter(FragmentActivity activity, ArrayList<Tab2Item> items) {
        this.context = context;
        this.items = this.items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
