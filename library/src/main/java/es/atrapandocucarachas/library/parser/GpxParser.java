package es.atrapandocucarachas.library.parser;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import es.atrapandocucarachas.library.model.Gpx;
import es.atrapandocucarachas.library.model.Trk;
import es.atrapandocucarachas.library.model.Trkpt;
import es.atrapandocucarachas.library.model.Wpt;

public class GpxParser {

    private BufferedReader bufferedReader;
    private InputStream inputStream;
    private boolean wptTag = false;
    private boolean trkTag = false;
    private Trk trk = null;
    private ArrayList<Wpt> wpts = new ArrayList<>();
    private ArrayList<Trk> trks = new ArrayList<>();
    private double lat = 0, lon = 0;
    private String name = null, sym = null, desc = null;
    private Wpt wpt = null;
    private ArrayList<Trkpt> trkseg = new ArrayList<>();
    private Gpx gpx;
    private XmlPullParser xpp;


    public GpxParser(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        xpp = Xml.newPullParser();
        try {
            xpp.setInput(bufferedReader);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public GpxParser(InputStream inputStream) {
        this.inputStream = inputStream;
        xpp = Xml.newPullParser();
        try {
            xpp.setInput(inputStream, "UTF-8");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse a GPX File and return a GPS Class
     *
     * @return A GPX Class
     */
    public Gpx parse() {

        try {

            //XmlPullParser xpp = Xml.newPullParser();

            //xpp.setInput(bufferedReader);

            int evento = xpp.getEventType();

            while (evento != XmlPullParser.END_DOCUMENT) {

                String etiqueta;

                switch (evento) {

                    case XmlPullParser.START_DOCUMENT:
                        gpx = new Gpx();
                        break;

                    case XmlPullParser.START_TAG:
                        etiqueta = xpp.getName();

                        switch (etiqueta) {

                            case "wpt":

                                wptTag = true;

                                wpt = new Wpt();

                                lat = Double.parseDouble(xpp.getAttributeValue(null, "lat"));
                                wpt.setLat(lat);
                                lon = Double.parseDouble(xpp.getAttributeValue(null, "lon"));
                                wpt.setLon(lon);

                                break;

                            case "name":
                                xpp.next();
                                name = xpp.getText();
                                break;

                            case "desc":
                                xpp.next();
                                desc = xpp.getText();
                                break;

                            case "sym":
                                xpp.next();
                                sym = xpp.getText();
                                break;

                            case "trk":
                                trkTag = true;
                                trk = new Trk();

                                break;

                            case "trkseg":
                                trkseg = new ArrayList<>();
                                break;
                            case "trkpt":
                                lat = Double.parseDouble(xpp.getAttributeValue(null, "lat"));
                                lon = Double.parseDouble(xpp.getAttributeValue(null, "lon"));
                                break;
                        }

                        break;

                    case XmlPullParser.END_TAG:
                        etiqueta = xpp.getName();

                        switch (etiqueta) {
                            case "wpt":
                                wptTag = false;
                                wpts.add(wpt);
                                break;

                            case "name":

                                if (trkTag) {
                                    trk.setName(name);
                                }

                                if (wptTag) {
                                    wpt.setName(name);
                                }

                                break;

                            case "desc":
                                if (wptTag) {
                                    wpt.setDesc(desc);
                                }
                                break;

                            case "sym":
                                if (wptTag) {
                                    wpt.setSym(sym);
                                }
                                break;

                            case "trk":
                                trkTag = false;
                                trk.setTrkseg(trkseg);
                                trks.add(trk);
                                break;

                            case "trkseg":
                                break;

                            case "trkpt":
                                Trkpt trkpt = new Trkpt(lat, lon);
                                trkseg.add(trkpt);
                                break;
                        }

                        break;
                }

                evento = xpp.next();
            }

            gpx.setWpts(wpts);
            gpx.setTrks(trks);

            if (bufferedReader != null)
                bufferedReader.close();
            if (inputStream != null)
                inputStream.close();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return gpx;
    }
}
