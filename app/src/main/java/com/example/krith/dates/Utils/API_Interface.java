package com.example.krith.dates.Utils;

import com.example.krith.dates.TransferObjects.Slots;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by krith on 06/08/16.
 */
public interface API_Interface {
    @GET("booking/slots/all")
    Call<Slots> getAllSlots(@Query("api_key") String apiKey,
                            @Query("vc") String vc,
                            @Query("username") String userName,
                            @Query("expert_username") String expertUserName,
                            @Query("format") String format);

}
