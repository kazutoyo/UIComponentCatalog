package jp.kazutoyo.uicomponentcatalog.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import jp.kazutoyo.uicomponentcatalog.ComponentItem
import jp.kazutoyo.uicomponentcatalog.R
import jp.kazutoyo.uicomponentcatalog.util.DimenUtil

class ComponentItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val titleView: TextView

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER
        val padding = DimenUtil.dpToPx(context, 16f).toInt()
        setPadding(padding, padding, padding, padding)

        titleView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, DimenUtil.dpToPx(context, 16f).toInt())
                gravity = Gravity.CENTER
            }
            TextViewCompat.setTextAppearance(this, R.style.TextAppearance_AppCompat_Caption)
        }
        addView(titleView)
    }

    fun setComponentItem(item: ComponentItem) {
        titleView.text = item.name
        addView(item.buildItem())
    }
}