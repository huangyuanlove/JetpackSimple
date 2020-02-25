package com.huangyuanlove.androidjetpack.architecture.navigation;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.huangyuanlove.androidjetpack.R;

public class FragmentA extends Fragment {

    public FragmentA() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =
                inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentBArgs.Builder builder= new  FragmentBArgs.Builder();
                builder.setNum(11111);
                builder.setTitle("FragmentB");
                Navigation.findNavController(v).navigate(R.id.action_fragmentA_to_fragmentB,builder.build().toBundle());
            }
        });

        return view;
    }

}
