package jp.kazutoyo.uicomponentcatalogsample

import android.view.View
import jp.kazutoyo.uicomponentcatalog.ComponentCatalogActivity
import jp.kazutoyo.uicomponentcatalog.ComponentCatalogCategory
import jp.kazutoyo.uicomponentcatalog.ComponentCatalogSubCategory
import jp.kazutoyo.uicomponentcatalog.ComponentItem

class MainActivity : ComponentCatalogActivity() {
    override fun createCollections(): List<ComponentCatalogCategory> {
        return listOf(
            ComponentCatalogCategory("Card", listOf(
                ComponentCatalogSubCategory("Feed", listOf(
                    ComponentItem.Factory.create("Card 1", this, R.layout.sample_card_1),
                    ComponentItem.Factory.create("Card 2", this, R.layout.sample_card_2),
                    ComponentItem.Factory.create("Card 3", this, R.layout.sample_card_3)
                ))
            )),
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
