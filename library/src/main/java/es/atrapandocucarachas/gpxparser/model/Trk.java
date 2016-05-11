package es.atrapandocucarachas.gpxparser.model;

import java.util.ArrayList;

/**
 * @author Alejandro Platas Mallo
 * @version 1.00
 * @since 21/5/15
 */

// This class represent a Track segment
public class Trk {
    private String name;
    private ArrayList<Trkpt> trkseg;

    public Trk() {

    }

    /**
     * Class constructor of Track segment
     *
     * @param name   Name of the segment
     * @param trkseg Track segment
     */
    public Trk(String name, ArrayList<Trkpt> trkseg) {
        this.name = name;
        this.trkseg = trkseg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the track segment
     *
     * @return The Track segment
     */
    public ArrayList<Trkpt> getTrkseg() {
        return trkseg;
    }

    /**
     * Set the Track segment
     *
     * @param trkseg Track segment
     */
    public void setTrkseg(ArrayList<Trkpt> trkseg) {
        this.trkseg = trkseg;
    }
}
