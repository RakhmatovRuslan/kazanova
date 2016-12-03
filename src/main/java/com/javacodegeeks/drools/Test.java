package com.javacodegeeks.drools;

import com.javacodegeeks.drools.libraries.Library;
import com.javacodegeeks.drools.tasks.JsonParserTask;
import com.javacodegeeks.drools.tasks.Task;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Ruslan on 11/30/2016.
 */
public class Test {


    public static void main(String[] args) {
        //init scanner
        Scanner scanner = new Scanner(System.in);

        // init Rule engine and working memory
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        // init data for working memory
        List<Library> jsonParserLibraries = LibrariesRepository.getInstance().getJsonParserLibraries();
        JsonParserTask jsonParserTask = new JsonParserTask();

        //ask user to input his problem (Task)
        // example: I want to transfer my data in json format, so I need a good java library for that
        System.out.println("Hey developer, what is your problem?");
        String problemDefinition = "---I want to transfer my data in json format, so I need a good java library for that";
        System.out.println(problemDefinition);
        ProblemAnalyzer problemAnalyzer = new ProblemAnalyzer();
        Task task = problemAnalyzer.analyzerProblemDefinition(problemDefinition);
        System.out.println(task.getDefinition());

        // ask user to input additional data
        jsonParserTask.askForConditions();

        // insert expression into working memory
        kSession.setGlobal("jsonParserLibraries", jsonParserLibraries);
        kSession.insert(jsonParserTask);

        //firing all rules
        kSession.fireAllRules();

        System.out.println(jsonParserTask);
    }
}
