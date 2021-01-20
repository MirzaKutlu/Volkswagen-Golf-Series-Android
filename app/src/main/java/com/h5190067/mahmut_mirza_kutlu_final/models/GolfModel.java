package com.h5190067.mahmut_mirza_kutlu_final.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GolfModel {

    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("UretimYili")
    @Expose
    private String uretimYili;
    @SerializedName("MotorHacmi")
    @Expose
    private String motorHacmi;
    @SerializedName("BeygirGucu")
    @Expose
    private String beygirGucu;
    @SerializedName("Vites")
    @Expose
    private String vites;
    @SerializedName("Agirlik")
    @Expose
    private String agirlik;
    @SerializedName("KapakResim")
    @Expose
    private String kapakResim;
    @SerializedName("KartResim")
    @Expose
    private String kartResim;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUretimYili() {
        return uretimYili;
    }

    public void setUretimYili(String uretimYili) {
        this.uretimYili = uretimYili;
    }

    public String getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(String motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public String getBeygirGucu() {
        return beygirGucu;
    }

    public void setBeygirGucu(String beygirGucu) {
        this.beygirGucu = beygirGucu;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public String getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(String agirlik) {
        this.agirlik = agirlik;
    }

    public String getKapakResim() {
        return kapakResim;
    }

    public void setKapakResim(String kapakResim) {
        this.kapakResim = kapakResim;
    }

    public String getKartResim() {
        return kartResim;
    }

    public void setKartResim(String kartResim) {
        this.kartResim = kartResim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}