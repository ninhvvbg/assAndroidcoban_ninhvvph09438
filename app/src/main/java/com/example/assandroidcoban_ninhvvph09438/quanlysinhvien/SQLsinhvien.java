package com.example.assandroidcoban_ninhvvph09438.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLsinhvien extends SQLiteOpenHelper {
    public SQLsinhvien(@Nullable Context context) {
        super(context, "SQLsinhvien", null, 1);
    }
    public  static final String TABLE_NAME = "SQLsinhvien";
    public  static  final  String COLUMN_ID = "ID";
    public  static  final  String COLUMN_NAME = "NAME";
    public static final  String COLUMN_NGAYSINH = "NGAYSINH";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY , " +
                ""+COLUMN_NAME+" VARCHAR,"+COLUMN_NGAYSINH+" VARCHAR)";
        Log.e("SQL",CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  long savesinhvien(sinhvien sinhvien){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,sinhvien.getId());
        contentValues.put(COLUMN_NAME,sinhvien.getName());
        contentValues.put(COLUMN_NGAYSINH,sinhvien.getNgaysinh());
        long ab = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return ab;
    }
    public long uploadsinhvien(sinhvien sinhvien){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,sinhvien.getId());
        contentValues.put(COLUMN_NAME,sinhvien.getName());
        contentValues.put(COLUMN_NGAYSINH,sinhvien.getNgaysinh());
        long ab = sqLiteDatabase.update(TABLE_NAME,contentValues,COLUMN_ID + "=?",new String[]{String.valueOf(sinhvien.getId())});
        return ab;

    }
    public long xoasinhvien ( String id){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,COLUMN_ID + "=?",new String[]{id});
    }
   public ArrayList<sinhvien> showsinhvien(){
        ArrayList<sinhvien> sinhviens = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String all = "SELECT * FROM " + TABLE_NAME;
       Cursor cursor = sqLiteDatabase.rawQuery(all,null);

       if (cursor != null && cursor.getCount() >0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
//               String id = cursor.getString(0);
//               String name = cursor.getString(1);
//               String ngaysinh = cursor.getString(2);
//               sinhvien sinhvien = new sinhvien(id,name,ngaysinh);
//               sinhviens.add(sinhvien);
//               cursor.moveToNext();
               String id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
               String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
               String ngaysinh = cursor.getString(cursor.getColumnIndex(COLUMN_NGAYSINH));
               sinhvien sinhvien = new sinhvien();
               sinhvien.setId(id);
               sinhvien.setName(name);
               sinhvien.setNgaysinh(ngaysinh);
               sinhviens.add(sinhvien);
               cursor.moveToNext();
           }
       }
       return sinhviens;
    }


}
