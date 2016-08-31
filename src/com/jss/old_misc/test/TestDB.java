package com.jss.old_misc.test;

import com.jss.actors.Client;
import com.jss.actors.User;
import com.jss.db.AppDB;

/**
 * Created by Стас on 21.08.2016.
 */
public class TestDB {
    public static void main(String[] args) {
User us1 = new Client("Sidor");
        Client cl = new Client("Vasa");
        Client cl2 = new Client("Petya");
        Client cl3 = new Client("Petya");
        Client cl4 = new Client("Petya");
        Client cl5 = new Client("Petya");
        Client cl6 = new Client("Petya");
        Client cl7 = new Client("Petya");

        AppDB appdb = new AppDB();

        appdb.addClient(cl);
        appdb.addClient(cl2);
        appdb.addClient(cl3);
        appdb.addClient(cl4);
        appdb.addClient(cl5);
        appdb.addClient(cl6);
        appdb.addClient(cl7);
        appdb.addObject(us1);

        appdb.showAllClientS();

       // appdb.showClient(appdb.findClient(3));
        System.out.println();
      appdb.removeClient(5);
        appdb.showAllClientS();

    }
}
