package jp.kazutoyo.uicomponentcatalogsample

import android.content.Context
import android.graphics.Outline
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView

class IconImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        clipToOutline = true
        scaleType = ScaleType.CENTER_CROP
        outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                view ?: return
                outline?.setRoundRect(0, 0, view.width, view.height, dpToPx(context, 30).toFloat())
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val size = dpToPx(context, 60)
        setMeasuredDimension(size, size)
    }

    private fun dpToPx(context: Context, dp: Int): Int
        = (dp * (context.resources.displayMetrics.densityDpi.toFloat()) / DisplayMetrics.DENSITY_DEFAULT).toInt()
}