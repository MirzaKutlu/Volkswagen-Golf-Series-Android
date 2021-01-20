package com.h5190067.mahmut_mirza_kutlu_final.adaptor;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190067.mahmut_mirza_kutlu_final.R;

public class GolfViewHolder extends RecyclerView.ViewHolder {

    ImageView golfImage;
    TextView txtGolfName;
    TextView txtGolfInfo1;
    TextView txtGolfInfo2;
    TextView txtGolfInfo3;
    public GolfViewHolder(@NonNull View itemView, GolfAdaptor.OnItemClickListener onItemClickListener) {
         super(itemView);


        golfImage =itemView.findViewById(R.id.golfImage);
        txtGolfName =itemView.findViewById(R.id.golfName);
        txtGolfInfo1 =itemView.findViewById(R.id.golfInfo1);
        txtGolfInfo2 =itemView.findViewById(R.id.golfInfo2);
        txtGolfInfo3 =itemView.findViewById(R.id.golfInfo3);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(getAdapterPosition());
            }
        });

    }
}
