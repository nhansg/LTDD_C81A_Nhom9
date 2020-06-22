package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.DetailTruyenActivity;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.models.Truyen;

import java.util.ArrayList;

public class AdapterTruyen extends RecyclerView.Adapter<AdapterTruyen.ViewHolder> {
    private ArrayList<Truyen> listTruyen;
    private Context context;

    public AdapterTruyen(ArrayList<Truyen> listTruyen, Context context) {
        this.listTruyen = listTruyen;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.cardview_truyen2,parent,false);
        ViewHolder vHolder = new ViewHolder(itemView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Truyen truyen = listTruyen.get(position);
        holder.txtTen.setText(truyen.getTenTruyen());
        Bitmap bmAnh = BitmapFactory.decodeByteArray(truyen.getAnh(),0,truyen.getAnh().length);
        holder.imgAnh.setImageBitmap(bmAnh);

        holder.cvTruyen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTruyenActivity.class);
                intent.putExtra("Ten",truyen.getTenTruyen());
                intent.putExtra("Anh",truyen.getAnh());
                intent.putExtra("ID",truyen.getId());
                intent.putExtra("TT",truyen.getIdTrangThai());
                intent.putExtra("LT",truyen.getIdLoaiTruyen());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTen;
        private ImageView imgAnh;
        private CardView cvTruyen1;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTen = (TextView)itemView.findViewById(R.id.txtTenTruyen2);
            imgAnh = (ImageView)itemView.findViewById(R.id.imgTruyen2);
            cvTruyen1 = (CardView) itemView.findViewById(R.id.cv_truyen2);
        }
    }
}
