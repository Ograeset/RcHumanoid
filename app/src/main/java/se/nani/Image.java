package se.nani;

import android.app.Activity;
import android.widget.ImageView;


public class Image{
    Activity activity;


    private ImageView head = (ImageView)activity.findViewById(R.id.head);
    public ImageView getHead() {

        return head;
    }



}
