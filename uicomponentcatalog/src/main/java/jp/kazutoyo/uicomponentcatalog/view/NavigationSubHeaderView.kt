package jp.kazutoyo.uicomponentcatalog.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import jp.kazutoyo.uicomponentcatalog.R

class NavigationSubHeaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val titleView by lazy { findViewById<TextView>(R.id.title) }
    
    init {
        LayoutInflater.from(context).inflate(R.layout.view_navigation_sub_header, this, true)
    }

    fun setTitle(text: CharSequence?) {
        titleView.text = text
    }
}