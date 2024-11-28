package com.ais.nativehelper.adapter;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.ais.nativehelper.R;
import com.android.volley.toolbox.ImageLoader;

import java.util.Iterator;
import java.util.List;

public class NewsContentAdapter  extends RecyclerView.Adapter<NewsContentAdapter.ViewHolder> {

    Context context;

    List<String> getDataAdapter;
    ImageLoader imageLoader1;
    String languageType;

    public NewsContentAdapter(List<String> getDataAdapter, Context context, String languageType){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        this.languageType=languageType;
    }

    public NewsContentAdapter(List<String> getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_txgt_content, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        String  content =  getDataAdapter.get(position);


        /*imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader1.get("http://192.168.0129:8080/downloadFile/20202250120794891/New%20Doc%202020-01-21%2010.57.08_1.jpg",
                ImageLoader.getImageListener(
                        Viewholder.newsImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );*/

        // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);
        if(languageType.equals("2")){
            Viewholder.webview_content.setTextAppearance(context, R.style.font_news_kannda_content);
            Viewholder.webview_content.setText(Html.fromHtml(content));
           // Viewholder.webview_content.loadData("<html><body>"+content+"!</body></html>  "text/html", "UTF-8");",
           // Viewholder.webview_content.setText(Html.fromHtml(content));

        }
        //Viewholder.webview_content.loadData(content, "text/html", "UTF-8",null);
       /* Viewholder.webview_content.loadData(content, "text/html", "UTF-8");
        Viewholder.webview_content.requestFocus();
        Viewholder.webview_content.getSettings().setLightTouchEnabled(true);
        Viewholder.webview_content.getSettings().setJavaScriptEnabled(true);
        Viewholder.webview_content.getSettings().setGeolocationEnabled(true);
        Viewholder.webview_content.setSoundEffectsEnabled(true);
        Viewholder.webview_content.loadData("<html><body>"+content+"!</body></html>",
                "text/html", "UTF-8");*/
        Viewholder.webview_content.setTextAppearance(context, R.style.font_news_kannda_content);
        Viewholder.webview_content.setText(Html.fromHtml(content));
    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView webview_content;


        public ViewHolder(View itemView) {

            super(itemView);


            webview_content = (TextView) itemView.findViewById(R.id.textView_content);

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
