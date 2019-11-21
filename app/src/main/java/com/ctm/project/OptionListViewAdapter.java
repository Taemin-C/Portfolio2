package com.ctm.project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OptionListViewAdapter extends BaseAdapter {
    private ArrayList<OptionListItem> OptionItemlist = new ArrayList<OptionListItem>();

    public OptionListViewAdapter() {
    }

    @Override
    public int getCount() {
        return OptionItemlist.size();
    }

    @Override
    public Object getItem(int position) {
        return OptionItemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.optionlistview,parent,false);
        }
            TextView titletextView = (TextView)convertView.findViewById(R.id.t1);
            TextView desctextView = (TextView)convertView.findViewById(R.id.t2);

            OptionListItem optionItemlist= OptionItemlist.get(position);

            titletextView.setText(optionItemlist.getTitle());
            desctextView.setText(optionItemlist.getDesc());

            return convertView;


        }
        public void addoption(String title, String desc) {
        OptionListItem option = new OptionListItem();

        option.setTitle(title);
        option.setDesc(desc);

        OptionItemlist.add(option);
        }

    }

