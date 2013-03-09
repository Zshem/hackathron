package com.example.faelapp.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint("ValidFragment")
public final class PlaceSlideFragment extends Fragment {
    int imageResourceId;
    
    public PlaceSlideFragment(int i) {
        imageResourceId = i;
    }
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        ImageView image = new ImageView(getActivity());
        image.setImageResource(imageResourceId);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT));
        layout.setBackgroundColor(Color.BLACK);

        layout.setGravity(Gravity.CENTER);
        layout.addView(image);

        return layout;
    }
}