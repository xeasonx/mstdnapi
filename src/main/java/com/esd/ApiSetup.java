package com.esd;

import com.esd.mstdnApi.MSTDNRestfulRegister;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ApiSetup {
    public static Properties getProperties(String propertyFile) {
        Properties apiProperties = new Properties();
        String filePath = propertyFile;
        if (filePath == null) {
            filePath = "mstdnConf.properties";
        }
        try {
            apiProperties.load(ClassLoader.getSystemResourceAsStream(filePath));
            return apiProperties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, MSTDNRestfulRegister> getRegisterMap() {
        final Gson API_GSON = new Gson();
        final String REGISTRY_JSON;
        StringBuilder stringBuilder = new StringBuilder();
        int c;

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("mstdnApiRegistry.json");
        try {
            while ((c = inputStream.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        REGISTRY_JSON = stringBuilder.toString();

        final MSTDNRestfulRegister[] registers = API_GSON.fromJson(REGISTRY_JSON, MSTDNRestfulRegister[].class);
        final HashMap<String, MSTDNRestfulRegister> registerMap = new HashMap<String, MSTDNRestfulRegister>();
        for (MSTDNRestfulRegister r : registers) {
            registerMap.put(r.name, r);
        }

        return registerMap;
    }
}
