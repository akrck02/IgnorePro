package com.akrck02.ignorepro.src.core;

public enum Protocol {
    FILE("file://"),
    HTTP("http://"),
    FTP("ftp://")
    ;

    private String name;
    Protocol(String name) {
        this.name = name;
    }
}
