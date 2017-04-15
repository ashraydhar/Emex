package com.android.app.emex;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
        TextView textView = (TextView) findViewById(R.id.forgotPassword);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SplashActivity.this, ForgotActivity.class);
                startActivity(intent);
            }

        });

        handler = new Handler();
        callback = new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        };
        handler.postDelayed(callback, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(callback);
    }


    ImageView splash;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:

                findViewById(R.id.splash_logo).setX(240);
                findViewById(R.id.splash_logo).setY(220);

                ImageView imageview =(ImageView) findViewById(R.id.splash_background_2);
                imageview.setVisibility(View.VISIBLE);

                ImageView imageview2 =(ImageView) findViewById(R.id.splash_background);
                imageview2.setVisibility(View.INVISIBLE);

                ImageView imageview3 =(ImageView) findViewById(R.id.emailIcon);
                imageview3.setVisibility(View.VISIBLE);

                EditText imageview4 =(EditText) findViewById(R.id.editText);
                imageview4.setVisibility(View.VISIBLE);

                ImageView imageview5 =(ImageView) findViewById(R.id.passwordIcon);
                imageview5.setVisibility(View.VISIBLE);

                EditText imageview6 =(EditText) findViewById(R.id.editText2);
                imageview6.setVisibility(View.VISIBLE);

                Button imageview7 =(Button) findViewById(R.id.btn1);
                imageview7.setVisibility(View.VISIBLE);

                TextView imageview10 =(TextView) findViewById(R.id.forgotPassword);
                imageview10.setVisibility(View.VISIBLE);

                TextView imageview8 =(TextView) findViewById(R.id.last);
                imageview8.setVisibility(View.VISIBLE);

                TextView imageview9 =(TextView) findViewById(R.id.last2);
                imageview9.setVisibility(View.VISIBLE);
        }
        return true;
    }

    public void valid(View v) {
        int status = 0;
        EditText imageview4 =(EditText) findViewById(R.id.editText);
        EditText imageview6 =(EditText) findViewById(R.id.editText2);
        if(imageview4.getText().toString().equals("abc") && imageview6.getText().toString().equals("abc"))
        {
             status = 1;
        } else {
            status = 0;
        }
        if(status == 1) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "RE - Enter   Please !", Toast.LENGTH_LONG).show();
        }
    }



}
