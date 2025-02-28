/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.model;

import com.aftership.base.Resource;
import com.google.gson.annotations.SerializedName;

public class CreateTrackingRequest extends Resource {

  @SerializedName("tracking_number")
  private String trackingNumber;

  @SerializedName("slug")
  private String slug;

  @SerializedName("title")
  private String title;

  @SerializedName("order_id")
  private String orderId;

  @SerializedName("order_id_path")
  private String orderIdPath;

  @SerializedName("custom_fields")
  private java.util.Map<String, String> customFields;

  @SerializedName("language")
  private String language;

  @SerializedName("order_promised_delivery_date")
  private String orderPromisedDeliveryDate;

  @SerializedName("delivery_type")
  private String deliveryType;

  @SerializedName("pickup_location")
  private String pickupLocation;

  @SerializedName("pickup_note")
  private String pickupNote;

  @SerializedName("tracking_account_number")
  private String trackingAccountNumber;

  @SerializedName("tracking_key")
  private String trackingKey;

  @SerializedName("tracking_ship_date")
  private String trackingShipDate;

  @SerializedName("origin_country_region")
  private String originCountryRegion;

  @SerializedName("origin_state")
  private String originState;

  @SerializedName("origin_city")
  private String originCity;

  @SerializedName("origin_postal_code")
  private String originPostalCode;

  @SerializedName("origin_raw_location")
  private String originRawLocation;

  @SerializedName("destination_country_region")
  private String destinationCountryRegion;

  @SerializedName("destination_state")
  private String destinationState;

  @SerializedName("destination_city")
  private String destinationCity;

  @SerializedName("destination_postal_code")
  private String destinationPostalCode;

  @SerializedName("destination_raw_location")
  private String destinationRawLocation;

  @SerializedName("note")
  private String note;

  @SerializedName("slug_group")
  private SlugGroupV1 slugGroup;

  @SerializedName("order_date")
  private String orderDate;

  @SerializedName("order_number")
  private String orderNumber;

  @SerializedName("shipment_type")
  private String shipmentType;

  @SerializedName("shipment_tags")
  private java.util.List<String> shipmentTags;

  @SerializedName("courier_connection_id")
  private String courierConnectionId;

  @SerializedName("tracking_origin_country_region")
  private String trackingOriginCountryRegion;

  @SerializedName("tracking_destination_country_region")
  private String trackingDestinationCountryRegion;

  @SerializedName("tracking_postal_code")
  private String trackingPostalCode;

  @SerializedName("tracking_state")
  private String trackingState;

  @SerializedName("location_id")
  private String locationId;

  @SerializedName("shipping_method")
  private String shippingMethod;

  @SerializedName("last_mile")
  private LastMileCreateTrackingRequest lastMile;

  @SerializedName("customers")
  private java.util.List<CustomersCreateTrackingRequest> customers;

  public String getTrackingNumber() {
    return trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderIdPath() {
    return orderIdPath;
  }

  public void setOrderIdPath(String orderIdPath) {
    this.orderIdPath = orderIdPath;
  }

  public java.util.Map<String, String> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(java.util.Map<String, String> customFields) {
    this.customFields = customFields;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getOrderPromisedDeliveryDate() {
    return orderPromisedDeliveryDate;
  }

  public void setOrderPromisedDeliveryDate(String orderPromisedDeliveryDate) {
    this.orderPromisedDeliveryDate = orderPromisedDeliveryDate;
  }

  public String getDeliveryType() {
    return deliveryType;
  }

  public void setDeliveryType(String deliveryType) {
    this.deliveryType = deliveryType;
  }

  public String getPickupLocation() {
    return pickupLocation;
  }

  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
  }

  public String getPickupNote() {
    return pickupNote;
  }

  public void setPickupNote(String pickupNote) {
    this.pickupNote = pickupNote;
  }

  public String getTrackingAccountNumber() {
    return trackingAccountNumber;
  }

  public void setTrackingAccountNumber(String trackingAccountNumber) {
    this.trackingAccountNumber = trackingAccountNumber;
  }

  public String getTrackingKey() {
    return trackingKey;
  }

  public void setTrackingKey(String trackingKey) {
    this.trackingKey = trackingKey;
  }

  public String getTrackingShipDate() {
    return trackingShipDate;
  }

  public void setTrackingShipDate(String trackingShipDate) {
    this.trackingShipDate = trackingShipDate;
  }

  public String getOriginCountryRegion() {
    return originCountryRegion;
  }

  public void setOriginCountryRegion(String originCountryRegion) {
    this.originCountryRegion = originCountryRegion;
  }

  public String getOriginState() {
    return originState;
  }

  public void setOriginState(String originState) {
    this.originState = originState;
  }

  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }

