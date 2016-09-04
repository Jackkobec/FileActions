package FindSorted;

import java.util.Comparator;

/**
 * Created by 1 on 04.09.2016.
 */
public class UserIDComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getId() > o2.getId()) {
            return 1;
        } else if (o1.getId() < o2.getId())
            return -1;
        return 0;
    }
}
