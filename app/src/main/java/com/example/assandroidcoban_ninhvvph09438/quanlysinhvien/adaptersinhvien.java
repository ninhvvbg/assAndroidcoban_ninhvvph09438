package com.example.assandroidcoban_ninhvvph09438.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assandroidcoban_ninhvvph09438.R;

import java.util.ArrayList;

public class adaptersinhvien extends BaseAdapter {
    ArrayList<sinhvien> sinhviens;
    Context context;

    public adaptersinhvien(ArrayList<sinhvien> sinhviens, Context context) {
        this.sinhviens = sinhviens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sinhviens.size();
    }

    @Override
    public Object getItem(int i) {
        return sinhviens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view = LayoutInflater.from(context).inflate(R.layout.danhsachsinhvien,viewGroup,false);
        TextView txtid = view.findViewById(R.id.txtid);
        TextView txtname = view.findViewById(R.id.txtname);
        TextView txtngay = view.findViewById(R.id.txtngay);
        txtid.setText(sinhviens.get(i).getId());
        txtname.setText(sinhviens.get(i).getName());
        txtngay.setText(sinhviens.get(i).getNgaysinh());

        return view;
    }
}
