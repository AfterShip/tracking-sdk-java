/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.model;

import com.google.gson.annotations.SerializedName;
import com.aftership.base.Resource;

public class DetectCourierRequest extends Resource {

    @SerializedName("tracking")
    private TrackingDetectCourierRequest tracking;

    public  TrackingDetectCourierRequest getTracking() {
        return tracking;
    }

    public void setTracking( TrackingDetectCourierRequest tracking) {
        this.tracking = tracking;
    }

}
