package search.linear.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates{

    public static List<Integer> linearSearch(List<String> searchList, String targetValue) {
        List<Integer> matches = new ArrayList<>();
        for (int idx = 0; idx < searchList.size(); idx++) {
            if (searchList.get(idx).equals(targetValue)) {
                matches.add(idx);
            }
        }
        if (!matches.isEmpty()) {
            return matches;
        } else {
            throw new IllegalArgumentException(targetValue + " not in list");
        }
    }

    public static void main(String[] args) {
        List<String> tourLocations = List.of("New York City", "Los Angeles", "Bangkok", "Istanbul", "London", "New York City", "Toronto");
        String targetCity = "New York City";

        List<Integer> tourStops = linearSearch(tourLocations, targetCity);
        System.out.println(tourStops);
    }
}
