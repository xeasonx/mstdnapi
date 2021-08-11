package com.esd.mstdnApi;


public abstract class ResponseCallback {
    static ResponseCallback getCallback(String callbackClass) {
        try {
            Class<?> cls = Class.forName(callbackClass);
            return (ResponseCallback) cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
