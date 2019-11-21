package com.ctm.project;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeLIstAdapter extends BaseAdapter {
    boolean i = false;
    private ArrayList<InvenItem> listViewItemList = new ArrayList<InvenItem>();

    public HomeLIstAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.toonhomelist, parent, false);
        }
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.homeImageView1);
        TextView titletextView = (TextView) convertView.findViewById(R.id.homeTextView1);
        TextView datetextView = (TextView) convertView.findViewById(R.id.homeDate);
        final ImageButton downbtn = (ImageButton) convertView.findViewById(R.id.downbtn);

        downbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == false) {
                    downbtn.setBackgroundColor(Color.GRAY);
                    i= true;}
                else {
                    downbtn.setBackgroundColor(Color.parseColor("#00ff0000"));
                    i=false;}
            }
        });
        downbtn.setFocusable(false);

        InvenItem listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titletextView.setText(listViewItem.getTitle());
        datetextView.setText(listViewItem.getDate());

        return convertView;

    }

    public void addinven(Drawable icon, String title, String date) {
        InvenItem inven = new InvenItem();

        inven.setIcon(icon);
        inven.setTitle(title);
        inven.setDate(date);

        listViewItemList.add(inven);
    }
}