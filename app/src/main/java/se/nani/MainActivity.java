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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MediaPlayer mediaPlayer;
    Button arm;
    Button left;
    Button right;
    Button btnHead;
    ImageView head;
    ImageView lArm;
    ImageView rArm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.arm);

        left = (Button)findViewById(R.id.btnCol4_R2);
        right= (Button)findViewById(R.id.btnCol6_R2);
        arm = (Button)findViewById(R.id.btnCol1_R2);
        btnHead = (Button)findViewById(R.id.btnCol2_R1);
        lArm = (ImageView)findViewById(R.id.arm_l);
        rArm = (ImageView)findViewById(R.id.arm_r);
        head = (ImageView)findViewById(R.id.head);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        arm.setOnClickListener(this);
        btnHead.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        int id = view.getId(); // saves button id from onclick

        Handler handler = new Handler(); // handler for time delay

        // Fade in/out images
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);


        if (id == R.id.btnCol1_R2){ //right arm
            mediaPlayer.start();

            rArm.startAnimation(animFadeIn);
            rArm.setVisibility(ImageView.VISIBLE);

            handler.postDelayed(new Runnable() {
                public void run() {
                    rArm.startAnimation(animFadeOut);
                    rArm.setVisibility(ImageView.INVISIBLE);
                }
            }, 5000);
        }
       else if(id == R.id.btnCol2_R1){ // head
            head.startAnimation(animFadeIn);
            head.setVisibility(ImageView.VISIBLE);
            handler.postDelayed(new Runnable() {
                public void run() {
                    head.startAnimation(animFadeOut);
                    head.setVisibility(ImageView.INVISIBLE);
                }
            }, 5000);
        }
    }
}