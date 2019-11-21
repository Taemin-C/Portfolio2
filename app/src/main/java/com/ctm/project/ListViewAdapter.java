package com.ctm.project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

public ListViewAdapter(){}

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    final int pos = position;
    final Context context = parent.getContext();

    if (convertView == null){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.webtoonlistview,parent,false);
    }

    ImageView iconImageView = (ImageView)convertView.findViewById(R.id.imageView1);
    TextView titletextView = (TextView)convertView.findViewById(R.id.textView1);
    TextView desctextView = (TextView)convertView.findViewById(R.id.textdesc);
    TextView writertextView = (TextView)convertView.findViewById(R.id.textView2);

    ListViewItem listViewItem= listViewItemList.get(position);

    iconImageView.setImageDrawable(listViewItem.getIcon());
    titletextView.setText(listViewItem.getTitle());
    desctextView.setText(listViewItem.getDesc());
    writertextView.setText(listViewItem.getWriter());

        return convertView;
    }
    public void addItem(Drawable icon, String title,String desc,String writer) {
       ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        item.setWriter(writer);

        listViewItemList.add(item);
    }
}
