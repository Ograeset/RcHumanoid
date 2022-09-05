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
    Button play;
    ImageView rArm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.arm);

        play = (Button)findViewById(R.id.play);
        rArm = (ImageView)findViewById(R.id.arm_l);


        play.setOnClickListener(new View.OnClickListener() {
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
}