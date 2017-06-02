package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rarshion on 16/9/25.
 */
public class ReconstructItinerary {

    HashMap<String, List<String>> maps;
    int count;

    public List<String> findItinerary(String[][] tickets) {

        return null;

    }

    private void initMap(String[][] tickets) {
        for (String[] tmp : tickets) {

            String from = tmp[0];
            String to = tmp[1];

            if (!maps.containsKey(from)) {
                maps.put(from, new LinkedList<>());
            }

            List<String> list = maps.get(from);

            int index = 0, size = list.size();
            while (index < size) {
                String cur = list.get(index);
                if (cur.compareTo(to) >= 0) {
                   break;
                }
                index++;
            }

            list.add(index, to);
        }
    }

}
