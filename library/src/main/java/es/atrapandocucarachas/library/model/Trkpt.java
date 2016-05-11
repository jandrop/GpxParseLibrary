package es.atrapandocucarachas.library.model;


import com.google.android.gms.maps.model.LatLng;

/**
 * @author Alejandro Platas Mallo
 * @version X.XX
 * @since 21/5/15
 */

public class Trkpt {
    private double lat;
    private double lon;

    public Trkpt(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
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

    public LatLng getLatLon() {
        return new LatLng(lat, lon);
    }
}
