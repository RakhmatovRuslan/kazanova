package com.javacodegeeks.drools;

import com.javacodegeeks.drools.Libraries.JsonParserLibrary;
import com.javacodegeeks.drools.Libraries.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class LibrariesRepository {

    final static String jsonParserLibFileName = "jsonlib.txt";

    private List<Library> jsonParserLibraries;

    private static LibrariesRepository ourInstance = new LibrariesRepository();

    public static LibrariesRepository getInstance() {
        return ourInstance;
    }

    private LibrariesRepository() {
        getJsonParserFromFile();

    }

    private void getJsonParserFromFile(){
        File file = new File(LibrariesRepository.class.getClassLoader().getResource("rules/"+jsonParserLibFileName).getFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Stream<String> fileContentStream =  bufferedReader.lines();
            jsonParserLibraries = new ArrayList<Library>();
            List<String> lines = new ArrayList<>();
            lines = fileContentStream.collect(Collectors.toList());
            lines.remove(0);
            lines.forEach(line-> {
                String [] tokens = line.split(" ");
                jsonParserLibraries.add(new JsonParserLibrary(tokens[0],Double.valueOf(tokens[3]),0.0,Double.valueOf(tokens[4]),Double.valueOf(tokens[1]),Double.valueOf(tokens[2])));
            });
            jsonParserLibraries.stream().forEach(lib-> System.out.println(lib.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Library> getJsonParserLibraries() {
        return jsonParserLibraries;
    }

    public void setJsonParserLibraries(List<Library> jsonParserLibraries) {
        this.jsonParserLibraries = jsonParserLibraries;
    }


}
