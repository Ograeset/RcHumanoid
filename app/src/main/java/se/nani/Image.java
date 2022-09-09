package se.nani;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Image extends AppCompatActivity {
    public ImageView getHead() {
        head = (ImageView)findViewById(R.id.head);
        return head;
    }


    private ImageView head;

}
