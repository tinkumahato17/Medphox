package com.example.medphox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.medphox.adapter.ImgSlide;
import com.example.medphox.adapter.SliderImageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ModalActivity extends AppCompatActivity {
    private ViewPager sliderpager;
    private TabLayout indicator;
    private Timer timer;
    private int current_position = 0;
    private List<ImgSlide> imgslide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal);

        imgslide = new ArrayList<>();
        imgslide.add(new ImgSlide(R.drawable.vec, "Free Home delvery"));
        imgslide.add(new ImgSlide(R.drawable.vec, "50% off on first order"));
        imgslide.add(new ImgSlide(R.drawable.vec, "helth is most important in your life"));
        imgslide.add(new ImgSlide(R.drawable.vec, "Medphox made with love"));
        imgslide.add(new ImgSlide(R.drawable.vec, "delvery all over India"));
        sliderpager = (ViewPager)findViewById(R.id.slider_pager);
        indicator = (TabLayout)findViewById(R.id.indicator);
        SliderImageAdapter adapter = new SliderImageAdapter(getApplicationContext(), imgslide);
        sliderpager.setAdapter(adapter);
        indicator.setupWithViewPager(sliderpager, true);
        createSlideShow();

        getWindow ().setFlags (
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );getSupportActionBar ().hide ();






    }

    private void createSlideShow()


        {
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (current_position == imgslide.size())
                        current_position = 0;
                    sliderpager.setCurrentItem(current_position++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, 250, 2500);


    }
}