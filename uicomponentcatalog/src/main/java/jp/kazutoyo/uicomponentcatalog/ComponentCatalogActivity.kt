package jp.kazutoyo.uicomponentcatalog

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat
import jp.kazutoyo.uicomponentcatalog.view.ComponentItemView
import jp.kazutoyo.uicomponentcatalog.view.NavigationHeaderView
import jp.kazutoyo.uicomponentcatalog.view.NavigationSubHeaderView
import jp.kazutoyo.uicomponentcatalog.view.NavigationItemView

import kotlinx.android.synthetic.main.activity_collection.*
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class ComponentCatalogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
    }

    abstract fun createCollections(): List<CatalogCategory>

    private fun setupDrawer() {
        val context = this
        val drawerToggleButton = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_open
            )
        drawer_layout.addDrawerListener(drawerToggleButton)
        drawerToggleButton.syncState()

        // setup drawer item
        val collections = createCollections()

        collections.forEach { category ->
            val header = NavigationHeaderView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                setTitle(category.name)
            }
            navContent.addView(header)

            category.subCategories.forEach { subCategory ->
                val subHeader = NavigationSubHeaderView(context).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    setTitle(subCategory.name)
                }
                navContent.addView(subHeader)

                subCategory.items.forEach { item ->
                    val itemView = NavigationItemView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        setTitle(item.name)
                        setOnClickListener {
                            setComponents(item)
                            drawer_layout.closeDrawer(GravityCompat.START)
                        }
                    }
                    navContent.addView(itemView)
                }
            }
        }
    }

    private fun setComponents(item: ComponentItem) {
        val itemView = ComponentItemView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            ).apply { gravity = Gravity.CENTER }
        }
        componentContainer.removeAllViews()
        componentContainer.addView(itemView)
        itemView.setComponentItem(item)
        // change title
        toolbar.title = item.name
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
