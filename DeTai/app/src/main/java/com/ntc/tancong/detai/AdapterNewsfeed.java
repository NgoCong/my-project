package com.ntc.tancong.detai;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanco on 3/18/2018.
 */

public class AdapterNewsfeed extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<Item> list;
    public AdapterNewsfeed(Activity act,ArrayList<Item> list)
    {
        inflater=act.getLayoutInflater();
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView=inflater.inflate(R.layout.itemnewsfeed,null);
        // get current item to be displayed
        Item currentItem = (Item) getItem(position);

        TextView tvTitle= (TextView) convertView.findViewById(R.id.tvTitle_Item_Newsfeed);
        TextView tvContent= (TextView) convertView.findViewById(R.id.tvContent_Newsfeed);
        TextView tvDate= (TextView) convertView.findViewById(R.id.tvDate);

        tvDate.setText(currentItem.getDate());
        tvTitle.setText(currentItem.getTitle());
        tvContent.setText(currentItem.getContent());

        return convertView;
    }
}
