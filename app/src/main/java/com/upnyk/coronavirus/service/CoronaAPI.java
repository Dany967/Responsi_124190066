package com.upnyk.coronavirus.service;

import com.upnyk.coronavirus.pojo.corona.CoronaResponse;
import com.upnyk.coronavirus.pojo.hospital.HospitalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaAPI {

    @GET("rekapitulasi_v2/jabar/harian")
    Call<CoronaResponse> getCorona();

    @GET("sebaran_v2/jabar/faskes")
    Call<HospitalResponse> getHospital();

}
