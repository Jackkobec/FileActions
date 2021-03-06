package com.jss.fileactions;


import java.io.*;
import java.util.ArrayList;

import java.util.List;

/**
 * Bash realisation
 */
public class Bash implements IBash, Cloneable, Serializable {

    String default_path = "d://FileActions.txt";

    /**
     * Correct show List<String>: next element - next line without "," "[ ]" and other symbols
     */


    public <T> void listStrCorrectShow(List<T> list) {
        for (T s : list) {
            System.out.println(s);
        }
    }

    /**
     * Read info from the file
     */

    public String less(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        //we will build string with StringBuilder
        StringBuilder sb = new StringBuilder();

        //create input stream
        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {

            //create variable for the append with StringBuilder
            String string;
            //read file line by line until EOF(find first empty line)
            while ((string = in.readLine()) != null) {
                sb.append(string + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Write info to the file
     */
    @Override
    public void writeInto(String path, String content) throws IOException {

        File file = new File(path);
        //check file present, create new if not
        if (!file.exists()) {
            file.createNewFile();
        }
        //create output stream
        try (BufferedWriter out = new BufferedWriter(new PrintWriter(file.getAbsoluteFile()))) {

            out.write(content);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Updating  info in the file version used earlier methods less and writeInto
     */
    @Override
    public void appendTo(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        //new FileWriter(file.getAbsoluteFile(), true)))   true - let us do append to the file
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true))) {

            out.newLine();
            out.write(content);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show dir forks
     */
    @Override
    public List<String> ls(String currentDirPath) throws FileNotFoundException {
        File file = new File(currentDirPath);
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный путь отсуствует");
        }
        //Take all filenames from the currentDirPath > to the File[]
        File[] files = file.listFiles();
        if (files.length == 0) {
            System.out.println("Dir " + currentDirPath + " is empty");
        }
        List<String> resaultArray = new ArrayList<>();
        //Output all filenames from currentDirPath on console > write names to the  List<String> for return action
        for (int i = 0; i < files.length; i++) {

            System.out.println(files[i].getName());
            resaultArray.add(files[i].getName());
        }

        return resaultArray;
    }

    /**
     * Create dir by path
     */
    @Override
    public boolean touch(String path) throws IOException {
        File file = new File(path);
        //check this path, if ton present - create new directory
        if (!file.exists()) {
            file.mkdir();
        }
        return true;
    }

    /**
     * Delete file by path
     */
    @Override
    public boolean delete(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        file.delete();
        return true;
    }

    /**
     * Copying file
     */
    @Override
    public boolean copy(String src, String dest) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File fileSrc = new File(src);
        if (!fileSrc.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }

        try {
            File fileDest = new File(dest);
            if (!fileDest.exists()) {
                fileDest.createNewFile();
            }
            sb.append(less(src));
            writeInto(dest, less(src).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }

    /**
     * Show lines with keyWord
     */
    @Override
    public List<String> grep(String src, String keyWord) throws FileNotFoundException {
        File file = new File(src);
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        //we will build string with StringBuilder
        StringBuilder sb = new StringBuilder();

        List<String> resultArray = new ArrayList<>();
        try {
            //create input stream
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //create variable for the append with StringBuilder
                String string;
                System.out.println("По запросу " + "\"" + keyWord + "\"" + " найдено:");
                //read file line by line until EOF(find first empty line)
                while ((string = in.readLine()) != null) {

                    //find the keyWord in the current line
                    if (string.contains(keyWord)) {
                        sb.append(string.replaceAll(keyWord, "\"" + keyWord + "\""));
                        //add to the array current line with keyWord \ add " " to keyWord
                        resultArray.add(string.replaceAll(keyWord, "\"" + keyWord + "\"") + "\n");

                    }

                }
                //close with finally
            } finally {
                in.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    /**
     * Cloning the objects
     */
    @Override
    // Cloneable implement must be declared on the class signature
    public Object clone(Object obj) {
        try {
            //Cloning through the superclass
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] toByteArr(Object obj) throws IOException {
        File file = new File("d://TestDir/Byte.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        return baos.toByteArray();
    }

    @Override
    public Object fromByteArr(byte[] arr) throws IOException {


        File file = new File("d://TestDir/Byte.txt");
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.read(arr);

        return obj;
    }


    public Object fromByteArr2(byte[] arr) throws IOException, ClassNotFoundException {

        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        ObjectInputStream ois = new ObjectInputStream(bais);

        return ois.readObject();
    }


    @Override
    public Object cloneDeep(Object obj) throws ClassNotFoundException, IOException {

        File file = new File("d://Test Dir2/Byte.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            return ois.readObject();
        }
    }


    @Override
    public boolean saveObjToFile(Object obj, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(obj);
        oos.flush();
        oos.close();

        return true;
    }

    @Override
    public <T> T deSerialization(T obj, String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object replicatedObj = (T) ois.readObject();
        return (T) replicatedObj;
    }


    @Override
    public boolean downloadFile(String url, String localPathName) throws IOException, ClassNotFoundException {
        File urlFile = new File(url);
        File lockalFile = new File(localPathName);
        if (!urlFile.canRead()) {
            throw new FileCantDownloadExeption("Cant download file");
        } else if (!lockalFile.exists()) {
            lockalFile.createNewFile();
        }

        FileInputStream fis = new FileInputStream(urlFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();

        saveObjToFile(obj, lockalFile.getAbsolutePath());
        return true;
    }


    /**
     * Find from the start-tree dir and in the all forks
     */
    @Override
    public List<String> find(File dir, List<String> resaultArray, String keyWord) throws IOException {
        File file = new File(dir.getPath());
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        //get list of files in the current dir
        File[] files = file.listFiles();

        //if length of the File[] array == 0   ist mean that dir is empty
        if (files.length == 0) {
            System.out.println("Dir " + dir + " is empty");
        }
        //move trough array of the inner files of current dir
        for (int i = 0; i < files.length; i++) {
            //check is dir the i-file
            if (files[i].isDirectory()) {
                //check equals keyWord and i-file
                if (files[i].getName().equalsIgnoreCase(keyWord)) {
                    //append founded file name to the List<String> resaultArray
                    resaultArray.add("--------------------------------------\n" + "File " + "\"" + files[i].getName()
                            + "\"" + " found in:  " + files[i].getAbsolutePath());
                }
                //recursive call this method for the forks directories
                find(files[i], resaultArray, keyWord);
            }
        }
        return resaultArray;
    }

    /**
     * Refactored Find from the start-tree dir and in the all forks
     */
    @Override
    public List<String> findRefactored(File dir, List<String> resaultArray, String keyWord) throws IOException {
        File file = new File(dir.getPath());
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        if (file.getName().contains(keyWord)) {
            resaultArray.add("--------------------------------------\n" + ((file.isDirectory()) ? "Dir " : "File ")
                    + "\"" + file.getName() + "\"" + " found in:  " + file.getAbsolutePath());
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                findRefactored(f.getCanonicalFile(), resaultArray, keyWord);
            }
        }
        return resaultArray;
    }

    @Override
    public List<String> findRefactored2(File dir, List<String> resaultArray, String keyWord) throws IOException {
        File file = new File(dir.getPath());
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        //get list of files in the current dir
        File[] files = file.listFiles();

        //if length of the File[] array == 0   ist mean that dir is empty
        if (files.length == 0) {
            System.out.println("Dir " + dir + " is empty");
        }
        //move trough array of the inner files of current dir
        for (File f : files) {
            if (f.isFile()) {
                continue;
            }
            //joined check is dir the i-file and equals his name to keyWord
            if (f.isDirectory() && f.getName().equalsIgnoreCase(keyWord)) {
                //append founded file name to the List<String> resaultArray
                resaultArray.add("--------------------------------------\n" + "File "
                        + "\"" + f.getName() + "\"" + " found in:  " + f.getAbsolutePath());
            }
            //recursive call this method for the forks directories
            findRefactored2(f.getCanonicalFile(), resaultArray, keyWord);
        }
        return resaultArray;
    }


   /* public List<String> findRefactored3(File dir, List<String> resaultArray, String keyWord) throws IOException {
        File file = new File(dir.getPath());
        if (!file.exists()) {
            throw new FileNotFoundException("Указанный файл отсуствует");
        }
        //get list of files in the current dir
        File[] files = file.listFiles();
        //if length of the File[] array == 0   ist mean that dir is empty
//        if (files.length == 0) {
//           return null;
        // System.out.println("Dir " + dir + " is empty");
//        }
        //move trough array of the inner files of current dir
        for (File f : files) {
            if (f.isFile()) {
                //check file name with "contains" because file has a
                if (f.getName().contains(keyWord)) {
                    //append founded file name to the List<String> resaultArray
                    resaultArray.add("--------------------------------------\n" + "File "
                            + "\"" + f.getName() + "\"" + " found in:  " + f.getAbsolutePath());
                }
            } else {
                if (f.getName().equalsIgnoreCase(keyWord)) {
                    //append founded file name to the List<String> resaultArray
                    resaultArray.add("--------------------------------------\n" + "Dir "
                            + "\"" + f.getName() + "\"" + " found in:  " + f.getAbsolutePath());
                }
                findRefactored3(f.getCanonicalFile(), resaultArray, keyWord);
            }
        }
        return resaultArray;
    }*/

  /* public List<String> findRefactored4(File dir, List<String> resaultArray, String keyWord) throws IOException {
       File file = new File(dir.getPath());
       if (!file.exists()) {
           throw new FileNotFoundException("Указанный файл отсуствует");
       }
       //get list of files in the current dir
       File[] files = file.listFiles();
       //move trough array of the inner files of current dir
       for (File f : files) {
           //at first check is current element a File
           if (f.isFile()) {
               //check file name with "contains" because file has a
               if (f.getName().contains(keyWord)) {
                   //append founded file name to the List<String> resaultArray
                   resaultArray.add("--------------------------------------\n" + "File "
                           + "\"" + f.getName() + "\"" + " found in:  " + f.getAbsolutePath());
               }
               //for the directories
           } else {
               if (f.getName().equalsIgnoreCase(keyWord)) {
                   //append founded file name to the List<String> resaultArray
                   resaultArray.add("--------------------------------------\n" + "Dir "
                           + "\"" + f.getName() + "\"" + " found in:  " + f.getAbsolutePath());
               }
               findRefactored4(f.getCanonicalFile(), resaultArray, keyWord);
           }
       }
       return resaultArray;
   }
   */


    private class FileCantDownloadExeption extends RuntimeException {
        public FileCantDownloadExeption(String s) {
        }
    }
}