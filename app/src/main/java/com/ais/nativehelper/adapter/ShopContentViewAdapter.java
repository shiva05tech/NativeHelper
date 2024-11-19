package com.ais.nativehelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.ais.nativehelper.R;
import com.ais.nativehelper.model.ShopContent;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopContentViewAdapter extends RecyclerView.Adapter<ShopContentViewAdapter.ViewHolder>{
    Context context;
    List<ShopContent> getDataAdapter;
    ImageLoader imageLoader1;
    public ShopContentViewAdapter(List<ShopContent> getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    public ShopContentViewAdapter(List<ShopContent> getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_contents_recycleview, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        ShopContent getDataAdapter1 =  getDataAdapter.get(position);




        if(getDataAdapter1.getLanguageType()==2){
            Viewholder.txt_shopconttitle.setTextAppearance(context, R.style.font_news_kannda_heading);
            Viewholder.txt_shopcontents.setTextAppearance(context, R.style.font_news_kannda_content);
        }
        // Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        //Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        Viewholder.txt_shopconttitle.setText(getDataAdapter1.getTitle());
        Viewholder.txt_shopcontents.setText(""+getDataAdapter1.getShopContent());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{


        public TextView txt_shopconttitle;
        public TextView txt_shopcontents;


        public ViewHolder(View itemView) {

            super(itemView);

            txt_shopconttitle = (TextView) itemView.findViewById(R.id.txt_shopconttitle);
            txt_shopcontents = (TextView) itemView.findViewById(R.id.txt_shopcontents);




          /*  img_jobs_experience1= (NetworkImageView) itemView.findViewById(R.id.img_jobs_experience1);
            img_jobs_PayScale1= (NetworkImageView) itemView.findViewById(R.id.img_jobs_PayScale1);
            img_jobs_Active1= (NetworkImageView) itemView.findViewById(R.id.img_jobs_Active1);*/

        }
    }

}
