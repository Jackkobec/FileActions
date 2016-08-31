package com.jss.old_misc.db;

import com.jss.old_misc.actors.Client;

/**
 * Created by Стас on 21.08.2016.
 */
public interface IAppDB {

    Object addObject(Object obj);

    Client addClient(Client client);

    Client findClient(long clientID);

    void showClient(Client client);

    void removeClient(long clientID);

    void showAllClientS();

    void updateClientInfo(long clientID);


}
