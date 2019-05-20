package com.huangyuanlove.androidjetpack.architecture.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.androidjetpack.R;
import com.huangyuanlove.androidjetpack.architecture.navigation.FragmentA;
import com.huangyuanlove.androidjetpack.architecture.navigation.FragmentB;
import com.huangyuanlove.androidjetpack.databinding.ActivityViewModelBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewModelActivity extends AppCompatActivity {

    ActivityViewModelBinding binding;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_view_model);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.setSex(binding.sex.getText().toString());
                userViewModel.setName(binding.name.getText().toString());
                userViewModel.setAge(Integer.valueOf(binding.age.getText().toString()));
            }
        });

        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.setAge(11);
                userViewModel.setName("aa");
                userViewModel.setSex("M");
                binding.setUser(userViewModel);
            }
        });
        binding.setUser(userViewModel);

        ArrayList<Fragment> pages = new ArrayList<>();
        pages.add(new ViewModelFragmentA());
        pages.add(new ViewModelFragmentB());
        PagerAdapter adapter=new ViewAdapter(getSupportFragmentManager(), pages);
       binding.viewPager.setAdapter(adapter);

    }

    class ViewAdapter extends FragmentPagerAdapter {



        private ArrayList<Fragment> list;
        public ViewAdapter(FragmentManager fm,ArrayList<Fragment> list) {
            super(fm);
            this.list=list;
        }

        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }

        @Override
        public int getCount() {
            return list.size();
        }



    }
}
