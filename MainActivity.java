package com.example.ayush.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.ayush.myapplication.Fragment.SampleFragmant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SampleFragmant());
        adapter.addFragment(new SampleFragmant());
        adapter.addFragment(new SampleFragmant());
        adapter.addFragment(new SampleFragmant());
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    private void setupTabIcons() {

        View tabOne = LayoutInflater.from(this).inflate(R.layout.custom_tab1, null);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        View tabTwo =  LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView textView = (TextView)tabTwo.findViewById(R.id.text);
        textView.setText("140");
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        View tabthree =  LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
         textView = (TextView)tabthree.findViewById(R.id.text);
        textView.setText("40");
        tabLayout.getTabAt(2).setCustomView(tabthree);

        View tabFour =  LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
         textView = (TextView)tabFour.findViewById(R.id.text);
        textView.setText("10");
        tabLayout.getTabAt(3).setCustomView(tabFour);
    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//        }
    }
}
