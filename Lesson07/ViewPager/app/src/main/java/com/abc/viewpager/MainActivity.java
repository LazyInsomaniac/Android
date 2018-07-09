package com.abc.viewpager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Blue";
                case 1:
                    return "Green";
                case 2:
                    return "Red";
                default:

            }

            @Override
            public Fragment getItem ( int i){
                switch (i) {
                    case 0:
                        return new FragmentBlue();
                    case 1:
                        return new FragmentGreen();
                    case 2:
                        return new FragmentRed();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() ;
            {
                return 3;
            }
        }
    }
}
