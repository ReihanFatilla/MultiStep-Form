package com.reift.multi_stepform.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.databinding.FragmentRateFormBinding
import com.reift.multi_stepform.model.Form

class RateFragment : Fragment() {

    private var _form: Form? = null
    private val form get() = _form as Form

    private var _binding: FragmentRateFormBinding? = null
    private val binding get() = _binding as FragmentRateFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRateFormBinding.inflate(layoutInflater)
        _form = arguments?.getParcelable(FormAdapter.FORM_BUNDLE)

        setUpForm()

        return binding.root
    }

    private fun setUpForm() {
        binding.apply {
            with(form){
                tvFormTitle.text = title
                tvFormDescription.text = desc

                tvRateStart.text = rateStartText
                tvRateEnd.text = rateEndText
            }
        }
    }
}