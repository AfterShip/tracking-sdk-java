/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.tracking;

import com.aftership.base.Creator;
import com.aftership.constant.ErrorEnum;
import com.aftership.exception.ApiException;
import com.aftership.http.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import com.aftership.http.Request;
import com.aftership.model.MarkTrackingCompletedBySlugTrackingNumberResponse;
import com.aftership.base.Page;
import com.aftership.model.MarkTrackingCompletedBySlugTrackingNumberRequest;
import com.aftership.model.Tracking;

import com.aftership.model.MarkTrackingCompletedBySlugTrackingNumberResponse;

public class MarkTrackingCompletedBySlugTrackingNumberCreator extends Creator<Tracking> {
    private final Map<String, String> headerParams= new HashMap<>(8);

    public MarkTrackingCompletedBySlugTrackingNumberCreator addHeaderParam(final String name, final String value) {
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
    private MarkTrackingCompletedBySlugTrackingNumberRequest markTrackingCompletedBySlugTrackingNumberRequest;

    public MarkTrackingCompletedBySlugTrackingNumberCreator setMarkTrackingCompletedBySlugTrackingNumberRequest(MarkTrackingCompletedBySlugTrackingNumberRequest markTrackingCompletedBySlugTrackingNumberRequest) {
        this.markTrackingCompletedBySlugTrackingNumberRequest = markTrackingCompletedBySlugTrackingNumberRequest;
        return this;
    }
     private String trackingAccountNumber;

     private String trackingOriginCountry;

     private String trackingDestinationCountry;

     private String trackingKey;

     private String trackingPostalCode;

     private String trackingShipDate;

     private String trackingState;

    private String slug;

    private String tracking_number;


    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingAccountNumber(String trackingAccountNumber) {
        this.trackingAccountNumber = trackingAccountNumber;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingOriginCountry(String trackingOriginCountry) {
        this.trackingOriginCountry = trackingOriginCountry;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingDestinationCountry(String trackingDestinationCountry) {
        this.trackingDestinationCountry = trackingDestinationCountry;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingKey(String trackingKey) {
        this.trackingKey = trackingKey;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingPostalCode(String trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingShipDate(String trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingState(String trackingState) {
        this.trackingState = trackingState;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public MarkTrackingCompletedBySlugTrackingNumberCreator setTrackingNumber(String tracking_number) {
        this.tracking_number = tracking_number;
        return this;
    }

    @Override
    public Tracking create(AfterShipClient client) throws Exception {
        if (slug == null || slug.isEmpty()) {
            throw new ApiException(ErrorEnum.BAD_REQUEST.getCode(), ErrorEnum.BAD_REQUEST.getMessage() + ": `slug` is invalid");
        }
        if (tracking_number == null || tracking_number.isEmpty()) {
            throw new ApiException(ErrorEnum.BAD_REQUEST.getCode(), ErrorEnum.BAD_REQUEST.getMessage() + ": `tracking_number` is invalid");
        }
        String path = String.format("/tracking/2024-04/trackings/%s/%s/mark-as-completed", slug,tracking_number);
        Request request = new Request(HttpMethod.POST, path);
        request.setBody((new Gson()).toJson(markTrackingCompletedBySlugTrackingNumberRequest));

        addQueryParams(request);
        setHeaderParams(request);
        Response response = client.request(request);
        AfterShipResponse<MarkTrackingCompletedBySlugTrackingNumberResponse> trackingResponse = new Gson().fromJson(response.getContent(), new TypeToken<AfterShipResponse<MarkTrackingCompletedBySlugTrackingNumberResponse>>() {
            }.getType());
        return trackingResponse.getData().getTracking();

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
