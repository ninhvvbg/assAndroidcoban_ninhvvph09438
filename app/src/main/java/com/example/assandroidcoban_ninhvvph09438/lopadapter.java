package com.example.assandroidcoban_ninhvvph09438;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class lopadapter extends BaseAdapter {
    public ArrayList<lop> lops;
    public Context context;

    public lopadapter(ArrayList<lop> lops, Context context){
        this.lops = lops;
        this.context = context;
    }
    @Override
    public int getCount() {
        return lops.size();
    }

    @Override
    public Object getItem(int i) {
        return lops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.danhsachlop,viewGroup,false);
        TextView txtmalop = view.findViewById(R.id.txtma);
        TextView txttenlop = view.findViewById(R.id.txtten);
        txtmalop.setText(lops.get(i).getMalop());
        txttenlop.setText(lops.get(i).getTenlop());
        return view;
    }
}
