package com.reift.multi_stepform.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Form(
    var title: String,
    var desc: String,
    var formType: FormType,
    var inputHint: String? = if (formType == FormType.INPUT || formType == FormType.FIELD) "" else null,
    var listCheckbox: List<String>? = if (formType == FormType.CHECKBOX || formType == FormType.CHECKBOXINPUT) listOf() else null,
    var rateStartText: String? = if (formType == FormType.RATE) "" else null,
    var rateEndText: String? = if (formType == FormType.RATE) "" else null,
) : Parcelable
