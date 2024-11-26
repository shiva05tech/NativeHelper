package com.ais.nativehelper;

import android.os.Bundle;

import com.ais.nativehelper.adapter.NewsHeadingViewAdapter;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ApiRequestSingleton;
import com.ais.nativehelper.model.NewsHeadline;
import com.ais.nativehelper.netowork_info.CheckConnectivity;
import com.ais.nativehelper.ùtil.DateConverstion;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.ais.nativehelper.databinding.ActivityNewsListBinding;

public class NewsListActivity extends BaseActivity2 {

    private AppBarConfiguration appBarConfiguration;
    private ActivityNewsListBinding binding;

    private String MESSAGE;
    private String TAG="NEWS";
    private ProgressDialog progressDialog;

    private List<NewsHeadline> headlineList;
    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager recyclerViewlayoutManager;
    private RecyclerView.Adapter recyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

     /*   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_news_list);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);*/

       // bottomNavigationExecute(NewsListActivity.this);






        //recycle view click event
        headlineList = new ArrayList<>();
        //Card View
        recyclerView = (RecyclerView) findViewById(R.id.news_headline_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // recyclerViewadapter=new NewsHeadingViewAdapter(headlineList);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.setAdapter(recyclerViewadapter);






        //check connectivity
        CheckConnectivity connectivity=new CheckConnectivity();
        boolean networkINfo=false;
        networkINfo=connectivity.checkNow(NewsListActivity.this);
        Log.e("TEST",""+networkINfo);

        Log.e("TEST","111111111111111111");
        if (networkINfo){
            // Calling Jobs List
            //set canditate Details
            Log.e("TEST","22222222222222222");
            getNewsHeadings();
            Log.e("TEST","22222222222222222");
        }
        else {
            Intent intent=new Intent(NewsListActivity.this,NetworkInfo.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        //recycle view click event
        headlineList = new ArrayList<>();
        //Card View
        recyclerView = (RecyclerView) findViewById(R.id.news_headline_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // recyclerViewadapter=new NewsHeadingViewAdapter(headlineList);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.setAdapter(recyclerViewadapter);

        //getting the recyclerview from xml




        recyclerView.addOnItemTouchListener(new NewsListActivity.RecyclerTouchListener(getApplicationContext(), recyclerView, new NewsListActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NewsHeadline headline = headlineList.get(position);
                Intent intent=new Intent(NewsListActivity.this,NewsDetailsActivity.class);
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



    }




    //recycle view click activity
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private NewsListActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final NewsListActivity.ClickListener clickListener) {
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

    private void getNewsHeadings() {
        progressDialog = new ProgressDialog(NewsListActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
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
                            Log.e("test","%%%%%%%%%%%%%%%%%%%%%");
                            Log.e("test",response.toString());
                            Log.e("test","%%%%%%%%%%%%%%%%%%%%%");
                            Log.e("test","44444444");




                            //Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6Gl3A1OvR
                            boolean check=response.has("message");

                            if(check){
                                message=response.getString("message");

                                if (message.equals("success")){
                                    System.out.println(GlobalController.ACCESSTOKEN1);



                                    if(response.has("headLines")){
                                        JSONArray jsonHeadLines=response.getJSONArray("headLines");

                                        if (jsonHeadLines != null) {
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
                            recyclerViewadapter = new NewsHeadingViewAdapter(headlineList,NewsListActivity.this);

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
                if (null != error.networkResponse)
                {
                    Log.e(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);
                }
                Log.e("TEST",GlobalController.API_HEADLINES);
                progressDialog.dismiss();
                Intent intent=new Intent(NewsListActivity.this,NetworkInfo.class);
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
        ApiRequestSingleton.getInstance(NewsListActivity.this).addToRequestQueue(jsonObjReq);
        Log.e("test","9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }


}