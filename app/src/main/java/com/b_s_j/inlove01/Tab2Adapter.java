package com.b_s_j.inlove01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Tab2Adapter extends RecyclerView.Adapter{
    Context context;
    ArrayList<Tab2Item> items;

    public Tab2Adapter(Tab2Fragment context, ArrayList<Tab2Item> items) {
       // this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView= inflater.inflate(R.layout.fragment_tab2_item,parent,false);
        VH holder = new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;

        Tab2Item item = items.get(position);
        vh.Day.setText(item.Day);
        vh.Msg.setText(item.msg);
        Glide.with(context).load(item.img).into(vh.item_img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class VH extends  RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        TextView Day;
        TextView Msg;
        ImageView item_img;

        public VH(@NonNull View itemView) {
            super(itemView);

         Day=itemView.findViewById(R.id.tv_day);
          Msg=  itemView.findViewById(R.id.tv_msg);
           recyclerView= itemView.findViewById(R.id.tab2recycler);
           item_img =itemView.findViewById(R.id.item_img);
        }
    }
}
