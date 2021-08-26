package com.esd.mstdnApi;


/**
 * RequestBackend interface
 * You can choose different libraries to perform HTTP API request by implementing this interface.
 * This interface provides a static method that returns a new instance of implemented class from
 * the name of the class.
 */
public interface RequestBackend {
    /**
     * instantiate a new instance of RequestBackend's subclass and cast it to RequestBackend
     * @param backendClass, String, fully qualified class name
     * @return new RequestBackend instance
     */
    static RequestBackend getBackend(String backendClass) {
        try {
            Class<?> cls = Class.forName(backendClass);
            return (RequestBackend) cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * performs the actual request asynchronously
     * @param register, MSTDNRestfulRegister instance that contains request context description
     * @param callback, String, to invoke a RequestBackend instance
     */
    public void request(MSTDNRestfulRegister register, ResponseCallback callback);

    public void teardown();

    public boolean isTearedDown();
}
