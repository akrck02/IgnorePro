package com.akrck02.ignorepro.src.io;

import com.akrck02.ignorepro.src.exception.io.WriterException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Local file:// implementation of abstract
 * writer strategy interface.
 */
public class LocalIgnoreWriter implements Writer{

    /**
     * Write a file on disc with the given content
     * @param url The url of the output file
     * @param content The content of the file
     */
    @Override
    public void write(String url, String content) throws WriterException{

        File file = new File(url);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            System.out.println("Writing into ignore file " + content);
            bw.append(content);
        } catch(IOException e) {
            throw new WriterException(e);
        }
    }
}
