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
    Button arm, left, right, btnHead;
    ImageView head;
    ImageView lArm;
    ImageView rArm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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


        if(id == R.id.btnCol2_R1){ // head
            showImage(head);

        }
        else if (id == R.id.btnCol1_R2){ // right arm
            showImage(rArm);
            mediaPlayer = MediaPlayer.create(this, R.raw.arm);
            mediaPlayer.start();

        }

    }


    public void playSound(){
    }

    public void showImage(ImageView image) {
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        Handler handler = new Handler(); // handler for time delay

        image.startAnimation(animFadeIn);
        image.setVisibility(ImageView.VISIBLE);
        handler.postDelayed(new Runnable() {
            public void run() {
                image.startAnimation(animFadeOut);
                image.setVisibility(ImageView.INVISIBLE);
            }
        }, 5000);
    }


}