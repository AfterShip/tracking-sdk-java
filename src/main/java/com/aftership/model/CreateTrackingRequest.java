/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.model;

import com.google.gson.annotations.SerializedName;
import com.aftership.base.Resource;

public class CreateTrackingRequest extends Resource {

    @SerializedName("tracking")
    private TrackingCreateTrackingRequest tracking;

    public  TrackingCreateTrackingRequest getTracking() {
        return tracking;
    }

    public void setTracking( TrackingCreateTrackingRequest tracking) {
        this.tracking = tracking;
    }

}