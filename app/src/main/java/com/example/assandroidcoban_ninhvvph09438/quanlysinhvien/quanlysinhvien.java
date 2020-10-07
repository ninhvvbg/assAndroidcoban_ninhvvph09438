package com.example.assandroidcoban_ninhvvph09438.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assandroidcoban_ninhvvph09438.MainActivity;
import com.example.assandroidcoban_ninhvvph09438.R;

import java.util.ArrayList;
import java.util.Calendar;

public class quanlysinhvien extends AppCompatActivity {
    TextView txttensinhvien , txtngaysinhsinhvien,txtidsinhvienmuonxoa,txtstt;
    Button btnthem, btnxoaid,show;
    ArrayList<sinhvien> sinhviens;
    adaptersinhvien adaptersinhvien;
    ListView lvdanhsachsinhvien;
    SQLsinhvien sqLsinhvien;
    String id , name, ngay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlysinhvien);
        sqLsinhvien = new SQLsinhvien(quanlysinhvien.this);
        sinhviens = new ArrayList<>();
        sinhviens.add(new sinhvien());
        sqLsinhvien = new SQLsinhvien(this);
        anhxa();
        gan();
    }

    private void gan() {
        txtngaysinhsinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date();
            }
        });

    }

    private void date() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    txtngaysinhsinhvien.setText(i2 + "/ " + (i1 + 1) + "/" +  i);
            }
        },calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH) );
            datePickerDialog.show();
    }

    @Override
    protected void onDestroy() {
        sqLsinhvien.close();
        super.onDestroy();
    }

    private void anhxa() {
        txttensinhvien = findViewById(R.id.txttensinhvien);
        txtngaysinhsinhvien = findViewById(R.id.txtngaysinhsinhvien);
        txtidsinhvienmuonxoa = findViewById(R.id.txtidsinhvienmuonxoa);
        txtstt = findViewById(R.id.txtstt);
        btnthem = findViewById(R.id.btnthem);
        btnxoaid = findViewById(R.id.btnxoaid);
        show = findViewById(R.id.show);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtstt.length() >= 1 && txttensinhvien.length() >= 5 && txtngaysinhsinhvien.length() >= 4) {
                        sinhvien sinhvien = getdata();
                        long re = sqLsinhvien.savesinhvien(sinhvien);
                    if (re > 0) {
                        Toast.makeText(quanlysinhvien.this, "thêm sinh viên thành công", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(quanlysinhvien.this, "thêm sinh viên thất bại", Toast.LENGTH_LONG).show();

                    }
                }else{
                        Toast.makeText(quanlysinhvien.this,"xem lại thông tin nhận tên phải lớn hơn 5 ",Toast.LENGTH_LONG).show();
                    }
              txtstt.setText("");
              txttensinhvien.setText("");
              txtngaysinhsinhvien.setText("");
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvdanhsachsinhvien = findViewById(R.id.lvdanhsachsinhvien);
                sinhviens = sqLsinhvien.showsinhvien();
                adaptersinhvien = new adaptersinhvien(sinhviens,quanlysinhvien.this);
                lvdanhsachsinhvien.setAdapter(adaptersinhvien);
                adaptersinhvien.notifyDataSetChanged();
            }
        });
        btnxoaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtidsinhvienmuonxoa.length() >= 1){
                    String de1 = txtidsinhvienmuonxoa.getText().toString();
                    int check = (int) sqLsinhvien.xoasinhvien(de1);
                    if (check>0){
                        Toast.makeText(quanlysinhvien.this, " xóa thành công  ", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(quanlysinhvien.this,"xóa thất bại ",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(quanlysinhvien.this, "nhập sai id rồi ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private sinhvien getdata(){
        id = txtstt.getText().toString();
        name = txttensinhvien.getText().toString();
        ngay = txtngaysinhsinhvien.getText().toString();
        sinhvien sinhvien = new sinhvien(id,name,ngay);
        return sinhvien;
    }


}