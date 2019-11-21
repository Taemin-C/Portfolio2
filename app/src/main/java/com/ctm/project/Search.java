package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Search extends AppCompatActivity {
    EditText editsearch;
    ImageButton searchib;
    Spinner pop;
    String popular[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("검색");
        actionBar.setDisplayHomeAsUpEnabled(true);
        editsearch = (EditText) findViewById(R.id.editsearch);
        searchib = (ImageButton) findViewById(R.id.searchib);

        pop = (Spinner) findViewById(R.id.rank);

        popular = new String[] {"인기검색어","1. 존윅3","2. 후궁계약","3. 학사재생","4. 창공의 크로이스","5. 나랏말싸미","6. 사자","7. 기생충"};

        ArrayAdapter<String> popadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,popular);
        pop.setAdapter(popadapter);


        pop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :break;
                    case 1 :editsearch.setText("존 윅3");
                        break;
                    case 2: editsearch.setText("후궁계약");
                        break;
                    case 3 : editsearch.setText("학사재생");
                        break;
                    case 4 : editsearch.setText("창공의 크로이스");
                    break;
                    case 5: editsearch.setText("나랏말싸미");
                    break;
                    case 6:  editsearch.setText("사자");
                        break;
                    case 7: editsearch.setText("기생충");
                    break;


                }
    }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    }
