package com.huangyuanlove.androidjetpack.architecture.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;

import com.huangyuanlove.androidjetpack.R;
import com.huangyuanlove.androidjetpack.databinding.ActivityViewModelBinding;

import java.util.ArrayList;

public class ViewModelActivity extends AppCompatActivity {

    ActivityViewModelBinding binding;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_view_model);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getValueChanged().observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.setUser(userViewModel);
            }
        });


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.setSex(binding.sex.getText().toString());
                userViewModel.setName(binding.name.getText().toString());
                userViewModel.setAge(Integer.valueOf(binding.age.getText().toString()));
                userViewModel.getValueChanged().postValue(1);
            }
        });

        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.setAge(11);
                userViewModel.setName("aa");
                userViewModel.setSex("M");
                userViewModel.getValueChanged().postValue(1);
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
