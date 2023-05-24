package com.reift.multi_stepform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.vpMultiStepForm.apply {
            adapter = FormAdapter(this@MainActivity)
        }
    }
}