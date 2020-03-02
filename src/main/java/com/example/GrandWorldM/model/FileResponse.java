package com.example.GrandWorldM.model;

import org.springframework.stereotype.Component;

@Component
public class FileResponse {
    byte[] bytes;
    String str;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
