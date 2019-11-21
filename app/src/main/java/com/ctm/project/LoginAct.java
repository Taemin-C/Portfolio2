package com.ctm.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAct extends AppCompatActivity {
    Button backhome, loginbtn, login,signupbtn;
    static EditText editId, editPass;
    TextView textId;
    ImageView profileimg;
    DbHelper dbHelper;
    String[] Ids = {"dog", "cat", "ferret", "lesser"};
    String[] Pass = {"ajdajd", "didhd", "vpflt", "fptjvosej"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        dbHelper = new DbHelper(getApplicationContext());

        editId = (EditText) findViewById(R.id.editId);
        editPass = (EditText) findViewById(R.id.editPass);
        backhome = (Button) findViewById(R.id.backhome);
        login = (Button) findViewById(R.id.login);
        dbHelper = new DbHelper(getApplicationContext());


    }

    public void LOnClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Intent intent2 = new Intent(getApplicationContext(),Write.class);
        switch (v.getId()) {
            case R.id.signupbtn:
                Intent GoSignUp = new Intent(getApplicationContext(),SignUp.class);
                startActivity(GoSignUp);
                break;

            case R.id.backhome:
                startActivity(intent);
                break;
            case R.id.loginbtn:
                String id = editId.getText().toString();
                String pw = editPass.getText().toString();

                if(dbHelper.CheckMember(id,pw)){

                    intent.putExtra("id",id);
                    intent2.putExtra("id",id);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT).show();
                    return;
                }
              /*  if (editId.getText().toString().equals(Ids[0]) && PASS.equals(Pass[0])) {
                    ID = "강아지";


                    intenthome.putExtra("id", ID.toString());
                    intenthome.putExtra("profile", 0);
                    startActivity(intenthome);
                    break;
                } else if (editId.getText().toString().equals(Ids[1]) && PASS.equals(Pass[1])) {
                    ID = "고양이";
                    intenthome.putExtra("id", ID.toString());
                    intenthome.putExtra("profile", 1);
                    startActivity(intenthome);
                    break;
                } else if (editId.getText().toString().equals(Ids[2]) && PASS.equals(Pass[2])) {

                    ID = "페럿";
                    intenthome.putExtra("id", ID.toString());
                    intenthome.putExtra("profile", 2);
                    startActivity(intenthome);
                    break;
                } else if (editId.getText().toString().equals(Ids[3]) && PASS.equals(Pass[3])) {
                    ID = "레서팬더";
                    intenthome.putExtra("id", ID.toString());
                    intenthome.putExtra("profile", 3);
                    startActivity(intenthome);
                    break;
                } else {
                    Toast.makeText(getApplicationContext(), "아이디/비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    editPass.setText("");
                    editId.setText("");
                }

*/
        }

    }

}




