package com.toong.recyclerlineardemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.toong.recyclerlineardemo.R;
import com.toong.recyclerlineardemo.model.Item;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Item[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public MyAdapter(Context context, Item[] data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    class ViewHolder0 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;

        public ViewHolder0(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;

        public ViewHolder2(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
                MyAdapter.ViewHolder0 viewHolder = new MyAdapter.ViewHolder0(view);
                return viewHolder;
            case 1:
                View view2 = mInflater.inflate(R.layout.recyclerview_item_2, parent, false);
                MyAdapter.ViewHolder2 viewHolder2 = new MyAdapter.ViewHolder2(view2);
                return viewHolder2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                viewHolder0.myTextView.setText(mData[position].getTitle());
                break;

            case 1:
                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                viewHolder2.myTextView.setText(mData[position].getMessage());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setClickListener(ItemClickListener clickListener) {
        mClickListener = clickListener;
    }
}