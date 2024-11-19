package com.ais.nativehelper.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


import com.ais.nativehelper.HomeScrollingActivity;
import com.ais.nativehelper.NetworkInfo;
import com.ais.nativehelper.global.GlobalController;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginControl  extends Application {

    private static LoginControl loginControl=null;
    private GlobalController globalController;
    private CurrentUserModel currentUserModel;

    private String userEmail;
    private String userName;
    private String userPassword;
    private String accessToken;
    private String TAG="LoginControl.java";


    @Override
    public void onCreate() {
        super.onCreate();
    }

    private LoginControl(){

    }

    public static LoginControl getLoginControl(){
        if (loginControl==null){
            loginControl=new LoginControl();
        }
        return loginControl;
    }

    public void getUserId(Context context){

        globalController= new GlobalController();


      /*  currentUserModel=globalController.getCurrentUserDetails(context);
        userEmail=currentUserModel.getUserEmail();
        userPassword=currentUserModel.getUserPassword();
        userName=currentUserModel.getUserName();*/
        Log.e("test","333333333");
        LoginReq(context);
        Log.e("test123","666666666");

    }


    private void LoginReq(final Context context) {

        Map<String, String> params= new HashMap<String, String>();
        Log.e("test",GlobalController.API_SIGNIN);

       // params.put("key",GlobalController.API_KEY);
        params.put("usernameOrEmail", "shivu");
        params.put("password","123456");

       /* params.put("key",GlobalController.API_KEY);
        params.put("usernameOrEmail", userEmail);
        params.put("password",userPassword);*/
       /* params.put("email_id", "androidtest@gmail.com");
        params.put("password","12345678");*/

        //params.put("ip", GlobalController.divice_ip);


        Log.e("test","8888888888888888888888");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                GlobalController.API_SIGNIN, new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            Log.e("test","44444444");
                            boolean check=response.has("accessToken");

                            if(check){
                                accessToken=response.getString("accessToken");

                                if (accessToken!=null){

                                    String tokenType=response.getString("tokenType");
                                    //String name=response.getString("name");


                                    if(response.has("accessToken")){

                                        GlobalController.ACCESSTOKEN1= response.getString("tokenType")+" "+response.getString("accessToken");
                                        System.out.println(GlobalController.ACCESSTOKEN1);
                                        Intent intent = new Intent(context, HomeScrollingActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent);


                                    }
                                    else {
                                        Intent intent = new Intent(context, NetworkInfo.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent);
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


                        } catch (JSONException e) {
                            Log.e(GlobalController.LOG_JSonException_TAG, "JSONException:" + e);
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e(TAG, "Error1234555: " + error.getMessage());
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
                //context.progressDialog.dismiss();
              /*  Intent intent=new Intent(context.this,NetworkInfo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();*/
                /*hideProgressDialog();*/
                VolleyLog.e(TAG, "Error: " + error.getMessage());
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
                /*hideProgressDialog();*/
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }



        };

        // Adding request to request queue
        /* AppController.getInstance().addToRequestQueue(jsonObjReq,tag_json_obj);*/
        Log.e("test","88888888888");
        ApiRequestSingleton.getInstance(context).addToRequestQueue(jsonObjReq);
        Log.e("test","9999999999");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }
}