package com.ais.nativehelper.adapter;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.ais.nativehelper.R;
import com.ais.nativehelper.ShopDetailsActivity;
import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.ItemHeader;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;
import java.util.Iterator;
import java.util.List;

public class DailyitemsHeadingViewAdapter extends RecyclerView.Adapter<DailyitemsHeadingViewAdapter.ViewHolder>{
        Context context;
        List<ItemHeader> getDataAdapter;
        ImageLoader imageLoader1;
        String url1=null;

public DailyitemsHeadingViewAdapter(List<ItemHeader> getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
        }

public DailyitemsHeadingViewAdapter(List<ItemHeader> getDataAdapter1) {
        this.getDataAdapter=getDataAdapter1;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_daily_items, parent, false);

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
        Viewholder.txt_dailyitem_brand_name.setTextAppearance(context, R.style.font_news_kannda_heading);
        Viewholder.txt_companyname.setTextAppearance(context, R.style.font_news_kannda_heading);
        }
        // Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
        //Log.e("%&&&&&&&&&&&&&&&&&&&","2222222244444444444");
    if(getDataAdapter1.getMcatId()==3)
    {

        Viewholder.txt_dailyitem_brand_name.setText(getDataAdapter1.getBrandName());
        Viewholder.txt_companyname.setText(" "+getDataAdapter1.geteName());
        Viewholder.txt_online_itemunit.setText(" "+getDataAdapter1.getItemUnit());

        Viewholder.txt_onlineitem_price.setText(" "+getDataAdapter1.getPrice());
        Viewholder.txt_onlineitem_mrp.setText(""+getDataAdapter1.getMrp());
        if(getDataAdapter1.getMrp()==0)
        {
            Viewholder.txt_onlineitem_mrp.setVisibility(View.GONE);
        }
        Viewholder.btn_online_shopbutton.setVisibility(View.GONE);
    }
    else if (getDataAdapter1.getMcatId()==2)
    {
        String r="\u20B9";
        Viewholder.txt_dailyitem_brand_name.setText(getDataAdapter1.getBrandName());
        Viewholder.txt_companyname.setText(" "+getDataAdapter1.geteName());
        Viewholder.txt_online_itemunit.setText(" "+getDataAdapter1.getItemUnit());

        Viewholder.txt_onlineitem_price.setText(r+" "+getDataAdapter1.getPrice());

        Viewholder.txt_onlineitem_mrp.setText(r+""+getDataAdapter1.getMrp());
        if(getDataAdapter1.getMrp()==0)
        {
            Viewholder.txt_onlineitem_mrp.setVisibility(View.GONE);
        }
        //Viewholder.txt_onlineitem_mrp.setBackgroundDrawable(R.drawable.ic_dash_line_icon);
       // Viewholder.txt_onlineitem_mrp.setBackground(R.drawable.ic_dash_line_icon);

    }
    else
    {
        String r="\u20B9";
        Viewholder.txt_dailyitem_brand_name.setText(getDataAdapter1.getBrandName());
        Viewholder.txt_companyname.setText(" "+getDataAdapter1.geteName());
        Viewholder.txt_online_itemunit.setText(" "+getDataAdapter1.getItemUnit());

        Viewholder.txt_onlineitem_price.setText(r+" "+getDataAdapter1.getPrice());

        Viewholder.txt_onlineitem_mrp.setText(r+""+getDataAdapter1.getMrp());
        if(getDataAdapter1.getMrp()==0)
        {
            Viewholder.txt_onlineitem_mrp.setVisibility(View.GONE);
        }
    }


        if((getDataAdapter1.getOnlitemUrl()!= null)  &&(!getDataAdapter1.getOnlitemUrl().equals("null")) )
        {
       // String urlll="https://valar.in/wp-content/uploads/2019/08/cropped-are-you-gonna-open-new-shop-opening-ceremony.jpg";
        // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);
            Log.e("%&&&&&&&&&&&&&&&&&&&","222222221111111111111111");
            Log.e("%&&&&&&&&&&&&&&&&&&&",getDataAdapter1.getOnlitemUrl());
        url1=getDataAdapter1.getOnlitemUrl();
        Picasso.with(context).load(getDataAdapter1.getOnlitemUrl()).resize(340, 240).into(Viewholder.dialyitem_imageView);

        //Picasso.with(context).load(urlll).resize(340, 240).into(Viewholder.dialyitem_imageView);

        }
        else if(getDataAdapter1.getItemImageUrl()!=null)
        {
       // String urlll="https://valar.in/wp-content/uploads/2019/08/cropped-are-you-gonna-open-new-shop-opening-ceremony.jpg";
            Log.e("%&&&&&&&&&&&&&&&&&&&","222222223333333333333");

        // Viewholder.newsImageView.setImageUrl(getDataAdapter1.getImageUrl(), imageLoader1);
        // Picasso.with(context).load(getDataAdapter1.getItemImageUrl()).resize(340, 240).into(Viewholder.itemImageView);
        url1=getDataAdapter1.getItemImageUrl();
        Picasso.with(context).load(getDataAdapter1.getItemImageUrl()).resize(340, 240).into(Viewholder.dialyitem_imageView);

        //Picasso.with(context).load(urlll).resize(340, 240).into(Viewholder.dialyitem_imageView);

        }
        else
        {
            Log.e("%&&&&&&&&&&&&&&&&&&&","222222224444444444444");
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

    public TextView txt_dailyitem_brand_name;
    public TextView txt_companyname;
    public TextView  txt_onlineitem_price;
    public TextView txt_onlineitem_mrp;
    public TextView  txt_online_itemunit;
    public ImageView dialyitem_imageView;
    public Button btn_online_shopbutton;













    public ViewHolder(View itemView) {

        super(itemView);


        txt_dailyitem_brand_name = (TextView) itemView.findViewById(R.id.txt_dailyitem_brand_name);
        txt_companyname = (TextView) itemView.findViewById(R.id.txt_companyname);
        txt_onlineitem_price = (TextView) itemView.findViewById(R.id.txt_onlineitem_price);
        txt_onlineitem_mrp = (TextView) itemView.findViewById(R.id.txt_onlineitem_mrp);
        txt_online_itemunit = (TextView) itemView.findViewById(R.id.txt_online_itemunit);
        dialyitem_imageView = (ImageView) itemView.findViewById(R.id.dialyitem_imageView) ;
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