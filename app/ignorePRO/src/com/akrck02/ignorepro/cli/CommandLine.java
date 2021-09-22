package com.akrck02.ignorepro.cli;

import com.akrck02.ignorepro.core.Ignore;

import java.util.Arrays;
import java.util.List;

public class CommandLine {

    public static int start(String[] args) {

        List<String> arguments = Arrays.asList(args);

        String output = "./.gitignore";
        if(arguments.contains("-u")){
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

        return 1;
    }

    public static void main(String[] args) {
        args = new String[] {"-o","../.gitignore","-t","python,java"};
        CommandLine.start(args);
    }
}

