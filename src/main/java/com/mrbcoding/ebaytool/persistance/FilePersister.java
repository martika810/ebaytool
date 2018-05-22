package com.mrbcoding.ebaytool.persistance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mrbcoding.ebaytool.domain.ProductMutable;
import com.sun.tools.javac.resources.javac;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import static sun.plugin2.util.PojoUtil.toJson;

/**
 * Created by rsm095 on 21/05/2018.
 */
public class FilePersister{


    public static <TYPE> TYPE loadFromFile(String filePath, Class<TYPE> classType){
        Gson gson = new GsonBuilder().create();
        String textExtractedFromFile = null;
        try {
            textExtractedFromFile = FileUtils.readFileToString(new File(filePath), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Start crying - File doesn't exist! ");
        }
        TYPE object = gson.fromJson(textExtractedFromFile,classType);
        return object;
    }

    public static <TYPE> void persist(String filePath,TYPE object){
        Gson gson = new GsonBuilder().create();
        String textToSave=gson.toJson(object).toString();
        try {
            FileUtils.writeStringToFile(new File(filePath),textToSave,Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Start crying - File doesn't exist! ");
        }
    }

    public static <TYPE> void persist(String filePath,List<TYPE> list){
        Gson gson = new GsonBuilder().create();
        String textToSave = gson.toJson(list).toString();
        try {
            FileUtils.writeStringToFile(new File(filePath),textToSave,Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Start crying - File doesn't exist! ");
        }
    }

    public static <TYPE> List<TYPE> loadListFromFile(String filePath, Class<TYPE> classType){
        Gson gson = new GsonBuilder().create();
        String textExtractedFromFile = null;
        try {
            textExtractedFromFile = FileUtils.readFileToString(new File(filePath), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Start crying - File doesn't exist! ");
        }

        List<TYPE> objectList = gson.fromJson(textExtractedFromFile,List.class);
        List<TYPE> anotherList = objectList.stream().map( x -> gson.fromJson(x.toString(),classType)).collect(Collectors.toList());
        return anotherList;
    }
}
