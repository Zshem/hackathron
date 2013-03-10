package com.example.faelapp.fragments;

import java.util.ArrayList;

import com.example.faelapp.CustomViewPager;
import com.example.faelapp.DepthPageTransformer;
import com.example.faelapp.R;
import com.example.faelapp.adapters.CouponsPagerAdapter;
import com.example.faelapp.model.Coupon;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class CouponsFragment extends Fragment {
	
	private String[] mSpinnerItems = {"All", "Billa", "Metro"};
	
	private ArrayList<Coupon> couponsAvailableAll = new ArrayList<Coupon>();
	private ArrayList<Coupon> couponsAvailable = new ArrayList<Coupon>();
	private ArrayList<Coupon> couponsOwned = new ArrayList<Coupon>();
    
	CouponsPagerAdapter mAdapterAvailable;
	CouponsPagerAdapter mAdapterOwned;
    CustomViewPager mPagerAvailable;
    CustomViewPager mPagerOwned;
    PageIndicator mIndicatorAvailable;
    PageIndicator mIndicatorOwned;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Coupon coupon = new Coupon("Billa", "10%", 1, R.drawable.logo_billa, Coupon.CouponType.AVAILABLE);
		couponsAvailableAll.add(coupon);
		coupon = new Coupon("Metro", "10%", 1, R.drawable.logo_metro, Coupon.CouponType.AVAILABLE);
		couponsAvailableAll.add(coupon);
		
		coupon = new Coupon("Billa", "10%", 1, R.drawable.logo_billa, Coupon.CouponType.OWNED);
		couponsOwned.add(coupon);
		coupon = new Coupon("Metro", "10%", 1, R.drawable.logo_metro, Coupon.CouponType.OWNED);
		couponsOwned.add(coupon);
		
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.coupon_layout, null);
		
		//Available cards viewpager
		mAdapterAvailable = new CouponsPagerAdapter(getActivity()
                .getSupportFragmentManager(),
                couponsAvailable);

		mPagerAvailable = (CustomViewPager) linearLayout.findViewById(R.id.couponsAvailableViewPager);
		mPagerAvailable.setPageTransformer(true, new DepthPageTransformer());
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
		
		Spinner spinner = (Spinner) linearLayout.findViewById(R.id.couponsSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, mSpinnerItems);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				couponsAvailable.clear();
				if(mSpinnerItems[position].equals("All")) 
				{
					for (int i = 0; i < couponsAvailableAll.size(); i++) {
						
							couponsAvailable.add(couponsAvailableAll.get(i));
					}
					
					
				}
				else
				{
				
				
					for (int i = 0; i < couponsAvailableAll.size(); i++) {
						if(mSpinnerItems[position].equals(couponsAvailableAll.get(i).getStore()))
						{
							couponsAvailable.add(couponsAvailableAll.get(i));
						}
					}
					
				}
				
				mAdapterAvailable.notifyDataSetChanged();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
        
        //Owned cards viewpager
        mAdapterOwned = new CouponsPagerAdapter(getActivity()
                .getSupportFragmentManager(),
                couponsOwned);

        mPagerOwned = (CustomViewPager) linearLayout.findViewById(R.id.couponsOwnedViewPager);
        mPagerOwned.setPageTransformer(true, new DepthPageTransformer());
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