  public String getOriginPostalCode() {
    return originPostalCode;
  }

  public void setOriginPostalCode(String originPostalCode) {
    this.originPostalCode = originPostalCode;
  }

  public String getOriginRawLocation() {
    return originRawLocation;
  }

  public void setOriginRawLocation(String originRawLocation) {
    this.originRawLocation = originRawLocation;
  }

  public String getDestinationCountryRegion() {
    return destinationCountryRegion;
  }

  public void setDestinationCountryRegion(String destinationCountryRegion) {
    this.destinationCountryRegion = destinationCountryRegion;
  }

  public String getDestinationState() {
    return destinationState;
  }

  public void setDestinationState(String destinationState) {
    this.destinationState = destinationState;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public String getDestinationPostalCode() {
    return destinationPostalCode;
  }

  public void setDestinationPostalCode(String destinationPostalCode) {
    this.destinationPostalCode = destinationPostalCode;
  }

  public String getDestinationRawLocation() {
    return destinationRawLocation;
  }

  public void setDestinationRawLocation(String destinationRawLocation) {
    this.destinationRawLocation = destinationRawLocation;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public SlugGroupV1 getSlugGroup() {
    return slugGroup;
  }

  public void setSlugGroup(SlugGroupV1 slugGroup) {
    this.slugGroup = slugGroup;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getShipmentType() {
    return shipmentType;
  }

  public void setShipmentType(String shipmentType) {
    this.shipmentType = shipmentType;
  }

  public java.util.List<String> getShipmentTags() {
    return shipmentTags;
  }

  public void setShipmentTags(java.util.List<String> shipmentTags) {
    this.shipmentTags = shipmentTags;
  }

  public String getCourierConnectionId() {
    return courierConnectionId;
  }

  public void setCourierConnectionId(String courierConnectionId) {
    this.courierConnectionId = courierConnectionId;
  }

  public String getTrackingOriginCountryRegion() {
    return trackingOriginCountryRegion;
  }

  public void setTrackingOriginCountryRegion(String trackingOriginCountryRegion) {
    this.trackingOriginCountryRegion = trackingOriginCountryRegion;
  }

  public String getTrackingDestinationCountryRegion() {
    return trackingDestinationCountryRegion;
  }

  public void setTrackingDestinationCountryRegion(String trackingDestinationCountryRegion) {
    this.trackingDestinationCountryRegion = trackingDestinationCountryRegion;
  }

  public String getTrackingPostalCode() {
    return trackingPostalCode;
  }

  public void setTrackingPostalCode(String trackingPostalCode) {
    this.trackingPostalCode = trackingPostalCode;
  }

  public String getTrackingState() {
    return trackingState;
  }

  public void setTrackingState(String trackingState) {
    this.trackingState = trackingState;
  }

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public String getShippingMethod() {
    return shippingMethod;
  }

  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public LastMileCreateTrackingRequest getLastMile() {
    return lastMile;
  }

  public void setLastMile(LastMileCreateTrackingRequest lastMile) {
    this.lastMile = lastMile;
  }

  public java.util.List<CustomersCreateTrackingRequest> getCustomers() {
    return customers;
  }

  public void setCustomers(java.util.List<CustomersCreateTrackingRequest> customers) {
    this.customers = customers;
  }
}
