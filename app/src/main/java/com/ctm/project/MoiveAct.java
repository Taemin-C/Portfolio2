package com.ctm.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.View;
import com.ctm.project.R;

public class MoiveAct extends AppCompatActivity {
    Button newmovie;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        newmovie = (Button)findViewById(R.id.newmovie);

        newmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewMovie = new Intent(MoiveAct.this,NewMovie.class);
                startActivity(intentNewMovie);
            }
        });

        int img[] = {
                R.drawable.movie1,R.drawable.movie2,R.drawable.movie3};

        MyAdapter adapter = new MyAdapter(
                getApplicationContext(),
                R.layout.gridrow,
                img);

        GridView gv = (GridView)findViewById(R.id.gridview1);
        GridView gv2 = (GridView)findViewById(R.id.gridview2);

        gv2.setAdapter(adapter);
        gv.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("영화");
        actionBar.setDisplayHomeAsUpEnabled(true);

       gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position)
               {
                   case 0:
                       Intent SazaIntent = new Intent(MoiveAct.this,Saza.class);
                       startActivity(SazaIntent);
                       break;


               }
           }
       });



    }
}
class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    int img[];
    LayoutInflater inf;

    public MyAdapter(Context context, int layout, int[] img) {
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

