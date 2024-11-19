package com.ais.nativehelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.ais.nativehelper.R;
import com.ais.nativehelper.model.ShopImages;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

public class ShopImagesViewAdapter extends RecyclerView.Adapter<ShopImagesViewAdapter.ViewHolder>{
    Context context;
    List<ShopImages> getDataAdapter;
    ImageLoader imageLoader1;

    public ShopImagesViewAdapter(List<ShopImages>  getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    public ShopImagesViewAdapter(List<ShopImages>  getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_imagelist_recycleview, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        ShopImages getDataAdapter1 =  getDataAdapter.get(position);


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

     Picasso.with(context).load(getDataAdapter1.getImageUrl()).resize(340, 240).into(Viewholder.shopImagesView);

        //Picasso.with(context).load(urlll).resize(340, 240).into(Viewholder.shopImagesView);




    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


      /*  public TextView txt_shopName;*/

        public ImageView shopImagesView;

        public ViewHolder(View itemView) {

            super(itemView);
            shopImagesView =  itemView.findViewById(R.id.shopImagesView) ;
          /*  txt_shopName = (TextView) itemView.findViewById(R.id.txt_shopName);*/
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