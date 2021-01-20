package com.h5190067.mahmut_mirza_kutlu_final.utilities;

import com.google.gson.Gson;
import com.h5190067.mahmut_mirza_kutlu_final.models.GolfModel;

public class ObjectUtil {

    public static String GolfToJsonString(GolfModel golfModel){

        Gson gson = new Gson();
        return gson.toJson(golfModel);

    }

    public static GolfModel JsonStringToGolf(String jsonString){

        Gson gson = new Gson();

        return gson.fromJson(jsonString , GolfModel.class);
    }

}
