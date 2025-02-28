/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.tracking;

import com.aftership.base.Creator;
import com.aftership.http.*;
import com.aftership.model.CreateTrackingRequest;
import com.aftership.model.Tracking;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class CreateTrackingCreator extends Creator<Tracking> {
  private final Map<String, String> headerParams = new HashMap<>(8);
  private CreateTrackingRequest createTrackingRequest;

  public CreateTrackingCreator addHeaderParam(final String name, final String value) {
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

  public CreateTrackingCreator setCreateTrackingRequest(
      CreateTrackingRequest createTrackingRequest) {
    this.createTrackingRequest = createTrackingRequest;
    return this;
  }

  @Override
  public Tracking create(AfterShipClient client) throws Exception {
    String path = "/tracking/2025-01/trackings";
    Request request = new Request(HttpMethod.POST, path);
    request.setBody((new Gson()).toJson(createTrackingRequest));

    setHeaderParams(request);
    Response response = client.request(request);
    AfterShipResponse<Tracking> trackingResponse =
        new Gson()
            .fromJson(
                response.getContent(), new TypeToken<AfterShipResponse<Tracking>>() {}.getType());
    return trackingResponse.getData();
  }
}
