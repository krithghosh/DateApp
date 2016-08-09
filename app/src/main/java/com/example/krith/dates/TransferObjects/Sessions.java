package com.example.krith.dates.TransferObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krith on 06/08/16.
 */
public class Sessions implements Serializable {

    @SerializedName("afternoon")
    @Expose
    private List<CommonSessions> afternoon = new ArrayList<CommonSessions>();
    @SerializedName("evening")
    @Expose
    private List<CommonSessions> evening = new ArrayList<CommonSessions>();
    @SerializedName("morning")
    @Expose
    private List<CommonSessions> morning = new ArrayList<CommonSessions>();

    public List<CommonSessions> getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(List<CommonSessions> afternoon) {
        this.afternoon = afternoon;
    }

    public List<CommonSessions> getEvening() {
        return evening;
    }

    public void setEvening(List<CommonSessions> evening) {
        this.evening = evening;
    }

    public List<CommonSessions> getMorning() {
        return morning;
    }

    public void setMorning(List<CommonSessions> morning) {
        this.morning = morning;
    }
}
