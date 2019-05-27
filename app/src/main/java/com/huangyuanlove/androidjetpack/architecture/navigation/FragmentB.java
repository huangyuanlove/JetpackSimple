package com.huangyuanlove.androidjetpack.architecture.navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.huangyuanlove.androidjetpack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {


    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        FragmentBArgs args = FragmentBArgs.fromBundle(getArguments());
        TextView tv =  view.findViewById(R.id.fragment_b);
        tv.setText(args.getNum() +"\n" + args.getTitle());
        return view;
    }

}
