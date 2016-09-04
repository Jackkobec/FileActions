package FindSorted.test_sort;

import FindSorted.actors.Client;
import FindSorted.controller.ClientController;
import FindSorted.controller.IClientController;

import java.util.ArrayList;
import java.util.List;

import static FindSorted.db.DataMixer.createClient;

/**
 * Created by 1 on 04.09.2016.
 */
public class TestClientSortFind {
    public static void main(String[] args) {
        List<Client> clients = crateClients();
        IClientController iclient = new ClientController(clients);


        //found by name
        //System.out.println(iclient.findByName("Vasa"));

        //sort found only  by Id form low to high
        // System.out.println(iclient.sortingById(iclient.findByName("Vasa")));

        //sort found only  by cities (alphabet sort)
        //System.out.println(iclient.sortingByCity(iclient.findByName("Vasa")));

        //sorting one - named Cities(alphabet sort) with ClientID from low to high
        System.out.println(iclient.sortingByIdAbdCity(iclient.findByName("Vasa")));

    }


    private static List<Client> crateClients() {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            clients.add(createClient());
        }
        return clients;
    }
}
