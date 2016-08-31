package com.jss.old_misc.db;

import com.jss.old_misc.*;
import com.jss.old_misc.actors.Client;

import java.util.ArrayList;
import java.util.List;


public class AppDB implements IAppDB {

    private List<Client> clientList = new ArrayList<>();

    private long currentClientID = 1;

    public long getCirrentClientID() {
        return currentClientID;
    }

    public void setCurrentClientID(long cirrentClientID) {
        this.currentClientID = cirrentClientID;
    }


    /**
     * Переназначеный метод для отображения одного клиента. Нужен для вывода одного контакта по входящему аргументу Client
     */
    @Override
    public void showClient(Client client) {
        System.out.println(String.format("fullName: %s, cliendID: %d",
                client.getFullName(), client.getClientID()));
    }

    /**
     * метод особого дебилического типо полиморфизма
     */
    @Override
    public Object addObject(Object obj) {
        if (obj instanceof Client) {
            addClient((Client) obj);
        }

        return null;
    }


    @Override
    public Client addClient(Client client) {
        client.setClientID(currentClientID++);

        clientList.add(client);
        return null;
    }

    @Override
    public Client findClient(long clientID) {
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getClientID() == clientID) {
                return clientList.get(i);
            }
        }
        return null;
    }


    @Override
    public void removeClient(long clientID) {
        clientList.remove(findClient(clientID));

    }


    /**
     * В этом методе при вызове для i-того элемента подметода showClient() мы обращаемся к методу в самом классе Client.
     * Такая крутая штука возможна т.к. данный метод переназначен тут с аргументами showClient(Client client) иплементируя
     * метод из интерфейса IAppDB. Но т.к. мы не передаем в метод showClient() никаких аргументов, а сам массив clientList у нас
     * состоит из Client , то візівается именно метод из класса Client.
     */
    @Override
    public void showAllClientS() {
        for (int i = 0; i < clientList.size(); i++) {
            clientList.get(i).showClient();
//            System.out.println(String.format("fullName: %s, cliendID: %d",
//                    clientList.get(i).getFullName(), clientList.get(i).getClientID()) );

        }
    }

    @Override
    public void updateClientInfo(long clientID) {
        findClient(clientID).showClient();
    }

}
