package com.example.krith.dates.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by krith on 06/08/16.
 */
public class ClientBuilder {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String URL) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
