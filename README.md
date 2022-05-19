## Setup
### Gradle

Add this to your project level `build.gradle`:
```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
Add this to your app `build.gradle`:
```groovy
dependencies {
    implementation 'com.github.edtslib:chart:latest'
}
```
# GeoView

![GeoView](https://i.ibb.co/nmR4DSd/geo.jpg)

### Usage
```xml
        <id.co.edtslib.chart.GeoView
            android:id="@+id/geo"
            android:layout_width="match_parent"
            android:layout_height="300dp" />
```

```kotlin
        val geo = findViewById<GeoView>(R.id.geo)
        geo.setData("Popularity", listOf(
            ChartData("Indonesia", 450.0),
            ChartData("Germany", 1000.0),
            ChartData("Denmark", 400.0),
            ChartData("France", 750.0),
            ChartData("Brazil", 1000.0)))
```

# GeoIDView

![GeoIDView](https://i.ibb.co/Lv7JN7j/geoid.jpg)

### Usage

```xml
        <id.co.edtslib.chart.GeoIDView
            android:id="@+id/geoId"
            android:layout_width="match_parent"
            android:layout_height="300dp" />
```

```kotlin
       val geoId = findViewById<GeoIDView>(R.id.geoId)
        geoId.setData("Popularity", listOf(
            ChartData("ID-JK", 580.0),
            ChartData("ID-BA", 103.0),
            ChartData("ID-JB", 239.0),
            ChartData("ID-BT", 78.0),
            ChartData("ID-JT", 78.0)))
```

# HorizontalBarChartView

![HorizontalBarChartView](https://i.ibb.co/sCMdb0P/Screen-Shot-2022-05-19-at-13-44-13.png)

### Usage

```xml
        <id.co.edtslib.chart.HorizontalBarChartView
            android:id="@+id/barChart"
            app:showLegend="false"
            android:layout_width="match_parent"
            android:layout_height="400dp" />
```

```kotlin
        val barChart = findViewById<HorizontalBarChartView>(R.id.barChart)
        barChart.setData("Data", listOf(
            ChartData("Feb", 1.0),
            ChartData("Mar", 2.0),
            ChartData("Apr", 3.0),
            ChartData("May", 4.0),
            ChartData("Jun", 5.0),
            ChartData("Jul", 6.0),
            ChartData("Aug", 7.0),
            ChartData("Sep", 8.0),
            ChartData("Oct", 9.0)))
```
