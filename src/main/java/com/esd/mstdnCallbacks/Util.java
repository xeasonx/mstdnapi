package com.esd.mstdnCallbacks;

import java.io.IOException;
import java.io.InputStream;

public class Util {
    public static String getBodyStream(InputStream bodyStream) {
        if (bodyStream == null) {
            return null;
        }
        int c;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((c = bodyStream.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            return null;
        }
        return stringBuilder.toString();
    }
}
