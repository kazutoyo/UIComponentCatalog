package jp.kazutoyo.uicomponentcatalog.util

import android.content.Context
import android.util.DisplayMetrics

object DimenUtil {
    fun dpToPx(context: Context, dp: Float) : Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}