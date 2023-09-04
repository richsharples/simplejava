/**
 * This is a simple class for testing stages of CI/CD.
 * @author Rich Sharples.
 */

package com.cloudbees.simplejava;

/**
 * Location class.
 */

public class Location {

    private String name;
    private double longitude;
    private double latitude;
    private double elevation;

    /**
     * @param name name
     * @return
     */
    public Location(String name, double longitude, double latitude, double elevation) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param loc
     * @return
     */
    public boolean isNorthOf(Location loc) {
        return loc.getLatitude() < this.getLatitude();
    }

    /**
     * @param loc
     * @return
     */
    public boolean isSouthOf(Location loc) {
        return loc.getLatitude() > this.getLatitude();
    }

    /**
     * @param loc - location
     * @return
     */
    public boolean isEastOf(Location loc) {
        return loc.getLongitude() < this.getLongitude();
    }

    /**
     * @param loc - location
     * @return
     */
    public boolean isWestOf(Location loc) {
        return loc.getLongitude() > this.getLongitude();
    }

    /**
     * @return true if in Northern Hemisphere
     */
    public boolean isNorthernHemisphere() {
        return this.getLatitude() > 0;
    }

    /**
     * @param elev - elevation
     * @return true if higher
     */
    public boolean isHigher(double elev) {
        return this.elevation > elev;
    }

    /**
     * @param loc - location
     * @return
     */
    public boolean isHigher(Location loc) {
        return this.getElevation() > loc.getElevation();
    }

    /**
     * @param name - new name
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return elevation
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * @param elevation
     */
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return String.format(
            "Location{name='%s', long=%.2f, lat=%.2f, elev=%.2f}",
            name, longitude, latitude, elevation);
    }
}
