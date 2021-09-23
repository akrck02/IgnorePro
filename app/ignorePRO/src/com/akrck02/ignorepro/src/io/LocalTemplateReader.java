package com.akrck02.ignorepro.src.io;

import com.akrck02.ignorepro.src.exception.io.AccessDeniedException;
import com.akrck02.ignorepro.src.exception.io.FileNotFoundException;
import com.akrck02.ignorepro.src.exception.io.ReaderException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocalTemplateReader implements Reader{
    @Override
    public String read(String url) throws ReaderException{

        try {
            File file = new File(url);
            if (file.exists())
                return new String(Files.readAllBytes(Paths.get(url)), StandardCharsets.UTF_8);

            throw new FileNotFoundException();
        }
        catch(java.nio.file.AccessDeniedException e){
            throw new AccessDeniedException();
        }
        catch(IOException e){
            throw new ReaderException(e);
        }
    }
}
