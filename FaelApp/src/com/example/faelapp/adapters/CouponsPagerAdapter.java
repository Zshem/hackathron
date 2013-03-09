package com.example.faelapp.adapters;

import com.viewpagerindicator.IconPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CouponsPagerAdapter extends FragmentStatePagerAdapter implements
		IconPagerAdapter {

	private int[] mImages;

	public CouponsPagerAdapter(FragmentManager fm, int[] images) {
		super(fm);
		mImages = images;
	}

	@Override
	public Fragment getItem(int position) {
		return new PlaceSlideFragment(mImages[position]);
	}

	@Override
	public int getCount() {
		return mImages.length;
	}

	@Override
	public int getIconResId(int index) {
		return 0;
	}

}