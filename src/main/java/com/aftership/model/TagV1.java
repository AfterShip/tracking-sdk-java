/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.model;

import com.google.gson.annotations.SerializedName;

public enum TagV1 {
  @SerializedName("Pending")
  Pending("Pending"),

  @SerializedName("InfoReceived")
  Inforeceived("InfoReceived"),

  @SerializedName("InTransit")
  Intransit("InTransit"),

  @SerializedName("OutForDelivery")
  Outfordelivery("OutForDelivery"),

  @SerializedName("AttemptFail")
  Attemptfail("AttemptFail"),

  @SerializedName("Delivered")
  Delivered("Delivered"),

  @SerializedName("AvailableForPickup")
  Availableforpickup("AvailableForPickup"),

  @SerializedName("Exception")
  Exception("Exception"),

  @SerializedName("Expired")
  Expired("Expired");

  private final String content;

  TagV1(final String content) {
    this.content = content;
  }

  public String toString() {
    return content;
  }
}
