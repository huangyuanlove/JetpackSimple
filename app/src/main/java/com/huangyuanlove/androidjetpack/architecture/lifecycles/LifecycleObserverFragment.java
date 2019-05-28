package com.huangyuanlove.androidjetpack.architecture.lifecycles;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huangyuanlove.androidjetpack.R;

public class LifecycleObserverFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getLifecycle().addObserver(new MyLifecycleObserver("Fragment"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lifecycle,container,false);
        view.findViewById(R.id.without_lifecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getActivity(),WithoutLifeCycleActivity.class));
            }
        });

        return view;
    }
}
