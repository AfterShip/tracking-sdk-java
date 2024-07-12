/*
 * This code was auto generated by AfterShip SDK Generator.
 * Do not edit the class manually.
 */
package com.aftership.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.aftership.constant.ErrorEnum;
import com.aftership.exception.ApiException;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import com.aftership.auth.AuthType;

public class AfterShipClient {

    private final String apiKey;

    private final String apiSecret;

    private final AuthType authType;

    private final String domain;

    private final Integer maxRetry;

    private final Integer timeoutMill;

    private final String userAgent;

    private final String proxy;

    private final HttpClient httpClient;

    protected AfterShipClient(Builder b) {
        this.apiKey = b.apiKey;
        this.apiSecret = b.apiSecret;
        this.authType = b.authType;
        this.domain = b.domain;
        this.maxRetry = b.maxRetry;
        this.timeoutMill = b.timeoutMill;
        this.userAgent = b.userAgent;
        this.proxy = b.proxy;
        this.httpClient = b.httpClient;
    }

    public Response request(final Request request) throws Exception {
        request.setAuth(apiKey, apiSecret, authType);
        Response response = httpClient.request(request, maxRetry);
        int statusCode = response.getStatusCode();
        if (statusCode > 299 && statusCode < 500) {
            int metaCode = 0;
            String message = "";
            try {
                JsonObject jsonObject = JsonParser.parseString(response.getContent()).getAsJsonObject();
                metaCode = jsonObject.get("meta").getAsJsonObject().get("code").getAsInt();
                message = jsonObject.get("meta").getAsJsonObject().get("message").getAsString();
            } catch (Exception ignore) {
            }
            throw new ApiException(metaCode, message, statusCode, ErrorEnum.getByMetaCode(metaCode), response.getContent());
        }
        if (statusCode > 499) {
            throw new ApiException(ErrorEnum.UNKNOWN_ERROR.getCode(), ErrorEnum.UNKNOWN_ERROR.getMessage(), ErrorEnum.UNKNOWN_ERROR.getStatusCode(), 0, "");
        }
        return response;
    }

    public static class Builder {
        private String apiKey;

        private String apiSecret;

        private AuthType authType;

        private String domain;

        private Integer maxRetry = 3;

        private Integer timeoutMill = 3000;

        private String userAgent;

        private String proxy;

        private HttpClient httpClient;

        public Builder(final String apiKey, final String apiSecret, AuthType authType) {
            this.apiKey = apiKey;
            this.apiSecret = apiSecret;
            this.authType = authType;
        }

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder setApiSecret(String apiSecret) {
            this.apiSecret = apiSecret;
            return this;
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder setProxy(String proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder setAuthType(AuthType authType) {
            this.authType = authType;
            return this;
        }

        public Builder setHttpClient(final HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder setTimeout(final int timeout) {
            this.timeoutMill = timeout;
            return this;
        }

        public Builder setMaxRetry(final int maxRetry) {
            this.maxRetry = maxRetry;
            return this;
        }

        public AfterShipClient build() {
            if (this.httpClient == null) {
                RequestConfig.Builder builder = RequestConfig
                    .custom();
                if (this.proxy != null && !this.proxy.isEmpty()) {
                    builder.setProxy(HttpHost.create(this.proxy));
                }
                builder.setSocketTimeout(this.timeoutMill);
                this.httpClient = new HttpClient(builder.build(), this.userAgent, this.domain);
            }
            return new AfterShipClient(this);
        }
    }
}
