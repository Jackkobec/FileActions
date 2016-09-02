package com.jss.fileactions;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Test Bash Actions with files
 */
public class TestFileActions implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bash bash = new Bash();
        User user = new User("22", "Vasa");


        BashTestMenu btm = new BashTestMenu();
        btm.initFile();

//        System.out.println(bash.cloneDeep(user));

//        bash.writeInto(path, "Hi there\nHello world\nWorld is beautiful\nThrout the hardship to the stars\nworld");
//        System.out.println(bash.less(path));
//        System.out.println("------------------------------------------------");
//
//        System.out.println(bash.copy(path, "d://FileActions_copy") ? "Copying successfully\n" : "Copying fail");
//        System.out.println(bash.less("d://FileActions_copy"));
//        System.out.println("------------------------------------------------");
//
//        System.out.println(bash.delete("d://FileActions_copy") ? "Successful deleting\n" : "Deleting fail");
//        System.out.println("------------------------------------------------");
//
//        bash.ls("d://Test Dir");
//        System.out.println("------------------------------------------------");
//
//        System.out.println(bash.touch("d://Test Dir/NewFileFromTouch") ? "File was create\n" : null);
//        bash.ls("d://Test Dir");
//        System.out.println("------------------------------------------------");
//
//        bash.listStrCorrectShow(bash.grep(path, "world"));
//        System.out.println("------------------------------------------------");
//        System.out.println("Cloning test");
//
//        Bash bash2 = (Bash) bash.clone(bash);
//        System.out.println(bash2.less(path));
//        System.out.println("------------------------------------------------");
        List<String> resaultArray = new ArrayList<>();
//        bash.listStrCorrectShow(bash.find(new File("d://Test Dir"),resaultArray, "teo"));
//        System.out.println("------------------------------------------------");
//        System.out.println("------------------------------------------------");

//
//        System.out.println("------------------------------------------------");
//        bash.listStrCorrectShow(bash.findRefactored(new File("d://Test Dir"), resaultArray, "teo"));
//        Car car = new Car("Lexus", "Black");
//        bash.saveObjToFile(car, "d://Test Dir/serialUser.txt");
//
//
//        System.out.println((bash.deSerialization(new Car(), "d://Test Dir/serialUser.txt")).toString());
//    bash.less("d://Test Dir");

        //  bash.downloadFile("d://Test Dir/serial.txt", "d://Test Dir/downloaded.txt");
    }

}
