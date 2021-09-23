package com.akrck02.ignorepro.src.cli;

import com.akrck02.ignorepro.src.App;
import com.akrck02.ignorepro.src.core.Ignore;
import com.akrck02.ignorepro.src.core.Protocol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CommandLine {

    public static int start(String[] args) {

        List<String> arguments = Arrays.asList(args);

        String output = "./.gitignore";
        if(arguments.contains("-o")){
            try{
                int output_index = arguments.indexOf("-o");
                output = arguments.get(output_index + 1);
            }catch(IndexOutOfBoundsException e){
                // message
                return 0;
            }
        }

        String[] templates = new String[0];
        if(arguments.contains("-t")){
            try{
                int templates_index = arguments.indexOf("-t");
                String res = arguments.get(templates_index + 1);
                templates = res.split(",");
            }catch(IndexOutOfBoundsException e){
                // message
                return 0;
            }
        }

        App app = new App("./");

        List<Protocol> protocols = new ArrayList<>();
        protocols.add(Protocol.FILE);

        List<Ignore> ignores = new ArrayList<>();

        for (String template : templates) {
            Ignore temp = Ignore.valueOf(template.toUpperCase(Locale.ROOT));
            if(temp != null)
                ignores.add(temp);
        }


        app.create(output,protocols,ignores);

        return 1;
    }

    public static void main(String[] args) {
        args = new String[] {"-o","../testing.gitignore","-t","python,java"};
        CommandLine.start(args);
    }
}

