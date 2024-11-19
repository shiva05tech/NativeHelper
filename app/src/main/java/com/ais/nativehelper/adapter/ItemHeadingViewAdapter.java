package com.ais.nativehelper.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.ais.nativehelper.R;
import com.ais.nativehelper.ShopDetailsActivity;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ItemHeader;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

public class ItemHeadingViewAdapter  extends RecyclerView.Adapter<ItemHeadingViewAdapter.ViewHolder>{
    Context context;
    List<ItemHeader> getDataAdapter;
    ImageLoader imageLoader1;
    String url1=null;

    public ItemHeadingViewAdapter(List<ItemHeader> getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    public ItemHeadingViewAdapter(List<ItemHeader> getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_items_list_recycleview, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        ItemHeader getDataAdapter1 =  getDataAdapter.get(position);



        /*imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader1.get("http://192.168.0129:8080/downloadFile/20202250120794891/New%20Doc%202020-01-21%2010.57.08_1.jpg",
                ImageLoader.getImageListener(
                        Viewholder.newsImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );*/
        if(getDataAdapter1.getLanType()==2){
            Viewholder.txt_itemName.setTextAppearance(context, R.style.font_news_kannda_heading);
            Viewholder.txt_brandName.setTextAppearance(context, R.style.font_news_kannda_heading);
        }
        // Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        //Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        String r="\u20B9";
        Viewholder.txt_itemName.setText(getDataAdapter1.getBrandName());
        Viewholder.txt_brandName.setText(" "+getDataAdapter1.geteName());
        Viewholder.txt_itemPrice.setText( r+" "+getDataAdapter1.getPrice());
        Viewholder.txt_ItemMrp.setText(r+" "+getDataAdapter1.getMrp());

        if((getDataAdapter1.getOnlitemUrl()!= null)  &&(!getDataAdapter1.getOnlitemUrl().equals("null")))
        {

            // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);
            url1=getDataAdapter1.getOnlitemUrl();
            //Picasso.with(context).load(getDataAdapter1.getOnlitemUrl()).resize(340, 240).into(Viewholder.itemImageView);

            Picasso.with(context).load(url1).resize(340, 240).into(Viewholder.itemImageView);

        }
        else if(getDataAdapter1.getItemImageUrl()!=null)
        {


           // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);
           // Picasso.with(context).load(getDataAdapter1.getItemImageUrl()).resize(340, 240).into(Viewholder.itemImageView);
            url1=getDataAdapter1.getItemImageUrl();
            Picasso.with(context).load(getDataAdapter1.getItemImageUrl()).resize(340, 240).into(Viewholder.itemImageView);

            Picasso.with(context).load(url1).resize(340, 240).into(Viewholder.itemImageView);

        }


        Viewholder.btn_online_shopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "text", Toast.LENGTH_LONG).show();
              Intent intent=new Intent(context, ShopDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("TASK","FROM NEWSHOME");
                intent.putExtra("USER","ALL USER");
                intent.putExtra(GlobalController.KEY_SHOPID,""+getDataAdapter1.getShopId());
                intent.putExtra(GlobalController.KEY_SHOPNAME,"");
                intent.putExtra(GlobalController.KEY_SHOPIMAGEURL,""+url1);
                intent.putExtra(GlobalController.KEY_SHOPVIEWS,"");
               context.startActivity(intent);

            }
        });






    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public TextView txt_itemName;
        public TextView txt_brandName;
        public TextView  txt_itemPrice;
        public TextView txt_ItemMrp;
        public ImageView itemImageView;
        public Button btn_online_shopbutton;





        public ViewHolder(View itemView) {

            super(itemView);


            txt_itemName = (TextView) itemView.findViewById(R.id.txt_itemName);
            txt_brandName = (TextView) itemView.findViewById(R.id.txt_brandName);
            txt_itemPrice = (TextView) itemView.findViewById(R.id.txt_itemPrice);
            txt_ItemMrp = (TextView) itemView.findViewById(R.id.txt_ItemMrp);
            itemImageView = (ImageView) itemView.findViewById(R.id.itemImageView) ;
            btn_online_shopbutton= itemView.findViewById(R.id.btn_online_shopbutton) ;

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