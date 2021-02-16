package com.b_s_j.inlove01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Tab1PagerAdapter extends FragmentPagerAdapter {

    Fragment[] pages = new Fragment[3];
    String[] titles = new String[]{"Map", "Weather","Movie"};
    public Tab1PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        pages[0] = new Tab1_MapFragment();
        pages[1] = new Tab1_WeatherFragment();
        pages[2] = new Tab1_MovieFragment();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pages[position];
    }

    @Override
    public int getCount() {return  pages.length; }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
