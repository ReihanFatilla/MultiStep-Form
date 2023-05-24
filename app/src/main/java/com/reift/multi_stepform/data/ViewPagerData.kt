package com.reift.multi_stepform.data

import com.reift.multi_stepform.model.Form
import com.reift.multi_stepform.model.FormType

fun getFormViewPagerData(): List<Form> {
    return listOf(
        Form(
            "Nama Lengkap",
            "Masukkan nama lengkap Anda",
            FormType.INPUT,
            inputHint = "Nama Lengkap Anda"
        ),
        Form(
            "Nomor Telepon",
            "Pastikan nomor telepon yand ada masukkan aktif",
            FormType.INPUT,
            inputHint = "Nomor Telepon Anda"
        ),
        Form(
            "Email",
            "Masukkan Email Anda",
            FormType.INPUT,
            inputHint = "Email Anda"
        ),
        Form(
            "Nama Bisnis",
            "Masukkan nama bisnis Anda",
            FormType.INPUT,
            inputHint = "Nama Bisnis Anda"
        ),
        Form(
            "Bidang Usaha",
            "Bisa dipilih lebih dari satu",
            FormType.CHECKBOX,
            listCheckbox = listOf("Pertanian", "Perikanan", "Peternakan", "Perkebunan", "Perdagangan", "Jasa", "Lainnya")
        ),
        Form(
            "Diferensiasi Bisnis",
            "Yang membedakan dari bisnis lain",
            FormType.CHECKBOXINPUT,
            listCheckbox = listOf("Harga", "Kualitas", "Pelayanan")
        ),
        Form(
            "Kondisi bisnis Anda saat ini",
            "Dan rencana optimalisasi ke depannya",
            FormType.FIELD,
            inputHint = "Tuliskan kondisi bisnis Anda saat ini dan rencana optimalisasi ke depannya"
        ),
        Form(
            "Channel digital yang digunakan saat ini",
            "Bisa dipilih lebih dari satu",
            FormType.CHECKBOX,
            listCheckbox = listOf("Instagram", "Facebook", "Tiktok", "Shopee", "Tokopedia", "Bukalapak", "Lainnya")
        ),
        Form(
            "Skala optimal channel digital Anda",
            "Apakah menurut anda channel digital sudah optimal?",
            FormType.RATE,
            rateStartText = "Belum\noptimal",
            rateEndText = "Sudah\noptimal"
        ),
        Form(
            "Kendala pada channel digital Anda",
            "Apakah ada kendala dalam mengelola channel digital anda?",
            FormType.RATE,
            rateStartText = "Tidak ada\nkendala",
            rateEndText = "banyak\nkendala"
        ),
        Form(
            "Channel digital yang ingin dioptimalkan",
            "Bisa dipilih lebih dari satu",
            FormType.CHECKBOX,
            listCheckbox = listOf("Website/Landing page", "Aplikasi", "SEO", "Sosial Media", "Marketplace", "Lainnya")
        ),
        Form(
            "Target bisnis anda melalui optimalisasi",
            "Tuliskan target dan rencana bisnis anda",
            FormType.FIELD,
            inputHint = "Tuliskan target dan rencana bisnis anda setelah melalui proses optimalisasi channel digital"
        ),
        Form(
            "Budget untuk optimalisasi channel anda",
            "Pilih jumlah budget yang sudah disiapkan",
            FormType.RADIO,
            listRadio = listOf("Rp. 0", "Rp. 500.000 - Rp. 1.000.000", "Rp. 1.000.000 - Rp. 2.500.000", "Rp. 2.500.000 - Rp. 5.000.000", "Rp. 5.000.000+",)
        ),
        Form(
            "% Kenaikan omset yang diharapkan",
            "Pilih jumlah kenaikan omset yang Anda harapkan",
            FormType.RADIOINPUT,
            listRadio = listOf("10%", "25%", "50%", "75%", "100%")
        ),
        Form(
            "Apakah bersedia untuk optimalisasi",
            "Pilih kersediaan untuk proses optimalisasi channel digital",
            FormType.RADIO,
            listRadio = listOf("Ya", "Tidak")
        ),

    )
}