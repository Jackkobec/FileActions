package com.jss.recurcive_move_dirs_files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  We move through the all files and directories from the start path
 *  Also check current file to equals keyword
 *  Advanced  version
 */

public class RecurciveMoveDirFile_Advanced {

    private static List<String> AdvMoveTroughtDirsAndFiles(File path, List<String> resArray, String keyWord)
            throws IOException {
        File file = new File(path.getPath());

        //check keyword in the name of file
        if (file.getName().contains(keyWord)) {
            resArray.add("--------------------------------------\n" + ((file.isDirectory()) ? "Dir " : "File ")
                    + "\"" + file.getName() + "\"" + " found in:  " + file.getAbsolutePath());
        }
        //if its a directory
        if (file.isDirectory()) {
            {
                File[] files = file.listFiles();
                for (File f : files) {
                    AdvMoveTroughtDirsAndFiles(f.getCanonicalFile(), resArray, keyWord);
                }
            }
        }
        return resArray;
    }

    public static void main(String[] args) {
        final String path = "d://Test Dir";
        List<String> res = new ArrayList<>();

        try {
            AdvMoveTroughtDirsAndFiles(new File(path), res, "teo");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);
    }
}

