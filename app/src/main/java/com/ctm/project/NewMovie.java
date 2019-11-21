package com.ctm.project;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class NewMovie extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmovie);

        int img[] = {
                R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
                R.drawable.movieimg4, R.drawable.movieimg5, R.drawable.movieimg6, R.drawable.movieimg7};
        NewMovieAdapter adapter2 = new NewMovieAdapter(
                getApplicationContext(),
                R.layout.gridrow,img);

        GridView NMGV = (GridView)findViewById(R.id.newmoviegrid);

        NMGV.setAdapter(adapter2);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("[NEW]놓칠 수 없는 최신작");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
class NewMovieAdapter extends BaseAdapter {
    Context context;
    int layout;
    int img[];
    LayoutInflater inf;

    public NewMovieAdapter(Context context, int layout, int[] img) {
        this.context = context;
        this.layout = layout;
        this.img = img;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView = inf.inflate(layout, null);
        ImageView iv = (ImageView)convertView.findViewById(R.id.gridimg1);
        iv.setImageResource(img[position]);

        return convertView;
    }
}
