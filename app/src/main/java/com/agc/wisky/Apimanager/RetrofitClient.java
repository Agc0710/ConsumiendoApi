package com.agc.wisky.Apimanager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  RetrofitClient {
    private static RetrofitClient instance = null;
    private WiskeysHunter myApi;
    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WiskeysHunter.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(WiskeysHunter.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }

        return instance;
    }

    public WiskeysHunter getMyApi() {
        return myApi;
    }
}
