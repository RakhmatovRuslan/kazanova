package com.javacodegeeks.drools.gui;

import com.javacodegeeks.drools.LibrariesRepository;
import com.javacodegeeks.drools.ProblemAnalyzer;
import com.javacodegeeks.drools.Questionnaire;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.libraries.Library;
import com.javacodegeeks.drools.tasks.JsonParserTask;
import com.javacodegeeks.drools.tasks.Task;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatyana on 12/11/2016.
 */
public class RuleEngineClass {
    private KieServices ks;
    private KieContainer kContainer;
    private KieSession kSession;
    private List<Library> jsonParserLibraries;
    private List<Task> correlatedTasks;
    private List<Framework> webFrameworkList;
    private JsonParserTask jsonParserTask;
    private Task task;
    private FactHandle factQuestionInsert;
    private Questionnaire questionnaire;
    private List<Framework> ormFrameworksList;

    public  RuleEngineClass(){
        ks = KieServices.Factory.get();
        kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
        jsonParserLibraries = LibrariesRepository.getInstance().getJsonParserLibraries();
        correlatedTasks=new ArrayList<>();
        jsonParserTask = new JsonParserTask();
        webFrameworkList = LibrariesRepository.getInstance().getWebFrameworks();
        factQuestionInsert = null;
        ormFrameworksList = LibrariesRepository.getInstance().getOrmFrameworks();
    }

    public Task defineProblem(String problemDefinition){
        ProblemAnalyzer problemAnalyzer= new ProblemAnalyzer();
        task = problemAnalyzer.analyzerProblemDefinition(problemDefinition);
        return task;
    }

    public void setGlobals(){
        kSession.setGlobal("questionnaire", questionnaire);
        kSession.setGlobal("task",task);
        kSession.setGlobal("jsonParserLibraries", jsonParserLibraries);
        kSession.setGlobal("webFrameworkList", webFrameworkList);
        kSession.setGlobal("correlatedTasks",correlatedTasks);
        kSession.setGlobal("ormFrameworks",ormFrameworksList);
    }

    public List<Task> getCorrelatedTasks() {
        return correlatedTasks;
    }

    public void setCorrelatedTasks(List<Task> correlatedTasks) {
        this.correlatedTasks = correlatedTasks;
    }

    public void insertExpressions(){
        kSession.insert(task);
        kSession.fireAllRules();

        correlatedTasks.forEach(t-> kSession.insert(t));
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public FactHandle getFactQuestionInsert() {
        return factQuestionInsert;
    }

    public void setFactQuestionInsert(FactHandle factQuestionInsert) {
        this.factQuestionInsert = factQuestionInsert;
    }

    public KieServices getKs() {
        return ks;
    }

    public void setKs(KieServices ks) {
        this.ks = ks;
    }

    public KieContainer getkContainer() {
        return kContainer;
    }

    public void setkContainer(KieContainer kContainer) {
        this.kContainer = kContainer;
    }

    public KieSession getkSession() {
        return kSession;
    }

    public void setkSession(KieSession kSession) {
        this.kSession = kSession;
    }

    public List<Library> getJsonParserLibraries() {
        return jsonParserLibraries;
    }

    public void setJsonParserLibraries(List<Library> jsonParserLibraries) {
        this.jsonParserLibraries = jsonParserLibraries;
    }

    public JsonParserTask getJsonParserTask() {
        return jsonParserTask;
    }

    public void setJsonParserTask(JsonParserTask jsonParserTask) {
        this.jsonParserTask = jsonParserTask;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Framework> getWebFrameworkList() {
        return webFrameworkList;
    }

    public void setWebFrameworkList(List<Framework> webFrameworkList) {
        this.webFrameworkList = webFrameworkList;
    }
}
