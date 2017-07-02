package com.example.poppybu.uitest;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class mFrameAnimation extends AppCompatActivity {

    private Button button = null;
    private ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_frame_animation);
        button = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.secondImage);
        button.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            imageView.setBackgroundResource(R.drawable.frame);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            animationDrawable.start();
        }
    }
}
