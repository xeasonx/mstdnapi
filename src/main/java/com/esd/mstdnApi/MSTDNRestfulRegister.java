package com.esd.mstdnApi;

import com.esd.mstdnRequestEntities.RequestEntity;

import java.util.HashMap;

public class MSTDNRestfulRegister {
    public String name;
    public String path;
    public String contentType;
    public int bodyType;
    public String bodyClass;
    public RequestEntity body;
    public String method;
    public HashMap<String, String> headers;
    public Attachment[] files;
    public Attachment file;

    public MSTDNRestfulRegister () {}


    public class Attachment {
        public String key;
        public String value;
        public String mediaType;
        public String filePath;
    }
}
