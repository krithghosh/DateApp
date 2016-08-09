package com.example.krith.dates.TransferObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by krith on 06/08/16.
 */
public class CommonSessions implements Serializable {

    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("is_booked")
    @Expose
    private Boolean isBooked;
    @SerializedName("is_expired")
    @Expose
    private Boolean isExpired;
    @SerializedName("slot_id")
    @Expose
    private Integer slotId;
    @SerializedName("start_time")
    @Expose
    private String startTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}