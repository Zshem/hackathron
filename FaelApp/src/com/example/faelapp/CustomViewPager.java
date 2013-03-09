package com.example.faelapp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomViewPager extends ViewPager {

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof CustomViewPager) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		
		requestDisallowInterceptTouchEvent(true);
		// TODO Auto-generated method stub
		return super.onTouchEvent(arg0);
	}
    
    
}
