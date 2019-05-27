package com.huangyuanlove.androidjetpack.ui.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huangyuanlove.androidjetpack.R;


public class TabFragment extends Fragment {

    private Bitmap bitmap;
    private TextView textViews[] = new TextView[8];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int tab = getArguments().getInt("TAB");
        View view = inflater.inflate(R.layout.fragment, container, false);
        ImageView imageView =view.findViewById(R.id.ivImg);
        textViews[0] = view.findViewById(R.id.view_1);
        textViews[1] = view.findViewById(R.id.view_2);
        textViews[2] = view.findViewById(R.id.view_3);
        textViews[3] = view.findViewById(R.id.view_4);
        textViews[4] = view.findViewById(R.id.view_5);
        textViews[5] = view.findViewById(R.id.view_6);
        textViews[6] = view.findViewById(R.id.view_7);
        textViews[7] = view.findViewById(R.id.view_8);
        if (tab == 1) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.palette_blue);
        } else if (tab == 2) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.palette_gray);
        } else if (tab == 3) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.palette_green);
        } else if (tab == 4) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        }
        imageView.setImageBitmap(bitmap);
        return view;
    }


    public TextView[] getTextViews(){
        return textViews;
    }

    public void setContent(int rgb) {
    }

    public Bitmap getBitmap() {

        return bitmap;
    }
}
