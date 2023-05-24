package com.reift.multi_stepform.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reift.multi_stepform.adapter.CheckBoxAdapter
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.databinding.FragmentCheckboxFormBinding
import com.reift.multi_stepform.model.Form
import com.reift.multi_stepform.model.FormType

class CheckBoxFragment : Fragment() {

    private var _form: Form? = null
    private val form get() = _form as Form

    private var _binding: FragmentCheckboxFormBinding? = null
    private val binding get() = _binding as FragmentCheckboxFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCheckboxFormBinding.inflate(layoutInflater)
        _form = arguments?.getParcelable(FormAdapter.FORM_BUNDLE)

        setUpForm()

        return binding.root
    }

    private fun setUpForm() {
        binding.apply {
            with(form){
                tvFormTitle.text = title
                tvFormDescription.text = desc

                if(formType == FormType.CHECKBOX){
                    etOtherForm.visibility = View.GONE
                }

                rvCheckbox.apply {
                    adapter = CheckBoxAdapter(listCheckbox ?: listOf())
                }

            }
        }
    }
}