package com.jss.recurcive_move_dirs_files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Base move trough Dirs And FIles
 */
public class BaseRecurciveMoveDir {
    public static void listAll(String path, List<String> resArray)
            throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.isFile()) {
                resArray.add("F: " + f.getCanonicalPath());
            } else {
                resArray.add("D: " + f.getCanonicalPath());
                listAll(f.getCanonicalPath(), resArray);
            }
        }
    }

    public static void main(String[] args) {
        final String path = "D://Test Dir";
        List<String> res = new ArrayList<>();

        try {
            listAll(path, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);
    }
}




