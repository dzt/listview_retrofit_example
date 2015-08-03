package com.under_rated.listofflowers.API;


import com.under_rated.listofflowers.Model.Flower;

import java.util.List;

import retrofit.http.GET;
import retrofit.Callback;

/**
 * Created by dave on 8/3/15.
 */
public interface FlowerHelper {
    @GET("/feeds/flowers.json")
    public void getFlowers(Callback<List<Flower>> response);

}
