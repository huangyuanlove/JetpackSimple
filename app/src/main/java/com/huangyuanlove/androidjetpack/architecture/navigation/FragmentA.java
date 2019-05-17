package com.huangyuanlove.androidjetpack.architecture.navigation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.androidjetpack.R;

/**
 * A simple {@link Fragment} subclass.
 *
 *
 * 在传参方面它可以通过gradle插件的方式为我们提供更可靠安全的数据传递。
 * 它能更简单的为fragment添加跳转动画
 * 它能让fragment实现共享元素动画
 * 它能通过Deep Link直接路由到fragment
 * 它能直接与androidx组件中的 NavigationView(对，就是侧滑抽屉用的那个)进行菜单联动
 * 它能和menu浮层菜单进行联动
 * 也能和toolbar进行联动
 *
 * 作者：逝水比喻时光
 * 链接：https://www.jianshu.com/p/a3fa469fbdfb
 * 来源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
