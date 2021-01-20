package com.h5190067.mahmut_mirza_kutlu_final.utilities;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190067.mahmut_mirza_kutlu_final.R;

public class GlideUtil {

    public  static  void glideImage(Context context, String url, ImageView image)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.no_image)
                .centerCrop()
                .into(image);
    }
}
