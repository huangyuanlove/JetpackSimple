package com.huangyuanlove.androidjetpack.architecture.paging;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.huangyuanlove.androidjetpack.architecture.room.User;

public class PagingAdapter extends PagedListAdapter<User, PagingAdapter.ViewHolder> {


    protected PagingAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }


    @Override
    public void onCurrentListChanged(@Nullable PagedList<User> previousList, @Nullable PagedList<User> currentList) {
        super.onCurrentListChanged(previousList, currentList);
        Log.d("PagingAdapter", "onCurrentListChanged");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("PagingAdapter", "onCreateViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("PagingAdapter", "onBindViewHolder");

        User user = getItem(position);
        if(user!=null){
            holder.infoView.setText(user.toString());
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView infoView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            infoView = itemView.findViewById(android.R.id.text1);
        }
    }
}
