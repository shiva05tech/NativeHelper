package com.ais.nativehelper.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.ais.nativehelper.R;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.NewsHeadline;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

public class NewsHeadingViewAdapter  extends RecyclerView.Adapter<NewsHeadingViewAdapter.ViewHolder> {

    Context context;
    List<NewsHeadline> getDataAdapter;
    ImageLoader imageLoader1;

    public NewsHeadingViewAdapter(List<NewsHeadline> getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    public NewsHeadingViewAdapter(List<NewsHeadline> getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
                if(GlobalController.NEWS_LIST_RECYCLE_CODE==2)
                {
                    v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_new_recycleview, parent, false);
                }
                else
                {
                     v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_recycle, parent, false);
                }



        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        NewsHeadline getDataAdapter1 =  getDataAdapter.get(position);
        Log.e("URL","****************");
        Log.e("URL",getDataAdapter1.getImageUrl());
        Log.e("URL","****************");


        Log.e("URL","*"+getDataAdapter1.getNewscloseDate());
        Log.e("URL","****************");

        /*imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader1.get("http://192.168.0129:8080/downloadFile/20202250120794891/New%20Doc%202020-01-21%2010.57.08_1.jpg",
                ImageLoader.getImageListener(
                        Viewholder.newsImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );*/

       // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);
        Picasso.with(context).load(getDataAdapter1.getImageUrl()).resize(340, 240).into(Viewholder.newsImageView);
        if(getDataAdapter1.getLanguageType().equals("2")){
            Viewholder.txt_newsheading.setTextAppearance(context, R.style.font_news_kannda_heading);
        }
        Viewholder.txt_newsheading.setText(getDataAdapter1.getNewsHeading());
        Viewholder.txt_newsDate.setText(""+getDataAdapter1.getNewscloseDate());

        Viewholder.txt_newsreporter.setText(getDataAdapter1.getViews()+" views");

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

              public TextView txt_newsheading;
        public TextView txt_newsDate;
        public TextView  txt_newsreporter;
        public ImageView newsImageView;

        public ViewHolder(View itemView) {

            super(itemView);

            txt_newsheading = (TextView) itemView.findViewById(R.id.txt_newsheading);
            txt_newsDate = (TextView) itemView.findViewById(R.id.txt_newsDate);
            txt_newsreporter = (TextView) itemView.findViewById(R.id.txt_newsreporter);

            newsImageView = (ImageView) itemView.findViewById(R.id.newsImageView) ;
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
}