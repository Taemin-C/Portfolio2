package com.ctm.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class tfirst extends Fragment {

    public tfirst(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.toonvpfrg1,container,false);
        ImageView nimg =(ImageView)layout.findViewById(R.id.nimg);
        nimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WhogungIntent = new Intent(getActivity(),Whogung.class);
                startActivity(WhogungIntent);
            }
        });
        return layout;
    }
}
