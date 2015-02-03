package com.example.selectableroundedcornersimageview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity
{
    
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        int width = getResources().getDisplayMetrics().widthPixels;
        float density = getResources().getDisplayMetrics().density;
        int imageWidth = (int) (width - (density * 40 + 0.5));
        int imageHeight = imageWidth * 3 / 4;
        
        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);
        imageView3 = (ImageView) findViewById(R.id.image3);
        imageView4 = (ImageView) findViewById(R.id.image4);
        
        LayoutParams layoutParams = new LayoutParams(imageWidth, imageHeight);
        layoutParams.topMargin = (int) (density * 10 + 0.5);
        imageView1.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams);
        imageView3.setLayoutParams(layoutParams);
        imageView4.setLayoutParams(layoutParams);
    }
}
