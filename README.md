# Edts Chart

![Pie](https://i.ibb.co/30KkX2W/Screen-Shot-2022-04-13-at-17-22-27.png)
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

The PieChartView is very easy to use. Just add it to your layout like any other view.

```xml
        <id.co.edtslib.chart.PieChartView
            android:id="@+id/pieChart"
            android:layout_width="match_parent"
            android:layout_height="400dp" />
```

And set data like this

```kotlin
        val pieChart = findViewById<PieChartView>(R.id.pieChart)
        pieChart.setData(listOf(
            ChartData("Mushrooms", 3.0),
            ChartData("Onions", 1.0),
            ChartData("Olives", 1.0),
            ChartData("Zucchini", 1.0),
            ChartData("Pepperoni", 2.0)))
```

