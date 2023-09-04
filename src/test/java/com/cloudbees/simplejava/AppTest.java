package com.cloudbees.simplejava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

@SuppressWarnings("checkstyle:MagicNumber")
class AppTest {
    
    /**
     * Test Data
     */
    private static List<Location> cities;

    @BeforeAll
    public static void setup() {
        cities = new ArrayList<Location>();  

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
    }

    @Test
    void testLocationElevation() {
        Location dallas = cities.stream().filter(city -> "Dallas".equals(city.getName())).findAny().orElse(null);
        assertNotNull(dallas);

        Location sanjose = cities.stream().filter(city -> "San Jose".equals(city.getName())).findAny().orElse(null);
        assertNotNull(sanjose);

        assertTrue(dallas.getElevation() > sanjose.getElevation());   
        assertFalse(sanjose.isHigher(dallas.getElevation()));   

        assertTrue(dallas.isHigher(sanjose.getElevation()));     

        assertTrue(dallas.isHigher(sanjose));
        assertFalse(sanjose.isHigher(dallas));
    }

    @Test
    void testLocationLat() {
        Location newyork = cities.stream().filter(city -> "New York".equals(city.getName())).findAny().orElse(null);
        assertNotNull(newyork);

        Location sanjose = cities.stream().filter(city -> "San Jose".equals(city.getName())).findAny().orElse(null);
        assertNotNull(sanjose);

        assertTrue(newyork.isEastOf(sanjose));
        assertFalse(sanjose.isEastOf(newyork));

        assertTrue(sanjose.isWestOf(newyork));
        assertFalse(newyork.isWestOf(sanjose));

    }

    @Test
    void testLocationLong() {
        Location chicago = cities.stream().filter(city -> "Chicago".equals(city.getName())).findAny().orElse(null);
        assertNotNull(chicago);

        Location sandiego = cities.stream().filter(city -> "San Diego".equals(city.getName())).findAny().orElse(null);
        assertNotNull(sandiego);

        assertTrue(chicago.isNorthOf(sandiego));
        assertFalse(sandiego.isNorthOf(chicago));

        assertTrue(sandiego.isSouthOf(chicago));
        assertFalse(chicago.isSouthOf(sandiego));


        for (Location loc : cities) {
            assertTrue(loc.isNorthernHemisphere());
        }

        Location beunosaries = new Location ("Beunos Aries", -23.55, -46.33, 23);
        assertFalse(beunosaries.isNorthernHemisphere());
    }

    @Test
    void testAssertList() {
        assertEquals(cities.isEmpty(), false);
        assertEquals(cities.size(), 11);
    }

    @Test
    void testAssertConstruct() {
    Location boston = new Location("Boston",0,0,0);
    boston.setName("Boston, MA");
    boston.setLongitude(-71.05);
    boston.setLatitude(42.36);
    boston.setElevation(46);
    String s = boston.toString();
    assertEquals(s,"Location{name='Boston, MA', long=-71.05, lat=42.36, elev=46.00}");
    
    }
        

}
