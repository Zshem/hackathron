package com.example.faelapp.adapters;

import com.example.faelapp.R;
import com.viewpagerindicator.IconPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
  
public class CouponsPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter{  
	
	 private int[] Images = new int[] {R.drawable.spar_10,R.drawable.billa_10,R.drawable.billa_20};

	    protected static final int[] ICONS = new int[] { R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher };

	    private int mCount = Images.length;

	    public CouponsPagerAdapter(FragmentManager fm) {
	        super(fm);
	    }

	    @Override
	    public Fragment getItem(int position) {
	        return new PlaceSlideFragment(Images[position]);
	    }

	    @Override
	    public int getCount() {
	        return mCount;
	    }

	    @Override
	    public int getIconResId(int index) {
	        return ICONS[index % ICONS.length];
	    }

	    public void setCount(int count) {
	        if (count > 0 && count <= 10) {
	            mCount = count;
	            notifyDataSetChanged();
	        }
	    }  
}