package com.reift.multi_stepform.fragment

import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.reift.multi_stepform.R
import com.reift.multi_stepform.adapter.CheckBoxAdapter
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.databinding.*
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
                FormType.RADIO -> R.layout.layout_radio_form
                FormType.RADIOINPUT -> R.layout.layout_radio_form
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
            FormType.RADIO -> {
                val binding = LayoutRadioFormBinding.bind(inflatedView)
                setUpRadioForm(binding)
            }
            FormType.RADIOINPUT -> {
                val binding = LayoutRadioFormBinding.bind(inflatedView)
                setUpRadioForm(binding)
            }
        }
    }

    private fun setUpRadioForm(binding: LayoutRadioFormBinding) {
        binding.apply {
            with(form){
                if(formType == FormType.RADIO){
                    etOtherForm.visibility = View.GONE
                }

                listRadio?.forEach {
                    val radioButton = RadioButton(context)
                    radioButton.text = it
                    radioButton.id = View.generateViewId()
                    radioButton.setPadding(24, 0, 0, 0)
                    val params = RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
                    params.setMargins(0, 28, 0, 28)
                    radioButton.layoutParams = params
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        radioButton.typeface = resources.getFont(R.font.inter_regular)
                    }
                    radioButton.setButtonDrawable(R.drawable.custom_radio_button)
                    rgForm.addView(radioButton)
                }

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