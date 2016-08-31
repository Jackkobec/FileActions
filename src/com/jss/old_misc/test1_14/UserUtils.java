package com.jss.old_misc.test1_14;

/**
 * Created by Стас on 06.08.2016.
 */
public class UserUtils {
    public static String userToString(User user) {
        return String.format("name: %s,\njob: %s,\nage: %d,\nsalary: %d\n",
                user.name, user.job, user.age, user.salary);
    }
}
