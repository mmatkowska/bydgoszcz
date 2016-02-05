package com.example.malgorzata.bydgoszcz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.malgorzata.bydgoszcz.fragment.BaseCenterPagerFragment;

public class MyCenterPagerAdapter extends FragmentPagerAdapter {

	private static int NUM_ITEMS = 4;

	public MyCenterPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return BaseCenterPagerFragment.newInstance(0);
			case 1:
				return BaseCenterPagerFragment.newInstance(1);
			case 2:
				return BaseCenterPagerFragment.newInstance(2);
			case 3:
				return BaseCenterPagerFragment.newInstance(3);
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return NUM_ITEMS;
	}
}