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
    Button  btnCol1_R1, btnCol1_R2, btnCol1_R3, btnCol1_R4,
            btnCol2_R1, btnCol2_R2, btnCol2_R3, btnCol2_R4,
            btnCol3_R1, btnCol3_R2, btnCol3_R3, btnCol3_R4,
            btnCol4_R1, btnCol4_R2, btnCol4_R3, btnCol4_R4,
            btnCol5_R1, btnCol5_R2, btnCol5_R3, btnCol5_R4,
            btnCol6_R1, btnCol6_R2, btnCol6_R3, btnCol6_R4;
    ImageView head;
    ImageView lArm;
    ImageView rArm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Buttons
        btnCol4_R2 = findViewById(R.id.btnCol4_R2);
        btnCol6_R2 = findViewById(R.id.btnCol6_R2);
        btnCol1_R2 = findViewById(R.id.btnCol1_R2);
        btnCol2_R1 = findViewById(R.id.btnCol2_R1);

        //Images
        lArm = findViewById(R.id.arm_l);
        rArm = findViewById(R.id.arm_r);
        head = findViewById(R.id.head);

        btnCol2_R1.setOnClickListener(this);
        btnCol1_R2.setOnClickListener(this);
        btnCol6_R2.setOnClickListener(this);
        btnCol4_R2.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        int id = view.getId(); // saves button id from onclick


        if(id == R.id.btnCol2_R1){ // head
            showImage(head);
            mediaPlayer = MediaPlayer.create(this, R.raw.head);

        }
        else if (id == R.id.btnCol1_R2){ // right arm
            showImage(rArm);
            mediaPlayer = MediaPlayer.create(this, R.raw.arm);

        }
        mediaPlayer.start();

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