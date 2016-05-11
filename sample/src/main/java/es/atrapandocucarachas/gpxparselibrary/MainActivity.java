package es.atrapandocucarachas.gpxparselibrary;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import es.atrapandocucarachas.library.model.Gpx;
import es.atrapandocucarachas.library.parser.GpxParser;

public class MainActivity extends AppCompatActivity {

    private GpxParser parser;
    private Gpx gpx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetManager = getAssets();

        try {

            InputStream inputStream = assetManager.open("file.gpx");
            parser = new GpxParser(inputStream);
            gpx = parser.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("TAG",gpx.getWpts().toString());

    }
}
