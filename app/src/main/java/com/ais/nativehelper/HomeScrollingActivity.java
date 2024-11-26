package com.ais.nativehelper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.ais.nativehelper.adapter.EventsHeadingViewAdapter;
import com.ais.nativehelper.adapter.NewsHeadingViewAdapter;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ApiRequestSingleton;
import com.ais.nativehelper.model.NewsHeadline;
import com.ais.nativehelper.model.ShopHeader;
import com.ais.nativehelper.netowork_info.CheckConnectivity;
import com.ais.nativehelper.ùtil.DateConverstion;
import com.android.volley.AuthFailureError;
import com.google.android.material.snackbar.Snackbar;


import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ais.nativehelper.databinding.ActivityHomeScrollingBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeScrollingActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityHomeScrollingBinding binding;

    private Button btn_layer1_bnt1;
    private Button btn_layer1_bnt2;
    private Button btn_layer1_bnt3;
    private Button btn_layer1_bnt4;
    private Button btn_layer1_bnt5;
    private Button btn_layer1_bnt6;
    private Button btn_layer4_bnt2_events;
    private Button btn_layer4_bnt1_news;
    private RecyclerView reclyview_layer2_events_recycle;
    private RecyclerView reclyview_layer8_newsviews;

    private AppCompatImageButton btn_layer5_bnt1_fdrt;
    private AppCompatImageButton btn_layer5_bnt2_agrp;
    private AppCompatImageButton btn_layer5_bnt3_grcr;
    private AppCompatImageButton btn_layer5_bnt4_clts;
    private AppCompatImageButton btn_layer5_bnt5_hmapl;
    private AppCompatImageButton btn_layer5_bnt6_mblse;
    private AppCompatImageButton btn_layer5_bnt7_wdftr;
    private AppCompatImageButton btn_layer5_bnt8_gldjw;
    private AppCompatImageButton btn_layer5_bnt9_grnts;


    private AppCompatImageButton srvc_txt_bnt1_edct;
    private AppCompatImageButton srvc_txt_bnt2_cnltnt;
    private AppCompatImageButton srvc_txt_bnt3_trvls;
    private AppCompatImageButton srvc_txt_bnt4_ctrn;
    private AppCompatImageButton srvc_txt_bnt5_plmbr;
    private AppCompatImageButton srvc_txt_bnt6_crpntr;
    private AppCompatImageButton srvc_txt_bnt7_pntr;
    private AppCompatImageButton srvc_txt_bnt8_elctn;

    private AppCompatImageButton btn_bnt1_bks;
    private AppCompatImageButton btn_bnt2_crs;


    private Button layer6_bnt1_hms_rnt;
    private Button layer6_bnt2_hms_buy;























    private String MESSAGE;
    private String TAG="NEWS";
    private ProgressDialog progressDialog;
    private String urlcmp="1/1/1/1";


    private List<NewsHeadline> headlineList;
    List<ShopHeader> eventsheadlineList;
    // RecyclerView recyclerView;
    // RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;


    private RecyclerView.Adapter evetsrecyclerViewadapter;


    private  void intialize()
    {
        btn_layer1_bnt1= (Button) findViewById(R.id.btn_layer1_bnt1);
        btn_layer1_bnt2= (Button) findViewById(R.id.btn_layer1_bnt2);
        btn_layer1_bnt3= (Button) findViewById(R.id.btn_layer1_bnt3);
        btn_layer1_bnt4= (Button) findViewById(R.id.btn_layer1_bnt4);
        btn_layer1_bnt5= (Button) findViewById(R.id.btn_layer1_bnt5);
        btn_layer4_bnt2_events= (Button) findViewById(R.id.btn_layer4_bnt2_events);
        btn_layer4_bnt1_news= (Button) findViewById(R.id.btn_layer4_bnt1_news);
        reclyview_layer2_events_recycle=findViewById(R.id.reclyview_layer2_events_recycle);
        reclyview_layer8_newsviews=findViewById(R.id.reclyview_layer8_newsviews);

        btn_layer5_bnt1_fdrt=  findViewById(R.id.btn_layer5_bnt1_fdrt);
        btn_layer5_bnt2_agrp=  findViewById(R.id.btn_layer5_bnt2_agrp);
        btn_layer5_bnt3_grcr=  findViewById(R.id.btn_layer5_bnt3_grcr);
        btn_layer5_bnt4_clts=  findViewById(R.id.btn_layer5_bnt4_clts);
        btn_layer5_bnt5_hmapl=  findViewById(R.id.btn_layer5_bnt5_hmapl);
        btn_layer5_bnt6_mblse= findViewById(R.id.btn_layer5_bnt6_mblse);
        btn_layer5_bnt7_wdftr=  findViewById(R.id.btn_layer5_bnt7_wdftr);
        btn_layer5_bnt8_gldjw=  findViewById(R.id.btn_layer5_bnt8_gldjw);
        btn_layer5_bnt9_grnts=  findViewById(R.id.btn_layer5_bnt9_grnts);


        srvc_txt_bnt1_edct=  findViewById(R.id.srvc_txt_bnt1_edct);
        srvc_txt_bnt2_cnltnt=  findViewById(R.id.srvc_txt_bnt2_cnltnt);
        srvc_txt_bnt3_trvls=  findViewById(R.id.srvc_txt_bnt3_trvls);
        srvc_txt_bnt4_ctrn=  findViewById(R.id.srvc_txt_bnt4_ctrn);
        srvc_txt_bnt5_plmbr=  findViewById(R.id.srvc_txt_bnt5_plmbr);
        srvc_txt_bnt6_crpntr= findViewById(R.id.srvc_txt_bnt6_crpntr);
        srvc_txt_bnt7_pntr=  findViewById(R.id.srvc_txt_bnt7_pntr);
        srvc_txt_bnt8_elctn=  findViewById(R.id.srvc_txt_bnt8_elctn);





        btn_bnt1_bks=  findViewById(R.id.btn_bnt1_bks);
        btn_bnt2_crs= findViewById(R.id.btn_bnt2_crs);
        layer6_bnt1_hms_rnt=  findViewById(R.id.layer6_bnt1_hms_rnt);
        layer6_bnt2_hms_buy=  findViewById(R.id.layer6_bnt2_hms_buy);














        //recycle view click event
        headlineList = new ArrayList<>();
        eventsheadlineList= new ArrayList<>();
        //Card View

        reclyview_layer8_newsviews.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(HomeScrollingActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(HomeScrollingActivity.this, LinearLayoutManager.HORIZONTAL, false);


        reclyview_layer8_newsviews.setLayoutManager(layoutManager);
        //reclyview_layer8_newsviews.setLayoutManager(recyclerViewlayoutManager);
        reclyview_layer8_newsviews.setItemAnimator(new DefaultItemAnimator());

        reclyview_layer2_events_recycle.setLayoutManager(layoutManager1);
        //reclyview_layer8_newsviews.setLayoutManager(recyclerViewlayoutManager);
        reclyview_layer2_events_recycle.setItemAnimator(new DefaultItemAnimator());


        //check connectivity
        CheckConnectivity connectivity=new CheckConnectivity();
        boolean networkINfo=false;
        networkINfo=connectivity.checkNow(HomeScrollingActivity.this);
        Log.e("TEST",""+networkINfo);

        Log.e("TEST","111111111111111111");
        if (networkINfo){
            // Calling Jobs List
            //set canditate Details
            Log.e("TEST","22222222222222222");
            getNewsHeadings();
            getshopHeaderList();
            Log.e("TEST","22222222222222222");
        }
        else {
            Intent intent=new Intent(HomeScrollingActivity.this,NetworkInfo.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }


        reclyview_layer8_newsviews.addOnItemTouchListener(new NewsListActivity.RecyclerTouchListener(getApplicationContext(), reclyview_layer8_newsviews, new NewsListActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NewsHeadline headline = headlineList.get(position);
                Intent intent=new Intent(HomeScrollingActivity.this,NewsDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_NEWSID,""+headline.getNewsID());

                startActivity(intent);





            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        reclyview_layer2_events_recycle.addOnItemTouchListener(new ShopListActivity.RecyclerTouchListener(getApplicationContext(), reclyview_layer2_events_recycle, new ShopListActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ShopHeader eventheadlineList = eventsheadlineList.get(position);
                Intent intent=new Intent(HomeScrollingActivity.this,ShopDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_SHOPID,""+eventheadlineList.getShopId());
                intent.putExtra(GlobalController.KEY_SHOPNAME,""+eventheadlineList.getShopName());
                intent.putExtra(GlobalController.KEY_SHOPIMAGEURL,""+eventheadlineList.getImageUrl());
                intent.putExtra(GlobalController.KEY_SHOPVIEWS,""+eventheadlineList.getView());


                startActivity(intent);
                /*Intent intent=new Intent(ShopListActivity.this,ShopDetailsActivity.class);
                startActivity(intent);*/




            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_scrolling);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });




        intialize();

        onclickshopsbuttonexection();





        btn_layer1_bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer1_bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });

        btn_layer1_bnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_TRANSPORT);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_TRANSPORT_CODE);
                startActivity(intent);
            }
        });

        btn_layer1_bnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_TEMPLES);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_TEMPLES_CODE);
                startActivity(intent);
            }
        });





        btn_layer1_bnt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MOVIES);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MOVIES_CODE);
                startActivity(intent);

            }
        });


        btn_layer4_bnt1_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GlobalController.NEWS_LIST_RECYCLE_CODE=1;
                Intent intent=new Intent(HomeScrollingActivity.this,NewsListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MOVIES);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MOVIES_CODE);
                startActivity(intent);


            }
        });
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_scrolling);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }









    private void getNewsHeadings() {
        progressDialog = new ProgressDialog(HomeScrollingActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        //progressDialog.show();
        Map<String, String> params= new HashMap<String, String>();

        Log.e("test","8888888888888888888888");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(GlobalController.API_HEADLINES,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // JSONObject response1 = new JSONObject(response.toString());
                            // JSONObject response1 =  response;
                            String message;
                            Log.e("test1","%%%%%%%%%%%%%%%%%%%%%");
                            Log.e("test1",response.toString());
                            Log.e("test1","%%%%%%%%%%%%%%%%%%%%%");
                            Log.e("test1","44444444");




                            //Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6Gl3A1OvR
                            boolean check=response.has("message");

                            if(check){
                                message=response.getString("message");

                                if (message.equals("success")){
                                    System.out.println(GlobalController.ACCESSTOKEN1);



                                    if(response.has("headLines")){
                                        JSONArray jsonHeadLines=response.getJSONArray("headLines");
                                        Log.e("test1","111");




                                        if (jsonHeadLines != null) {

                                            Log.e("test1","222");
                                            for (int k=0;k<jsonHeadLines.length();k++){
                                                JSONObject jheadline = (JSONObject) jsonHeadLines.get(k);
                                                NewsHeadline headline=new NewsHeadline();
                                                headline.setNewsID(jheadline.getLong("newsID"));
                                                headline.setNewsHeading(jheadline.getString("newsHeading"));
                                                headline.setNewscloseDate(DateConverstion.StringToDate(jheadline.getString("date")));
                                                headline.setLanguageType(jheadline.getString("languageType"));
                                                headline.setImageUrl(jheadline.getString("imageUrl"));
                                                headline.setNewscategory(jheadline.getInt("newscategory"));
                                                headline.setCreatedBY(jheadline.getLong("createdBY"));
                                                headline.setFinalStatus(jheadline.getString("finalStatus"));
                                                headline.setName(jheadline.getString("name"));
                                                headline.setViews(jheadline.getLong("views"));
                                                headlineList.add(headline);

                                            }
                                        }

                                        Log.e("test","^^^^^^^^^^^^^^");
                                        Log.e("test",GlobalController.ACCESSTOKEN1);
                                        Log.e("test","^^^^^^^^^^^^^^");


                                    }
                                    else {

                                    }





                                    /*currentUserModel= globalController.getCurrentUserDetails(ActivitySingIn.this);*/







                                }
                                /*Toast.makeText(SignupActivity.this,MESSAGE,Toast.LENGTH_LONG).show();
                                System.out.println(MESSAGE);*/
                            }else{




                               /* Intent intent=new Intent(SignupActivity.this,ActivityEventsList.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);*/


                            }
                            GlobalController.NEWS_LIST_RECYCLE_CODE=2;
                            recyclerViewadapter = new NewsHeadingViewAdapter(headlineList,HomeScrollingActivity.this);

                            reclyview_layer8_newsviews.setAdapter(recyclerViewadapter);
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
                if (null != error.networkResponse)
                {
                    Log.e(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);
                }
                Log.e("TEST",GlobalController.API_HEADLINES);
                progressDialog.dismiss();
                Intent intent=new Intent(HomeScrollingActivity.this,NetworkInfo.class);
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
        ApiRequestSingleton.getInstance(HomeScrollingActivity.this).addToRequestQueue(jsonObjReq);
        Log.e("test","9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }


    //getting the shopdetails vule from shop data
    private void getshopHeaderList() {
        progressDialog = new ProgressDialog(HomeScrollingActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        //progressDialog.show();
        Map<String, String> params= new HashMap<String, String>();

        Log.e("test","888888888881111111111");
        Log.e("test",GlobalController.ACCESSTOKEN1);

        Log.e("test",GlobalController.API_SHOPLISTBYCATANDSUBCAT+urlcmp);
        Log.e("test","888888888881111111111");
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



                                                eventsheadlineList.add(headline);

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
                            recyclerViewadapter = new EventsHeadingViewAdapter(eventsheadlineList,HomeScrollingActivity.this);

                            reclyview_layer2_events_recycle.setAdapter(recyclerViewadapter);
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
                Intent intent=new Intent(HomeScrollingActivity.this,NetworkInfo.class);
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
        ApiRequestSingleton.getInstance(HomeScrollingActivity.this).addToRequestQueue(jsonObjReq);
        Log.e("test","9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }


    private void onclickshopsbuttonexection()
    {





        btn_layer5_bnt1_fdrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer5_bnt2_agrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer5_bnt3_grcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });






        btn_layer5_bnt4_clts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer5_bnt5_hmapl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });




        btn_layer5_bnt6_mblse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer5_bnt7_wdftr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer5_bnt8_gldjw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        btn_layer5_bnt9_grnts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });











        srvc_txt_bnt1_edct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });

        srvc_txt_bnt2_cnltnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });



        srvc_txt_bnt3_trvls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });


        srvc_txt_bnt4_ctrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });








        srvc_txt_bnt5_plmbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });

        srvc_txt_bnt6_crpntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });

        srvc_txt_bnt7_pntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });

        srvc_txt_bnt8_elctn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });




        btn_layer4_bnt2_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeScrollingActivity.this,ShopListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_HEALTH);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_HEALTH_CODE);



                startActivity(intent);
            }
        });









        layer6_bnt1_hms_rnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });


        layer6_bnt2_hms_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });


        btn_bnt2_crs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });

        btn_bnt1_bks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScrollingActivity.this,ItemListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_URLFORNEXTCLASS,""+GlobalController.KEY_URL_MARKET);
                intent.putExtra(GlobalController.KEY_MAINCAT,""+GlobalController.KEY_MARKET_CODE);
                startActivity(intent);
            }
        });


    }

}





