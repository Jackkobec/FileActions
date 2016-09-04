package FindSorted.controller;


import FindSorted.actors.Client;
import FindSorted.actors.ClientIdComparator;
import FindSorted.actors.UserCityComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 04.09.2016.
 */
public class ClientController implements IClientController {
    private List<Client> cleents;

    @Override
    public String toString() {
        return "ClientController{" +
                "cleents=" + cleents +
                '}';
    }

    public ClientController(List<Client> cleents) {
        this.cleents = cleents;
    }

    public List<Client> getCleents() {
        return cleents;
    }

    public void setCleents(List<Client> cleents) {
        this.cleents = cleents;
    }

    @Override
    public List<Client> findByName(String findedName) {
        List<Client> finded = new ArrayList<>();
        for (Client cl : cleents) {
            if (cl.getFullName().contains(findedName)) {
                finded.add(cl);
            }
        }
        return finded;
    }

    @Override
    public List<Client> findByPhone(String findedPhone) {
        List<Client> finded = new ArrayList<>();
        for (Client cl : cleents) {
            if (cl.getContactInfo().getPhone().contains(findedPhone)) {
                finded.add(cl);
            }
        }
        return finded;
    }

    //sorting only by ClientID
    @Override
    public List<Client> sortingById(List<Client> listForSort) {

        listForSort.sort(new ClientIdComparator());
        return listForSort;
    }

    //sorting only by Cities
    @Override
    public List<Client> sortingByCity(List<Client> listForSort) {

        listForSort.sort(new UserCityComparator());
        return listForSort;
    }

    //sorting one - named Cities(alphabet sort) with ClientID from low to high
    @Override
    public List<Client> sortingByIdAbdCity(List<Client> listForSort) {
        listForSort.sort(new ClientIdComparator());
        listForSort.sort(new UserCityComparator());
        return listForSort;
    }


}
