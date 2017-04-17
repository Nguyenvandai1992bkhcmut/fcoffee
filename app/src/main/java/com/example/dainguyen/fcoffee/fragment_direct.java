package com.example.dainguyen.fcoffee;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by dainguyen on 4/4/17.
 */

public class fragment_direct extends Fragment {

    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_introduce,container,false);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int w = metrics.widthPixels/2;
        int h = metrics.heightPixels/2;
        ImageView imageView1 = (ImageView) v.findViewById(R.id.img1);

        ImageView imageView2 = (ImageView) v.findViewById(R.id.img2);

        ImageView imageView3 = (ImageView) v.findViewById(R.id.img3);

        ImageView imageView4 = (ImageView) v.findViewById(R.id.img4);

        ImageView imageView5 = (ImageView) v.findViewById(R.id.img5);
        int anpha = 180/4;
        imageView1.setX((float) (-w*0.8));
        imageView2.setX((float) (w*0.8));
        imageView3.setY((float) (-h*0.4*0.8));
        imageView4.setX((float) -(w*0.8*Math.cos(anpha*3.14/180)));
        imageView4.setY((float) -(h*0.4*0.8*Math.sin(anpha*3.14/180)));
        imageView5.setX((float) (w*0.8*Math.cos(anpha*3.14/180)));
        imageView5.setY((float) -(h*0.4*0.8*Math.sin(anpha*3.14/180)));

        AnimationSet animationSet1 = new AnimationSet(true);
        animationSet1.setDuration(200);
        animationSet1.setFillAfter(true);
        animationSet1.setStartOffset(400);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1);
        Animation animation1 = new AlphaAnimation(0,1);
        animationSet1.addAnimation(animation1);
        animationSet1.addAnimation(scaleAnimation);

        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.setDuration(200);
        animationSet2.setFillAfter(true);
        animationSet2.setStartOffset(200);
        Animation animation2 = new AlphaAnimation(0,1);
        animationSet2.addAnimation(animation2);
        ScaleAnimation scaleAnimation1 = new ScaleAnimation(0,1,0,1);
        animationSet2.addAnimation(scaleAnimation1);


        AnimationSet animationSet3 = new AnimationSet(true);
        animationSet3.setDuration(200);
        animationSet3.setFillAfter(true);
        animationSet3.setStartOffset(400);
        Animation animation3 = new AlphaAnimation(0,1);
        animationSet3.addAnimation(animation2);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0,1,0,1);
        animationSet3.addAnimation(scaleAnimation2);

        AnimationSet animationSet4 = new AnimationSet(true);
        animationSet4.setDuration(200);
        animationSet4.setFillAfter(true);
        animationSet4.setStartOffset(600);
        Animation animation4 = new AlphaAnimation(0,1);
        animationSet4.addAnimation(animation2);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(0,1,0,1);
        animationSet4.addAnimation(scaleAnimation3);


        AnimationSet animationSet5 = new AnimationSet(true);
        animationSet5.setDuration(200);
        animationSet5.setFillAfter(true);
        animationSet5.setStartOffset(800);
        Animation animation5 = new AlphaAnimation(0,1);
        animation5.setFillAfter(true);
        animationSet5.addAnimation(animation2);
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(0,1,0,1);
        scaleAnimation4.setFillAfter(true);

        animationSet5.addAnimation(scaleAnimation4);

        imageView1.startAnimation(animationSet1);
        imageView4.startAnimation(animationSet2);
        imageView3.startAnimation(animationSet3);
        imageView5.startAnimation(animationSet4);
        imageView2.startAnimation(animationSet5);


//
//        Animation animation = new TranslateAnimation(0,(float) (-w*0.8),0,0);
//        animation.setDuration(500);
//        animation.setFillAfter(true);
//        animation.setInterpolator(new OvershootInterpolator());
//        imageView1.startAnimation(animation);
//
//        Animation animation1 = new TranslateAnimation(0,(float) (w*0.8),0,0);
//        animation1.setDuration(500);
//        animation1.setFillAfter(true);
//        animation1.setInterpolator(new OvershootInterpolator());
//        imageView2.startAnimation(animation1);
//
//        Animation animation2 = new TranslateAnimation(0,0,0,(float) (-h*0.4*0.8));
//        animation2.setDuration(500);
//        animation2.setFillAfter(true);
//        animation2.setInterpolator(new OvershootInterpolator());
//        imageView3.startAnimation(animation2);
//
//        Animation animation3 = new TranslateAnimation(0, (float) -(w*0.8*Math.cos(anpha*3.14/180)),0,(float) -(h*0.4*0.8*Math.sin(anpha*3.14/180)));
//        animation3.setDuration(500);
//        animation3.setFillAfter(true);
//        animation3.setInterpolator(new OvershootInterpolator());
//        imageView4.startAnimation(animation3);
//
//        Animation animation4 = new TranslateAnimation(0, (float) (w*0.8*Math.cos(anpha*3.14/180)),0,(float) -(h*0.4*0.8*Math.sin(anpha*3.14/180)));
//        animation4.setDuration(500);
//        animation4.setFillAfter(true);
//        animation4.setInterpolator(new OvershootInterpolator());
//        imageView5.startAnimation(animation4);

        return v;
    }
}
