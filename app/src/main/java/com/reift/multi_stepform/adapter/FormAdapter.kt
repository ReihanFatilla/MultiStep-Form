package com.reift.multi_stepform.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.multi_stepform.data.getFormViewPagerData
import com.reift.multi_stepform.fragment.FormFragment

class FormAdapter(
    fm: FragmentActivity
): FragmentStateAdapter(fm) {

    private val listForm = getFormViewPagerData()

    override fun getItemCount() = listForm.size

    override fun createFragment(position: Int): Fragment {
        return FormFragment().also { fragment ->
            Bundle().also { bundle ->
                bundle.putParcelable(FORM_BUNDLE, listForm[position])
                fragment.arguments = bundle
            }
        }
    }

    companion object {
        const val FORM_BUNDLE = "form_bundle"
    }
}