package com.jss.fileactions;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bash test menu
 */
public class BashTestMenu implements Serializable {
    Scanner sc = new Scanner(System.in);
    User user = new User("22", "Vasa");
    Bash bash = new Bash();

    public void initFile() throws IOException, ClassNotFoundException {

        System.out.println("Enter path to the test Directory:");
        String testPath = sc.nextLine();
        // String testPath = "D://Test Dir2";

        //create dir from console path input
        bash.touch(testPath);
        //append to the dir path way to test txt file
        String createdTestFile = testPath.replaceAll(testPath, testPath + "/createdTestFile.txt");
        File file = new File(createdTestFile);
        //create new createdTestFile.txt
        file.createNewFile();
        //fill createdTestFile.txt  with test text data
        bash.writeInto(file.getPath(), "Hello, we create new File for you!\nCreatedTestFile location: " + file.getAbsolutePath() +
                "\nThis is test text for using bash program:\nHello world! Hello friend! Hi there!\nTrough the hardship to the stars.\n" +
                "All in good time.\nNeither fish nor flash.\nstars, world, fish, friend.");

        String serializationFile = serialisationInit(testPath);

        //call Main Menu
        mainMenu(testPath, createdTestFile, serializationFile);
    }

    public void mainMenu(String testPath, String createdTestFile, String serializationFile) throws IOException, ClassNotFoundException {
        System.out.println("Добро пожаловать в test Bask");
        System.out.println(">>>>>>>MAIN MENU / ГЛАВНОЕ МЕНЮ<<<<<<<:");
        System.out.println("Выберите действие");
        System.out.println("\"0\" - less - show test file content");
        System.out.println("\"1\" - appendTo - add data from console to the test file");
        System.out.println("\"2\" - touch - create new dir");
        System.out.println("\"3\" - delete - deleting file or directory");
        System.out.println("\"4\" - copy - copy file from src to dst");
        System.out.println("\"5\" - grep - find lines with keyword");
        System.out.println("\"6\" - saveObjToFile with serialization");
        System.out.println("\"7\" - deSerialization - replicate saved object from file");
        System.out.println("\"8\" - ls - show forks directories and inner files" +
                "Удаление контакта по мультипараметру(имени или номеру) и отображение контакт - листа без него");
        System.out.println("\"9\" - find -  recursive find files and dirs by keyword");
        System.out.print("Сделайте выбор пункта меню: ");
        Scanner sc = new Scanner(System.in);

        String selection = sc.nextLine();
        String res = menuValidator(selection);

        int sel = Integer.parseInt(res);

        switch (sel) {
            case 0: {
                System.out.println("less:");
                System.out.println(bash.less(createdTestFile));
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 1: {
                System.out.println("appendTo:");
                System.out.println("Enter additional content and pres Enter");
                String content = sc.nextLine();
                bash.appendTo(createdTestFile, content);
                System.out.println(bash.less(createdTestFile));

                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 2: {
                System.out.println("touch:");
                System.out.println("Enter path to the test new  directory:");
                String testDirPath = sc.nextLine();
                bash.touch(testDirPath);
                System.out.println("Dir " + testDirPath + " was creating.");
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 3: {
                System.out.println("delete:");
                System.out.println(bash.delete(createdTestFile) ? "Successful deleting\n" : "Deleting fail");
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 4: {
                System.out.println("copy:");
                System.out.println("Enter dest path to the copy of the test file:");
                String testDestPath = sc.nextLine();
                bash.touch(testDestPath);
                System.out.println(bash.copy(createdTestFile, testDestPath) ? "Copying successfully\n" : "Copying fail");
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 5: {
                System.out.println("grep by keyword \"world\"");
                bash.listStrCorrectShow(bash.grep(createdTestFile, "world"));
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 6: {
                System.out.println("serialization: ");
                System.out.println(bash.saveObjToFile(user, serializationFile) ? "Serialization successfully" : "Serialization fail");
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 7: {
                System.out.println("Deserialization: ");
                User unserialisedUser = bash.deSerialization(new User(), serializationFile);

                System.out.println(unserialisedUser);
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 8: {
                System.out.println("ls: ");
                System.out.println("Enter path to show hiw forks directories and inner files:");
                String startPath = sc.nextLine();
                bash.ls(startPath);
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
            case 9: {
                System.out.println("recursive find: ");
                List<String> resArray = new ArrayList<>();
                System.out.println("Enter start path to begin search: ");
                String startPath = sc.nextLine();
                System.out.print("Enter keyword to search: ");
                String keyword = sc.nextLine();

                bash.listStrCorrectShow(bash.findRefactored(new File(startPath), resArray, keyword));
                subMenu(testPath, createdTestFile, serializationFile);
            }
            break;
        }
    }

    private String serialisationInit(String testPath) throws IOException {
        String serializationDir = testPath.replaceAll(testPath, testPath + "/serialized");
        bash.touch(serializationDir);
        String serializationFile = serializationDir.replaceAll(serializationDir, serializationDir + "/serialFile.txt");
        File serialFile = new File(serializationFile);
        serialFile.createNewFile();
        return serializationFile;
    }

    public void subMenu(String testPath, String createdTestFile, String serializationFile) throws IOException, ClassNotFoundException {
        System.out.println("\"0\" - Return to the MAIN MENU");
        Scanner sc = new Scanner(System.in);
        int subSelect = sc.nextInt();
        while (subSelect != 0) {
            System.out.println("Incorrect Selection");
            subSelect = sc.nextInt();

        }
        mainMenu(testPath, createdTestFile, serializationFile);
    }


    /**
     * Валидатор вібора пункта меню
     */
    public static String menuValidator(String selection) {
        Scanner sc = new Scanner(System.in);
        while (!checkSelection(selection)) {
            System.out.println("Не правильно введен пункт меню. ВВедите число от 0 до 9. Пример: 7");
            selection = sc.nextLine();
        }
        return selection;
    }

    /**
     * Патерн валидации выбора пункта меню, число 0-9, один символ
     */
    public static boolean checkSelection(String selection) {

        Pattern p = Pattern.compile("^[0-9]{1}$");
        Matcher m = p.matcher(selection);
        return m.matches();
    }

}
