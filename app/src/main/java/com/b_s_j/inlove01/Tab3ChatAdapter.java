package com.b_s_j.inlove01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Tab3ChatAdapter extends BaseAdapter {

    Context context;
    ArrayList<Tab3MessageItem> messageItems;

    public Tab3ChatAdapter(Context context, ArrayList<Tab3MessageItem> messageItems) {
        this.context = context;
        this.messageItems = messageItems;
    }

    @Override
    public int getCount() {return messageItems.size();

    }

    @Override
    public Object getItem(int position) {return  messageItems.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Tab3MessageItem item =  messageItems.get(position);

        View itemView = null;
        LayoutInflater inflater = LayoutInflater.from(context);

        //메세지가 내 메세지 인지
        if (item.profileUrl.equals(Tab3G.profileUrl)){
            itemView=inflater.inflate(R.layout.my_messagebox,parent,false);
        }else {
            itemView=inflater.inflate(R.layout.other_messagebox,parent,false);
        }

        //bind view : 값 연결
        CircleImageView civ= itemView.findViewById(R.id.iv);

        TextView tvMsg= itemView.findViewById(R.id.tv_msg);
        TextView tvTime= itemView.findViewById(R.id.tv_time);

        tvMsg.setText(item.message);
        tvTime.setText(item.time);

        Glide.with(context).load(item.profileUrl).into(civ);

        return itemView;

    }
}
