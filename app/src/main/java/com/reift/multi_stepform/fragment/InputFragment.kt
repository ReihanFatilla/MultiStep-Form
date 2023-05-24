package com.reift.multi_stepform.fragment

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reift.multi_stepform.R
import com.reift.multi_stepform.adapter.FormAdapter
import com.reift.multi_stepform.databinding.ActivityMainBinding
import com.reift.multi_stepform.databinding.FragmentInputFormBinding
import com.reift.multi_stepform.model.Form
import com.reift.multi_stepform.model.FormType

class InputFragment : Fragment() {

    private var _form: Form? = null
    private val form get() = _form as Form

    private var _binding: FragmentInputFormBinding? = null
    private val binding get() = _binding as FragmentInputFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInputFormBinding.inflate(layoutInflater)
        _form = arguments?.getParcelable(FormAdapter.FORM_BUNDLE)

        setUpForm()

        return binding.root
    }

    private fun setUpForm() {
        binding.apply {
            with(form){
                tvFormTitle.text = title
                tvFormDescription.text = desc

                if(formType == FormType.FIELD){
                    etFormInput.inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE
                    etFormInput.setLines(10)
                }

                etFormInput.hint = inputHint
            }
        }
    }
}