package com.ais.nativehelper;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ais.nativehelper.adapter.ShopHeadingViewAdapter;
import com.ais.nativehelper.databinding.ActivityShopListBinding;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ApiRequestSingleton;
import com.ais.nativehelper.model.ShopHeader;
import com.ais.nativehelper.netowork_info.CheckConnectivity;
import com.ais.nativehelper.ùtil.DateConverstion;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class ShopListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityShopListBinding binding;
    private String MESSAGE;
    private String TAG="shops";
    private ProgressDialog progressDialog;
    private String urlcmp="";




    List<ShopHeader> headlineList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    private void intialization() {

        urlcmp = getIntent().getStringExtra(GlobalController.KEY_URLFORNEXTCLASS);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShopListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);



     /*   binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
        intialization();

        //check connectivity
        CheckConnectivity connectivity=new CheckConnectivity();
        boolean networkINfo=false;
        networkINfo=connectivity.checkNow(ShopListActivity.this);
        Log.e("TEST",""+networkINfo);

        Log.e("TEST","111111111111111111");
        if (networkINfo){
            // Calling Jobs List
            //set canditate Details
            Log.e("TEST","22222222222222222");
            getshopHeaderList();
            Log.e("TEST","22222222222222222");
        }
        else {
            Intent intent=new Intent(ShopListActivity.this,NetworkInfo.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        //recycle view click event
        headlineList = new ArrayList<>();
        //Card View
        recyclerView = (RecyclerView) findViewById(R.id.shop_header_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // recyclerViewadapter=new NewsHeadingViewAdapter(headlineList);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.setAdapter(recyclerViewadapter);

        //getting the recyclerview from xml




        recyclerView.addOnItemTouchListener(new ShopListActivity.RecyclerTouchListener(getApplicationContext(), recyclerView, new ShopListActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ShopHeader headline = headlineList.get(position);
                Intent intent=new Intent(ShopListActivity.this,ShopDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_SHOPID,""+headline.getShopId());
                intent.putExtra(GlobalController.KEY_SHOPNAME,""+headline.getShopName());
                intent.putExtra(GlobalController.KEY_SHOPIMAGEURL,""+headline.getImageUrl());
                intent.putExtra(GlobalController.KEY_SHOPVIEWS,""+headline.getView());


                startActivity(intent);
                /*Intent intent=new Intent(ShopListActivity.this,ShopDetailsActivity.class);
                startActivity(intent);*/




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
        private ShopListActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ShopListActivity.ClickListener clickListener) {
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


    //getting the shopdetails vule from shop data
    private void getshopHeaderList() {
        progressDialog = new ProgressDialog(ShopListActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        Map<String, String> params= new HashMap<String, String>();

        Log.e("test","8888888888888888888888");
        Log.e("test","8888888888888888888888");

        Log.e("test",GlobalController.API_SHOPLISTBYCATANDSUBCAT+urlcmp);
        Log.e("test","8888888888888888888888");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(GlobalController.API_SHOPLISTBYCATANDSUBCAT+urlcmp,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // JSONObject response1 = new JSONObject(response.toString());
                            // JSONObject response1 =  response;
                            String message;
                            Log.e("test","%%%%%%%%%%%%%%%%%%%%%");
                            Log.e("test",response.toString());
                            Log.e("test","%%%%%%%%%%%%%%%%%%%%%");





                            //Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6Gl3A1OvR
                            boolean check=response.has("message");

                            if(check){
                                message=response.getString("message");

                                if (message.equals("success")){

                                    Log.e("test","11111111");
                                    System.out.println(GlobalController.ACCESSTOKEN1);
                                    Log.e("test",GlobalController.ACCESSTOKEN1);
                                    Log.e("test","11111111");



                                    if(response.has("shopHeaders")){
                                        JSONArray jsonHeadLines=response.getJSONArray("shopHeaders");

                                        if (jsonHeadLines != null  ) {
                                            for (int k=0;k<jsonHeadLines.length();k++){
                                                Log.e("test","2222222222");
                                                JSONObject jheadline = (JSONObject) jsonHeadLines.get(k);
                                                ShopHeader headline=new ShopHeader();
                                                headline.setShopId(jheadline.getLong("shopId"));
                                                headline.setShopName(jheadline.getString("shopName"));
                                                headline.setShopTitle(jheadline.getString("shopTitle"));
                                                headline.setLanguageType(jheadline.getString("languageType"));
                                                headline.setCreatedBY(jheadline.getLong("createdBY"));
                                                headline.setUserId(jheadline.getLong("userId"));
                                                headline.setName(jheadline.getString("name"));
                                                headline.setDate(DateConverstion.StringToDate1(jheadline.getString("date")));
                                                headline.setMctId(jheadline.getInt("mcatId"));
                                                headline.setSubCatId(jheadline.getInt("subCatId"));
                                                headline.setResourcePhNo(jheadline.getString("resourcePhNo"));
                                                headline.setImageUrl(jheadline.getString("imageUrl"));
                                                headline.setFinalStatus(jheadline.getString("finalStatus"));
                                                headline.setCatName(jheadline.getString("catName"));
                                                headline.setView(jheadline.getInt("views"));



                                                headlineList.add(headline);

                                            }
                                        }

                                        Log.e("test","^^^^^^^^^^^^^^");
                                        Log.e("test",GlobalController.ACCESSTOKEN1);
                                        Log.e("test","^^^^^^^^^^^^^^");


                                    }
                                    else {
                                        Log.e("test","565656565");
                                    }





                                    /*currentUserModel= globalController.getCurrentUserDetails(ActivitySingIn.this);*/







                                }
                                /*Toast.makeText(SignupActivity.this,MESSAGE,Toast.LENGTH_LONG).show();
                                System.out.println(MESSAGE);*/
                            }else{


                                Log.e("test","8888888888");

                               /* Intent intent=new Intent(SignupActivity.this,ActivityEventsList.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);*/


                            }
                            recyclerViewadapter = new ShopHeadingViewAdapter(headlineList,ShopListActivity.this);

                            recyclerView.setAdapter(recyclerViewadapter);
                            progressDialog.dismiss();

                        } catch (JSONException e) {
                            Log.e(GlobalController.LOG_JSonException_TAG, "JSONException:" + e);
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(TAG, "Error: " + error.getMessage());
                NetworkResponse networkResponse = error.networkResponse;
                if (networkResponse != null && networkResponse.data != null) {
                    String jsonError = new String(networkResponse.data);
                    Log.e("TEST",jsonError);
                    // Print Error!
                }
                //Log.e("test",error.getMessage());

                if(error instanceof ServerError)

                {
                    Log.e("test","################");
                }
                Log.e("test","55555555555555555555");
                Log.e("test",error.toString());
                Log.e("test","55555555555555555555");
                if (null != error.networkResponse)
                {
                    Log.e(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);
                }
                Log.e("TEST",GlobalController.API_HEADLINES);
                progressDialog.dismiss();
                Intent intent=new Intent(ShopListActivity.this,NetworkInfo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                /*hideProgressDialog();*/
            }
        }) {

            /**
             * Passing some request headers
             * */
           /* @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //add params <key,value>
                return params;
            }*/
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=UTF-8");
                headers.put("Authorization", GlobalController.ACCESSTOKEN1);
                // headers.put("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMDAwMDAwMDAyIiwiaWF0IjoxNTg0Mjc4MjEzLCJleHAiOjE1ODQ4ODMwMTN9.bVsei4HjGxs9JngxvJ2qMmJ2M4xJ7Sy8XIvN1JozQUzPdBulunO0Cux9VLD0_dEcDg77lFmxxcCfsZfgTC3a4A");

                return headers;
            }
           /* @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = SyncStateContract.Constants.getHeaders(NewsHomeActivity.this);
                // add headers <key,value>
                String credentials = USERNAME+":"+PASSWORD;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(),
                        Base64.NO_WRAP);
                headers.put("Authorization", auth);
                return headers;
            }*/


        };

        // Adding request to request queue
        /* AppController.getInstance().addToRequestQueue(jsonObjReq,tag_json_obj);*/
        Log.e("test","88888888888");
        ApiRequestSingleton.getInstance(ShopListActivity.this).addToRequestQueue(jsonObjReq);
        Log.e("test","9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }


}