package com.java8.nashorn;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ShowMeTheEngines {

    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        for (ScriptEngineFactory engineFactory : scriptEngineManager.getEngineFactories()) {
            System.out.println(engineFactory.getEngineName());
            System.out.println(engineFactory.getLanguageName());
            System.out.println(engineFactory.getLanguageVersion());
        }
    }
}
