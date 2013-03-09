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
    
    public static final String TAG = "detailsFragment";
    
	CouponsPagerAdapter mAdapter;
    CustomViewPager mPager;
    PageIndicator mIndicator;
	
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

        mAdapter = new CouponsPagerAdapter(getActivity()
                .getSupportFragmentManager());

        mPager = (CustomViewPager) linearLayout.findViewById(R.id.couponsAvailableViewPager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator) linearLayout.findViewById(R.id.couponsAvailableIndicator);
        mIndicator.setViewPager(mPager);
        ((CirclePageIndicator) mIndicator).setSnap(true);

        mIndicator
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
