package com.h5190067.mahmut_mirza_kutlu_final.utilities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

import com.h5190067.mahmut_mirza_kutlu_final.R;

public class AlertUtil {

    public static void giveAlert(Activity activity, String title, String message, boolean isNoConnectionAlert){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);


        if(isNoConnectionAlert)
        {
            builder.setNegativeButton(R.string.ExitApp, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });
            builder.setPositiveButton(R.string.GoSettings, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    activity.finish();
                }
            });
        }
        else{
            builder.setNegativeButton(R.string.ExitNo, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setPositiveButton(R.string.ExitYes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });
        }
        builder.show();

    }

}
