package com.teamgeneral.forcheck;

import android.content.Context;
import android.text.PrecomputedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdaptorR extends RecyclerView.Adapter<AdaptorR.ViewHolder> {
    private Context context;
    private ArrayList<RvModel> weatherArraylist;

    public AdaptorR(Context context, ArrayList<RvModel> weatherArraylist) {
        this.context = context;
        this.weatherArraylist = weatherArraylist;
    }

    @NonNull
    @Override
    public AdaptorR.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_holder,parent,false);
     return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptorR.ViewHolder holder, int position) {
        RvModel rvModel=weatherArraylist.get(position);
        holder.idTvTemp.setText(rvModel.getTemperature()+"℃");
        Picasso.get().load("http://".concat(rvModel.getIcon())).into(holder.image_view_condition);
        holder.idTvWind.setText(rvModel.getWindSpeed()+"km/h");
        SimpleDateFormat input=new SimpleDateFormat("yyyy-mm-dd hh:mm");
        SimpleDateFormat output=new SimpleDateFormat("hh:mm aa");
        try{
            Date t=input.parse(rvModel.getTime());
            holder.idTvTime.setText(output.format(t));
        }catch (ParseException e){
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return weatherArraylist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
       private TextView idTvTime,idTvWind,idTvTemp;
       private ImageView image_view_condition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTvTemp=(TextView) itemView.findViewById(R.id.idTvTemp);
            idTvTime=(TextView) itemView.findViewById(R.id.idTvTime);
            idTvWind=(TextView) itemView.findViewById(R.id.idTvWind);
            image_view_condition=(ImageView) itemView.findViewById(R.id.image_view_condition);
        }
    }
}
