package com.esd.mstdnCallbacks;

import com.esd.ApiPlayground;
import com.esd.mstdnApi.OkHttpCallback;
import okhttp3.Call;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.io.InputStream;

public class ObservableCallback extends OkHttpCallback {
    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        System.out.println("failed");
        e.printStackTrace();
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        ApiPlayground.ObservableResponse observableResponse = this.getObservableResponse();
        String[] urlParts = response.request().url().toString().split("/");
        InputStream inputStream = response.body().byteStream();
        if (inputStream != null) {
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = inputStream.read()) != -1) {
                stringBuilder.append((char) c);
            }
            observableResponse.setResponseBody(urlParts[urlParts.length - 1], stringBuilder.toString());
        }
        response.body().close();
    }
}
