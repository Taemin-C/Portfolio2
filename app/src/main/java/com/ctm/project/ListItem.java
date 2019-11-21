package com.ctm.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItem {
    int num;
    String title;
    String content;
    String date;
    String writer;


    public ListItem(int num, String title, String content, String date, String writer) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.date = date;
        this.writer = writer;

    }
}


class ListItemAdapter extends BaseAdapter {
    Context maincon; //mainActivity
    LayoutInflater Inflater; //메인 액티비티의 레이아웃인플레이터
    ArrayList<ListItem> arSrc; //데이터원본 배열
    int layout; //사용할 xml의 리소스값

    public ListItemAdapter(Context context, int alayout, ArrayList<ListItem> aarSrc) {
        maincon = context;
        Inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        arSrc = aarSrc;
        layout = alayout;
    }

    public int getCount() {
        return arSrc.size(); //데이터 원본 배열의 크기
    }
    public String getItem(int position) {
        return arSrc.get(position).title; //pos위치의 데이터원본의 이름
    }

    public long getItemId(int position) {
        return position; //사용x
    }

    // 각 항목의 뷰 생성
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = Inflater.inflate(layout, parent, false);
        }

        TextView listTitle = (TextView)convertView.findViewById(R.id.TitleTv_ListItem);
        listTitle.setText(arSrc.get(position).title);

        TextView listContent = (TextView)convertView.findViewById(R.id.ContentTv_ListItem);
        listContent.setText(arSrc.get(position).content);

        TextView listDate = (TextView)convertView.findViewById(R.id.DateTv_ListItem);
        listDate.setText(arSrc.get(position).date);

        TextView listWriter = (TextView)convertView.findViewById(R.id.WriterTv_ListItem);
        listWriter.setText(arSrc.get(position).writer);
        return convertView;
    }
}
