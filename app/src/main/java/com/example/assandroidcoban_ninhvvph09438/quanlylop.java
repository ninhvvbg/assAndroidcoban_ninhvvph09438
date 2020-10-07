package com.example.assandroidcoban_ninhvvph09438;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class quanlylop extends SQLiteOpenHelper {
    public quanlylop(@Nullable Context context) {
        super(context, "quanlylop", null, 1);
    }
    public  static  final String TABLE_NAME = "quanlylop";

    public  static  final String COLUMN_MA = "MALOP";
    public  static  final String COLUMN_TENLOP= "TENLOP";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_MA+" INTEGER PRIMARY KEY , "+COLUMN_TENLOP+" VARCHAR)";
        Log.e("SQL",CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long savelop(lop lop){
        SQLiteDatabase sqLiteDatabaser = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MA,lop.getMalop());
        contentValues.put(COLUMN_TENLOP,lop.getTenlop());
        long re =  sqLiteDatabaser.insert(TABLE_NAME,null,contentValues);
        return re;
    }
    public long sualop(lop lop){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MA,lop.getMalop());
        contentValues.put(COLUMN_TENLOP,lop.getTenlop());
        long re = sqLiteDatabase.update(TABLE_NAME,contentValues,COLUMN_MA + "=?", new String[]{lop.getMalop()});
        return re;
    }
    public long xoalop(String malop){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,COLUMN_MA + "=?",new String[]{malop});
    }
    public ArrayList<lop> laydanhsachlop(){
        ArrayList<lop> lops = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String all = "SELECT * FROM quanlylop";
        Cursor cursor = sqLiteDatabase.rawQuery(all,null);
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String ma = cursor.getString(0);
                String ten = cursor.getString(1);
                lop lop = new lop(ma,ten);
                lops.add(lop);
                cursor.moveToNext();
            }
        }
        return lops;
    }
}
