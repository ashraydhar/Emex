package com.android.app.emex;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * this activity causes splash screen and login , signup, forgot password . . .
 */
public class SplashActivity extends AppCompatActivity {
    static final int X = 240;
    static final int Y = 220;
    private String userName = "abc";
    private String password = "abc";
    private Handler handler;
    private Runnable callback;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
        TextView textView = (TextView) findViewById(R.id.forgotPassword);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

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
        final int forTime = 2000;
        handler.postDelayed(callback, forTime);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(callback);
    }


// ImageView splash;

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                findViewById(R.id.splash_logo).setX(X);
                findViewById(R.id.splash_logo).setY(Y);

                ImageView imageview = (ImageView) findViewById(R.id.splash_background_2);
                imageview.setVisibility(View.VISIBLE);

                ImageView imageview2 = (ImageView) findViewById(R.id.splash_background);
                imageview2.setVisibility(View.INVISIBLE);

                ImageView imageview3 = (ImageView) findViewById(R.id.emailIcon);
                imageview3.setVisibility(View.VISIBLE);

                EditText imageview4 = (EditText) findViewById(R.id.editText);
                imageview4.setVisibility(View.VISIBLE);

                ImageView imageview5 = (ImageView) findViewById(R.id.passwordIcon);
                imageview5.setVisibility(View.VISIBLE);

                EditText imageview6 = (EditText) findViewById(R.id.editText2);
                imageview6.setVisibility(View.VISIBLE);

                Button imageview7 = (Button) findViewById(R.id.btn1);
                imageview7.setVisibility(View.VISIBLE);

                TextView imageview10 = (TextView) findViewById(R.id.forgotPassword);
                imageview10.setVisibility(View.VISIBLE);

                TextView imageview8 = (TextView) findViewById(R.id.last);
                imageview8.setVisibility(View.VISIBLE);

                TextView imageview9 = (TextView) findViewById(R.id.last2);
                imageview9.setVisibility(View.VISIBLE);
                break;
            default:
                break;

        }
        return true;
    }


    /**
     * very important function
     *
     * @param v is used for edittext
     */
    public void valid(final View v) {
        int status = 0;
        EditText imageview4 = (EditText) findViewById(R.id.editText);
        EditText imageview6 = (EditText) findViewById(R.id.editText2);
        if (imageview4.getText().toString().equals(userName) && imageview6.getText().toString().equals(password)) {
            status = 1;
        } else {
            status = 0;
        }
        if (status == 1) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "RE - Enter   Please !", Toast.LENGTH_LONG).show();
        }
    }


}
