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

public class dfirst extends Fragment {

    public dfirst(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.danhang1,container,false);
        ImageView dimg =(ImageView)layout.findViewById(R.id.dimg);
        dimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Temintent = new Intent(getActivity(),Danhang_Tem.class);
                startActivity(Temintent);
            }
        });
        return layout;
    }
}
