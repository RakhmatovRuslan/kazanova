package com.javacodegeeks.drools;

import com.javacodegeeks.drools.enums.WebApplicationType;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.frameworks.OrmFramework;
import com.javacodegeeks.drools.frameworks.WebFramework;
import com.javacodegeeks.drools.libraries.JsonParserLibrary;
import com.javacodegeeks.drools.libraries.Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class LibrariesRepository {

    final static String jsonParserLibFileName = "jsonlib.txt";
    final static String webFrameworkFileName = "webFramework.txt";
    final static String ormFrameworkFileName = "orm-framework.txt";

    private List<Library> jsonParserLibraries;
    private List<Framework> webFrameworks;
    private List<Framework> ormFrameworks;

    private static LibrariesRepository ourInstance = new LibrariesRepository();

    public static LibrariesRepository getInstance() {
        return ourInstance;
    }

    private LibrariesRepository() {
        getJsonParserFromFile();
        getWebFrameworksFromFile();
        getOrmFrameworksFromFile();
    }

    private void getOrmFrameworksFromFile() {
        File file = new File(LibrariesRepository.class.getClassLoader().getResource("knowledge/"+ormFrameworkFileName).getFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            lines.remove(0);
            ormFrameworks = new ArrayList<>();
            lines.forEach(line->{
                String [] words = line.split(" ");
                ormFrameworks.addAll(Arrays.asList(
                   new OrmFramework(words[0],Double.valueOf(words[1]),Double.valueOf(words[2]))
                ));
            });
            System.out.println("============================================================");
            ormFrameworks.forEach(orm-> System.out.println(orm));
            System.out.println("============================================================");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getJsonParserFromFile() {
        File file = new File(LibrariesRepository.class.getClassLoader().getResource("knowledge/" + jsonParserLibFileName).getFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Stream<String> fileContentStream = bufferedReader.lines();
            jsonParserLibraries = new ArrayList<>();
            List<String> lines = fileContentStream.collect(Collectors.toList());
            lines.remove(0);
            lines.forEach(line -> {
                String[] tokens = line.split(" ");
                jsonParserLibraries.add(new JsonParserLibrary(tokens[0],
                        Double.valueOf(tokens[3]), 0.0,
                        Double.valueOf(tokens[4]),
                        Double.valueOf(tokens[1]),
                        Double.valueOf(tokens[2])));
            });
            System.out.println("============================================================");
            jsonParserLibraries.stream().forEach(lib -> System.out.println(lib.toString()));
            System.out.println("============================================================");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getWebFrameworksFromFile() {
        File file = new File(LibrariesRepository.class.getClassLoader().getResource("knowledge/" + webFrameworkFileName).getFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            lines.remove(0);
            webFrameworks = new ArrayList<>();
            lines.forEach(line -> {
                String[] tokens = line.split(" ");
                webFrameworks.add(
                        new WebFramework(tokens[0], Double.valueOf(tokens[1]),
                                Double.valueOf(tokens[2]),
                                Double.valueOf(tokens[3]),
                                Double.valueOf(tokens[4]),
                                Double.valueOf(tokens[5]),
                                Double.valueOf(tokens[6]),
                                Double.valueOf(tokens[7]),
                                Double.valueOf(tokens[8]),
                                Double.valueOf(tokens[9]),
                                WebApplicationType.values()[Integer.valueOf(tokens[10])])
                );
            });
            webFrameworks.forEach(framework -> System.out.println(framework));
            System.out.println("============================================================");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Framework> getWebFrameworks() {
        return webFrameworks;
    }

    public void setWebFrameworks(List<Framework> webFrameworks) {
        this.webFrameworks = webFrameworks;
    }

    public List<Library> getJsonParserLibraries() {
        return jsonParserLibraries;
    }

    public void setJsonParserLibraries(List<Library> jsonParserLibraries) {
        this.jsonParserLibraries = jsonParserLibraries;
    }

    public List<Framework> getOrmFrameworks() {
        return ormFrameworks;
    }

    public void setOrmFrameworks(List<Framework> ormFrameworks) {
        this.ormFrameworks = ormFrameworks;
    }
}
