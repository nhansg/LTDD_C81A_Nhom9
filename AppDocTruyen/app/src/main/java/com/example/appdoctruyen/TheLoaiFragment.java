package com.example.appdoctruyen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appdoctruyen.adapter.ViewPaperAdapter;
import com.google.android.material.tabs.TabLayout;

public class TheLoaiFragment extends Fragment {

    public TheLoaiFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPaperAdapter vadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_the_loai, container, false);
        tabLayout = (TabLayout)v.findViewById(R.id.tabsTheLoai);
        viewPager = (ViewPager) v.findViewById(R.id.vpTheLoai);
        vadapter = new ViewPaperAdapter(getFragmentManager());
        vadapter.addFragment(new TL1Fragment(),"Tiên Hiệp");
        vadapter.addFragment(new TL2Fragment(),"Võ Hiệp");
        viewPager.setAdapter(vadapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }
}
