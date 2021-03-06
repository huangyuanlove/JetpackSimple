package com.huangyuanlove.androidjetpack.architecture.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.huangyuanlove.androidjetpack.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }


    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.fragment_first).navigateUp();
    }
}
