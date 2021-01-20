package com.h5190067.mahmut_mirza_kutlu_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.h5190067.mahmut_mirza_kutlu_final.R;
import com.h5190067.mahmut_mirza_kutlu_final.adaptor.GolfAdaptor;
import com.h5190067.mahmut_mirza_kutlu_final.models.GolfModel;
import com.h5190067.mahmut_mirza_kutlu_final.network.Service;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.AlertUtil;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.Constant;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GolfsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golfs);

        initialize();

    }

    @Override
    public void onBackPressed() {
        AlertUtil.giveAlert(this, getString(R.string.go_back_alert)
                , getString(R.string.go_back_alert_message),
                false);


    }

    private void initialize() {
        getGolfs();
    }

    void getGolfs() {
        new Service().getServiceApi().getGolfs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<GolfModel>>() {

                List<GolfModel> golfModels = new ArrayList<>();

                @Override
                public void onSubscribe(Disposable d) {
                    Log.e("RETROFIT", "onSubscribe : ");

                }


                @Override
                public void onNext(List<GolfModel> golfModelList) {
                    Log.e("RETROFIT", "onNext : ");
                    golfModels = golfModelList;
                    progressDialog = new ProgressDialog(GolfsActivity.this);
                    progressDialog.setMessage(getString(R.string.progress_dialog));
                    progressDialog.show();
                }

                @Override
                public void onError(Throwable e) {

                    Log.e("RETROFIT", "onError : " + e.getLocalizedMessage());

                }

                @Override
                public void onComplete() {
                    Log.e("RETROFIT", "onComplete : ");

                    progressDialog.dismiss();

                    if (golfModels.size() > 0) {
                        initRecycleView(golfModels);
                    }
                }
            });
    }

    private void initRecycleView(List<GolfModel> golfModelList) {
        recyclerView = findViewById(R.id.rcvGolf);
        GolfAdaptor golfAdaptor = new GolfAdaptor(golfModelList, getApplicationContext(), new GolfAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                GolfModel clickedGolfModel = golfModelList.get(position);
                changeActivity(clickedGolfModel);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(golfAdaptor);
    }

    private void changeActivity(GolfModel clickedGolfModel) {
        String golfModelString = ObjectUtil.GolfToJsonString(clickedGolfModel);
        Intent detailIntent = new Intent(getApplicationContext(), GolfDetailActivity.class);
        detailIntent.putExtra(Constant.CLICKED_GOLF, golfModelString);
        startActivity(detailIntent);
    }
}