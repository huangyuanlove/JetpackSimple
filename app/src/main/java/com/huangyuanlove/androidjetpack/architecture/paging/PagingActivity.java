package com.huangyuanlove.androidjetpack.architecture.paging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.huangyuanlove.androidjetpack.R;
import com.huangyuanlove.androidjetpack.architecture.room.AppDatabase;
import com.huangyuanlove.androidjetpack.architecture.room.User;
import com.huangyuanlove.androidjetpack.architecture.room.UserDao;

import java.util.List;

public class PagingActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        recyclerView = findViewById(R.id.recycler_view);

        DiffUtil.ItemCallback<User> itemCallback = new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.toString().equals(newItem.toString());
            }

            @Override
            public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.id ==  newItem.id;
            }
        };


        final PagingAdapter adapter = new PagingAdapter(itemCallback);

        UserDao dao = AppDatabase.get(this).userDao();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        dao.getAllUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.d("observe","【数据发生改变】" + users.size());
            }
        });

        PagingViewModel viewModel = ViewModelProviders.of(this).get(PagingViewModel.class);

        viewModel.getRefreshLiveData().observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                Log.d("viewModel observe","【数据发生改变】" + users.size());

                adapter.submitList(users);
            }
        });



    }
}
