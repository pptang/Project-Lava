package com.money.lava.deal.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.money.lava.deal.R;
import com.money.lava.deal.logger.Dump;
import com.money.lava.deal.view.BorrowFragment;
import com.money.lava.deal.view.LendFragment;

public class MainTabAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String[] tabTitles = {"Lend Money", "Borrow Money"};
    private Context context;

    public MainTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position) {
            case 0:
                fragment = new LendFragment();
                break;
            case 1:
                fragment = new BorrowFragment();
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
