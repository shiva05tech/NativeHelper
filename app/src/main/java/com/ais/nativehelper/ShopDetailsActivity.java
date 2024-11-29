package com.ais.nativehelper;

import android.os.Bundle;
import android.Manifest;

import com.ais.nativehelper.adapter.ShopContentViewAdapter;
import com.ais.nativehelper.adapter.ShopImagesViewAdapter;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ApiRequestSingleton;
import com.ais.nativehelper.model.ShopAddress;
import com.ais.nativehelper.model.ShopCmpltDetails;
import com.ais.nativehelper.model.ShopContent;
import com.ais.nativehelper.model.ShopImages;
import com.ais.nativehelper.model.ShopOpenStatus;
import com.ais.nativehelper.model.ShopTimming;
import com.ais.nativehelper.model.ShopcontactInfo;
import com.ais.nativehelper.ùtil.DateConverstion;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ais.nativehelper.databinding.ActivityShopDetailsBinding;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.SyncStateContract;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopDetailsActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityShopDetailsBinding binding;

    private String MESSAGE;
    private String TAG="shops";
    private ProgressDialog progressDialog;
    private String urlcmp="1/1/1/1";
    private String task;
    private String shopID;
    private String shopName;
    private String shopUrl;
    private String views;


    private List<String> imageUrlsList;
    private List<ShopContent> shopContensList;
    private RecyclerView recyclerViewImageView;
    private RecyclerView recyclerViewShopContent;
    private RecyclerView.LayoutManager recyclerViewlayoutManager;
    private RecyclerView.Adapter recyclerImageViewadapter;
    private RecyclerView.Adapter recyclerContentViewadapter;

    private ImageView shopImageViewMain;
    private TextView txtv_shopname;
    private TextView txt_shopDateOpnstatus;
    private TextView txt_shopViews;
    private TextView txt_shopAdress;
    private ImageButton btn_call;
    private ImageButton btn_whatsapp;
    private ImageButton btn_share;
    private Button shop_btn_bestdeals;

    private TextView txt_shopaddress;
    private TextView txt_shopaphno;
    private TextView txt_shoptmming;
    private TextView txt_shopowner;
    private TextView txt_email;
    private ShopCmpltDetails shopDetails;
    private String phoneNo;
    private LinearLayout linLayout_openstatus ;




    private void intialization()
    {
        recyclerViewImageView=  findViewById(R.id.shop_imageslist_recyclerviewc);
        recyclerViewShopContent=  findViewById(R.id.shop_content_recyclerviewc);
        shopImageViewMain=  findViewById(R.id.shopImageViewMain);
        txtv_shopname=  findViewById(R.id.txtv_shopname);
        txt_shopDateOpnstatus=  findViewById(R.id.txt_shopDateOpnstatus);
        txt_shopAdress=  findViewById(R.id.txt_shopAdress);
        btn_call=  findViewById(R.id.btn_call);
        btn_whatsapp=  findViewById(R.id.btn_whatsapp);
        btn_share=  findViewById(R.id.btn_share);
        shop_btn_bestdeals=  findViewById(R.id.shop_btn_bestdeals);
        txt_shopaddress=  findViewById(R.id.txt_shopaddress);
        txt_shopaphno=  findViewById(R.id.txt_shopaphno);
        txt_shoptmming=  findViewById(R.id.txt_shoptmming);
        txt_shopViews=  findViewById(R.id.txt_shopViews);
        txt_shopowner=  findViewById(R.id.txt_shopowner);
        // shop_imageslist_recyclerviewc=  findViewById(R.id.shop_imageslist_recyclerviewc);
        txt_email=  findViewById(R.id.txt_email);
        // shop_content_recyclerviewc=  findViewById(R.id.shop_content_recyclerviewc);

        btn_call=  findViewById(R.id.btn_call);
        btn_whatsapp=findViewById(R.id.btn_whatsapp);
        btn_share=findViewById(R.id.btn_share);
        linLayout_openstatus=findViewById(R.id.lin_txt_shopDateOpnstatus);



        task=getIntent().getStringExtra("TASK");
        shopID=getIntent().getStringExtra(GlobalController.KEY_SHOPID);
        shopName=getIntent().getStringExtra(GlobalController.KEY_SHOPNAME);
        shopUrl=getIntent().getStringExtra(GlobalController.KEY_SHOPIMAGEURL);
        views=getIntent().getStringExtra(GlobalController.KEY_SHOPVIEWS);
        txt_shopViews.setText(views +" views");
        //URL MAKKING
        if (GlobalController.APPUSERID!=null){
            urlcmp=GlobalController.API_SHOPDETAILS+shopID+"/"+GlobalController.APPUSERID;
            // APPUSERID,DAPPUSERID
        }
        else{
            urlcmp=GlobalController.API_SHOPDETAILS+shopID+"/"+GlobalController.DAPPUSERID;
        }
        txtv_shopname.setText(shopName);
        //String urlll="https://valar.in/wp-content/uploads/2019/08/cropped-are-you-gonna-open-new-shop-opening-ceremony.jpg";
        Picasso.with(ShopDetailsActivity.this).load(shopUrl).resize(340, 240).into(shopImageViewMain);
        //Picasso.with(ShopDetailsActivity.this).load(urlll).resize(340, 240).into(shopImageViewMain);



        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(phoneNo!=null)
                {

                    onCall(phoneNo);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"service provider denied to make calls", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(phoneNo!=null)
                {

                    whatsappInstalledOrNot("com.whatsapp");
                   /* if (isWhatsappInstalled) {
                        Uri uri = Uri.parse("smsto:" + "9945085447");
                        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hai Good Morning");
                        sendIntent.setPackage("com.whatsapp");
                        startActivity(sendIntent);
                    } else {
                        Toast.makeText(getApplicationContext(), "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                        Uri uri = Uri.parse("market://details?id=com.whatsapp");
                        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(goToMarket);

                    }*/
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"service provider denied to make calls", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "ghgfh");
                   //     "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShopDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        intialization();

        imageUrlsList = new ArrayList<>();
        shopContensList= new ArrayList<>();
        //Card View
        recyclerViewImageView =  findViewById(R.id.shop_imageslist_recyclerviewc);
        recyclerViewImageView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerViewImageView.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewImageView.setItemAnimator(new DefaultItemAnimator());

        recyclerViewShopContent =  findViewById(R.id.shop_content_recyclerviewc);
        recyclerViewShopContent.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerViewShopContent.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewShopContent.setItemAnimator(new DefaultItemAnimator());




        recyclerViewImageView.addOnItemTouchListener(new ShopDetailsActivity.RecyclerTouchListener(getApplicationContext(), recyclerViewImageView, new ShopDetailsActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                GallaryImageView.staticimageList=shopDetails.getImageList();

                Intent intent=new Intent(ShopDetailsActivity.this,GallaryImageView.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM SHOPDETAILS");
                intent.putExtra(GlobalController.KEY_SHOPGALLARYIMAGE,GlobalController.KEY_SHOPGALLARYIMAGE);



                startActivity(intent);




            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        getshopHeaderList();


    }

    //recycle view click activity
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ShopDetailsActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ShopDetailsActivity.ClickListener clickListener) {
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


    private void getshopHeaderList() {

        Map<String, String> params= new HashMap<String, String>();



        JsonObjectRequest jsonObjReq = new JsonObjectRequest(urlcmp,null,
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



                                    if(response.has("shopDetails")){
                                        JSONObject jsonShop=response.getJSONObject("shopDetails");
                                        Log.e("test","22222222222");


                                        // JSONArray jsonHeadLines=response.getJSONArray("shopDetails");

                                        if (jsonShop != null ) {
                                            Log.e("test","3333333333333");
                                            shopDetails=new ShopCmpltDetails();

                                            shopDetails.setShopId(jsonShop.getLong("shopId"));
                                            shopDetails.setShopName(jsonShop.getString("shopName"));
                                            shopDetails.setShopTitle(jsonShop.getString("shopTitle"));
                                            shopDetails.setLanguageType(jsonShop.getInt("languageType"));
                                            shopDetails.setUserId(jsonShop.getLong("userId"));
                                            shopDetails.setUserName(jsonShop.getString("userName"));
                                            shopDetails.setPhNo(jsonShop.getString("phNo"));
                                            shopDetails.setMcatId(jsonShop.getInt("mcatId"));
                                            shopDetails.setSubcatId(jsonShop.getInt("subcatId"));
                                            shopDetails.setDistrictID(jsonShop.getInt("districtID"));
                                            shopDetails.setTalukID(jsonShop.getInt("talukID"));
                                            shopDetails.setRegion(jsonShop.getInt("region"));
                                            shopDetails.setPriority(jsonShop.getInt("priority"));
                                            shopDetails.setIdentity(jsonShop.getString("identity"));
                                            shopDetails.setStatus(jsonShop.getString("status"));
                                            shopDetails.setTdyStatus(jsonShop.getString("tdyStatus"));

                                            JSONArray contentList=jsonShop.getJSONArray("contentList");
                                            List<ShopContent> shopContentList=new ArrayList<>();
                                            if (contentList != null ) {
                                                // Log.e("test","===============:1"+contentList.length());
                                                for (int k=0;k<contentList.length();k++) {
                                                    JSONObject jsonShop1 = (JSONObject) contentList.get(k);
                                                    ShopContent shopContent = new ShopContent();
                                                    shopContent.setShopId(jsonShop1.getLong("shopId"));
                                                    shopContent.setTrsnNo(jsonShop1.getInt("trsnNo"));
                                                    shopContent.setTitle(jsonShop1.getString("title"));
                                                    shopContent.setShopContent(jsonShop1.getString("shopContent"));
                                                    shopContent.setPriority(jsonShop1.getInt("priority"));
                                                    shopContent.setLanguageType(jsonShop1.getInt("languageType"));
                                                    shopContent.setStatus(jsonShop1.getString("status"));
                                                    shopContent.setApproved(jsonShop1.getLong("approved"));
                                                    shopContent.setCreatedDate(jsonShop1.getString("createdDate"));
                                                    shopContent.setVisible(jsonShop1.getInt("visible"));
                                                    shopContentList.add(shopContent);

                                                }
                                                shopDetails.setContentList(shopContentList);
                                            }

                                            JSONArray imageListList=jsonShop.getJSONArray("imageList");
                                            List<ShopImages> shopImagesList=new ArrayList<>();
                                            if (imageListList != null ) {
                                                Log.e("test","===============:2"+imageListList.length());
                                                for (int k=0;k<imageListList.length();k++) {
                                                    JSONObject jsonShop1 = (JSONObject) imageListList.get(k);
                                                    ShopImages shopContent = new ShopImages();
                                                    shopContent.setShopId(jsonShop1.getLong("shopId"));
                                                    shopContent.setTrsnNo(jsonShop1.getInt("trsnNo"));
                                                    shopContent.setTitle(jsonShop1.getString("title"));
                                                    shopContent.setImageUrl(jsonShop1.getString("imageUrl"));
                                                    shopContent.setPriority(jsonShop1.getInt("priority"));
                                                    shopContent.setStatus(jsonShop1.getString("status"));
                                                    shopContent.setApproved(jsonShop1.getLong("approved"));
                                                    shopContent.setFileName(jsonShop1.getString("fileName"));
                                                    shopContent.setCreatedDate(jsonShop1.getString("createdDate"));
                                                    shopContent.setVisible(jsonShop1.getInt("visible"));
                                                    shopImagesList.add(shopContent);

                                                }
                                                shopDetails.setImageList(shopImagesList);
                                            }


                                            JSONArray adressList=jsonShop.getJSONArray("adressList");
                                            List<ShopAddress> adressListList=new ArrayList<>();
                                            if (adressListList != null ) {
                                                Log.e("test","===============:3"+adressList.length());
                                                for (int k=0;k<adressList.length();k++) {
                                                    JSONObject jsonShop1 = (JSONObject) adressList.get(k);
                                                    ShopAddress shopContent = new ShopAddress();
                                                    shopContent.setShopId(jsonShop1.getLong("shopId"));
                                                    shopContent.setTrsnNo(jsonShop1.getInt("trsnNo"));
                                                    shopContent.setLine1(jsonShop1.getString("line1"));
                                                    shopContent.setLine2(jsonShop1.getString("line2"));
                                                    shopContent.setArea(jsonShop1.getString("area"));
                                                    shopContent.setArea2(jsonShop1.getString("area2"));
                                                    shopContent.setDistrictID(jsonShop1.getInt("districtID"));
                                                    shopContent.setTalukID(jsonShop1.getInt("talukID"));
                                                    shopContent.setRegion(jsonShop1.getInt("region"));
                                                    shopContent.setPriority(jsonShop1.getString("priority"));
                                                    shopContent.setStatus(jsonShop1.getString("status"));
                                                    shopContent.setPincode(jsonShop1.getInt("pincode"));
                                                    adressListList.add(shopContent);

                                                }
                                                shopDetails.setAdressList(adressListList);
                                            }



                                            JSONArray contList1=jsonShop.getJSONArray("contList");
                                            List<ShopcontactInfo> shopcontactInfoList=new ArrayList<>();
                                            if (contList1 != null ) {
                                                Log.e("test","===============:4"+contList1.length());
                                                for (int k=0;k<contList1.length();k++) {
                                                    JSONObject jsonShop1 = (JSONObject) contList1.get(k);
                                                    ShopcontactInfo shopContent1 = new ShopcontactInfo();
                                                    shopContent1.setShopId(jsonShop1.getLong("shopId"));
                                                    shopContent1.setTrsnNo(jsonShop1.getInt("trsnNo"));
                                                    shopContent1.setTitle(jsonShop1.getString("title"));
                                                    shopContent1.setMobileNo(jsonShop1.getString("mobileNo"));
                                                    shopContent1.setEmail(jsonShop1.getString("email"));
                                                    shopContent1.setStatus(jsonShop1.getString("status"));
                                                    shopContent1.setApproved(jsonShop1.getLong("approved"));
                                                    shopContent1.setMobVisible(jsonShop1.getString("mobVisible"));
                                                    shopContent1.setEmailVisible(jsonShop1.getString("emailVisible"));
                                                    shopContent1.setVisible(jsonShop1.getInt("visible"));


                                                    shopcontactInfoList.add(shopContent1);

                                                }
                                                shopDetails.setContList(shopcontactInfoList);
                                            }


                                            JSONArray jsontimmimgList=jsonShop.getJSONArray("timmimg");
                                            List<ShopTimming> shopTimmingList=new ArrayList<>();
                                            if (jsontimmimgList != null ) {

                                                for (int k=0;k<jsontimmimgList.length();k++) {
                                                    JSONObject jsonShop1 = (JSONObject) jsontimmimgList.get(k);
                                                    ShopTimming shopContent = new ShopTimming();
                                                    shopContent.setShopId(jsonShop1.getLong("shopId"));
                                                    shopContent.setDayID(jsonShop1.getInt("dayID"));
                                                    shopContent.setOpenFrom(DateConverstion.StringToDate1(jsonShop1.getString("openFrom")));
                                                    shopContent.setOpenTo(DateConverstion.StringToDate1(jsonShop1.getString("openTo")));
                                                    shopContent.setBrkFrom(DateConverstion.StringToDate1(jsonShop1.getString("brkFrom")));
                                                    shopContent.setBrkTo(DateConverstion.StringToDate1(jsonShop1.getString("brkTo")));
                                                    shopContent.setBrkStatus(jsonShop1.getString("brkStatus"));

                                                    shopContent.setOpenStatus(jsonShop1.getString("openStatus"));
                                                    shopContent.setTimeStatus(jsonShop1.getString("timeStatus"));
                                                    shopContent.setWeekStatus(jsonShop1.getString("weekStatus"));
                                                    shopContent.setApproved(jsonShop1.getLong("shopId"));
                                                    shopContent.setRemark(jsonShop1.getString("remark"));
                                                    shopContent.setStatus(jsonShop1.getString("status"));
                                                    shopTimmingList.add(shopContent);

                                                }
                                                shopDetails.setTimmimg(shopTimmingList);
                                            }


                                            JSONObject jsonopenStatus=jsonShop.getJSONObject("openStatus");


                                            ShopOpenStatus shopOpenStatus=null;

                                            if (jsonopenStatus != null ) {
                                                shopOpenStatus =new ShopOpenStatus();
                                                Log.e("test","&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                                                shopOpenStatus.setId(jsonopenStatus.getLong("id"));
                                                shopOpenStatus.setShopId(jsonopenStatus.getLong("shopId"));
                                                shopOpenStatus.setUserId(jsonopenStatus.getLong("userId"));
                                                shopOpenStatus.setDate(DateConverstion.StringToDate1(jsonopenStatus.getString("date")));
                                                shopOpenStatus.setOpenStatus(jsonopenStatus.getString("openStatus"));
                                                shopOpenStatus.setStatus(jsonopenStatus.getString("status"));
                                                shopDetails.setOpenStatus(shopOpenStatus);

                                            }



                                            //E END OF THE OUT PUT EXTRACTING PROCESS

                                            resulltBindingtoView(shopDetails);

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
                           /* recyclerViewadapter = new ShopHeadingViewAdapter(headlineList,ShopListActivity.this);

                            recyclerView.setAdapter(recyclerViewadapter);
                            progressDialog.dismiss();*/

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

                }

                if (null != error.networkResponse)
                {
                    Log.e(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);
                }
                Log.e("TEST",GlobalController.API_HEADLINES);
                progressDialog.dismiss();
                Intent intent=new Intent(ShopDetailsActivity.this,NetworkInfo.class);
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
        // Log.e("test","88888888888");
        ApiRequestSingleton.getInstance(ShopDetailsActivity.this).addToRequestQueue(jsonObjReq);
        //Log.e("test","9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }


    private void resulltBindingtoView(ShopCmpltDetails shopDetails )
    {


        txtv_shopname.setText(shopDetails.getShopName());
        txt_shopowner.setText(shopDetails.getUserName());
        txtv_shopname.setText(shopDetails.getShopName());


        if(shopDetails.getTimmimg().size()>0)
        {
            if(shopDetails.getTimmimg().get(0).getStatus().equals("PSD"))
            {
                String penFrom=DateConverstion.shopdateConversion(shopDetails.getTimmimg().get(0).getOpenFrom());
                String openTo=DateConverstion.shopdateConversion(shopDetails.getTimmimg().get(0).getOpenTo());
                String shopTime=penFrom+"  To  "+openTo+ "   ";
                txt_shoptmming.setText(shopTime);
                penFrom=null;
                openTo=null;
                shopTime=null;
            }

        }
        if(DateConverstion.diffrenceDate(shopDetails.getOpenStatus().getDate())>=0)
        {
            linLayout_openstatus.setVisibility(View.VISIBLE);

        }
        else
        {
            if(shopDetails.getOpenStatus().getOpenStatus().equals("Y"))
            {
                txt_shopDateOpnstatus.setText("OPEN");
            }
            else if (shopDetails.getOpenStatus().getOpenStatus().equals("N"))
            {
                txt_shopDateOpnstatus.setText("CLOSE");

            }
            else{
                txt_shopDateOpnstatus.setText(" ");
            }
        }

        if( shopDetails.getAdressList().size()>0)
        {
            //Log.e("test","@@@@@@@@@@@11111111111111111");
            String line1= shopDetails.getAdressList().get(0).getLine1();
            String line2= shopDetails.getAdressList().get(0).getLine2();
            String area= shopDetails.getAdressList().get(0).getArea();
            String area2= shopDetails.getAdressList().get(0).getArea2();
            int  pincode= shopDetails.getAdressList().get(0).getPincode();
            String areacpmt1=line1+" ,"+line2+", "+ area +" "+"PIN CODE:"+pincode+"";
            txt_shopAdress.setText(areacpmt1);
            txt_shopaddress.setText(areacpmt1);

        }


        if( shopDetails.getContList().size()>0)
        {
            if(shopDetails.getContList().get(0).getMobVisible().equals("Y"))
            {


                phoneNo=shopDetails.getContList().get(0).getMobileNo();
                txt_shopaphno.setText(shopDetails.getContList().get(0).getMobileNo());
            }

            if(shopDetails.getContList().get(0).getEmailVisible().equals("Y"))
            {

                txt_email.setText(shopDetails.getContList().get(0).getMobileNo());
            }

        }

        if(shopDetails.getImageList().size()>0)
        {
            Picasso.with(ShopDetailsActivity.this).load(shopDetails.getImageList().get(0).getImageUrl()).resize(340, 240).into(shopImageViewMain);
            recyclerImageViewadapter = new ShopImagesViewAdapter(shopDetails.getImageList(),ShopDetailsActivity.this);
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(ShopDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false);


            recyclerViewImageView.setLayoutManager(layoutManager);
            recyclerViewImageView.setAdapter(recyclerImageViewadapter);


        }


        if(shopDetails.getContentList().size()>0)
        {

            recyclerContentViewadapter = new ShopContentViewAdapter(shopDetails.getContentList(),ShopDetailsActivity.this);

            recyclerViewShopContent.setAdapter(recyclerContentViewadapter);
        }








        /*private ImageView shopImageViewMain;
        private TextView txtv_shopname;
        private TextView txt_shopDateOpnstatus;
        private TextView txt_shopViews;
        private TextView txt_shopAdress;
        private Button btn_call;
        private Button btn_whatsapp;
        private Button btn_share;
        private Button shop_btn_bestdeals;
        private TextView txt_shopaddress;
        private TextView txt_shopaphno;
        private TextView txt_shoptmming;
        private TextView txt_shopowner;
        private RecyclerView shop_imageslist_recyclerviewc;
        private TextView txt_email;
        private RecyclerView shop_content_recyclerviewc;*/



    }



    public void onCall(String phNO ) {

        //Intent callIntent = new Intent(Intent.ACTION_CALL); //use ACTION_CALL class
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phNO));    //this is the phone number calling

        //check permission
        //If the device is running Android 6.0 (API level 23) and the app's targetSdkVersion is 23 or higher,
        //the system asks the user to grant approval.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //request permission from user if the app hasn't got the required permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                    10);

            return;
        }else {     //have got permission
            try{

                startActivity(callIntent);  //call activity and make phone call
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded", Toast.LENGTH_SHORT).show();
            }
        }
    }



    private boolean whatsappInstalledOrNot1(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            //pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);

            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }


    private void whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();

        try {


            String toNumber = "xxxxxxxxxx"; // Replace with mobile phone number without +Sign or leading zeros, but with country code.
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.



           /* Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + "9945084447" + "?body=" + "tedsttttt"));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);*/



            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"9945085447"+"&text="+"shop name "+shopName));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"it may be you dont have whats app",Toast.LENGTH_LONG).show();

        }


    }


}