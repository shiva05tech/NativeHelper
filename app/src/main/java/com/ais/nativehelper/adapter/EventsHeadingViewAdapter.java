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

        Picasso pk=getImageLoader(context);
        pk.load(getDataAdapter1.getImageUrl()).resize(340, 240).into(Viewholder.events_imageView);

        //Picasso.with(context).load(urlll).resize(340, 240).into(Viewholder.shopImageView);
      /*  if(getDataAdapter1.getLanguageType().equals("2")){
            Viewholder.txt_shopName.setTextAppearance(context, R.style.font_news_kannda_heading);
        }
        Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
       Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        Viewholder.txt_shopName.setText(getDataAdapter1.getShopName());
        Viewholder.txt_catName.setText(""+getDataAdapter1.getCatName());
        Viewholder.txt_shopTitle.setText(getDataAdapter1.getShopTitle());
        Viewholder.txt_ownerName.setText(""+getDataAdapter1.getName());

        Viewholder.txt_shopViews.setText(getDataAdapter1.getView()+" views");*/





    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        /*public TextView txt_shopName;
        public TextView txt_catName;
        public TextView  txt_shopTitle;
        public TextView txt_ownerName;
        public TextView txt_shopViews;*/
        public ImageView events_imageView;

        public ViewHolder(View itemView) {

            super(itemView);

            /*txt_shopName = (TextView) itemView.findViewById(R.id.txt_shopName);
            txt_catName = (TextView) itemView.findViewById(R.id.txt_catName);
            txt_shopTitle = (TextView) itemView.findViewById(R.id.txt_shopTitle);
            txt_ownerName = (TextView) itemView.findViewById(R.id.txt_ownerName);
            txt_shopViews = (TextView) itemView.findViewById(R.id.txt_shopViews);*/


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