package com.example.krith.dates.TransferObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by krith on 06/08/16.
 */
public class Slots implements Serializable {

    @SerializedName("slots")
    @Expose
    private HashMap<String, Sessions> dates = new HashMap<String, Sessions>();

    public HashMap<String, Sessions> getDates() {
        return dates;
    }

    public void setDates(HashMap<String, Sessions> dates) {
        this.dates = dates;
    }
}
