package com.example.medphox.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.medphox.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SliderImageAdapter extends PagerAdapter {
    private Context mcontext;
    private List<ImgSlide> mList;

    public SliderImageAdapter(Context mcontext, List<ImgSlide> mList) {
        this.mcontext = mcontext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {


        LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout=inflater.inflate(R.layout.image_slider_item,null);
        ImageView slideImg=slideLayout.findViewById(R.id.imageView);
        TextView textView=slideLayout.findViewById(R.id.textView2);
        slideImg.setImageResource(mList.get(position).getImage());
        textView.setText(mList.get(position).getImgtitle());
        container.addView(slideLayout);

        return slideLayout ;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
