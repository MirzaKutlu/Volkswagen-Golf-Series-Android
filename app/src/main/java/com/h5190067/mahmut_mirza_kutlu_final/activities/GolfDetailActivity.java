package com.h5190067.mahmut_mirza_kutlu_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190067.mahmut_mirza_kutlu_final.R;
import com.h5190067.mahmut_mirza_kutlu_final.models.GolfModel;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.Constant;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.GlideUtil;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.ObjectUtil;

public class GolfDetailActivity extends AppCompatActivity {

    ImageView imgGolf;
    TextView txtGolfTitle;
    TextView txtDescription;
    TextView txtYear;
    TextView txtHorsePower;
    TextView txtEngineCap;
    TextView txtTransmission;
    TextView txtWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf_detail);

        init();

    }

    private void init() {

        String movedGolfString = getIntent().getStringExtra(Constant.CLICKED_GOLF);
        GolfModel golfModel = ObjectUtil.JsonStringToGolf(movedGolfString);
        imgGolf = findViewById(R.id.imgGolf);
        txtGolfTitle = findViewById(R.id.txtGolfTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtYear = findViewById(R.id.txtYear);
        txtHorsePower = findViewById(R.id.txtHorsePower);
        txtEngineCap = findViewById(R.id.txtEngineCap);
        txtTransmission = findViewById(R.id.txtTransmission);
        txtWeight = findViewById(R.id.txtWeight);

        String year = getString(R.string.year);
        String hp = getString(R.string.hp);
        String engine = getString(R.string.engine);
        String gear = getString(R.string.gear);
        String weight = getString(R.string.weight);

        GlideUtil.glideImage(getApplicationContext(),golfModel.getKapakResim(),imgGolf);
        txtGolfTitle.setText(golfModel.getModel());
        txtDescription.setText(golfModel.getAciklama());
        txtYear.setText(year + golfModel.getUretimYili());
        txtHorsePower.setText(hp + golfModel.getBeygirGucu());
        txtEngineCap.setText(engine + golfModel.getMotorHacmi());
        txtTransmission.setText(gear + golfModel.getVites());
        txtWeight.setText(weight + golfModel.getAgirlik());

    }

}