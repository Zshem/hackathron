package com.example.faelapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TabHost;

import com.example.faelapp.adapters.SwipeCollectionPagerAdapter;
import com.example.faelapp.adapters.TabsAdapter;
import com.example.faelapp.fragments.BaseFragment;
import com.example.faelapp.fragments.CouponsFragment;
import com.example.faelapp.fragments.CreditCardFragment;
import com.example.faelapp.fragments.PayFragment;

public class MainActivity extends FragmentActivity {

	TabHost mTabHost;
	ViewPager mViewPager;
	TabsAdapter mTabsAdapter;
	SwipeCollectionPagerAdapter mSwipeCollectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        setContentView(R.layout.fragment_tabs_pager);

		mViewPager = (ViewPager) findViewById(R.id.pager);

		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		mTabsAdapter = new TabsAdapter(this, mViewPager);

		mTabsAdapter.addTab(bar.newTab().setText("Cards"),
				CreditCardFragment.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Coupons"),
				CouponsFragment.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Transactions"),
				BaseFragment.class, null);
*/
        setContentView(R.layout.fragment_swipe_item);

        
        mSwipeCollectionPagerAdapter =
                new SwipeCollectionPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSwipeCollectionPagerAdapter);
        
//		mViewPager = (ViewPager) findViewById(R.id.pager);
//
//		ActionBar bar = getActionBar();
//		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//		mTabsAdapter = new TabsAdapter(this, mViewPager);
//
//		mTabsAdapter.addTab(bar.newTab().setText("Pay"),
//				PayFragment.class, null);
//		mTabsAdapter.addTab(bar.newTab().setText("Cards"),
//				CreditCardFragment.class, null);
//		mTabsAdapter.addTab(bar.newTab().setText("Coupons"),
//				BaseFragment.class, null);
//		mTabsAdapter.addTab(bar.newTab().setText("Transactions"),
//				BaseFragment.class, null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
