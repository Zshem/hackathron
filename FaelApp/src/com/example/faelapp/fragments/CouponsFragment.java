package com.example.faelapp.fragments;

import com.example.faelapp.CustomViewPager;
import com.example.faelapp.R;
import com.example.faelapp.adapters.CouponsPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class CouponsFragment extends Fragment {
	
	private String[] mSpinnerItems = {"Konzum", "Billa"};
	
	private int[] cardsAvailable = new int[] { R.drawable.spar_10, R.drawable.billa_10,
			R.drawable.billa_20 };
    
    public static final String TAG = "detailsFragment";
    
	CouponsPagerAdapter mAdapterAvailable;
	CouponsPagerAdapter mAdapterOwned;
    CustomViewPager mPagerAvailable;
    CustomViewPager mPagerOwned;
    PageIndicator mIndicatorAvailable;
    PageIndicator mIndicatorOwned;
	
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);

	  }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.coupon_layout, null);
		
		Spinner spinner = (Spinner) linearLayout.findViewById(R.id.couponsSpinner);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, mSpinnerItems);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);
		
		//Available cards viewpager
		mAdapterAvailable = new CouponsPagerAdapter(getActivity()
                .getSupportFragmentManager(),
                cardsAvailable);

		mPagerAvailable = (CustomViewPager) linearLayout.findViewById(R.id.couponsAvailableViewPager);
		mPagerAvailable.setAdapter(mAdapterAvailable);

		mIndicatorAvailable = (CirclePageIndicator) linearLayout.findViewById(R.id.couponsAvailableIndicator);
		mIndicatorAvailable.setViewPager(mPagerAvailable);
        ((CirclePageIndicator) mIndicatorAvailable).setSnap(true);

        mIndicatorAvailable
                .setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                    }

                    @Override
                    public void onPageScrolled(int position,
                            float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
        
        //Owned cards viewpager
        mAdapterOwned = new CouponsPagerAdapter(getActivity()
                .getSupportFragmentManager(),
                cardsAvailable);

        mPagerOwned = (CustomViewPager) linearLayout.findViewById(R.id.couponsOwnedViewPager);
        mPagerOwned.setAdapter(mAdapterOwned);

        mIndicatorOwned = (CirclePageIndicator) linearLayout.findViewById(R.id.couponsOwnedIndicator);
        mIndicatorOwned.setViewPager(mPagerOwned);
        ((CirclePageIndicator) mIndicatorOwned).setSnap(true);

        mIndicatorOwned
                .setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                    }

                    @Override
                    public void onPageScrolled(int position,
                            float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
        
        return linearLayout;
    }
}
