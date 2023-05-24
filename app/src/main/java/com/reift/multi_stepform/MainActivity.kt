package com.reift.multi_stepform

import android.os.Bundle
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.data.getFormViewPagerData
import com.reift.multi_stepform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    val formSize = getFormViewPagerData().size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpProgressBar()
        setUpViewPager()
    }

    private fun setUpProgressBar() {
        binding.apply {
            tvQuestionNumber.text = formSize.toString()
            vpMultiStepForm.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int,
                    ) {
                        val currentQuestion = (position + 1).toString()
                        tvQuestionNumberActive.text = currentQuestion

                        progressLineActive.animate().scaleX((position + 1f) / formSize.toFloat())
                            .setInterpolator(BounceInterpolator()).duration = 750
                    }
                }
            )

        }
    }

    private fun setUpViewPager() {
        binding.apply {
            vpMultiStepForm.apply {
                adapter = FormAdapter(this@MainActivity)
                isUserInputEnabled = false
                btnNext.setOnClickListener {
                    currentItem += 1
                }
                btnPrevious.setOnClickListener {
                    currentItem -= 1
                }
            }
        }
    }
}