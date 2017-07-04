package com.toong.recyclerlineardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.toong.recyclerlineardemo.adapter.MyAdapter;
import com.toong.recyclerlineardemo.adapter.MyRecyclerViewAdapter;
import com.toong.recyclerlineardemo.model.Item;
import java.util.ArrayList;

public class MultipleItemTypeListActivity extends AppCompatActivity implements MyAdapter.ItemClickListener{
    private RecyclerView mRecyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_type_list);

        getSupportActionBar().setTitle("Multiple Item Type Recycler List");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Item> data = new ArrayList<>();
        data.add(new Item("a", "b"));
        data.add(new Item("c", "b"));
        data.add(new Item("d", "b"));
        data.add(new Item("e", "b"));
        data.add(new Item("f", "b"));
        data.add(new Item("g", "b"));
        data.add(new Item("h", "b"));
        data.add(new Item("j", "b"));
        data.add(new Item("k", "b"));
        data.add(new Item("l", "b"));
        data.add(new Item("m", "b"));

        // set up the RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, data.toArray(new Item[data.size()]));
        adapter.setClickListener(this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
