package com.example.ayush.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.appyvet.rangebar.RangeBar;
import com.example.ayush.myapplication.Fragment.Frag_Preferences;
import com.example.ayush.myapplication.Fragment.SampleFragmant;

import java.util.ArrayList;
import java.util.List;

public class SeekBar_Radio extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar__radio);

        viewPager    = (ViewPager) findViewById(R.id.viewPager);
        tabLayout    = (TabLayout) findViewById(R.id.tabs);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Frag_Preferences(), "Preferences");
        adapter.addFragment(new Frag_Preferences(), "Artists");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mTitletList = new ArrayList<>();

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

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mTitletList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitletList.get(position);
        }
    }
}
