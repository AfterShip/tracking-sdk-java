# AfterShip Tracking API library for Java

This library allows you to quickly and easily use the AfterShip Tracking API via Java.

For updates to this library, see our [GitHub release page](https://github.com/AfterShip/tracking-sdk-java/releases).

If you need support using AfterShip products, please contact support@aftership.com.

## Table of Contents

- [AfterShip Tracking API library for Java](#aftership-tracking-api-library-for-java)
  - [Table of Contents](#table-of-contents)
  - [Before you begin](#before-you-begin)
    - [API and SDK Version](#api-and-sdk-version)
  - [Quick Start](#quick-start)
    - [Installation](#installation)
  - [Constructor](#constructor)
    - [Example](#example)
  - [Rate Limiter](#rate-limiter)
  - [Error Handling](#error-handling)
    - [Error List](#error-list)
  - [Endpoints](#endpoints)
    - [/trackings](#trackings)
    - [/couriers](#couriers)
    - [/estimated-delivery-date](#estimated-delivery-date)
  - [Help](#help)
  - [License](#license)


## Before you begin

Before you begin to integrate:

- [Create an AfterShip account](https://admin.aftership.com/).
- [Create an API key](https://organization.automizely.com/api-keys).
- [Install Java](https://www.oracle.com/java/technologies/downloads/) version Java 1.8 or later.

### API and SDK Version

Each SDK version is designed to work with a specific API version. Please refer to the table below to identify the supported API versions for each SDK version, ensuring you select the appropriate SDK version for the API version you intend to use.

| SDK Version | Supported API Version | Branch                                                      |
| ----------- | --------------------- | ----------------------------------------------------------- |
| 6.x.x       | 2024-07               | https://github.com/AfterShip/tracking-sdk-java/tree/2024-07 |
| 5.x.x       | 2024-04               | https://github.com/AfterShip/tracking-sdk-java/tree/2024-04 |
| 4.x.x       | 2023-10               | https://github.com/AfterShip/aftership-sdk-java             |
| <=3.x.x     | Legacy API            | https://github.com/AfterShip/aftership-sdk-java             |

## Quick Start

### Installation
```bash
<dependency>
    <groupId>com.aftership</groupId>
    <artifactId>tracking-sdk</artifactId>
    <version>7.0.0</version>
</dependency>
```


## Constructor

Create AfterShip instance with options

| Name       | Type   | Required | Description                                                                                                                       |
| ---------- | ------ | -------- | --------------------------------------------------------------------------------------------------------------------------------- |
| api_key    | string | ✔        | Your AfterShip API key                                                                                                            |
| auth_type  | enum   |          | Default value: `AuthType.API_KEY` <br > AES authentication: `AuthType.AES` <br > RSA authentication: `AuthType.RSA`               |
| api_secret | string |          | Required if the authentication type is `AuthType.AES` or `AuthType.RSA`                                                           |
| domain     | string |          | AfterShip API domain. Default value: https://api.aftership.com                                                                    |
| user_agent | string |          | User-defined user-agent string, please follow [RFC9110](https://www.rfc-editor.org/rfc/rfc9110#field.user-agent) format standard. |
| proxy      | string |          | HTTP proxy URL to use for requests. <br > Default value: `null` <br > Example: `http://192.168.0.100:8888`                        |
| max_retry  | number |          | Number of retries for each request. Default value: 2. Min is 0, Max is 10.                                                        |
| timeout    | number |          | Timeout for each request in milliseconds.                                                                                         |

### Example

```java
import com.aftership.AfterShip;
import com.aftership.model.CreateTrackingRequest;
import com.aftership.model.CreateTrackingResponse;
import com.aftership.tracking.TrackingResource;

public class App {
    public static void main(String[] args) {
        try {
            AfterShip.init(
                    "YOUR_API_KEY"
            );
            
            CreateTrackingRequest trackingCreateTrackingRequest = new CreateTrackingRequest();
            trackingCreateTrackingRequest.setTrackingNumber("<tracking_number>");
            trackingCreateTrackingRequest.setSlug("<slug>");
            Tracking response = TrackingResource.createTracking().
                    setCreateTrackingRequest(trackingCreateTrackingRequest).
                    create();
            System.out.println(response.getTrackingNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Rate Limiter

See the [Rate Limit](https://www.aftership.com/docs/tracking/2024-07/quickstart/rate-limit) to understand the AfterShip rate limit policy.

## Error Handling

The SDK will return an error object when there is any error during the request, with the following specification:

| Name          | Type   | Description                    |
| ------------- | ------ | ------------------------------ |
| message       | string | Detail message of the error    |
| code          | enum   | Error code enum for API Error. |
| meta_code     | number | API response meta code.        |
| status_code   | number | HTTP status code.              |
| response_body | string | API response body.             |


### Error List

| code                              | meta_code       | status_code     | message                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| --------------------------------- | --------------- | --------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| INVALID_REQUEST                   | 400             | 400             | The request was invalid or cannot be otherwise served.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| INVALID_JSON                      | 4001            | 400             | Invalid JSON data.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| TRACKING_ALREADY_EXIST            | 4003            | 400             | Tracking already exists.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| TRACKING_DOES_NOT_EXIST           | 4004            | 404             | Tracking does not exist.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| TRACKING_NUMBER_INVALID           | 4005            | 400             | The value of tracking_number is invalid.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| TRACKING_REQUIRED                 | 4006            | 400             | tracking object is required.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| TRACKING_NUMBER_REQUIRED          | 4007            | 400             | tracking_number is required.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| VALUE_INVALID                     | 4008            | 400             | The value of [field_name] is invalid.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| VALUE_REQUIRED                    | 4009            | 400             | [field_name] is required.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| SLUG_INVALID                      | 4010            | 400             | The value of slug is invalid.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| MISSING_OR_INVALID_REQUIRED_FIELD | 4011            | 400             | Missing or invalid value of the required fields for this courier. Besides tracking_number, also required: [field_name]                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| BAD_COURIER                       | 4012            | 400             | The error message will be one of the following:<br/>1. Unable to import shipment as the carrier is not on your approved list for carrier auto-detection. Add the carrier here: https://admin.aftership.com/settings/couriers<br/>2. Unable to import shipment as we don’t recognize the carrier from this tracking number.<br/>3. Unable to import shipment as the tracking number has an invalid format.<br/>4. Unable to import shipment as this carrier is no longer supported.<br/>5. Unable to import shipment as the tracking number does not belong to a carrier in that group. |
| INACTIVE_RETRACK_NOT_ALLOWED      | 4013            | 400             | Retrack is not allowed. You can only retrack an inactive tracking.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| NOTIFICATION_REUQIRED             | 4014            | 400             | notification object is required.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| ID_INVALID                        | 4015            | 400             | The value of id is invalid.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| RETRACK_ONCE_ALLOWED              | 4016            | 400             | Retrack is not allowed. You can only retrack each shipment once.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| TRACKING_NUMBER_FORMAT_INVALID    | 4017            | 400             | The format of tracking_number is invalid.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| API_KEY_INVALID                   | 401             | 401             | The API key is invalid.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| REQUEST_NOT_ALLOWED               | 403             | 403             | The request is understood, but it has been refused or access is not allowed.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| NOT_FOUND                         | 404             | 404             | The URI requested is invalid or the resource requested does not exist.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| TOO_MANY_REQUEST                  | 429             | 429             | You have exceeded the API call rate limit. The default limit is 10 requests per second.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| INTERNAL_ERROR                    | 500 502 503 504 | 500 502 503 504 | Something went wrong on AfterShip's end.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |

## Endpoints

The AfterShip instance has the following properties which are exactly the same as the API endpoints:

- courier - Get a list of our supported couriers.
- tracking - Create trackings, update trackings, and get tracking results.
- estimated-delivery-date - Get estimated delivery date for your order.

### /trackings

**POST** /trackings

```java
CreateTrackingRequest trackingCreateTrackingRequest = new CreateTrackingRequest();
trackingCreateTrackingRequest.setTrackingNumber("<tracking_number>");
trackingCreateTrackingRequest.setSlug("<slug>");
Tracking response = TrackingResource.createTracking().
        setCreateTrackingRequest(trackingCreateTrackingRequest).
        create();
System.out.println(response.getTrackingNumber());
```

**DELETE** /trackings/:id

```java
Tracking response = TrackingResource.deleteTrackingById()
        .setId("<tracking_id>")
        .delete();
System.out.println(response.getId());
```

**GET** /trackings

```java
Page<Tracking> response =  TrackingResource.getTrackings().setKeyword("test").read();
for (Tracking tracking : response.getRecords()) {
    System.out.println(tracking.getTrackingNumber());
}
```

**GET** /trackings/:id

```java
Tracking response = TrackingResource.getTrackingById()
        .setId("<tracking_id>")
        .fetch();
System.out.println(response.getTrackingNumber());
```

**PUT** /trackings/:id

```java
UpdateTrackingByIdRequest request = new UpdateTrackingByIdRequest();
request.setTitle("test");
Tracking response = TrackingResource.updateTrackingById()
        .setId("<tracking_id>")
        .setUpdateTrackingByIdRequest(request)
        .update();
System.out.println(response.getTitle());
```

**POST** /trackings/:id/retrack

```java
Tracking response = TrackingResource.retrackTrackingById()
        .setId("<tracking_id>")
        .create();
System.out.println(response.getTrackingNumber());
```

**POST** /trackings/:id/mark-as-completed

```java
MarkTrackingCompletedByIdRequest request =  new MarkTrackingCompletedByIdRequest();
request.setReason("LOST");
Tracking response = TrackingResource.markTrackingCompletedById()
        .setId("<tracking_id>")
        .setMarkTrackingCompletedByIdRequest(request)
        .create();
System.out.println(response.getTrackingNumber());
```

### /couriers
**GET** /couriers

```java
GetUserCouriersResponse response = CourierResource.getUserCouriers().fetch();
System.out.println(response.getTotal());
```

**GET** /couriers/all

```java
GetAllCouriersResponse response = CourierResource.getAllCouriers().fetch();
System.out.println(response.getTotal());
```

**POST** /couriers/detect

```java
DetectCourierRequest request = new DetectCourierRequest();
request.setTrackingNumber("<tracking_number>");
DetectCourierResponse response = CourierResource.detectCourier()
      .setDetectCourierRequest(request)
      .create();
System.out.println(response.getTotal());
```

### /estimated-delivery-date

**POST** /estimated-delivery-date/predict-batch

```java
PredictBatchRequest request = new PredictBatchRequest();
EstimatedDeliveryDateRequest edd = new EstimatedDeliveryDateRequest();
edd.setSlug("<slug>");
DestinationAddressEstimatedDeliveryDateRequest dest = new DestinationAddressEstimatedDeliveryDateRequest();
dest.setCountry("<ISO 3166-1 country/region code>");
dest.setState("<ISO 3166-1 country/region code>");

edd.setDestinationAddress( dest);

OriginAddressEstimatedDeliveryDateRequest origin  = new OriginAddressEstimatedDeliveryDateRequest();
origin.setCountry("<ISO 3166-1 country/region code>");
origin.setState("<ISO 3166-1 country/region code>");
edd.setOriginAddress(origin);

edd.setPickupTime("2024-08-01 06:42:30");
request.setEstimatedDeliveryDates(Arrays.asList(edd));
PredictBatchResponse response = EstimatedDeliveryDateResource.predictBatch()
        .setPredictBatchRequest(request)
        .create();
System.out.println(response.getEstimatedDeliveryDates().get(0).getSlug());
```

## Help

If you get stuck, we're here to help:

- [Issue Tracker](https://github.com/AfterShip/tracking-sdk-java/issues) for questions, feature requests, bug reports and general discussion related to this package. Try searching before you create a new issue.
- Contact AfterShip official support via support@aftership.com

## License
Copyright (c) 2024 AfterShip

Licensed under the MIT license.