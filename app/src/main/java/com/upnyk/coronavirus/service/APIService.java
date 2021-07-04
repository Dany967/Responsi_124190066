package com.upnyk.coronavirus.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private Retrofit retrofit = null;
    public String URL = "https://covid19-public.digitalservice.id/api/v1/";

    public CoronaAPI getAPI(){
        if (retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CoronaAPI.class);
    }
}
