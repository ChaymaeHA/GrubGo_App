package com.example.grubgo

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.grubgo.R.drawable.img_2


class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var indicatorLayout: LinearLayout
    private val pages = listOf(
        OnboardingPage(
            R.drawable.img_1,
            "Préparez-vous à un festin visuel et gustatif avec notre menu interactif !"
        ),
        OnboardingPage(
            img_2,
            "Bienvenue dans le monde délicieux SirFood, où chaque plat raconte une histoire."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        indicatorLayout = findViewById(R.id.indicatorLayout)

        viewPager.adapter = OnboardingAdapter(pages)

        setupIndicators()
        setCurrentIndicator(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setCurrentIndicator(position)
            }
        })
    }

    private fun setupIndicators() {
        val indicators = Array(pages.size) { ImageView(this) }
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(8, 0, 8, 0)

        indicators.forEach {
            it.setImageResource(R.drawable.indicator_inactive)
            it.layoutParams = params
            indicatorLayout.addView(it)
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorLayout.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageResource(R.drawable.indicator_active)
            } else {
                imageView.setImageResource(R.drawable.indicator_inactive)
            }
        }
    }
}
