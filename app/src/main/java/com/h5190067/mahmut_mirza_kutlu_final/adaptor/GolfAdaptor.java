package com.h5190067.mahmut_mirza_kutlu_final.adaptor;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190067.mahmut_mirza_kutlu_final.R;
import com.h5190067.mahmut_mirza_kutlu_final.models.GolfModel;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.GlideUtil;

import java.util.List;

public class GolfAdaptor extends RecyclerView.Adapter<GolfViewHolder> {


    List<GolfModel> golfModels;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{

        void onClick(int position);

    }


    public GolfAdaptor(List<GolfModel> golfModelList, Context context, OnItemClickListener onItemClickListener) {
        this.golfModels = golfModelList;
        this.context = context;
        this.onItemClickListener=onItemClickListener;

    }

    @NonNull
    @Override
    public GolfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_golfs,parent,false);
        return new GolfViewHolder(itemView,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GolfViewHolder viewHolder, int position) {

        String hp = context.getString(R.string.hp);
        String weight = context.getString(R.string.weight);
        String year = context.getString(R.string.year);

        viewHolder.txtGolfName.setText(golfModels.get(position).getModel());
        viewHolder.txtGolfInfo1.setText(hp + golfModels.get(position).getBeygirGucu());
        viewHolder.txtGolfInfo2.setText(weight + golfModels.get(position).getAgirlik());
        viewHolder.txtGolfInfo3.setText(year + golfModels.get(position).getUretimYili());
        GlideUtil.glideImage(context,golfModels.get(position).getKartResim(),viewHolder.golfImage);

    }

    @Override
    public int getItemCount() {
        return golfModels.size();
    }
}