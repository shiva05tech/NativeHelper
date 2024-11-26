package com.ais.nativehelper.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.ais.nativehelper.R;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ShopHeader;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.UrlConnectionDownloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

public class EventsHeadingViewAdapter  extends RecyclerView.Adapter<EventsHeadingViewAdapter.ViewHolder>{
    Context context;
    List<ShopHeader> getDataAdapter;
    ImageLoader imageLoader1;

    public EventsHeadingViewAdapter(List<ShopHeader> getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    public EventsHeadingViewAdapter(List<ShopHeader> getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_list_recycle, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        ShopHeader getDataAdapter1 =  getDataAdapter.get(position);


        /*imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader1.get("http://192.168.0129:8080/downloadFile/20202250120794891/New%20Doc%202020-01-21%2010.57.08_1.jpg",
                ImageLoader.getImageListener(
                        Viewholder.newsImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );*/
//String urlll="https://valar.in/wp-content/uploads/2019/08/cropped-are-you-gonna-open-new-shop-opening-ceremony.jpg";
        // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);


        Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        Log.e("%&&&&&&&&&&&&&&&&&&&",getDataAdapter1.getImageUrl());
        Log.e("%&&&&&&&&&&&&&&&&&&&",getDataAdapter1.getImageUrl());
        Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
if(getDataAdapter1.getImageUrl()!=null){
    Picasso pk=getImageLoader(context);
    pk.load(getDataAdapter1.getImageUrl()).resize(340, 240).into(Viewholder.events_imageView);
        }









        //Picasso.with(context).load(urlll).resize(340, 240).into(Viewholder.shopImageView);
       if(getDataAdapter1.getLanguageType().equals("2")){
            Viewholder.txt_eventsName.setTextAppearance(context, R.style.font_news_kannda_heading);
        }
       else{
           Viewholder.txt_eventsName.setText(getDataAdapter1.getShopName());
       }
        Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
       Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");

        Viewholder.txt_eventCat.setText(""+getDataAdapter1.getCatName());
        Viewholder.txt_evenTitle.setText(getDataAdapter1.getShopTitle());
        Viewholder.txt_eventownerName.setText(""+getDataAdapter1.getName());

        Viewholder.txt_eventViews.setText(getDataAdapter1.getView()+" views");





    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


       public TextView txt_eventsName;
        public TextView txt_eventCat;
        public TextView  txt_evenTitle;
        public TextView txt_eventownerName;
        public TextView txt_eventViews;
        public ImageView events_imageView;

        public ViewHolder(View itemView) {

            super(itemView);


           txt_eventsName = (TextView) itemView.findViewById(R.id.txt_eventsName);
            txt_eventCat = (TextView) itemView.findViewById(R.id.txt_eventCat);
            txt_evenTitle = (TextView) itemView.findViewById(R.id.txt_evenTitle);
            txt_eventViews = (TextView) itemView.findViewById(R.id.txt_eventViews);
            txt_eventownerName = (TextView) itemView.findViewById(R.id.txt_eventownerName);


            events_imageView = (ImageView) itemView.findViewById(R.id.events_imageView) ;
          /*  img_jobs_experience1= (NetworkImageView) itemView.findViewById(R.id.img_jobs_experience1);
            img_jobs_PayScale1= (NetworkImageView) itemView.findViewById(R.id.img_jobs_PayScale1);
            img_jobs_Active1= (NetworkImageView) itemView.findViewById(R.id.img_jobs_Active1);*/

        }
    }

    String concatList(List<String> sList, String separator)
    {
        Iterator<String> iter = sList.iterator();
        StringBuilder sb = new StringBuilder();

        while (iter.hasNext())
        {
            sb.append(iter.next()).append( iter.hasNext() ? separator : "");
        }
        return sb.toString();
    }


    public static Picasso getImageLoader(Context ctx) {
        Picasso.Builder builder = new Picasso.Builder(ctx);

        builder.downloader(new UrlConnectionDownloader(ctx) {
            @Override
            protected HttpURLConnection openConnection(Uri uri) throws IOException {
                HttpURLConnection connection = super.openConnection(uri);
                connection.setRequestProperty("Authorization", GlobalController.ACCESSTOKEN1);

                return connection;
            }
        });

        return builder.build();
    }

    public static Picasso getImageLoader1(Context ctx) {
        Picasso.Builder builder = new Picasso.Builder(ctx);

        builder.downloader(new UrlConnectionDownloader(ctx) {
            @Override
            protected HttpURLConnection openConnection(Uri uri) throws IOException {
                HttpURLConnection connection = super.openConnection(uri);
                connection.setRequestProperty( "Authorization", GlobalController.ACCESSTOKEN1);

                return connection;
            }
        });

        return builder.build();
    }






}