package com.jss.old_misc.actors;


public class Client extends User{


    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    private long clientID;

    public Client(String fullName) {
        super(fullName);
    }
    public long getClientID() {
        return clientID;
    }

    /**
     * Метод для отображения одного клиента. Нужен для последующего использования при выводе массива клиентов,
     * а так же переназначения.
     */
    public void showClient() {
        System.out.println(String.format("fullName: %s | cliendID: %d",
                getFullName(), getClientID()) + "\n-----------------------------");
    }

}
