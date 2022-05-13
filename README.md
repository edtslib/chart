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

# PieChartView

### Usage

```kotlin
        val pieChart = findViewById<PieChartView>(R.id.pieChart)
        pieChart.setData(listOf(
            ChartData("Mushrooms", 3.0),
            ChartData("Onions", 1.0),
            ChartData("Olives", 1.0),
            ChartData("Zucchini", 1.0),
            ChartData("Pepperoni", 2.0)))
```

# DonutChartView
### Usage

```kotlin
        val donutChart = findViewById<PieChartView>(R.id.donutChart)
        donutChart.setData(listOf(
            ChartData("Work", 11.0),
            ChartData("Eat", 2.0),
            ChartData("Commute", 2.0),
            ChartData("Watch TV", 2.0),
            ChartData("Sleep", 7.0)))
```




