package com.ais.nativehelper;

import android.os.Bundle;

import com.ais.nativehelper.adapter.ShopGallaryImagesViewAdapter;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ShopImages;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ais.nativehelper.databinding.ActivityGallaryImageViewBinding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class GallaryImageView extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGallaryImageViewBinding binding;
    private RecyclerView.LayoutManager recyclerViewlayoutManager;
    private RecyclerView  recyclerViewImageView;
    private RecyclerView.Adapter recyclerImageViewadapter;
    public static List<ShopImages> staticimageList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGallaryImageViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding = ActivityGallaryImageViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
       // bottomNavigationExecute(GallaryImageView.this);

        setSupportActionBar(binding.toolbar);
        recyclerViewImageView=  findViewById(R.id.shop_image_recyclerview11);

        if(GallaryImageView.staticimageList!=null)
        {
            if(GallaryImageView.staticimageList.size()>0)
            {
                recyclerImageViewadapter = new ShopGallaryImagesViewAdapter(GallaryImageView.staticimageList,GallaryImageView.this);
                LinearLayoutManager layoutManager
                        = new LinearLayoutManager(GallaryImageView.this, LinearLayoutManager.HORIZONTAL, false);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                recyclerViewImageView.setLayoutManager(gridLayoutManager);

                recyclerViewImageView.setAdapter(recyclerImageViewadapter);
            }

        }

        recyclerViewImageView.addOnItemTouchListener(new GallaryImageView.RecyclerTouchListener(getApplicationContext(), recyclerViewImageView, new GallaryImageView.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                if(GallaryImageView.staticimageList!=null){
                    if(GallaryImageView.staticimageList.size()>0)
                    {
                        Intent intent=new Intent(GallaryImageView.this,ImageMultiTouchActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("TASK","FROM SHOPDETAILS");
                        intent.putExtra(GlobalController.KEY_SHOPGALLARYIMAGE,GallaryImageView.staticimageList.get(position).getImageUrl());
                        startActivity(intent);

                    }

                }






            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));








    }

    //recycle view click activity
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private GallaryImageView.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final GallaryImageView.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }



}