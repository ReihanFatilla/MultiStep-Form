package com.reift.multi_stepform.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reift.multi_stepform.R
import com.reift.multi_stepform.adapter.CheckBoxAdapter
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.databinding.FragmentFormBinding
import com.reift.multi_stepform.databinding.LayoutCheckboxFormBinding
import com.reift.multi_stepform.databinding.LayoutInputFormBinding
import com.reift.multi_stepform.databinding.LayoutRateFormBinding
import com.reift.multi_stepform.model.Form
import com.reift.multi_stepform.model.FormType

class FormFragment : Fragment() {

    private var _form: Form? = null
    private val form get() = _form as Form

    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding as FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFormBinding.inflate(layoutInflater)
        _form = arguments?.getParcelable(FormAdapter.FORM_BUNDLE)

        setUpFormLayout()

        return binding.root
    }

    private fun setUpFormLayout() {
        binding.apply {
            with(form) {
                tvFormTitle.text = title
                tvFormDescription.text = desc
            }
            stubForm.layoutResource = when (form.formType) {
                FormType.INPUT -> R.layout.layout_input_form
                FormType.FIELD -> R.layout.layout_input_form
                FormType.CHECKBOX -> R.layout.layout_checkbox_form
                FormType.CHECKBOXINPUT -> R.layout.layout_checkbox_form
                FormType.RATE -> R.layout.layout_rate_form
            }
        }

        val inflatedView = binding.stubForm.inflate()

        when (form.formType) {
            FormType.INPUT -> {
                val binding = LayoutInputFormBinding.bind(inflatedView)
                setUpInputForm(binding)
            }
            FormType.FIELD -> {
                val binding = LayoutInputFormBinding.bind(inflatedView)
                setUpInputForm(binding)
            }
            FormType.CHECKBOX -> {
                val binding = LayoutCheckboxFormBinding.bind(inflatedView)
                setUpCheckboxForm(binding)
            }
            FormType.CHECKBOXINPUT -> {
                val binding = LayoutCheckboxFormBinding.bind(inflatedView)
                setUpCheckboxForm(binding)
            }
            FormType.RATE -> {
                val binding = LayoutRateFormBinding.bind(inflatedView)
                setUpRateForm(binding)
            }
        }
    }

    private fun setUpInputForm(binding: LayoutInputFormBinding) {
        binding.apply {
            with(form) {
                if(formType == FormType.FIELD){
                    etFormInput.inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE
                    etFormInput.setLines(10)
                }
                etFormInput.hint = inputHint
            }
        }
    }

    private fun setUpCheckboxForm(binding: LayoutCheckboxFormBinding) {
        binding.apply {
            with(form) {
                if (formType == FormType.CHECKBOX) {
                    etOtherForm.visibility = View.GONE
                }
                rvCheckbox.apply {
                    adapter = CheckBoxAdapter(listCheckbox ?: listOf())
                }

            }
        }
    }

    private fun setUpRateForm(binding: LayoutRateFormBinding) {
        binding.apply {
            with(form){
                tvRateStart.text = rateStartText
                tvRateEnd.text = rateEndText
            }
        }
    }
}