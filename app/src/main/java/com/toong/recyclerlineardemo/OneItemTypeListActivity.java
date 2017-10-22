package com.toong.recyclerlineardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.toong.recyclerlineardemo.adapter.OneItemTypeAdapter;
import com.toong.recyclerlineardemo.model.Item;
import java.util.ArrayList;

public class OneItemTypeListActivity extends AppCompatActivity implements OneItemTypeAdapter.ItemClickListener {
    private RecyclerView mRecyclerView;
    private OneItemTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("One Item Type Recycler List");

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
        data.add(new Item("n", "b"));
        data.add(new Item("o", "b"));
        data.add(new Item("u", "b"));
        data.add(new Item("p", "b"));
        data.add(new Item("q", "b"));
        data.add(new Item("r", "b"));
        data.add(new Item("s", "b"));
        data.add(new Item("w", "b"));
        data.add(new Item("y", "b"));

        // set up the RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OneItemTypeAdapter(this, data.toArray(new Item[data.size()]));
        adapter.setItemClickListener(this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}