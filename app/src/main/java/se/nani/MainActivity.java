package se.nani;


import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button arm;
    Button left;
    Button right;
    ImageView lArm;
    ImageView rArm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.arm);

        left = (Button)findViewById(R.id.btnCol4_R1);
        right= (Button)findViewById(R.id.btnCol5_R1);
        arm = (Button)findViewById(R.id.btnCol6_R1);
        lArm = (ImageView)findViewById(R.id.arm_l);
        rArm = (ImageView)findViewById(R.id.arm_r);


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.start();
                        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                        lArm.startAnimation(animFadeIn);
                        lArm.setVisibility(ImageView.VISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                                lArm.startAnimation(animFadeOut);
                                lArm.setVisibility(ImageView.INVISIBLE);
                            }
                        }, 5000);
                    }
                });
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.start();
                        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                        rArm.startAnimation(animFadeIn);
                        rArm.setVisibility(ImageView.VISIBLE);
                       Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                                rArm.startAnimation(animFadeOut);
                                rArm.setVisibility(ImageView.INVISIBLE);
                            }
                        }, 5000);
                    }
                });
            }
        });



    }
}