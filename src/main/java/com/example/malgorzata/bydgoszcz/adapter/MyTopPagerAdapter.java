package com.example.malgorzata.bydgoszcz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.malgorzata.bydgoszcz.fragment.BaseTopPagerFragment;
import com.viewpagerindicator.IconPagerAdapter;

public class MyTopPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

	private static int NUM_ITEMS = 3;

	public MyTopPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return BaseTopPagerFragment.newInstance(0);
			case 1:
				return BaseTopPagerFragment.newInstance(1);
			case 2:
				return BaseTopPagerFragment.newInstance(2);
			default:
				return null;
		}
	}

	@Override
	public int getIconResId(int index) {
		return 0;
	}

	@Override
	public int getCount() {
		return NUM_ITEMS;
	}
}