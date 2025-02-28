/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.http;

import com.aftership.auth.Auth;
import com.aftership.auth.AuthType;
import com.aftership.exception.ApiException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class Request {
  private final Map<String, List<String>> queryParams;
  private final Map<String, String> headerParams;

  private final HttpMethod method;
  private final String path;
  private final String date;
  private String queryString;
  private String body;

  public Request(HttpMethod method, String path) {
    this.method = method;
    this.path = path;
    this.date = this.getCurrDate();
    this.queryParams = new HashMap<>(8);
    this.headerParams = new HashMap<>(8);
  }

  private static String encodeParameters(final Map<String, List<String>> params)
      throws ApiException {
    List<String> parameters = new ArrayList<>();

    for (final Map.Entry<String, List<String>> entry : params.entrySet()) {
      try {
        String encodedName = URLEncoder.encode(entry.getKey(), "UTF-8");
        for (final String value : entry.getValue()) {
          if (value == null) {
            continue;
          }
          String encodedValue = URLEncoder.encode(value, "UTF-8");
          parameters.add(encodedName + "=" + encodedValue);
        }
      } catch (final UnsupportedEncodingException e) {
        throw new ApiException(0, e.getMessage());
      }
    }
    return joinIgnoreNull("&", parameters);
  }

  private static String joinIgnoreNull(final String separator, final List<String> items) {
    final StringBuilder builder = new StringBuilder();

    for (final String item : items) {
      if (item != null) {
        if (builder.length() > 0) {
          builder.append(separator);
        }
        builder.append(item);
      }
    }

    return builder.toString();
  }

  public String getURL() {
    try {
      return path + "?" + encodeQueryParams();
    } catch (Exception e) {
      return path;
    }
  }

  public void setAuth(
      final String apiKey, final String apiSecret, final AuthType authenticationType)
      throws Exception {
    Auth auth = new Auth(apiKey, apiSecret, authenticationType);
    Map<String, String> authHeaders = auth.getAuthHeader(this);
    if (authHeaders != null) {
      headerParams.putAll(authHeaders);
    }
  }

  public String encodeQueryParams() throws Exception {
    queryString = encodeParameters(queryParams);
    return queryString;
  }

  public void addQueryParam(final String name, final String value) {
    addParam(queryParams, name, value);
  }

  public void addHeaderParam(final String name, final String value) {
    if (value == null || value.equals("null")) {
      return;
    }

    if (!headerParams.containsKey(name)) {
      headerParams.put(name, value);
    }
  }

  private void addParam(
      final Map<String, List<String>> params, final String name, final String value) {
    if (value == null || value.equals("null")) return;

    if (!params.containsKey(name)) {
      params.put(name, new ArrayList<>());
    }

    params.get(name).add(value);
  }

  private String getCurrDate() {
    SimpleDateFormat sdf3 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
    return sdf3.format(new Date());
  }

  public String getPath() {
    return path;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Map<String, String> getHeaders() {
    return headerParams;
  }

  public String getQueryString() {
    return queryString;
  }

  public String getDate() {
    return date;
  }

  public HttpMethod getMethod() {
    return method;
  }
}
