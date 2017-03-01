package com.example.azadljy.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azadljy.myapplication.databinding.LogitemBinding;
import com.example.azadljy.myapplication.model.LogModel;

/**
 * 作者：Ljy on 2017/3/1.
 * 邮箱：enjoy_azad@sina.com
 */

public class LogViewHolder extends RecyclerView.ViewHolder {

    private final LogitemBinding binding;

    public LogViewHolder(LogitemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * 绑定数据  并立即调用executePendingBindings（）方法，使RecyclerView
     * 可以在绑定viewholder后立即测量该view，防止数据错误而导致的binding等待，使得测量结果不准确。
     *
     * @param model
     */
    public void bind(LogModel model) {
        binding.setLog(model);
        binding.executePendingBindings();
    }


//    public LogViewHolder onCreatViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        LogitemBinding logitemBinding = LogitemBinding.inflate(layoutInflater, parent, false);
//        return new LogViewHolder(logitemBinding) {
//            @Override
//            protected LogModel getLogModelForPosition(int position) {
//                return null;
//            }
//        };
////        return  null;
//    }

    //    public void onBindViewHolder(LogViewHolder logViewHolder, int positoin) {
//        LogModel model = getLogModelForPosition(positoin);
//        logViewHolder.bind(model);
//    }
//    protected abstract LogModel getLogModelForPosition(int position);

}
