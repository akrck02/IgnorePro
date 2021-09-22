package com.akrck02.ignorepro.io;

import com.akrck02.ignorepro.exception.io.WriterException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalIgnoreWriter implements Writer{
    @Override
    public void write(String url, String content) throws WriterException{

        try {
            File file = new File(url);

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);

        }
        catch(IOException e){
            throw new WriterException(e);
        }
    }
}
