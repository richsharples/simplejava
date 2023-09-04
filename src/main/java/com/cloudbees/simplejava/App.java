/**
 * Main class for informal testing.
 * @author : Rich Sharples
 */

package com.cloudbees.simplejava;

import java.util.ArrayList;
import java.util.List;

/**
 * Supress checkstyle errors.
 */

@SuppressWarnings("checkstyle:MagicNumber")
public final class App {

    /**
     * Suppress checkstyle warning.
     */
    private App() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * @param args - usual main stuff.
     */
    public static void main(String[] args) {
        List<Location> cities = new ArrayList<Location>();

        cities.add(new Location("New York", -74, 40.96, 102));
        cities.add(new Location("Los Angeles", -118.24, 34.05, 58));
        cities.add(new Location("Chicago", -87.62, 41.87, 672));
        cities.add(new Location("Houston", -95.36, 29.76, 49));
        cities.add(new Location("Phoenix", -112.07, 33.44, 1087));
        cities.add(new Location("Philadelphia", -75.16, 39.95, 45));
        cities.add(new Location("San Antonio", -98.49, 29.42, 643));
        cities.add(new Location("San Diego", -117.16, 32.71, 119));
        cities.add(new Location("Dallas", -96.80, 432.76, 438));
        cities.add(new Location("San Jose", -121.89, 37.38, 23));
        cities.add(new Location("Austin", -97.74, 30.26, 498));

        // Sort the list by elevation in ascending order.
        cities.sort((a, b) -> (int) a.getElevation() - (int) b.getElevation());

        // Iterate over the list and print the information about each location.
        for (Location loc : cities) {
            System.out.println(loc.toString());
        }
    }
}
