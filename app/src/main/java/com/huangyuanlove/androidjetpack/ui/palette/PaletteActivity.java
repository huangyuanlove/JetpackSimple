package com.huangyuanlove.androidjetpack.ui.palette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.huangyuanlove.androidjetpack.R;

import java.util.ArrayList;
import java.util.List;

public class PaletteActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TabFragment tab1;
    private TabFragment tab2;
    private TabFragment tab3;
    private TabFragment tab4;

    private Toolbar toolbar;
    private List<TabFragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        tabLayout =  findViewById(R.id.tabLayout);
        viewPager =  findViewById(R.id.viewPager);
        toolbar = findViewById(R.id.toolbar);
        initActionBar();
        initFragments();
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        addPageChangeListener();

    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
    }


    private void initFragments() {
        tab1 = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TAB", 1);
        tab1.setArguments(bundle);

        tab2 = new TabFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("TAB", 2);
        tab2.setArguments(bundle2);

        tab3 = new TabFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("TAB", 3);
        tab3.setArguments(bundle3);


        tab4 = new TabFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("TAB", 4);
        tab4.setArguments(bundle4);

        fragments.add(tab1);
        fragments.add(tab2);
        fragments.add(tab3);
        fragments.add(tab4);
    }

    private boolean isInit = false;

    private void addPageChangeListener() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 这个方法在setAdapter之后会调用一次，在这里初始化第一个界面，而且只调用一次
                if (!isInit) {
                    isInit = true;
                    setPaletteColor(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                setPaletteColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setPaletteColor(final int position) {
        Bitmap bitmap = null;
        if (position == 0) {
            bitmap = tab1.getBitmap();
        } else if (position == 1) {
            bitmap = tab2.getBitmap();
        } else if (position == 2) {
            bitmap = tab3.getBitmap();
        } else if (position == 3) {
            bitmap = tab4.getBitmap();
        }
        if (bitmap == null) {
            return;
        }
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                if (vibrant == null) {
                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        vibrant = swatch;
                        break;
                    }
                }
                //谷歌推荐的：图片的整体的颜色rgb的混合值---主色调
                int rbg = vibrant.getRgb();


                TextView[] textViews = fragments.get(position).getTextViews();
                if(textViews!=null){
                    //暗、柔和的颜色
                    int darkMutedColor = palette.getDarkMutedColor(Color.RED);//如果分析不出来，则返回默认颜色
                    textViews[0].setBackgroundColor(darkMutedColor);
                    textViews[0].setText("darkMutedColor");

                    //亮、柔和
                    int lightMutedColor = palette.getLightMutedColor(Color.RED);
                    textViews[1].setBackgroundColor(lightMutedColor);
                    textViews[1].setText("lightMutedColor");

                    //暗、鲜艳
                    int darkVibrantColor = palette.getDarkVibrantColor(Color.RED);
                    textViews[2].setBackgroundColor(darkVibrantColor);
                    textViews[2].setText("darkVibrantColor");

                    //亮、鲜艳
                    int lightVibrantColor = palette.getLightVibrantColor(Color.RED);
                    textViews[3].setBackgroundColor(lightVibrantColor);
                    textViews[3].setText("lightVibrantColor");


                    //柔和
                    int mutedColor = palette.getMutedColor(Color.RED);
                    textViews[4].setBackgroundColor(mutedColor);
                    textViews[4].setText("mutedColor");

                    //柔和
                    int vibrantColor = palette.getVibrantColor(Color.RED);
                    textViews[5].setBackgroundColor(vibrantColor);
                    textViews[5].setText("vibrantColor");


                    //获取某种特性颜色的样品
                    Palette.Swatch lightVibrantSwatch = palette.getVibrantSwatch();


                    //谷歌推荐：图片中间的文字颜色
                    int bodyTextColor = lightVibrantSwatch.getBodyTextColor();
                    textViews[6].setBackgroundColor(bodyTextColor);
                    textViews[6].setText("bodyTextColor");

                    //谷歌推荐：作为标题的颜色（有一定的和图片的对比度的颜色值）
                    int titleTextColor = lightVibrantSwatch.getTitleTextColor();
                    textViews[7].setBackgroundColor(titleTextColor);
                    textViews[7].setText("titleTextColor");
                }




                tabLayout.setBackgroundColor(rbg);
                toolbar.setBackgroundColor(rbg);
                if (Build.VERSION.SDK_INT > 21) {
                    Window window = getWindow();
                    //状态栏改变颜色。
                    int color = changeColor(rbg);
                    window.setStatusBarColor(color);
                }









            }
        });
    }

    private int changeColor(int rgb) {
        int red = rgb >> 16 & 0xFF;
        int green = rgb >> 8 & 0xFF;
        int blue = rgb & 0xFF;
        red = (int) Math.floor(red * (1 - 0.2));
        green = (int) Math.floor(green * (1 - 0.2));
        blue = (int) Math.floor(blue * (1 - 0.2));
        return Color.rgb(red, green, blue);
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "第" + (position + 1) + "页";
        }
    }

}
