# UIComponentCatalog
[![](https://jitpack.io/v/kazutoyo/UIComponentCatalog.svg)](https://jitpack.io/#kazutoyo/UIComponentCatalog)

Android UI Component Catalog

![demo](https://raw.githubusercontent.com/kazutoyo/UIComponentCatalog/master/images/demo.gif)

## Usage

### Add JitPack
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Add UIComponentCatalog library.
```
dependencies {
    implementation 'com.github.kazutoyo:UIComponentCatalog:0.0.+'
}
```

### Implement ComponentCatalogActivity

```
class MainActivity : ComponentCatalogActivity() {
    override fun createCollections(): List<ComponentCatalogCategory> {
        return listOf(
            ComponentCatalogCategory("Image", listOf(
                ComponentCatalogSubCategory("Icon", listOf(
                    object : ComponentItem("Circle Icon") {
                        override fun buildItem(): View {
                            return IconImageView(this@MainActivity).apply {
                                setImageResource(R.drawable.sample)
                            }
                        }
                    }
                ))
            ))
        )
    }
}
```

### set NoActionBar Theme.
```
<activity
    android:name="jp.kazutoyo.uicomponentcatalogsample.MainActivity"
    android:theme="@style/Theme.AppCompat.NoActionBar">
```