package com.example.faelapp.adapters;

import com.example.faelapp.R;
import com.example.faelapp.model.Coupon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public final class PlaceSlideFragment extends Fragment {
    private Coupon mCoupon;
    
    public PlaceSlideFragment(){}
    
    public PlaceSlideFragment(Coupon coupon) {
    	mCoupon = coupon;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.coupon_cell, null);
    	
    	ImageView imageView = (ImageView) frameLayout.findViewById(R.id.coupon_image);
    	TextView textView = (TextView) frameLayout.findViewById(R.id.coupon_discount);

        imageView.setImageResource(mCoupon.getImageId());
        textView.setText("Magarac");
        
        //frameLayout.setOnTouchListener(new AvailableCouponsOnTouchListener(getActivity(), mCoupon));

        return frameLayout;
    }
    
    public class AvailableCouponsOnTouchListener implements OnTouchListener
    {
    	private Coupon mCoupon;
    	private Context mContext;
    	float oldX = 0, newX = 0, sens = 5;
    	
    	public AvailableCouponsOnTouchListener(Context context, Coupon coupon)
    	{
    		mCoupon = coupon;
    		mContext = context;
    	}

		@Override
		public boolean onTouch(View view, MotionEvent event) {
			
			switch (event.getAction()) {
	        case MotionEvent.ACTION_DOWN:
	            oldX = event.getX();
	            return true;

	        case MotionEvent.ACTION_UP:
	            newX = event.getX();
	            if (Math.abs(oldX - newX) < sens) {
	            	Toast.makeText(mContext, "11", Toast.LENGTH_LONG).show();
	                return true;
	            }
	            oldX = 0;
	            newX = 0;
	            break;
	        }
			
	        return false;
		
		}
    	
    }
}