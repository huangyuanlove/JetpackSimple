package com.huangyuanlove.androidjetpack.architecture.navigation;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.huangyuanlove.androidjetpack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment {


    public FragmentC() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }


}
