package com.example.recyclelibrary;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

public abstract class MultiItemCommonAdpter<T> extends CommonAdapter<T> {

    MultiItemTypeSupport mMultiItemTypeSupport;

    public MultiItemCommonAdpter(Context context, List<T> dataList, MultiItemTypeSupport multiItemTypeSupport) {
        super(context, dataList, -1);
        this.mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {
        return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        CommonViewHolder holder = CommonViewHolder.get(mContext, parent, layoutId);
        return holder;
    }
}
