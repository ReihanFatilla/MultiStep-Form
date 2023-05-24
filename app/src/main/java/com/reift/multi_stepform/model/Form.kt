package com.reift.multi_stepform.model

data class Form<T>(
    var title: String,
    var desc: String,
    var input: T,
    var formType: FormType,
)
