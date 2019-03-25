package jp.kazutoyo.uicomponentcatalogsample

import android.app.Activity
import android.content.Intent

class DebugHelperImpl: DebugHelper {
    override fun openUIComponentCatalog(activity: Activity) {
        activity.startActivity(Intent(activity, UIComponentCatalogActivity::class.java))
    }
}