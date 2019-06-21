package com.example.recyclelibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    Context mContext;
    List<T> mDatas;
    int layoutResourceId;
    LayoutInflater inflater;


    public CommonAdapter(Context context, List<T> dataList, int layoutResourceId) {
        this.mContext = context;
        this.mDatas = dataList;
        this.layoutResourceId = layoutResourceId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.get(mContext, parent, layoutResourceId);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        onBindView(holder, mDatas.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void onBindView(CommonViewHolder holder, T t);

    public void replaceData(List<T> datas) {
        if (datas == null) {
            throw new NullPointerException();
        }
        mDatas = datas;
        notifyDataSetChanged();
    }

    public void insertData(int position, T data) {
        mDatas.add(position, data);
        notifyItemInserted(position);
    }

    public void insertData(int position, List<T> data) {
        mDatas.addAll(position, data);
        notifyDataSetChanged();
    }

    public void insertToEnd(List<T> data) {
        mDatas.addAll(data);
        notifyDataSetChanged();
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public void changeData(int position, T data) {
        mDatas.set(position, data);
        notifyItemChanged(position);
    }

    public List<T> getDatas() {
        return mDatas;
    }
}
