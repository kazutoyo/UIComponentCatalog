package jp.kazutoyo.uicomponentcatalogsample

import jp.kazutoyo.uicomponentcatalog.CatalogCategory
import jp.kazutoyo.uicomponentcatalog.CatalogSubCategory
import jp.kazutoyo.uicomponentcatalog.ComponentCatalogActivity
import jp.kazutoyo.uicomponentcatalog.ComponentItem

class UIComponentCatalogActivity: ComponentCatalogActivity() {
    override fun createCollections(): List<CatalogCategory> {
        return listOf(CatalogCategory("Card", listOf(
            CatalogSubCategory("Common", listOf(
                ComponentItem.Factory.create("Card 1", this, R.layout.sample_card_1),
                ComponentItem.Factory.create("Card 2", this, R.layout.sample_card_2),
                ComponentItem.Factory.create("Card 3", this, R.layout.sample_card_3)
            ))
        )))
    }
}