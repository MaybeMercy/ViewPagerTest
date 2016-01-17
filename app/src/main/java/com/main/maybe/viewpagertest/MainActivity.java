package com.main.maybe.viewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String POSITION = "position";
    private ViewPager mPager;
    private FragmentPagerAdapter mAdapter;
    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList = new ArrayList<>();
        Fragment one = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, 0);
        one.setArguments(bundle);
        fragmentList.add(one);
        Fragment two = new WebViewFragment();
        bundle = new Bundle();
        bundle.putInt(POSITION, 1);
        two.setArguments(bundle);
        fragmentList.add(two);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> list;
        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public void onPageSelected(int position) {
            Log.d(LOG_TAG, "onPageSelected " + position);
            if (fragmentList.size() - position < 2) {
                Fragment fragment = new WebViewFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(POSITION, fragmentList.size());
                fragment.setArguments(bundle);
                fragmentList.add(fragment);
                mAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
    }
}
