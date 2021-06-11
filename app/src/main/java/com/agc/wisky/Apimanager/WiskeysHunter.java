package com.agc.wisky.Apimanager;

import com.agc.wisky.Models.Destilerias;
import com.agc.wisky.Models.Wiskeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WiskeysHunter {
    String BASE_URL ="https://whiskyhunter.net/api/";

    @GET("auctions_info")
    Call<List<Wiskeys>> getWiskeys();

    @GET("distilleries_info")
    Call<List<Destilerias>> getDestileria();

   @GET("auction_data/{slug}")
   Call<List<Wiskeys>> getWiskeys(@Path("slug") String slug);

    @GET("distillery_data/{slug}")
    Call<List<Destilerias>> getDestileria(@Path("slug") String slug);



}
