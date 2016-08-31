package com.jss.file_test_utils;

import java.io.*;

/**
 * Created by Стас on 19.08.2016.
 */
public class FileTestIO {

    private static String text = ("This new text \n");
    private static String fileName = "D://a.txt";



    public static  void main(String[] args) throws FileNotFoundException {

        //Запись в файл
        FileTestIO.write(fileName, text);

        //Попытка прочитать несуществующий файл
       // file_test_utils.FileTestIO.read("no_file.txt");

        //Чтение файла
        String textFromFile = FileTestIO.read(fileName);
        System.out.println(textFromFile);

//updating
        FileTestIO.update(fileName, "update file");
        //Чтение файла
        String textFromFile2 = FileTestIO.read(fileName);
        System.out.println(textFromFile2);

        //deleting
       // exists(fileName);
       // new File(fileName).delete();
    }

    /**
     * Запись  в файл
     * @param fileName
     * @param text
     */
    public static  void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Чтение из файла
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);
        File file = new File(fileName);
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }
   // проверка на наличие файла
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    /**
     * Updating file
     * @param nameFile
     * @param newText
     * @throws FileNotFoundException
     */
    public static void update(String nameFile, String newText) throws FileNotFoundException {
        exists(fileName);
        StringBuilder sb = new StringBuilder();
        String oldFile = read(nameFile);
        sb.append(oldFile);
        sb.append(newText);
        write(nameFile, sb.toString());
    }

    /**
     * Deleting file
     * @param nameFile
     * @throws FileNotFoundException
     */
    public static void delete(String nameFile) throws FileNotFoundException {
        exists(nameFile);
        new File(nameFile).delete();
    }

}
