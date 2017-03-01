package com.example.azadljy.myapplication.adapter;


import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.azadljy.myapplication.databinding.LogitemBinding;
import com.example.azadljy.myapplication.model.LogModel;

import java.util.List;

/**
 * 作者：Ljy on 2017/3/1.
 * 邮箱：enjoy_azad@sina.com
 */

public abstract class LogAdapter extends RecyclerView.Adapter<LogViewHolder> {
    //    private List<LogModel> logModels;
//
//    public LogAdapter(Context context, List<LogModel> logModels) {
//        this.logModels = logModels;
//    }
    @Override
    public LogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LogitemBinding logitemBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new LogViewHolder(logitemBinding);
    }

    @Override
    public void onBindViewHolder(LogViewHolder holder, int position) {
        LogModel logModel = getModel(position);
        holder.bind(logModel);
    }

    @Override
    public int getItemViewType(int position) {
        return setItemViewType(position) ;
    }

    public abstract LogModel getModel(int position);

    public abstract int setItemViewType(int position);


}
