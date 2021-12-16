package com.akrck02.ignorepro.src;

import com.akrck02.ignorepro.src.core.Constants;
import com.akrck02.ignorepro.src.core.Ignore;
import com.akrck02.ignorepro.src.core.Protocol;
import com.akrck02.ignorepro.src.io.LocalIgnoreWriter;
import com.akrck02.ignorepro.src.io.Reader;
import com.akrck02.ignorepro.src.io.LocalTemplateReader;
import com.akrck02.ignorepro.src.io.Writer;

import java.io.File;
import java.util.*;

public class App {

    private String url;
    private final Map<Protocol,Reader> readers;
    private final Map<Protocol,Writer> writers;

    public App(String url){
        this.url = url;
        this.readers = new HashMap<>();
        this.writers = new HashMap<>();

        this.readers.put(Protocol.FILE,new LocalTemplateReader());
        this.writers.put(Protocol.FILE,new LocalIgnoreWriter());
    }

    /**
     * Write a file for the given protocol
     * @param url The file URL
     * @param content The content to write
     * @param protocols The protocol to follow
     */
    private void write(String url, String content, List<Protocol> protocols){
        for (Protocol protocol: protocols) {
            Writer wr = this.writers.get(protocol);
            if(wr != null)
                wr.write(url,content);
        }
    }

    /**
     * Read a file for the given protocol
     * @param url The file URL
     * @param protocol The protocol to follow
     * @return An optional with the result String
     */
    private Optional<String> read(String url, Protocol protocol){
            Reader rd = this.readers.get(protocol);
            if(rd != null)
                return Optional.ofNullable(rd.read(url));

            return Optional.empty();
    }


    /**
     * Create an ignore file
     * @param url The url of the file output
     * @param protocols The protocols to follow
     * @param ignoreTemplates The templates to mix
     */
    public void create(String url, List<Protocol> protocols, List<Ignore> ignoreTemplates){

        for (Ignore ig: ignoreTemplates) {

            StringBuilder builder = new StringBuilder();
            builder.append(Constants.TEMPLATE_URLS)
                .append(ig.getName().replaceAll(" ", "_"))
                .append(Constants.TEMPLATE_EXTENSION);

            System.out.println(System.getProperty("user.dir"));
            System.out.println("URL: " + new File(builder.toString()).getAbsolutePath());

            String content = read(builder.toString(),Protocol.FILE).orElse("");
            content += "\n";
            write(url,content,protocols);
        }

    }

}


