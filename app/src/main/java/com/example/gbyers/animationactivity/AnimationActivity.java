package com.example.gbyers.animationactivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    private ImageView lightsImageView;
    private AnimationDrawable frameAnim;
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View view) {
        //programmatically set Background of imageView to @drawable
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);
        //animate fram_anim
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        //start the animation
        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();



    }

    public void toggleRotateAnim(View view) {


        if(rotateAnim!=null && rotateAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }else
        {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        }
    }
    public void toggleShakeView(View view)
    {
        if(shakeAnim!= null && shakeAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }else
        {
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
            lightsImageView.startAnimation(shakeAnim);
        }
    }
}
