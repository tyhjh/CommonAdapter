package com.example.recyclelibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author dhht
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;


    public CommonViewHolder(View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }


    public static CommonViewHolder get(Context context, ViewGroup parent, int layoutId) {
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new CommonViewHolder(view);
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


    public void setText(int viewId, String text) {
        ((TextView) getView(viewId)).setText(text);
    }


    public void setOnClick(int viewId, View.OnClickListener listener) {
        getView(viewId).setOnClickListener(listener);
    }


    public View getConvertView() {
        return mConvertView;
    }

}
