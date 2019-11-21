package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ticket extends AppCompatActivity {
    EditText editcount1, editcount2, editcount3, editcount4, editcount5, editcount6;
    TextView totalnum, totalprice;
    Button tbuy;

    int P100 = 9000;
    int P80 = 7200;
    int P50 = 4500;
    int P30 = 2700;
    int P10 = 900;
    int P1 = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("이용권 충전");
        actionBar.setDisplayHomeAsUpEnabled(true);

        editcount1 = (EditText) findViewById(R.id.editcount1);
        editcount2 = (EditText) findViewById(R.id.editcount2);
        editcount3 = (EditText) findViewById(R.id.editcount3);
        editcount4 = (EditText) findViewById(R.id.editcount4);
        editcount5 = (EditText) findViewById(R.id.editcount5);
        editcount6 = (EditText) findViewById(R.id.editcount6);
        totalnum = (TextView) findViewById(R.id.totalnum);
        totalprice = (TextView) findViewById(R.id.totalprice);
        tbuy = (Button) findViewById(R.id.tbuy);
        tbuy.setEnabled(false);


        TextWatcher textWatcher = new TextWatcher() {
            int a, b, c, d, e, f;
            int pa, pb, pc, pd, pe, pf;
            String str1,str2,str3,str4,str5,str6;


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                str1 = editcount1.getText().toString();

                if (str1.getBytes().length<=0) {
                    a=0;
                    pa = 0;
                    int total = a+b+c+d+e+f;
                    totalnum.setText("총 "+total+"개");
                    int totalp = pa + pb + pc + pd + pe + pf;
                    totalprice.setText(totalp+"");
                }
                str2 = editcount2.getText().toString();
                if (str2.getBytes().length<=0) {
                    b=0;
                    pb = 0;
                    int total = a+b+c+d+e+f;
                    totalnum.setText("총 "+total+"개");
                    int totalp = pa + pb + pc + pd + pe + pf;
                    totalprice.setText(totalp+"");
                }
                str3 = editcount3.getText().toString();
                if (str3.getBytes().length<=0) {
                    c=0;
                    pc = 0;
                    int total = a+b+c+d+e+f;
                    totalnum.setText("총 "+total+"개");
                    int totalp = pa + pb + pc + pd + pe + pf;
                    totalprice.setText(totalp+"");
                }
                str4 = editcount4.getText().toString();
                if (str4.getBytes().length<=0) {
                    d=0;
                    pd = 0;
                    int total = a+b+c+d+e+f;
                    totalnum.setText("총 "+total+"개");
                    int totalp = pa + pb + pc + pd + pe + pf;
                    totalprice.setText(totalp+"");
                }
                str5 = editcount5.getText().toString();
                if (str5.getBytes().length<=0) {
                    e=0;
                    pe = 0;
                    int total = a+b+c+d+e+f;
                    totalnum.setText("총 "+total+"개");
                    int totalp = pa + pb + pc + pd + pe + pf;
                    totalprice.setText(totalp+"");
                }
                str6 = editcount6.getText().toString();
                if (str6.getBytes().length<=0) {
                    f=0;
                    pf = 0;
                    int total = a+b+c+d+e+f;
                    totalnum.setText("총 "+total+"개");
                    int totalp = pa + pb + pc + pd + pe + pf;
                    totalprice.setText(totalp+"");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String p = totalprice.getText().toString();
                String t = totalnum.getText().toString();
                if (p.getBytes().length<2) {tbuy.setEnabled(false);}
                if (s == editcount1.getEditableText()) {
                    try {

                        a = (Integer.parseInt(editcount1.getText().toString())) * 100;
                        int total = a + b + c + d + e + f;
                        totalnum.setText("총 " + total + "개");
                        pa = (Integer.parseInt(editcount1.getText().toString())) * P100;
                        int totalp = pa + pb + pc + pd + pe + pf;
                        totalprice.setText(totalp + "");
                        if (totalp > 0) {
                            tbuy.setEnabled(true);
                        } else if (p.getBytes().length <=1){tbuy.setEnabled(false);}
                    } catch (Exception e) {
                    }
                } else if (s == editcount2.getEditableText()) {

                    try {
                        b = (Integer.parseInt(editcount2.getText().toString())) * 80;
                        int total = a + b + c + d + e + f;
                        totalnum.setText("총 " + total + "개");
                        if (editcount2.getText().toString()==null||editcount2.getText().toString().equals("")) {
                            pb = 0;
                        } else
                            pb = (Integer.parseInt(editcount2.getText().toString())) * P80;
                        int totalp = pa + pb + pc + pd + pe + pf;
                        totalprice.setText(totalp + "");
                        if (totalp > 0) {
                            tbuy.setEnabled(true);
                        } else if (totalp <= 0) {
                            tbuy.setEnabled(false);
                        }

                    } catch (Exception e) {
                    }
                } else if (s == editcount3.getEditableText()) {

                    try {
                        c = (Integer.parseInt(editcount3.getText().toString())) * 50;
                        int total = a + b + c + d + e + f;
                        totalnum.setText("총 " + total + "개");
                        if (editcount3.getText().toString()==null||editcount3.getText().toString().equals("")) {
                            pc = 0;
                        } else
                            pc = (Integer.parseInt(editcount3.getText().toString())) * P50;
                        int totalp = pa + pb + pc + pd + pe + pf;
                        totalprice.setText(totalp + "");
                        if (totalp > 0) {
                            tbuy.setEnabled(true);
                        } else if (totalp <= 0) {
                            tbuy.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                } else if (s == editcount4.getEditableText()) {
                    try {
                        d = (Integer.parseInt(editcount4.getText().toString())) * 30;
                        int total = a + b + c + d + e + f;
                        totalnum.setText("총 " + total + "개");
                        if (editcount4.getText().toString()==null||editcount4.getText().toString().equals("")) {
                            pd = 0;
                        } else
                            pd = (Integer.parseInt(editcount4.getText().toString())) * P30;
                        int totalp = pa + pb + pc + pd + pe + pf;
                        totalprice.setText(totalp + "");
                        if (totalp > 0) {
                            tbuy.setEnabled(true);
                        } else if (totalp <= 0) {
                            tbuy.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                } else if (s == editcount5.getEditableText()) {
                    try {
                        e = (Integer.parseInt(editcount5.getText().toString())) * 10;
                        int total = a + b + c + d + e + f;
                        totalnum.setText("총 " + total + "개");
                        if (editcount5.getText().toString()==null||editcount5.getText().toString().equals("")) {
                            pe = 0;
                        } else
                            pe = (Integer.parseInt(editcount5.getText().toString())) * P10;
                        int totalp = pa + pb + pc + pd + pe + pf;
                        totalprice.setText(totalp + "");
                        if (totalp > 0) {
                            tbuy.setEnabled(true);
                        } else if (totalp <= 0) {
                            tbuy.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                } else if (s == editcount6.getEditableText()) {
                    try {
                        f = (Integer.parseInt(editcount6.getText().toString())) * 1;
                        int total = a + b + c + d + e + f;
                        totalnum.setText("총 " + total + "개");
                        if (editcount6.getText().toString()==null||editcount6.getText().toString().equals("")) {
                            pf = 0;
                        } else
                            pf = (Integer.parseInt(editcount6.getText().toString())) * P1;
                        int totalp = pa + pb + pc + pd + pe + pf;
                        totalprice.setText(totalp + "");
                        if (totalp > 0) {
                            tbuy.setEnabled(true);
                        } else if (totalp <= 0) {
                            tbuy.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

        };
        editcount1.addTextChangedListener(textWatcher);
        editcount2.addTextChangedListener(textWatcher);
        editcount3.addTextChangedListener(textWatcher);
        editcount4.addTextChangedListener(textWatcher);
        editcount5.addTextChangedListener(textWatcher);
        editcount6.addTextChangedListener(textWatcher);


        tbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "이용권을 구매하였습니다", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
