/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.estimated_delivery_date;

import com.aftership.base.Creator;
import com.aftership.constant.ErrorEnum;
import com.aftership.exception.ApiException;
import com.aftership.http.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import com.aftership.http.Request;
import com.aftership.model.PredictBatchResponse;
import com.aftership.base.Page;
import com.aftership.model.PredictBatchRequest;

import com.aftership.model.PredictBatchResponse;

public class PredictBatchCreator extends Creator<PredictBatchResponse> {
    private final Map<String, String> headerParams= new HashMap<>(8);

    public PredictBatchCreator addHeaderParam(final String name, final String value) {
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
    private PredictBatchRequest predictBatchRequest;

    public PredictBatchCreator setPredictBatchRequest(PredictBatchRequest predictBatchRequest) {
        this.predictBatchRequest = predictBatchRequest;
        return this;
    }

    @Override
    public PredictBatchResponse create(AfterShipClient client) throws Exception {
        String path = "/tracking/2024-04/estimated-delivery-date/predict-batch";
        Request request = new Request(HttpMethod.POST, path);
        request.setBody((new Gson()).toJson(predictBatchRequest));

        setHeaderParams(request);
        Response response = client.request(request);
        AfterShipResponse<PredictBatchResponse> trackingResponse = new Gson().fromJson(response.getContent(), new TypeToken<AfterShipResponse<PredictBatchResponse>>() {
            }.getType());
        return trackingResponse.getData();

    }

}
