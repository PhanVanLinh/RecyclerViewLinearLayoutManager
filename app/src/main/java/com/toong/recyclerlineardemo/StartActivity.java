package com.toong.recyclerlineardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void oneItemTypeList(View v){
        Intent intent = new Intent(StartActivity.this, OneItemTypeListActivity.class);
        startActivity(intent);
    }

    public void multipleItemTypeList(View v){
        Intent intent = new Intent(StartActivity.this, MultipleItemTypeListActivity.class);
        startActivity(intent);
    }

}
