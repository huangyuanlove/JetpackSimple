package com.huangyuanlove.androidjetpack.architecture.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.huangyuanlove.androidjetpack.R;


public class ViewModelFragmentB extends Fragment implements View.OnClickListener {
    private EditText name;
    private EditText age;
    private EditText sex;

    private UserViewModel user;

    public ViewModelFragmentB() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_model_fragment_b, container, false);
        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        sex = view.findViewById(R.id.sex);

        view.findViewById(R.id.save).setOnClickListener(this);
        view.findViewById(R.id.reset).setOnClickListener(this);
        view.findViewById(R.id.show).setOnClickListener(this);
        show();
        return view;
    }


    private void show(){
        sex.setText(user.getSex());
        age.setText(String.valueOf(user.getAge()));
        name.setText(user.getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                user.setSex(sex.getText().toString());
                user.setName(name.getText().toString());
                user.setAge(Integer.valueOf(age.getText().toString()));
                break;
            case R.id.reset:
                user.setAge(11);
                user.setName("aa");
                user.setSex("M");
                break;
            case R.id.show:
                show();
                break;
        }

    }
}
