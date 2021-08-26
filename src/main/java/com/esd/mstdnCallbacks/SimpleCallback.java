package com.esd.mstdnCallbacks;

import com.esd.mstdnApi.OkHttpCallback;
import okhttp3.Call;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class SimpleCallback extends OkHttpCallback {
    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        System.out.println("fail");
        e.printStackTrace();
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        System.out.println(response.code());
        System.out.println(response.request().url());
        String responseBody = Util.getBodyStream(response.body().byteStream());
        if (responseBody != null) {
            System.out.println(responseBody);
        }
    }
}
