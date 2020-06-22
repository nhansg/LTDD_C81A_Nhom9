package com.example.appdoctruyen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.adapter.AdapterTruyen;
import com.example.appdoctruyen.models.ChiTietTacGia;
import com.example.appdoctruyen.models.Truyen;

import java.util.ArrayList;

public class DetailTruyenActivity extends AppCompatActivity {
    private ImageView img;
    private TextView ten,tacGia,trangThai,theLoai,soChuong,chuongMoi;
    private RecyclerView recyclerView;
    final String DATABASE_NAME = "dbAppRead.db";
    SQLiteDatabase DB;
    ArrayList<Truyen> mTruyen;
    ArrayList<ChiTietTacGia> mTacGia;
    AdapterTruyen adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_truyen);
        DB = Database.initDatabase(this,DATABASE_NAME);
        anhXa();
        initUI();

        LinearLayoutManager ln = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(ln);
        recyclerView.setAdapter(adapter);
    }
    void initUI()
    {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",-1);
        Cursor cursor = DB.rawQuery("SELECT * FROM Truyen WHERE idTruyen = ? ",new String[]{String.valueOf(id)});
        cursor.moveToFirst();
        int idTruyen = cursor.getInt(0);
        String tenTruyen = cursor.getString(1);
        int idTrangThai = cursor.getInt(2);
        int idLoaiTruyen = cursor.getInt(3);
        byte[] anh = cursor.getBlob(4);

        Bitmap bmAnh = BitmapFactory.decodeByteArray(anh,0,anh.length);
        String tt = getTrangThaiByID(idTrangThai);
        int idTg = getIDTacGiaByIdT(idTruyen);
        String tg = getTacGiabyID(idTg);

        getTruyenCungTacGia(idTg);
        img.setImageBitmap(bmAnh);
        ten.setText(tenTruyen);
        trangThai.setText("Trạng thái : "+tt);
        tacGia.setText("Tác giả : " +tg);
    }
    String getTrangThaiByID(int idTT)
    {
        Cursor cursor = DB.rawQuery("SELECT * FROM TrangThai WHERE idTrangThai = ?",new String[]{String.valueOf(idTT)});
        cursor.moveToFirst();
        String tt = cursor.getString(1);
        return tt;
    }
    int getIDTacGiaByIdT(int idT)
    {
        Cursor cursor = DB.rawQuery("SELECT * FROM ChiTietTacGia WHERE idTruyen = ?",new String[]{String.valueOf(idT)});
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        return id;
    }
    String getTacGiabyID(int idtg)
    {
        Cursor cursor = DB.rawQuery("SELECT * FROM TacGia WHERE idTacGia = ?",new String[]{String.valueOf(idtg)});
        cursor.moveToFirst();
        String tg = cursor.getString(1);
        return tg;
    }
    String getLoaiTruyenbyID(int idLT)
    {
        Cursor cursor = DB.rawQuery("SELECT * FROM LoaiTruyen WHERE idLoaiTruyen = ?",new String[]{String.valueOf(idLT)});
        cursor.moveToFirst();
        String lt = cursor.getString(1);
        return lt;
    }
    public void getTruyenCungTacGia(int idTg)
    {
        Cursor cursor = DB.rawQuery("SELECT a.idTruyen,a.tenTruyen,a.idTrangThai,a.idLoaiTruyen,a.anh " +
                                        "FROM Truyen a, ChiTietTacGia b " +
                                        "WHERE idTacGia = ? AND a.idTruyen = b.idTruyen",
                                        new String[]{String.valueOf(idTg)});
        mTruyen.clear();
        for(int i = 0; i < cursor.getCount();i++)
        {
            cursor.moveToPosition(i);
            int idTruyen = cursor.getInt(0);
            String ten = cursor.getString(1);
            int idTrangThai = cursor.getInt(2);
            int idLoaiTruyen = cursor.getInt(3);
            byte[] anh = cursor.getBlob(4);
            mTruyen.add(new Truyen(idTruyen,ten,idTrangThai,idLoaiTruyen,anh));
        }
        adapter.notifyDataSetChanged();
    }
    void anhXa()
    {
        img = (ImageView) findViewById(R.id.imgDetail);
        ten = (TextView)findViewById(R.id.ten);
        tacGia = (TextView)findViewById(R.id.tacgia);
        trangThai = (TextView)findViewById(R.id.trangthai);
        theLoai = (TextView)findViewById(R.id.theloai);
        soChuong = (TextView)findViewById(R.id.sochuong);
        chuongMoi = (TextView)findViewById(R.id.chuongmoi);
        recyclerView = (RecyclerView)findViewById(R.id.rvCungTacGia);
        mTruyen = new ArrayList<Truyen>();
        adapter = new AdapterTruyen(mTruyen,this);
    }
}
