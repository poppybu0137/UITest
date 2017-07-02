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

public class testXmlAnimation extends AppCompatActivity {

    private Button rotateButton = null;
    private Button scaleButton = null;
    private Button alphaButton = null;
    private Button translateButton = null;
    private ImageView image = null;

    private Button jump2button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_xml_animation);
        rotateButton = (Button)findViewById(R.id.mrotateButton);
        scaleButton = (Button)findViewById(R.id.mscaleButton);
        alphaButton = (Button)findViewById(R.id.malphaButton);
        translateButton = (Button)findViewById(R.id.mtranslateButton);
        image = (ImageView)findViewById(R.id.mimage);

        jump2button = (Button)findViewById(R.id.jump2Button);
        jump2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpIntent = new Intent(testXmlAnimation.this,MainActivity.class);
                startActivity(jumpIntent);
            }
        });

        alphaButton.setOnClickListener(new testXmlAnimation.AlphaButtonListener());
        rotateButton.setOnClickListener(new testXmlAnimation.RotateButtonListener());
        scaleButton.setOnClickListener(new testXmlAnimation.ScaleButtonListener());
        translateButton.setOnClickListener(new testXmlAnimation.TranslateButtonListener());

    }

    class AlphaButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(
                    testXmlAnimation.this,R.anim.alpha
            );
            image.startAnimation(animation);
        }
    }

    class RotateButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(
                    testXmlAnimation.this,R.anim.rotate
            );
            image.startAnimation(animation);
        }
    }

    class ScaleButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(
                    testXmlAnimation.this,R.anim.scale
            );
            image.startAnimation(animation);
        }
    }

    class TranslateButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(
                    testXmlAnimation.this,R.anim.translate
            );
            image.startAnimation(animation);

        }
    }

}
