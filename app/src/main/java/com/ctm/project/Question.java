package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Question extends AppCompatActivity {
    Spinner spin1, spin2;
    Button send;
    String[] item;
    String[] nation;
    EditText editquestion;
    CheckBox agree;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("문의하기");
        actionBar.setDisplayHomeAsUpEnabled(true);

        agree = (CheckBox)findViewById(R.id.agree);

        spin1 = (Spinner) findViewById(R.id.spinnerquestion);
        spin2 = (Spinner) findViewById(R.id.nation);
        editquestion = (EditText) findViewById(R.id.editquestion);
        item = new String[]{"문의내용 선택", "이용권 환불", "캐시 환불", "구매오류", "캐시 충전오류",
                "권리침해 신고", "개선 제안", "콘텐츠 관련", "이용 장애"};
        nation = new String[]{"국가 선택", "+82 Korea Republikc of", "+84 Vietnam", "+852 Hong Kong", "+853 Macau", "+855 Cambodia", "+856 Laos",
                "+86 China", "+870 Pitcairn Islands", "+880 Bangladesh", "+886 Taiwan", "+90 Turkey", "+91 India"};


        send = (Button) findViewById(R.id.questionsend);

        ArrayAdapter<String> spinadapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, item);
        ArrayAdapter<String> spinadapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nation);
        spin1.setAdapter(spinadapter1);
        spin2.setAdapter(spinadapter2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "미구현", Toast.LENGTH_SHORT).show();
            }
        });
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String a = "-환불을 원하는 이용권의 시리즈명: ";
                String b = "-환불을 원하는 그레이 북 계정(이메일):";
                switch (position) {
                    case 0:
                        editquestion.setText("문의 내용을 선택해 주세요");
                        break;
                    case 1:
                        editquestion.setText(a + "\n" + b);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    send.setEnabled(true); }
                    else {send.setEnabled(false);}

            }
        });


    }
}
