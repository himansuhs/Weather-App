package com.teamgeneral.forcheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdaptorF extends RecyclerView.Adapter<AdaptorF.ViewHolder1> {
    private Context context;
    private ArrayList<RvModel2> ForecastArrayList;

    public AdaptorF(Context context, ArrayList<RvModel2> forecastArrayList) {
        this.context = context;
        ForecastArrayList = forecastArrayList;
    }

    @NonNull
    @Override
    public AdaptorF.ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_holder2,parent,false);
        return new AdaptorF.ViewHolder1(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptorF.ViewHolder1 holder, int position) {
     RvModel2 rvModel2=ForecastArrayList.get(position);
        holder.temp_1.setText(rvModel2.getTemperatures()+"℃");
        holder.wind_t.setText(rvModel2.getWind()+"Km/h");
        Picasso.get().load("http://".concat(rvModel2.getIcons())).into(holder.image_icon2);
        holder.condition_text.setText(rvModel2.getForcastCondition().toString());
//        SimpleDateFormat input=new SimpleDateFormat("yyyy-mm-dd hh:mm");
//        SimpleDateFormat output=new SimpleDateFormat("hh:mm aa");
//        try{
//            Date t=input.parse(rvModel2.getTimes());
//            holder.text_day.setText(output.format(t));
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        holder.text_day.setText((rvModel2.getTimes()));
    }

    @Override
    public int getItemCount() {
        return ForecastArrayList.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder{
        private TextView text_day,condition_text,wind_t,temp_1;
        private ImageView image_icon2;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            text_day=(TextView) itemView.findViewById(R.id.text_day);
            condition_text=(TextView) itemView.findViewById(R.id.condition_text);
            temp_1=(TextView) itemView.findViewById(R.id.temp_1);
            wind_t=(TextView) itemView.findViewById(R.id.wind_t);
            image_icon2=(ImageView) itemView.findViewById(R.id.image_icon2);
        }
    }
}
