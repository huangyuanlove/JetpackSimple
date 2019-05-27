package com.huangyuanlove.androidjetpack.architecture.paging;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.huangyuanlove.androidjetpack.architecture.room.AppDatabase;
import com.huangyuanlove.androidjetpack.architecture.room.User;

import java.util.concurrent.Executors;

public class PagingViewModel extends AndroidViewModel {
    public PagingViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<PagedList<User>> getRefreshLiveData() {
        DataSource.Factory<Integer, User> dataSourceFactory = AppDatabase.get(getApplication()).userDao().getAllUserDataSource();

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setMaxSize(Integer.MAX_VALUE)
                .setPrefetchDistance(2)
                .setEnablePlaceholders(true)
                .build();
        LivePagedListBuilder<Integer, User> livePagedListBuilder = new LivePagedListBuilder<>(dataSourceFactory, config)
.setFetchExecutor(Executors.newSingleThreadExecutor())
                .setInitialLoadKey(0)
                .setBoundaryCallback(new PagedList.BoundaryCallback<User>() {
                    @Override
                    public void onZeroItemsLoaded() {
                        super.onZeroItemsLoaded();
                        Log.d("getRefreshLiveData","没有数据被加载");
                    }

                    @Override
                    public void onItemAtFrontLoaded(@NonNull User itemAtFront) {
                        super.onItemAtFrontLoaded(itemAtFront);
                        Log.d("getRefreshLiveData","加载第一个-->" + itemAtFront.toString());

                    }

                    @Override
                    public void onItemAtEndLoaded(@NonNull User itemAtEnd) {
                        super.onItemAtEndLoaded(itemAtEnd);
                        Log.d("getRefreshLiveData","加载最后一个-->" + itemAtEnd.toString());
                    }
                });
        return livePagedListBuilder.build();

    }

}
