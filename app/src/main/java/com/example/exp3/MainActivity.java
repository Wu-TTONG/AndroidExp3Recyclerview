package com.example.exp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.exp3.adapters.ListViewAdapter;
import com.example.exp3.beans.Data;
import com.example.exp3.beans.ItemBean;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private List<ItemBean> mData;
    private RecyclerView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        viewById = this.findViewById(R.id.recycler_view);
        RecyclerView list = viewById;
        //准备数据
        initData();
    }
    private void initData(){
        mData = new ArrayList<>();
        //模拟数据
        for (int i = 0; i < Data.picture.length; i++){
            ItemBean data = new ItemBean();
            data.icon = Data.picture[i];
            data.title = Data.title[i];
            data.price = Data.price[i];
            mData.add(data);
        }
        //设置样式
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        viewById.setLayoutManager(layoutManager);
        //创建适配器
        ListViewAdapter adapter = new ListViewAdapter(mData);
        //设置到RecycleView里面
        viewById.setAdapter(adapter);
    }
}