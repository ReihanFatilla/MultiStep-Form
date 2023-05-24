package com.reift.multi_stepform.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.multi_stepform.data.getFormViewPagerData
import com.reift.multi_stepform.fragment.CheckBoxFragment
import com.reift.multi_stepform.fragment.InputFragment
import com.reift.multi_stepform.fragment.RateFragment
import com.reift.multi_stepform.model.FormType

class FormAdapter(
    fm: FragmentActivity
): FragmentStateAdapter(fm) {

    private val listForm = getFormViewPagerData()

    override fun getItemCount() = listForm.size

    override fun createFragment(position: Int): Fragment {
        return when(listForm[position].formType){
            FormType.INPUT -> InputFragment()
            FormType.FIELD -> InputFragment()
            FormType.CHECKBOX -> CheckBoxFragment()
            FormType.CHECKBOXINPUT -> CheckBoxFragment()
            FormType.RATE -> RateFragment()
        }.also {
            val bundle = Bundle()
            bundle.putParcelable(FORM_BUNDLE, listForm[position])
            it.arguments = bundle
        }
    }

    companion object {
        const val FORM_BUNDLE = "form_bundle"
    }
}