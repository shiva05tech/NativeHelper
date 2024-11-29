package com.ais.nativehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.ImageView;


import com.ais.nativehelper.global.GlobalController;
import com.squareup.picasso.Picasso;

public class ImageMultiTouchActivity extends AppCompatActivity {
    private ImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_multi_touch);
        imageView=  findViewById(R.id.gallariimageView1);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());


        // String ImageURL=getIntent().getStringExtra("TASK");
        String ImageURL=getIntent().getStringExtra(GlobalController.KEY_SHOPGALLARYIMAGE);
        if(ImageURL!=null)
        {
            //String urlll="https://valar.in/wp-content/uploads/2019/08/cropped-are-you-gonna-open-new-shop-opening-ceremony.jpg";


            Picasso.with(ImageMultiTouchActivity.this).load(ImageURL).resize(340, 240).into(imageView);

            //Picasso.with(ImageMultiTouchActivity.this).load(urlll).resize(340, 240).into(imageView);

           /*TouchImageView img = new TouchImageView(this);
           img.setImageResource(imageView);
           img.setMaxZoom(4f);
           setContentView(img);*/


        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }
    }
}