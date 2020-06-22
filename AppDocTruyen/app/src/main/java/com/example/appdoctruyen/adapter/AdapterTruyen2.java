package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.models.Truyen;

import java.util.ArrayList;

public class AdapterTruyen2 extends RecyclerView.Adapter<AdapterTruyen2.ViewHolder> {
    private ArrayList<Truyen> listTruyen;
    private Context context;

    public AdapterTruyen2(ArrayList<Truyen> listTruyen, Context context) {
        this.listTruyen = listTruyen;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.cardview_truyen1,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyen truyen = listTruyen.get(position);
        holder.txtTen.setText(truyen.getTenTruyen());
        Bitmap bmAnh = BitmapFactory.decodeByteArray(truyen.getAnh(),0,truyen.getAnh().length);
        holder.imgAnh.setImageBitmap(bmAnh);
    }

    @Override
    public int getItemCount() {
        return listTruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTen;
        private ImageView imgAnh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTen = (TextView)itemView.findViewById(R.id.txtTenTruyen1);
            imgAnh = (ImageView)itemView.findViewById(R.id.imgTruyen1);
        }
    }
}
