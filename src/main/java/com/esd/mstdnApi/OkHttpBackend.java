package com.esd.mstdnApi;

import okhttp3.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/**
 * An implementation of RequestBackend, uses OkHttp library.
 */
public class OkHttpBackend implements RequestBackend {
    private final OkHttpClient client = new OkHttpClient.Builder()
            .connectionSpecs(Arrays.asList(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
            .build();

    /**
     * takes request context description in register instance, build request and perform.
     * @param register, MSTDNRestfulRegister instance that contains request context description
     * @param callback, String, to invoke a RequestBackend instance
     */
    @Override
    public void request(MSTDNRestfulRegister register, ResponseCallback callback) {

        Request.Builder requestBuilder = new Request.Builder();
        RequestBody requestBody = null;
        switch (register.bodyType) {
            case BodyType.NONE:
                break;
            case BodyType.FORM:
                FormBody.Builder formBuilder= new FormBody.Builder();
                HashMap<String, String> hashMap = register.body.getFields();
                for (String key : hashMap.keySet()) {
                    formBuilder.add(key, hashMap.get(key));
                }
                requestBody = formBuilder.build();
                break;
            case BodyType.URL:
//                requestBody = RequestBody.create(register.body.toString(), MediaType.get(register.contentType));
                register.path = register.path + "?" + register.body.toString();
                break;
            case BodyType.RAW:
                requestBody = RequestBody.create(register.body.toString(), MediaType.get(register.contentType));
                break;
            case BodyType.BINARY:
                requestBody = RequestBody.create(new File(register.file.filePath), MediaType.parse(register.file.mediaType));
                break;
            case BodyType.MULTI:
                MultipartBody.Builder multiBuilder = new MultipartBody.Builder();
                multiBuilder.setType(MultipartBody.FORM);
                HashMap<String, String> hashMap1 = register.body.getFields();
                if (hashMap1 != null && hashMap1.size() > 0){
                    for (String key : hashMap1.keySet()) {
                        multiBuilder.addFormDataPart(key, hashMap1.get(key));
                    }
                }
                for (MSTDNRestfulRegister.Attachment file : register.files) {
                    multiBuilder.addFormDataPart(
                            file.key,
                            file.value,
                            RequestBody.create(new File(file.filePath), MediaType.parse(file.mediaType))
                    );
                }
                requestBody = multiBuilder.build();
                break;
            default:
                break;
        }
        requestBuilder.url(register.path).method(register.method, requestBody);
        if (register.headers != null) {
            for (String key : register.headers.keySet()) {
                requestBuilder.addHeader(key, register.headers.get(key));
            }
        }
        Request request = requestBuilder.build();
        client.newCall(request).enqueue((Callback) callback);
    }

    @Override
    public void teardown() {
        client.dispatcher().executorService().shutdown();
        System.out.println("tear down");
    }

    public boolean isTearedDown() {
        return client.dispatcher().executorService().isShutdown();
    }
}
