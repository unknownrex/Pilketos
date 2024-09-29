package com.rexample.pilketos.data

import androidx.annotation.DrawableRes
import com.rexample.pilketos.R

data class Account(
    val namaSiswa: String = "Hakari Kinji",
    val nisnSiswa: String = "0012345679",
    val kelasJurusan: String = "XI - PPLG 2",
    val emailSiswa: String = "exampleemail@gmail.com",
    val tanggalLahir: String = "01 - 03 -2005",
    val passwordAccount: String = "admin123",
    @DrawableRes val photoProfile: Int = R.drawable.photo_profile
)
