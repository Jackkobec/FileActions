package com.jss.old_misc.homeWork1;

import java.util.Scanner;

import static com.jss.old_misc.homeWork1.UserUtils.userToString;



public class RemoveUtils {
    public static String removeByEnteredName(User[] users) {
        Scanner sc = new Scanner(System.in);
        String removeParam = sc.nextLine();
        String resultRemoving = "";

        for (int i = 0; i < users.length; i++) {
            User user1 = users[i];
            if (user1.name.contains(removeParam))
                continue;
            resultRemoving += (userToString(user1) + "\n");

        }
        return resultRemoving;
    }
}
