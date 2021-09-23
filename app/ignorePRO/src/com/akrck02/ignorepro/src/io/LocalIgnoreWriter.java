package com.akrck02.ignorepro.src.io;

import com.akrck02.ignorepro.src.exception.io.WriterException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalIgnoreWriter implements Writer{
    @Override
    public void write(String url, String content) throws WriterException{

        File file = new File(url);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            System.out.println("Writing into ignore file " + content);
            bw.append(content);
        }
        catch(IOException e){
            throw new WriterException(e);
        }
    }
}
