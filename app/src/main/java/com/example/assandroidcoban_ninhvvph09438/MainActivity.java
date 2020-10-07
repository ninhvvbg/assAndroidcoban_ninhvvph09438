package com.example.assandroidcoban_ninhvvph09438;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assandroidcoban_ninhvvph09438.quanlysinhvien.quanlysinhvien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button themlop,xemdanhsachlop;
    ArrayList<lop> lops;
   quanlylop quanlylop;
   lopadapter lopadapter;
   ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themlop = findViewById(R.id.themlop);
        xemdanhsachlop = findViewById(R.id.xemdanhsachlop);
        list = findViewById(R.id.lvlist);
        xemdanhsachlop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lops = quanlylop.laydanhsachlop();
                lopadapter = new lopadapter(lops,MainActivity.this);
                list.setAdapter(lopadapter);
            }

        });
        quanlylop = new quanlylop(MainActivity.this);
        themlop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
        lops = new ArrayList<>();
        lops.add(new lop("1","1"));
        quanlylop = new quanlylop(this);
    }



    @Override
    protected void onDestroy() {
        quanlylop.close();
        super.onDestroy();
    }

    public void dialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.themlop);
        final TextView txtmalop = dialog.findViewById(R.id.txtmalop);
        final TextView txttenlop = dialog.findViewById(R.id.txttenlop);
        final TextView txtidxoa = dialog.findViewById(R.id.txtidxoa);
        Button btnidxoa = dialog.findViewById(R.id.btnidxoa);
        Button btnxoa = dialog.findViewById(R.id.btnxoa);
        Button btnluu = dialog.findViewById(R.id.btnluu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtmalop.length() >=2 && txttenlop.length() >= 5) {
                    lop lop = new lop();
                    lop.malop = txtmalop.getText().toString();
                    lop.tenlop = txttenlop.getText().toString();
                    long re = quanlylop.savelop(lop);
                    if ( re== 1) {
                        Toast.makeText(MainActivity.this, "Trùng mã lớp vui lòng xem lại", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Thêm lớp thành công", Toast.LENGTH_LONG).show();
                    }
                }else {
                        Toast.makeText(MainActivity.this,"Mã lớp >=3 ký tự tên lớp >=5",Toast.LENGTH_LONG).show();
                    }

                }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtmalop.setText("");
                txttenlop.setText("");
            }
        });
        btnidxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtidxoa.length() >= 3){
                    String de1 = txtidxoa.getText().toString();
                    int check = (int) quanlylop.xoalop(de1);
                    if (check>0){
                        Toast.makeText(MainActivity.this, " xóa thành công  ", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(MainActivity.this,"xóa thất bại ",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "nhập sai id rồi ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }




    public void quanlysinhvien(View view) {
            Intent intent = new Intent(MainActivity.this, quanlysinhvien.class);
        startActivity(intent);

    }


}