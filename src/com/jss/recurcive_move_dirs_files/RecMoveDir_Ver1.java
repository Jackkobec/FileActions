package com.jss.recurcive_move_dirs_files;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  We move through the all files and directories from the start path
 *  !BUT! we dint check current file to equals keyword
 *  Look at advanced  version
 */
public class RecMoveDir_Ver1 {

    private static void MoveTroughtDirsAndFiles(File path, ArrayList<String> res, String keyWord)
            throws IOException {
        File file = new File(path.getPath());
        File[] list = file.listFiles();

        for (File f : list) {
            //if its afile
            if (f.isFile()) {
                //check keyword in the name of file
                if (f.getName().contains(keyWord)) {
                    res.add("File: " + f.getCanonicalPath());
                }
                //if its a directory
            } else {
                //check keyword in the name of dir
                if (f.getName().equalsIgnoreCase(keyWord)) {
                    res.add("Dir: " + f.getCanonicalPath());
                }
                MoveTroughtDirsAndFiles(f.getCanonicalFile(), res, keyWord);
            }
        }
    }

    public static void main(String[] args) {
        final String path = "d://Test Dir";
        ArrayList<String> res = new ArrayList<String>();

        try {
            MoveTroughtDirsAndFiles(new File(path), res, "teo");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);
    }
}