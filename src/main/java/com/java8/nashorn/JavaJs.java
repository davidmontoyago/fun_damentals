package com.java8.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JavaJs {

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        engine.eval(new FileReader("src/main/java/com/java8/nashorn/scripts.js"));

        Invocable invocator = (Invocable)engine;
        Integer result = (Integer) invocator.invokeFunction("sumSomething");

        System.out.println(result);
    }

}
