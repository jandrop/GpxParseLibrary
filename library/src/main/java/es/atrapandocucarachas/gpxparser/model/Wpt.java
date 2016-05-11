package es.atrapandocucarachas.gpxparser.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * @author Alejandro Platas Mallo
 * @version 1.00
 * @since 21/5/15
 */

/**
 * This is a waypoint
 */
public class Wpt {
    private double lat;
    private double lon;
    private String name;
    private String desc;
    private String sym;

    public Wpt() {

    }

    /**
     * The waypoint constructor
     *
     * @param lat  Latitude
     * @param lon  Longitude
     * @param name Name of the waypoint
     * @param desc Description of the waypoint
     * @param sym  Waypoint symbol
     */
    public Wpt(double lat, double lon, String name, String desc, String sym) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.desc = desc;
        this.sym = sym;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSym() {
        return sym;
    }

    public void setSym(String sym) {
        this.sym = sym;
    }

    public LatLng getLatLon() {
        return new LatLng(lat, lon);
    }

    @Override
    public String toString() {
        return "Wpt{" +
                "coordinates=" + lat + "," + lon +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", sym='" + sym + '\'' +
                '}';
    }
}
