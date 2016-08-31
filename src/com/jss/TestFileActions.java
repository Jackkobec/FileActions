package com.jss;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Test Bash Actions with files
 */
public class TestFileActions {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bash bash = new Bash();
        User user = new User("22", "Vasa");
        String path = "d://FileActions";

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

     //   bash.listStrCorrectShow(bash.findRefactored(new File("d://Test Dir"), resaultArray, "teo"));
        System.out.println("------------------------------------------------");
        bash.listStrCorrectShow(bash.findRefactored2(new File("d://Test Dir"), resaultArray, "teo"));
//        Car car = new Car("Lexus", "Black");
//        bash.saveObjToFile(car, "d://Test Dir/serialUser.txt");
//
//
//        System.out.println((bash.deSerialization(new Car(), "d://Test Dir/serialUser.txt")).toString());


        //  bash.downloadFile("d://Test Dir/serial.txt", "d://Test Dir/downloaded.txt");
    }

}
