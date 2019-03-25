package jp.kazutoyo.uicomponentcatalog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

/**
 * @param name Component Name
 */
abstract class ComponentItem(val name: String) {
    /**
     * build Collection Item View
     * @return View
     */
    abstract fun buildItem(): View

    object Factory {
        /**
         * @param name Component Nmae
         * @param context Android Context
         * @param id layout resource ID
         * @return ComponentItem object
         */
        fun create(name: String, context: Context, @LayoutRes id: Int): ComponentItem
            = object : ComponentItem(name) {
            override fun buildItem(): View {
                return LayoutInflater.from(context).inflate(id, null)
            }
        }
    }
}