package com.ais.nativehelper.global;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.widget.Toast;


import com.ais.nativehelper.model.CurrentUserModel;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class GlobalController extends Application {

    public static String  ACCESSTOKEN1;
    public static String APPUSERID;
    public static String DAPPUSERID="1000000000";
    public static final String API_URI="http://localhost:8080/";
   // public static final String API_URI="http://103.117.180.14:8080/news/";
    //public static final String API_URI="http://192.168.43.190:9090/";

    // public static final String API_URI="http://192.168.157.33:8080/newsapps/";
    public static final String API_SIGNIN =API_URI+"api/auth/signin";
    public static final String API_HEADLINES =API_URI+"api/news/headlines/1000000000/0/10";
    public static final String API_SIGNUP=API_URI+"api/auth/signup";
    public static final String API_NEWSDETAILS=API_URI+"api/news/details/";
    //http://localhost:8080/api/news/headlines/1000000000

    public static final String API_SHOPLISTBYCATANDSUBCAT=API_URI+"api/shops/shopsbymcts/";
    public static final String API_SHOPDETAILS=API_URI+"api/shops/shpdetails/";
    public static final String API_ONLINEITEMSURL=API_URI+"api/onlitms/";
    public static final String API_ONLINEITEMSURL_BY_MCAT=API_ONLINEITEMSURL+"itmsbymcts/";




    public static final String API_GET_IP =API_URI+"get_ip.php";


    public static final String API_SELECTDATA_MARITALSTATUS =API_URI+"list_marital_status.php?key=hNfkSfrSeTTZwCp3YfABEKPqHTOCcVRlvX9eWaqU2dPy4nruDa36wOUlP3AM/k";
    public static final String API_GET_CANDIDATES_DETAILS=API_URI+"get_candidate_details.php";
    public static final String API_GET_CANDIDATES_ADDRESS=API_URI+"get_address.php";

    public static final String API_GET_X_DETAILS=API_URI+"get_education_x.php";
    public static final String API_GET_XII_DETAILS=API_URI+"get_education_xii.php";
    public static final String API_GET_BG_DETAILS=API_URI+"get_education_bg.php";
    public static final String API_GET_PG_DETAILS=API_URI+"get_education_pg.php";
    public static final String API_GET_DR_DETAILS=API_URI+"get_education_d_p.php";

    public static final String API_GET_EXP_DETAILS=API_URI+"get_experience_details.php";

    public static final String API_GET_JOBS_LIST=API_URI+"job_search.php";

    public static final String API_GET_PROMO_CODE_URI=API_URI+"promo_code_existing.php";



    public static final String LOG_JSonException_TAG ="JSonException :";



    //IP ADRESS
    public static String divice_ip=null;

    //APP ACCESS KEY
    public static final String API_KEY="hNfkSfrSeTTZwCp3YfABEKPqHTOCcVRlvX9eWaqU2dPy4nruDa36wOUlP3AM/k";

    //APP LOGIN ID



    //GLOBAL SHARING METHOD AREA
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences=null;
    private int PRIVATE_MODE=0;
    private final String PREFERANCE_NAME="jobsforme";

    //GLOBAL SHARING METHOD AREA KEYS

    public static final String KEY_USEREAMIL="USER_EMAIL";
    public static final String KEY_PASSWORD="USER_PASSWORD";
    public static final String KEY_USERNAME="APP_USERNAME";
    public static final String KEY_USERID="USERID_USERNAME";
    public static final String KEY_NEWSID="NEWSID";
    public static final String KEY_SHOPID="SHOPID";
    public static final String KEY_SHOPNAME="SHOPNAME";
    public static final String KEY_SHOPIMAGEURL="SHOPIMAGEURL";
    public static final String KEY_SHOPVIEWS="VIEWS";
    public static final String KEY_SHOPGALLARYIMAGE="GALLARYINAGEVIEW";

    //URLS FOR THE PERTICULOR CLASS
    public static final String KEY_URLFORNEXTCLASS="URL_CMPLT";
    public static final String KEY_URL_HEALTH="1/1/1/1";
    public static final String KEY_MAINCAT="MAIN_CATEGORY";
    public static final String KEY_HEALTH_CODE="1";

    public static final String KEY_URL_MARKET="1/1/1/2";
    public static final String KEY_MARKET_CODE="2";

    public static final String KEY_URL_TRANSPORT="1/1/1/3";
    public static final String KEY_TRANSPORT_CODE="3";

    public static final String KEY_URL_TEMPLES="1/1/1/4";
    public static final String KEY_TEMPLES_CODE="4";

    public static final String KEY_URL_MOVIES="1/1/1/5";
    public static final String KEY_MOVIES_CODE="5";



    public static final String IS_LOGIN = "IODHDT";
   /* public static final String KEY_NAME = "E";
    public static final String KEY_ADDRESS = "I";*/

    //LOGIN_TOKEN VARIABLE
    public static String Login_SessionId="NOT_DEFIND";
    public static  int NEWS_LIST_RECYCLE_CODE =0;



    public void localStoreLoginInfo(Context context , String email, String password, String name, String userID){
        String encryptUsermail;
        String encryptUserPassword;
        String encryptUserName;
        String encryptUserID;

        try {
            encryptUsermail=strinChainEncrypt(email);
            encryptUserPassword=strinChainEncrypt(password);
            encryptUserName=strinChainEncrypt(name);
            encryptUserName=strinChainEncrypt(name);
            encryptUserID=strinChainEncrypt(userID);



            sharedPreferences=getApplicationContext().getSharedPreferences(PREFERANCE_NAME,PRIVATE_MODE);
            editor=sharedPreferences.edit();
            editor.putBoolean(IS_LOGIN,true);

            editor.putString(KEY_USEREAMIL,encryptUsermail);
            editor.putString(KEY_PASSWORD,encryptUserPassword);
            editor.putString(KEY_USERNAME,encryptUserName);
            editor.putString(KEY_USERID,encryptUserName);

            editor.commit();

        }
        catch (Exception e){

        }

    }

    public CurrentUserModel getCurrentUserDetails(Context context){



        String decriptEmail;
        String decriptPassword;
        String decriptName;
        boolean is_login;

        CurrentUserModel obj= new CurrentUserModel();

        try {

            sharedPreferences=context.getSharedPreferences(PREFERANCE_NAME,PRIVATE_MODE);
            decriptEmail=stringChainDecrypt(sharedPreferences.getString(KEY_USEREAMIL,null));
            decriptPassword=stringChainDecrypt(sharedPreferences.getString(KEY_PASSWORD,null));
            decriptName=stringChainDecrypt(sharedPreferences.getString(KEY_USERNAME,null));


            is_login=sharedPreferences.getBoolean(IS_LOGIN,true);
            obj.setIs_login(is_login);
            obj.setUserEmail(decriptEmail);
            obj.setUserPassword(decriptPassword);
            obj.setUserName(decriptName);



        }catch (Exception e){

        }
        return obj;
    }


    //checking SignIn
    public boolean isSignedIn(Context context){

        sharedPreferences=context.getSharedPreferences(PREFERANCE_NAME,PRIVATE_MODE);
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


    //SingOut process
    public void signOut(Context context){
        //new AsyncTaskUnregisterGCM(context).execute();
        //storeRegistrationId("");
        sharedPreferences = context.getSharedPreferences(PREFERANCE_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Login_SessionId=null;

        Toast.makeText(context,"User Log Out Successfully",Toast.LENGTH_LONG).show();


    }


    //STRING ENCRYPTION AND DECRYPTION
    private String strinChainEncrypt(String string){

        return chainEncrypt(chainEncrypt(string));


    }

    private String stringChainDecrypt(String string){
        return chainDecrypt(chainDecrypt(string));
    }



    private String chainEncrypt(String string){
        try {
            return encrypt(encrypt(encrypt(encrypt(string))));
        } catch (Exception e) {
            return "";
        }
    }
    private String chainDecrypt(String string){
        try {
            return decrypt(decrypt(decrypt(decrypt(string))));
        } catch (Exception e) {
            return "";
        }
    }


    //Emcrypstion and decryption
    private final String ALGORITHM = "AES";
    private final byte[] keyValue = new byte[] { 'I', 'N', 'N', 'O', 'V', 'A', 'T', 'I', 'V', 'E', 'H', 'C', 'Y', 'H', 'E', 'A' };

    @SuppressLint("TrulyRandom")
    private String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = valueToEnc.getBytes("UTF-8");
        String encryptedValue = Base64.encodeToString(encValue, Base64.DEFAULT);

        return encryptedValue;
    }

    private String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] data = Base64.decode(encryptedValue, Base64.DEFAULT);
        String decryptedValue = new String(data, "UTF-8");
        return decryptedValue;
    }

    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }}






