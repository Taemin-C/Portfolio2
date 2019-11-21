package com.ctm.project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
   DbHelper dbHelper;
    boolean i = false;
    private ArrayList<InvenItem> listViewItemList = new ArrayList<InvenItem>();
    private Context alt;
    public ListAdapter(Context alt) {
        this.alt = alt;
    }
    String titles;



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

    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.allinvenlist, parent, false);
        }
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.invenImageView1);
        final TextView titletextView = (TextView) convertView.findViewById(R.id.invenTextView1);
        TextView datetextView = (TextView) convertView.findViewById(R.id.invenDate);
        final ImageButton alterbtn = (ImageButton) convertView.findViewById(R.id.alterbtn);
        InvenItem listViewItem = listViewItemList.get(position);
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titletextView.setText(listViewItem.getTitle());
        datetextView.setText(listViewItem.getDate());

        titles = listViewItem.getTitle();


        alterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == false) {

                    alterbtn.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(alt,"업데이트시 알림을 받습니다.",Toast.LENGTH_SHORT).show();
                i= true;}
                else {
                    alterbtn.setBackgroundColor(Color.parseColor("#00ff0000"));
                    Toast.makeText(alt,"알림을 받지 않습니다.",Toast.LENGTH_SHORT).show();
                i=false;}
            }
        });
        alterbtn.setFocusable(false);
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


