package com.example.appdoctruyen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.adapter.AdapterTruyen2;
import com.example.appdoctruyen.models.Truyen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TL1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TL1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TL1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TL1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TL1Fragment newInstance(String param1, String param2) {
        TL1Fragment fragment = new TL1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    final String DATABASE_NAME = "dbAppRead.db";
    SQLiteDatabase DB;
    ArrayList<Truyen> mTruyen;
    AdapterTruyen2 radapter;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_t_l1, container, false);
        DB = Database.initDatabase(getActivity(),DATABASE_NAME);
        recyclerView = (RecyclerView)v.findViewById(R.id.rvTL1);
        LinearLayoutManager ln = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(ln);
        mTruyen = new ArrayList<Truyen>();
        radapter =  new AdapterTruyen2(mTruyen,getActivity());
        getData();
        recyclerView.setAdapter(radapter);
        return v;
    }
    public void getData()
    {
        Cursor cursor = DB.rawQuery("SELECT a.idTruyen,a.tenTruyen,a.idTrangThai,a.idLoaiTruyen,a.anh " +
                        "FROM Truyen a, ChiTietTheLoai b " +
                        "WHERE idTheLoai = 1 AND a.idTruyen = b.idTruyen",null);
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
        radapter.notifyDataSetChanged();
    }
}
