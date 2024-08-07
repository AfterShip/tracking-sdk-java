/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.tracking;

import com.aftership.base.Updater;
import com.aftership.constant.ErrorEnum;
import com.aftership.exception.ApiException;
import com.aftership.http.*;
import com.aftership.model.Tracking;
import com.aftership.model.UpdateTrackingBySlugTrackingNumberRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class UpdateTrackingBySlugTrackingNumberUpdater extends Updater<Tracking> {
    private final Map<String, String> headerParams = new HashMap<>(8);
    private UpdateTrackingBySlugTrackingNumberRequest updateTrackingBySlugTrackingNumberRequest;
    private String trackingAccountNumber;
    private String trackingOriginCountry;
    private String trackingDestinationCountry;
    private String trackingKey;
    private String trackingPostalCode;
    private String trackingShipDate;
    private String trackingState;
    private String slug;
    private String tracking_number;

    public UpdateTrackingBySlugTrackingNumberUpdater addHeaderParam(final String name, final String value) {
        if (value == null || value.equals("null")) {
            return this;
        }

        if (!headerParams.containsKey(name)) {
            headerParams.put(name, value);
        }
        return this;
    }

    private void setHeaderParams(final Request request) {
        for (final Map.Entry<String, String> entry : headerParams.entrySet()) {
            request.addHeaderParam(entry.getKey(), entry.getValue());
        }
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setUpdateTrackingBySlugTrackingNumberRequest(UpdateTrackingBySlugTrackingNumberRequest updateTrackingBySlugTrackingNumberRequest) {
        this.updateTrackingBySlugTrackingNumberRequest = updateTrackingBySlugTrackingNumberRequest;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingAccountNumber(String trackingAccountNumber) {
        this.trackingAccountNumber = trackingAccountNumber;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingOriginCountry(String trackingOriginCountry) {
        this.trackingOriginCountry = trackingOriginCountry;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingDestinationCountry(String trackingDestinationCountry) {
        this.trackingDestinationCountry = trackingDestinationCountry;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingKey(String trackingKey) {
        this.trackingKey = trackingKey;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingPostalCode(String trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingShipDate(String trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingState(String trackingState) {
        this.trackingState = trackingState;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public UpdateTrackingBySlugTrackingNumberUpdater setTrackingNumber(String tracking_number) {
        this.tracking_number = tracking_number;
        return this;
    }

    @Override
    public Tracking update(AfterShipClient client) throws Exception {
        if (slug == null || slug.isEmpty()) {
            throw new ApiException(ErrorEnum.BAD_REQUEST.getCode(), ErrorEnum.BAD_REQUEST.getMessage() + ": `slug` is invalid");
        }
        if (tracking_number == null || tracking_number.isEmpty()) {
            throw new ApiException(ErrorEnum.BAD_REQUEST.getCode(), ErrorEnum.BAD_REQUEST.getMessage() + ": `tracking_number` is invalid");
        }
        String path = String.format("/tracking/2024-07/trackings/%s/%s", slug, tracking_number);
        Request request = new Request(HttpMethod.PUT, path);
        request.setBody((new Gson()).toJson(updateTrackingBySlugTrackingNumberRequest));

        addQueryParams(request);
        setHeaderParams(request);
        Response response = client.request(request);
        AfterShipResponse<Tracking> trackingResponse = new Gson().fromJson(response.getContent(), new TypeToken<AfterShipResponse<Tracking>>() {
        }.getType());
        return trackingResponse.getData();

    }

    private void addQueryParams(final Request request) {
        if (trackingAccountNumber != null) {
            request.addQueryParam("tracking_account_number", trackingAccountNumber);
        }
        if (trackingOriginCountry != null) {
            request.addQueryParam("tracking_origin_country", trackingOriginCountry);
        }
        if (trackingDestinationCountry != null) {
            request.addQueryParam("tracking_destination_country", trackingDestinationCountry);
        }
        if (trackingKey != null) {
            request.addQueryParam("tracking_key", trackingKey);
        }
        if (trackingPostalCode != null) {
            request.addQueryParam("tracking_postal_code", trackingPostalCode);
        }
        if (trackingShipDate != null) {
            request.addQueryParam("tracking_ship_date", trackingShipDate);
        }
        if (trackingState != null) {
            request.addQueryParam("tracking_state", trackingState);
        }

    }
}
