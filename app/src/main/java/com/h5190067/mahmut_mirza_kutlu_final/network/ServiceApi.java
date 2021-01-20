package com.h5190067.mahmut_mirza_kutlu_final.network;

import com.h5190067.mahmut_mirza_kutlu_final.models.GolfModel;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("golfapi.json")
    Observable<List<GolfModel>> getGolfs();

}
