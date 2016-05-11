GpxParse Sample
===================================

## How to use

### 1.- Gradle Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```groovy
gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### 2.- Configuring your Project Dependencies
Add the library dependency to your build.gradle file.

```groovy
dependencies {
    ...
    compile 'com.github.jandrop:GpxParseLibrary:1.0'
}
```
### 3.- Example GPX on assets directory:
```groovy

AssetManager assetManager = getAssets();
GpxParser parser;
Gpx gpx;
try {
    InputStream inputStream = assetManager.open("file.gpx");
    parser = new GpxParser(inputStream);
    gpx = parser.parse();

} catch (IOException e) {
  e.printStackTrace();
}

// Get a List of waypoints
ArrayList<Wpt> wpts = gpx.getWpts();
for (Wpt w : wpts) {
    Log.i("Name of waypoint", w.getName());
    Log.i("Description of waypoint",w.getDesc());
    Log.i("Symbol of waypoint",w.getSym());
    Log.i("Coordinates of waypoint",String.valueOf(w.getLatLon()));
}
```


## License

Copyright Alejandro Platas 2016

This file is part of some open source application.

Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
