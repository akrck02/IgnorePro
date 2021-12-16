package com.akrck02.ignorepro.src.io;

/**
 * Abstract writer strategy for
 * multiple implementations of a writer
 */
public interface Writer {

    /**
     * Write a string on a given URL
     * @param url The url to follow
     * @param content The content to write
     */
    void write(String url, String content);
}
