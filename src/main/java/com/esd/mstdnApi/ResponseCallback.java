package com.esd.mstdnApi;

import com.esd.ApiPlayground;

public abstract class ResponseCallback {
    private ApiPlayground.ObservableResponse observableResponse;

    public ResponseCallback() {
        observableResponse = new ApiPlayground.ObservableResponse();
    }

    public void setObservableResponse(ApiPlayground.ObservableResponse observableResponse) {
        this.observableResponse = observableResponse;
    }

    public ApiPlayground.ObservableResponse getObservableResponse() {
        return observableResponse;
    }

    public static ResponseCallback getCallback(String callbackClass) {
        try {
            Class<?> cls = Class.forName(callbackClass);
            return (ResponseCallback) cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
