package com.example.appdoctruyen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.adapter.AdapterTruyen;
import com.example.appdoctruyen.models.Truyen;

import java.util.ArrayList;

public class ThuVienFragment extends Fragment {
    ViewFlipper viewFlipper ;

    final String DATABASE_NAME = "dbAppRead.db";
    SQLiteDatabase database;
    ArrayList<Truyen> list;
    AdapterTruyen adapter;
    CardView cvTL;
    public ThuVienFragment() {// Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thu_vien, container, false);
        cvTL =(CardView)view.findViewById(R.id.cvTheLoai);
        cvTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TheLoaiFragment());
            }
        });
        viewFlipper = (ViewFlipper) view.findViewById(R.id.vflipper);

        RecyclerView recyclerViewNew = (RecyclerView)view.findViewById(R.id.rvTrCapNhap);
        recyclerViewNew.setHasFixedSize(true);
        LinearLayoutManager ln = new LinearLayoutManager(getActivity());
        ln.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewNew.setLayoutManager(ln);
        list = new ArrayList<Truyen>();
        adapter = new AdapterTruyen(list,getContext());
        getData();
        recyclerViewNew.setAdapter(adapter);
        recyclerViewNew.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
    public void getData()
    {
        database = Database.initDatabase(getActivity(),DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Truyen",null);
        list.clear();
        for(int i = 0; i < cursor.getCount();i++)
        {
            cursor.moveToPosition(i);
            int idTruyen = cursor.getInt(0);
            String ten = cursor.getString(1);
            int idTrangThai = cursor.getInt(2);
            int idLoaiTruyen = cursor.getInt(3);
            byte[] anh = cursor.getBlob(4);
            list.add(new Truyen(idTruyen,ten,idTrangThai,idLoaiTruyen,anh));
        }
        adapter.notifyDataSetChanged();
    }
    void loadFragment(Fragment fr)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fr);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
