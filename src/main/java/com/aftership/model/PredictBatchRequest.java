/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.model;

import com.aftership.base.Resource;
import com.google.gson.annotations.SerializedName;

public class PredictBatchRequest extends Resource {

  @SerializedName("estimated_delivery_dates")
  private java.util.List<EstimatedDeliveryDateRequest> estimatedDeliveryDates;

  public java.util.List<EstimatedDeliveryDateRequest> getEstimatedDeliveryDates() {
    return estimatedDeliveryDates;
  }

  public void setEstimatedDeliveryDates(
      java.util.List<EstimatedDeliveryDateRequest> estimatedDeliveryDates) {
    this.estimatedDeliveryDates = estimatedDeliveryDates;
  }
}
