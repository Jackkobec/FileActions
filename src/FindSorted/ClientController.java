package FindSorted;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 04.09.2016.
 */
public class ClientController {
    private List<Client> cleents;

    public List<Client> getCleents() {
        return cleents;
    }

    public void setCleents(List<Client> cleents) {
        this.cleents = cleents;
    }

    public List<Client> findByName(String findedName) {
        List<Client> finded = new ArrayList<>();
        for (Client cl : cleents) {
            if (cl.getFullName().equalsIgnoreCase(findedName)) {
                finded.add(cl);
            }
        }
        return finded;
    }

    public List<Client> findByPhone(String findedPhone) {
        List<Client> finded = new ArrayList<>();
        for (Client cl : cleents) {
            if (cl.getContactInfo().getPhone().contains(findedPhone)) {
                finded.add(cl);
            }
        }
        return finded;
    }

    public List<Client> sortingById(List<Client> listForSort) {

        listForSort.sort(new UserIDComparator());
        return listForSort;
    }


}
