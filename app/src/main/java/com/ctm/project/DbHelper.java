package com.ctm.project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "graybook.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE member (_memberId INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT UNIQUE NOT NULL, pw TEXT NOT NULL, name TEXT NOT NULL, gender TEXT CHECK (gender IN ('Man','Woman')));");
        db.execSQL("CREATE TABLE post (_num INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL, date TEXT, writer TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor searchPost(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM post ORDER BY _num DESC;", null);
        return cursor;
    }
    public void deletePost(int num) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM post WHERE _num=" + num + ";");
        db.close();
    }
    public void updatePost(int num, String title, String content) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE post SET title='" + title + "', content='"+content + "'"+ "WHERE _num=" + num + ";");
        db.close();
    }
    public void insertPost(String title, String content, String date, String writer) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO post VALUES(null, '" + title + "', '" + content + "', '" + date + "', '"+writer+"');");
        db.close();
    }

    public void insertMember(String id, String pw, String name, String gender) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO member VALUES(null, '" + id + "', '" + pw + "', '" + name + "', '" + gender + "');");
        db.close();
    }

    public Cursor login(String id, String pw) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM member WHERE id = '" + id + "' AND pw = '" + pw + "' ;", null);
        return cursor;
    }

    public Cursor checkid(String id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM member WHERE id = '" + id + "';", null);
        return cursor;

    }

    public Cursor nickname(String id)
    {SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM member WHERE id = '" + id + "' ;",null);
    return cursor;}

    public boolean CheckMember(String id, String pw){
        SQLiteDatabase db = getReadableDatabase();
        boolean result;
        Cursor cursor = db.rawQuery("SELECT * FROM member WHERE id = '"+ id +"';", null);
        if(cursor.getCount() == 0){
            result = false;
        }else{
            cursor.moveToNext();
            String checkPw = cursor.getString(cursor.getColumnIndex("pw"));
            if(pw.equals(checkPw)){result = true;}
            else{result = false;}
        }
        return result;
    }
}