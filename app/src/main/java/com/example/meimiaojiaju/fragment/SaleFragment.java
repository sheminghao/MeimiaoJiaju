package com.example.meimiaojiaju.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.meimiaojiaju.R;

/**
 * Created by smh on 2015/11/20.
 */
public class SaleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;

    //主页面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sale, null);
        init(view);
        return view;
    }

    private void init(View view) {
        listView = (ListView) view.findViewById(R.id.lv_sale);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
