package com.ntc.tancong.detai;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tanco on 3/18/2018.
 */

public class AdapterPeople extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<Item> list;
    public AdapterPeople(Activity act, ArrayList<Item> list)
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
            convertView=inflater.inflate(R.layout.itempeople,null);
        // get current item to be displayed
        Item currentItem = (Item) getItem(position);

        TextView tvpeople_name= (TextView) convertView.findViewById(R.id.tvpeople_name);
        TextView tvpeople_phone= (TextView) convertView.findViewById(R.id.tvpeople_phone);
        ImageView imgpeople_avatar= (ImageView) convertView.findViewById(R.id.imgpeople_avatar);

        tvpeople_name.setText(currentItem.getPeople_name());
        tvpeople_phone.setText(currentItem.getPeople_phone());
        imgpeople_avatar.setImageResource(currentItem.getPeople_img());

        return convertView;
    }
}
