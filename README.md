![Edts Chart](https://i.ibb.co/LCZ0HBL/2022-05-11-11-27-05.jpg)
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

# GeoIDView

### Usage

```kotlin
       val geoId = findViewById<GeoIDView>(R.id.geoId)
        geoId.setData(listOf(
            ChartData("ID-JK", 580.0),
            ChartData("ID-BA", 103.0),
            ChartData("ID-JB", 239.0),
            ChartData("ID-BT", 78.0),
            ChartData("ID-JT", 78.0)))
```

# GeoView

### Usage

```kotlin
        val geo = findViewById<GeoView>(R.id.geo)
        geo.setData(listOf(
            ChartData("Europe", 580.0),
            ChartData("Asia", 103.0),
            ChartData("Africa", 239.0),
            ChartData("Oceania", 78.0),
            ChartData("Americas", 78.0)))
```
