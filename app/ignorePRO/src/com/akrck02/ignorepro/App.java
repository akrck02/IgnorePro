package com.akrck02.ignorepro;

import com.akrck02.ignorepro.core.Ignore;
import com.akrck02.ignorepro.core.Protocol;
import com.akrck02.ignorepro.io.LocalIgnoreWriter;
import com.akrck02.ignorepro.io.Reader;
import com.akrck02.ignorepro.io.LocalTemplateReader;
import com.akrck02.ignorepro.io.Writer;

import java.util.*;

public class App {

    private String url;
    private Map<Protocol,Reader> readers;
    private Map<Protocol,Writer> writers;

    public App(String url){
        this.url = url;
        this.readers = new HashMap<>();
        this.writers = new HashMap<>();

        this.readers.put(Protocol.FILE,new LocalTemplateReader());
        this.writers.put(Protocol.FILE,new LocalIgnoreWriter());
    }

    private void write(String url, String content, List<Protocol> protocols){
        for (Protocol protocol: protocols) {
            Writer wr = this.writers.get(protocol);
            if(wr != null)
                wr.write(url,content);
        }
    }

    private Optional<String> read(String url, Protocol protocol){
            Reader rd = this.readers.get(protocol);
            if(rd != null)
                return Optional.ofNullable(rd.read(url));

            return Optional.empty();
    }


    public void create(String url, List<Protocol> protocols, List<Ignore> ignoreTemplates){



    }

    public static void main(String[] args) {
        App app = new App("../");

        String content = app.read("../../templates/java/java.gitignore",Protocol.FILE).orElse("NO content");
        System.out.println(content);

        List<Protocol> protocols = new ArrayList<>();
        protocols.add(Protocol.FILE);

        app.write("../testingFile.ignore",content,protocols);
    }

}


