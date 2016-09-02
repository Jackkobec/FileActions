package com.jss.fileactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface IBash {

    // show file content


    String less(String path) throws FileNotFoundException;

    void writeInto(String path, String content) throws IOException;

    void appendTo(String path, String content) throws IOException;

    // show files in current directory
    List<String> ls(String currentDirPath) throws FileNotFoundException;

    // use File
    // create new file
    boolean touch(String path) throws IOException;

    boolean delete(String path) throws FileNotFoundException;

    boolean copy(String src, String dest) throws FileNotFoundException;

    List<String> grep(String src, String keyWord) throws FileNotFoundException;

    //shallow copy
    // use standard clone mechanism in java
    Object clone(Object obj);

    byte[] toByteArr(Object obj) throws IOException;

    Object fromByteArr(byte[] arr) throws IOException;

    // do deep copy via Java Serialization, use above methods
    Object cloneDeep(Object obj) throws IOException, ClassNotFoundException;

    boolean saveObjToFile(Object obj, String filePath) throws IOException;

    <T> Object deSerialization(T obj, String filePath)throws IOException, ClassNotFoundException;

    boolean downloadFile(String url, String localPathName) throws IOException, ClassNotFoundException;

    // implement recursive search (find in curr directory, then find in child dir, then repeat...)

    List<String> findRefactored(File dir, List<String> resaultArray, String keyWord) throws IOException;

    List<String> find(File dir, List<String> resaultArray, String keyWord) throws IOException;

    List<String> findRefactored2(File dir, List<String> resaultArray, String keyWord) throws IOException;


}
