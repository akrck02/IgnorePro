package com.akrck02.ignorepro.src.io;

import com.akrck02.ignorepro.src.exception.io.AccessDeniedException;
import com.akrck02.ignorepro.src.exception.io.FileNotFoundException;
import com.akrck02.ignorepro.src.exception.io.ReaderException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Local file:// implementation of abstract
 * reader strategy interface.
 */
public class LocalTemplateReader implements Reader{

    /**
     * Read from disc file
     * @param url The URL to read from
     * @return The content of the file
     */
    @Override
    public String read(String url) throws ReaderException{

        try {
            File file = new File(url);
            if (file.exists())
                return Files.readString(Paths.get(url));

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
