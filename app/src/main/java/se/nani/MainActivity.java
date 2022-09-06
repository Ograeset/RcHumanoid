package se.nani;


import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
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

        left = (Button)findViewById(R.id.test1);
        right= (Button)findViewById(R.id.test5);
        arm = (Button)findViewById(R.id.test9);
        lArm = (ImageView)findViewById(R.id.arm_l);
        rArm = (ImageView)findViewById(R.id.arm_r);


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.start();
                        lArm.setVisibility(ImageView.VISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                lArm.setVisibility(ImageView.INVISIBLE);
                                // yourMethod();
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
                        rArm.setVisibility(ImageView.VISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                rArm.setVisibility(ImageView.INVISIBLE);
                                // yourMethod();
                            }
                        }, 5000);
                    }
                });
            }
        });



    }
}