package com.ctm.project;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText idEdit, pwEdit, nameEdit;
    RadioGroup genderRg;
    String gender;
    DbHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("회원가입");

        idEdit = (EditText) findViewById(R.id.IdEdit_signup);
        pwEdit = (EditText) findViewById(R.id.PwEdit_signup);
        nameEdit = (EditText) findViewById(R.id.NameEdit_signup);
        final Button OkBtn = (Button) findViewById(R.id.OkBtn_signup);
        Button CancelBtn = (Button) findViewById(R.id.CancelBtn_signup);
        final Button idcheck = (Button) findViewById(R.id.idcheck);
        genderRg = (RadioGroup) findViewById(R.id.GenderRg_signup);

        dbHelper = new DbHelper(this);

        OkBtn.setEnabled(false);


        idcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEdit.getText().toString();

                Cursor c = dbHelper.checkid(id);
                c.moveToNext();
                if (c.getCount() == 0 && !(id.equals(""))) {
                    Toast.makeText(getApplicationContext(), "사용 가능한 id입니다.", Toast.LENGTH_SHORT).show();
                    OkBtn.setEnabled(true);
                } else {
                    Toast.makeText(getApplicationContext(), "이미 존재하는 id입니다.", Toast.LENGTH_SHORT).show();
                    OkBtn.setEnabled(false);
                }
            }
        });

        OkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력한 값을 가져와 member table insert
                String id = idEdit.getText().toString();
                String pw = pwEdit.getText().toString();
                String name = nameEdit.getText().toString();
                String gen = gender;
                try {
                    if (pw.length() < 5) {
                        Toast.makeText(getApplicationContext(), "비밀번호를 5자 이상 입력해주세요", Toast.LENGTH_SHORT).show();
                        pwEdit.setText("");
                        return;
                    } else {
                        dbHelper.insertMember(id, pw, name, gen);
                        Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력하지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idEdit.setText("");
                pwEdit.setText("");
                nameEdit.setText("");
                genderRg.clearCheck();
                finish();
            }
        });

        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ManRb_signup:
                        gender = "Man";
                        break;
                    case R.id.WomanRb_signup:
                        gender = "Woman";
                        break;
                }
            }
        });
    }
    }
