package com.toong.recyclerlineardemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.toong.recyclerlineardemo.R;
import com.toong.recyclerlineardemo.model.Item;

public class OneItemTypeAdapter extends RecyclerView.Adapter<OneItemTypeAdapter.ViewHolder> {
    private static final String TAG = "OneItemTypeAdapter";
    private Item[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mItemClickListener;

    public OneItemTypeAdapter(Context context, Item[] data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mData[position];
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemClickListener mItemClickListener;
        private Item mItem = null;
        private TextView myTextView;

        private ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            mItemClickListener = itemClickListener;
            itemView.setOnClickListener(this);
        }

        void bindItem(Item item) {
            Log.i(TAG, "old item name " + (mItem == null ? "null" : mItem.getTitle()));
            Log.i(TAG, "new item name " + item.getTitle());
            Log.i(TAG, "---");
            mItem = item;
            myTextView.setText(item.getTitle());
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public Item getItem(int id) {
        return mData[id];
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}