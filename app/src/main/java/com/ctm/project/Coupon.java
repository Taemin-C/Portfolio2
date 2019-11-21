package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Coupon extends AppCompatActivity {
    EditText couponedit;
    Button couponbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon);

        couponbtn = (Button)findViewById(R.id.couponbtn);
        couponedit = (EditText)findViewById(R.id.couponedit);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("쿠폰");
        actionBar.setDisplayHomeAsUpEnabled(true);

        couponbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"사용 불가능한 쿠폰입니다.",Toast.LENGTH_SHORT).show();
                couponedit.setText("");
            }
        });
    }
}
