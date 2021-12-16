package com.akrck02.ignorepro.src.io;

/**
 * Abstract writer strategy for
 * multiple implementations of a reader
 */
public interface Reader {

    /**
     * Read for a given url
     * @param url The URL to read
     * @return The String read
     */
    String read(String url);
}
