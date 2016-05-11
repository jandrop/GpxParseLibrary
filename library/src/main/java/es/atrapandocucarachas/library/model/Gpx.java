package es.atrapandocucarachas.library.model;

import java.util.ArrayList;

/**
 * @author Alejandro Platas Mallo
 * @version 1.00
 * @since 21/5/15
 */

public class Gpx {
    private String version;
    private String creator;

    private ArrayList<Wpt> wpts; // Optional Waypoints
    private ArrayList<Trk> trks; // Optional Tracks

    public Gpx() {

    }

    public Gpx(String version, String creator, ArrayList<Wpt> wpts, ArrayList<Trk> trks) {
        this.version = version;
        this.creator = creator;
        this.wpts = wpts;
        this.trks = trks;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public ArrayList<Wpt> getWpts() {
        return wpts;
    }

    public void setWpts(ArrayList<Wpt> wpts) {
        this.wpts = wpts;
    }

    /**
     * Get the Tracks segments
     *
     * @return Tracks
     */
    public ArrayList<Trk> getTrks() {
        return trks;
    }

    public void setTrks(ArrayList<Trk> trks) {
        this.trks = trks;
    }
}
