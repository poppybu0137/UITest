package com.example.poppybu.uitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    private Button rotateButton = null;
    private Button scaleButton = null;
    private Button alphaButton = null;
    private Button translateButton = null;
    private Button completeButton = null;
    private ImageView image = null;

    private Button jumpButton = null;
    private Button jump3Button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotateButton = (Button)findViewById(R.id.rotateButton);
        scaleButton = (Button)findViewById(R.id.scaleButton);
        alphaButton = (Button)findViewById(R.id.alphaButton);
        translateButton = (Button)findViewById(R.id.translateButton);
        completeButton = (Button)findViewById(R.id.completeButton);
        image = (ImageView)findViewById(R.id.image);

        jumpButton = (Button)findViewById(R.id.jumpButtom);
        jump3Button = (Button)findViewById(R.id.jump3Button);

        alphaButton.setOnClickListener(new AlphaButtonListener());
        rotateButton.setOnClickListener(new RotateButtonListener());
        scaleButton.setOnClickListener(new ScaleButtonListener());
        translateButton.setOnClickListener(new TranslateButtonListener());
        completeButton.setOnClickListener(new CompleteButtonListener());

        jumpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpIntent = new Intent(MainActivity.this, testXmlAnimation.class);
                startActivity(jumpIntent);
            }
        });
        jump3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jump3Intent = new Intent(MainActivity.this, mFrameAnimation.class);
                startActivity(jump3Intent);
            }
        });
    }

    class AlphaButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
            alphaAnimation.setDuration(5000);
            alphaAnimation.setFillAfter(true);
            animationSet.addAnimation(alphaAnimation);
            image.startAnimation(animationSet);
        }
    }

    class RotateButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AnimationSet animationSet = new AnimationSet(true);
            RotateAnimation rotateAnimation = new RotateAnimation(0,360,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setStartOffset(1000);
            rotateAnimation.setRepeatCount(4);
            animationSet.addAnimation(rotateAnimation);
            image.startAnimation(animationSet);
        }
    }

    class ScaleButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AnimationSet animationSet = new AnimationSet(true);
            ScaleAnimation scaleAnimation = new ScaleAnimation(
                    0,0.5f,0,0.5f,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0.5f
            );
            scaleAnimation.setDuration(1000);
            scaleAnimation.setFillAfter(true);
            //scaleAnimation.setFillBefore(true);
            animationSet.addAnimation(scaleAnimation);
            image.startAnimation(animationSet);
        }
    }

    class TranslateButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF,0f,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0f,
                    Animation.RELATIVE_TO_SELF,0.5f
            );
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);
            animationSet.addAnimation(translateAnimation);
            image.startAnimation(animationSet);
        }
    }

    class CompleteButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(
                    MainActivity.this,R.anim.doubleani);
            image.startAnimation(animation);
        }
    }

}
