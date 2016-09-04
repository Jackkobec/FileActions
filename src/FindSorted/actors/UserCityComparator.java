package FindSorted.actors;

import java.util.Comparator;


/**
 *
 */
public class UserCityComparator implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getContactInfo().getCity().compareTo(o2.getContactInfo().getCity());
    }
}
