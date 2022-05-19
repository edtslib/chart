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
![HorizontalBarChartView](https://i.ibb.co/GM3wVDT/Screen-Shot-2022-05-19-at-14-52-48.png)
![HorizontalBarChartView](https://i.ibb.co/N2dFBPn/Screen-Shot-2022-05-19-at-14-54-47.png)


### Usage

```xml
    <id.co.edtslib.chart.HorizontalBarChartView
        android:id="@+id/barChart"
        app:showLegend="false"
        app:isStacked="true"
        android:layout_width="match_parent"
        android:layout_height="400dp" />
```

```kotlin
    val hBarChart = findViewById<HorizontalBarChartView>(R.id.hBarChart)
    hBarChart.setData(
            listOf(RowData("Data", listOf(
            ColumnData("Feb", 1.0),
            ColumnData("Mar", 2.0),
            ColumnData("Apr", 3.0),
            ColumnData("May", 4.0),
            ColumnData("Jun", 5.0),
            ColumnData("Jul", 6.0),
            ColumnData("Aug", 7.0),
            ColumnData("Sep", 8.0),
            ColumnData("Oct", 9.0)))))
```
# BarChartView

![BarChartView](https://i.ibb.co/k1mcx1M/Screen-Shot-2022-05-19-at-13-54-55.png)
![BarChartView](https://i.ibb.co/QKw3R79/Screen-Shot-2022-05-19-at-14-57-06.png)
![BarChartView](https://i.ibb.co/WV29PXP/Screen-Shot-2022-05-19-at-14-59-48.png)

### Usage

```xml
    <id.co.edtslib.chart.BarChartView
        android:id="@+id/barChart"
        app:showLegend="false"
        app:isStacked="true"
        android:layout_width="match_parent"
        android:layout_height="400dp" />
```

```kotlin
    val barChart = findViewById<BarChartView>(R.id.barChart)
    barChart.setData(
            listOf(RowData("Data", listOf(
                ColumnData("Feb", 1.0),
                ColumnData("Mar", 2.0),
                ColumnData("Apr", 3.0),
                ColumnData("May", 4.0),
                ColumnData("Jun", 5.0),
                ColumnData("Jul", 6.0),
                ColumnData("Aug", 7.0),
                ColumnData("Sep", 8.0),
                ColumnData("Oct", 9.0)))))
```

# AreaChartView

![AreaChartView](https://i.ibb.co/MB5DDhP/Screen-Shot-2022-05-19-at-15-08-28.png)
![AreaChartView](https://i.ibb.co/hcPnmgx/Screen-Shot-2022-05-19-at-15-44-57.png)
![AreaChartView](https://i.ibb.co/mSk73hy/Screen-Shot-2022-05-19-at-15-47-39.png)

### Usage

```xml
    <id.co.edtslib.chart.AreaChartView
        android:id="@+id/areaChart"
        app:showLegend="false"
        app:isStacked="true"
        android:layout_width="match_parent"
        android:layout_height="300dp" />
```

```kotlin
    val areaChart = findViewById<AreaChartView>(R.id.areaChart)
    areaChart.setData(
        listOf(RowData("Data", listOf(
            ColumnData("Feb", 1.0),
            ColumnData("Mar", 2.0),
            ColumnData("Apr", 3.0),
            ColumnData("May", 4.0),
            ColumnData("Jun", 3.0),
            ColumnData("Jul", 6.0),
            ColumnData("Aug", 9.0),
            ColumnData("Sep", 8.0),
            ColumnData("Oct", 9.0)))))
```
