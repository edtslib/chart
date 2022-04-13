# PieChartView

![PieChartView](https://i.ibb.co/F6VdTY0/Screen-Shot-2022-04-13-at-16-29-29.png)
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
# Usage

The PieChartView is very easy to use. Just add it to your layout like any other view.
##### Via XML

Here's a basic implementation.

```xml
        <id.co.edtslib.chart.PieChartView
        android:id="@+id/chartView"
        android:background="@color/white"
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:borderWidth="2dp"
        app:labelSize="14sp"
        app:labelColor="@color/white"
        app:showLabel="true"/>
```
### Attributes information

An example is shown below.

##### _app:showLabel_
[boolean]: true if label will be show, default true

##### _app:labelColor_
[color]: color of label, default Color.WHITE

##### _app:labelSize_
[dimension]: text size of label

##### _app:borderWidth_
[dimension]: stroke width, default 0 = no border

##### _app:borderColor_
[reference]: stroke color

### Data setter
##### Set list of percent

```kotlin
    fun setPercent(percents: List<Float>)
```

##### Set list of value
```kotlin
    fun setValues(values: List<Float>)
```

### Colors parameters

Using static variable to define your colors. For example
```kotlin
PieChartView.colors = arrayListOf(
            Color.parseColor("#9C9DA6"),
            Color.parseColor("#1178D4"),
            Color.parseColor("#6CA5E0"),
            Color.parseColor("#FFA800"))
```

### Listener when input completed
```kotlin
    interface PieChartListener {
        // index of data
        fun onClick(index: Int)
    }
```

For example
```kotlin
chartView.listener = object : PieChartListener {
            override fun onClick(index: Int) {
                toast?.cancel()
                toast = Toast.makeText(this@MainActivity, "Percent ${percents[index]}", Toast.LENGTH_SHORT)
                toast?.show()
            }
        }
```





