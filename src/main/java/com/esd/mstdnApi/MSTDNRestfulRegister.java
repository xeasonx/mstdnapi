package com.esd.mstdnApi;

import com.esd.mstdnRequestEntities.RequestEntity;

public class MSTDNRestfulRegister {
    public String name;
    public String path;
    public String contentType;
    public int bodyType;
    public RequestEntity body;
    public String method;
    public Header[] headers;
    public Attachment[] files;
    public Attachment file;

    public MSTDNRestfulRegister () {}

    public class Header {
        public String key;
        public String value;
    }

    public class Attachment {
        public String key;
        public String value;
        public String mediaType;
        public String filePath;
    }
}
