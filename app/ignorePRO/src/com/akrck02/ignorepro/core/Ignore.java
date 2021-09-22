package com.akrck02.ignorepro.core;

public enum Ignore {
    VSCODE("vscode",false),
    VISUAL_STUDIO("visual studio",false),
    INTELLIJ_IDEA("intellij idea",false),
    PYCHARM("pycharm",false),
    UNITY("unity",false),

    JAVA("java",true),
    JAVASCRIPT("javascript",true),
    PYTHON("python",true),
    ;

    private String name;
    private boolean lang;

    Ignore(String name, boolean lang){
        this.name = name;
        this.lang = lang;
    }

}
