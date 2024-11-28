package com.ais.nativehelper;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.ais.nativehelper.adapter.NewsContentAdapter;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ApiRequestSingleton;
import com.ais.nativehelper.netowork_info.CheckConnectivity;
import com.ais.nativehelper.ùtil.DateConverstion;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ais.nativehelper.databinding.ActivityNewsDetailsBinding;

public class NewsDetailsActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityNewsDetailsBinding binding;

    private String MESSAGE;
    private String TAG="NewsDetails";
    private ProgressDialog progressDialog;
    private String task;
    private String newsId;
    private Context context;
    private static  String newsDetailsUrl;


    List<String > contentList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    public TextView txt_newsheading;
    public TextView txt_newsDate;
    public TextView  txt_newsreporter;
    public TextView   txt_newsViews;
    public ImageView newsImageView;


    private void initialize(){
        context=NewsDetailsActivity.this;
        txt_newsheading= (TextView) findViewById(R.id.txt_newsheadingc);
        txt_newsDate= (TextView) findViewById(R.id.txt_newsDatec);
        txt_newsreporter= (TextView) findViewById(R.id.txt_newsreporterc);
        // txt_content= (WebView) findViewById(R.id.txt_content);
        newsImageView= (ImageView) findViewById(R.id.newsImageViewc);
        txt_newsViews=(TextView) findViewById(R.id.txt_newsViews);

        //recycle view click event
        contentList = new ArrayList<>();
        //Card View
        recyclerView = (RecyclerView) findViewById(R.id.news_headline_recyclerviewc);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
       /* recyclerViewadapter=new NewsContentAdapter(contentList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerViewadapter);*/



        task=getIntent().getStringExtra("TASK");
        newsId=getIntent().getStringExtra(GlobalController.KEY_NEWSID);
        //URL MAKKING
        if (GlobalController.APPUSERID!=null){
            newsDetailsUrl=GlobalController.API_NEWSDETAILS+newsId+"/"+GlobalController.APPUSERID;
            // APPUSERID,DAPPUSERID
        }
        else{
            newsDetailsUrl=GlobalController.API_NEWSDETAILS+newsId+"/"+GlobalController.DAPPUSERID;
        }
        Log.e(TAG,"%%%%%%%%%%%%%%%%%%%%%");
        Log.e(TAG,newsDetailsUrl);
        Log.e(TAG,"%%%%%%%%%%%%%%%%%%%%%");




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        initialize();

        //check connectivity
        CheckConnectivity connectivity=new CheckConnectivity();
        boolean networkINfo=false;
        networkINfo=connectivity.checkNow(NewsDetailsActivity.this);
        Log.e(TAG,""+networkINfo);

        Log.e(TAG,"111111111111111111");
        if (networkINfo){
            // Calling Jobs List
            //set canditate Details
            Log.e(TAG,"22222222222222222");
            getNewsDetails();
            Log.e(TAG,"22222222222222222");
        }
        else {
            Intent intent=new Intent(NewsDetailsActivity.this,NetworkInfo.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }
    }

    private void getNewsDetails() {
        progressDialog = new ProgressDialog(NewsDetailsActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        Map<String, String> params= new HashMap<String, String>();

        Log.e(TAG,"8888888888888888888888");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(newsDetailsUrl,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // JSONObject response1 = new JSONObject(response.toString());
                            // JSONObject response1 =  response;
                            String message;
                            Log.e(TAG,"%%%%%%%%%%%%%%%%%%%%%");
                            Log.e(TAG,response.toString());
                            Log.e(TAG,"%%%%%%%%%%%%%%%%%%%%%");
                            Log.e(TAG,"44444444");




                            //Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6Gl3A1OvR
                            boolean check=response.has("message");
                            Log.e(TAG,"11111111");
                            Log.e(TAG,""+check);
                            Log.e(TAG,"11111111");
                            if(check){
                                message=response.getString("message");

                                if (message.equals("success")){

                                    Log.e(TAG,"11111111");
                                    Log.e(TAG,""+message);
                                    Log.e(TAG,"11111111");
                                    repoenceHandling(response);



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
                    Log.e(TAG,jsonError);
                    // Print Error!
                }
                //Log.e(TAG,error.getMessage());

                if(error instanceof ServerError)

                {
                    Log.e(TAG,"################");
                }

                Log.e(TAG,"55555555555555555555");
                if (null != error.networkResponse)
                {
                    Log.e(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);
                }
                Log.e(TAG,GlobalController.API_HEADLINES);
                progressDialog.dismiss();
                Intent intent=new Intent(NewsDetailsActivity.this,NetworkInfo.class);
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
                Log.e(TAG + ": ", "Error Response code: " + "$$$$$$$$$$$$$$$$");
                Log.e(TAG + ": ", "Error Response code: " + GlobalController.ACCESSTOKEN1);
                Log.e(TAG + ": ", "Error Response code: " + "$$$$$$$$$$$$$$$$");
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
        Log.e(TAG,"88888888888");
        ApiRequestSingleton.getInstance(NewsDetailsActivity.this).addToRequestQueue(jsonObjReq);
        Log.e(TAG,"9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }


    //Repsonce handling
    private void repoenceHandling(JSONObject response)
    {
        Log.e(TAG,"222222");


        List<String> contentlist =new ArrayList<>();
        List<String> imageUrllist =new ArrayList<>();

        try {

            if(response.has("news")){
                String  languageType="1";
                Log.e(TAG,"33333");
                Log.e(TAG,""+"true");
                Log.e(TAG,"33333");

                JSONObject news=response.getJSONObject("news");
                if(news.getString("finalStatus").equals("PSD")){
                    Log.e(TAG,"33333");
                    Log.e(TAG,news.getString("finalStatus"));
                    Log.e(TAG,"33333");
                    String newsHeading=news.getString("newsHeading");
                    Log.e(TAG,"11");
                    long newsID =news.getLong("newsID");
                    languageType=news.getString("languageType");
                    Long createdBy=news.getLong("createdBy");
                    String createdDate= DateConverstion.StringToDate(news.getString("createdDate"));
                    Integer newsCategory=news.getInt("newsCategory");
                    Integer newsStatus=news.getInt("newsStatus");
                    //String newsCloseDate=DateConverstion.StringToDate(news.getString("newsCloseDate")); ;
                    String finalStatus=news.getString("finalStatus");
                    String userName=news.getString("userName") ;
                    long userId=news.getLong("userId");
                    String emailId=news.getString("emailId") ;
                    String views=news.getString("viewCont") ;


                    //seting fot to the text view
                    if(languageType.equals("2")){
                             /*Typeface typeface = ResourcesCompat.getFont(this, R.font.kedagebb);              txt_newsheading.setTextAppearance(context, R.style.font_news_kannda_heading);
                             Typeface typeface = getResources.getFont(R.font.roboto);
                             textView.setTypeface(typeface);*/
                        txt_newsheading.setTextAppearance(context, R.style.font_news_kannda_heading);
                    }
                    txt_newsheading.setTextAppearance(context, R.style.font_news_kannda_heading);
                    txt_newsheading.setText(newsHeading);
                    txt_newsDate.setText(""+createdDate);
                    txt_newsreporter.setText(userName);
                    txt_newsViews.setText(views+"views");
                    Log.e(TAG,"444444");
                    Log.e(TAG,news.getString("finalStatus"));
                    Log.e(TAG,"444444");
                }
                //GETTING IMAGE URL
                if(news.has("imagesList")){

                    JSONArray imagesList=news.getJSONArray("imagesList");


                    if (imagesList != null) {
                        Log.e(TAG,"66666");
                        Log.e(TAG,imagesList.toString());
                        Log.e(TAG,""+imagesList.length());
                        Log.e(TAG,"66666");
                        for (int k=0;k<imagesList.length();k++){
                            JSONObject imageUrl = (JSONObject) imagesList.get(k);
                            if(imageUrl.getString("status").equals("PSD")){
                                Log.e(TAG,"12121");
                                Log.e(TAG,imageUrl.toString());
                                Log.e(TAG,"1313");

                                imageUrllist.add(imageUrl.getString("imageUrl"));
                                Log.e(TAG,"1313");
                                Log.e(TAG,imageUrl.getString("imageUrl"));
                                Log.e(TAG,"1414");

                            }

                        }
                    }

                    //Picasso.with(context).load(imageUrllist.get(0)).resize(340, 300).into(newsImageView);
                    Log.e(TAG,"7777777");
                    if (imageUrllist.size()>0){
                        Picasso.with(context).load(imageUrllist.get(0)).into(newsImageView);
                        Log.e(TAG,"7777777");
                    }



                }
                //CONTENT EXTRACT
                Log.e(TAG,"222222");
                if(news.has("contentlist")){
                    Log.e(TAG,"111");
                    JSONArray newsContents=news.getJSONArray("contentlist");

                    if (newsContents != null) {
                        Log.e(TAG,"2222");
                        for (int k=0;k<newsContents.length();k++){

                            JSONObject newscontent = (JSONObject) newsContents.get(k);

                            Log.e(TAG,"333");
                            Log.e(TAG,newscontent.toString());
                            Log.e(TAG,"333");

                            if(newscontent.getString("status").equals("PSD")){
                                Log.e(TAG,"444");
                                Log.e(TAG,newscontent.toString());
                                Log.e(TAG,"444");
                                String[] arrayOctent=newscontent.getString("newsContent").split("\\.");
                                // String contet="";
                                for (String cont : arrayOctent) {
                                    String con=cont+" "+"."+" ";



                                    contentlist.add((con));
                                    // contet=contet+con+"<br />";




                                }

                                //String str2 = "Line number 1 <br /> Line number 2";
                                //need to import android.text.Html class
                                    /* String htmlText = " %s ";
                                   //  txt_content.loadData(String.format(htmlText, contet), "text/html", "utf-8");
                                     //Font must be placed in assets/fonts folder
                                     String text = "<html><style type='text/css'>@font-face { font-family: spqr; src: url('font/kedagen.ttf'); } body p {font-family: spqr;}</style>"
                                             + "<body >" + "<p align=\"justify\" style=\"font-size: 22px; font-family: spqr;\">" + contet + "</p> "+ "</body></html>";

                                     txt_content.loadDataWithBaseURL("file:///",text,"text/html","utf-8",null);
*/

                            }

                        }
                    }

                    recyclerViewadapter = new NewsContentAdapter(contentlist, NewsDetailsActivity.this,languageType);
                    recyclerView.setAdapter(recyclerViewadapter);
                }
                //IMAGE







                progressDialog.dismiss();
            }
            else {

            }





        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG,"99999");
            Log.e(TAG,e.toString());
            Log.e(TAG,"99999");
            progressDialog.dismiss();


            Intent intent=new Intent(NewsDetailsActivity.this,NetworkInfo.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }


    }

}