/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.http;

public enum HttpMethod {
  GET("GET"),
  POST("POST"),
  PUT("PUT"),
  DELETE("DELETE"),
  HEAD("HEAD"),
  PATCH("PATCH");

  private final String method;

  HttpMethod(final String method) {
    this.method = method;
  }

  public String toString() {
    return method;
  }
}
