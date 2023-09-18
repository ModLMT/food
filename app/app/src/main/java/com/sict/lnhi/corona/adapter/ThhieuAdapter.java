package com.sict.lnhi.corona.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sict.lnhi.corona.R;
import com.sict.lnhi.corona.model.Menu;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ThhieuAdapter extends BaseAdapter {
    Context context;
    ArrayList<Menu> arraythuonghieu;

    public ThhieuAdapter(Context context, ArrayList<Menu> arraythuonghieu) {
        this.context = context;
        this.arraythuonghieu = arraythuonghieu;
    }

    @Override
    public int getCount() {
        return arraythuonghieu.size();
    }

    @Override
    public Object getItem(int i) {
        return arraythuonghieu.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        public TextView txtten, txtgia, txtmota;
        public ImageView imganh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_thhieu, null);
            viewHolder.txtten = (TextView) view.findViewById(R.id.tenth);
            viewHolder.txtgia = (TextView) view.findViewById(R.id.gia);
            viewHolder.txtmota = (TextView) view.findViewById(R.id.mota);
            viewHolder.imganh = (ImageView) view.findViewById(R.id.imgth);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Menu menu = (Menu) getItem(i);
        Picasso.with(context).load(menu.getAnh()).placeholder(R.drawable.logo).error(R.drawable.login).into(viewHolder.imganh);
        viewHolder.txtten.setText(menu.getTenmon());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgia.setText("Giá: " +decimalFormat.format(menu.getGia())+"Đ");
        viewHolder.txtmota.setMaxLines(2);
        viewHolder.txtmota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmota.setText(menu.getMota());

        return view;
    }
}