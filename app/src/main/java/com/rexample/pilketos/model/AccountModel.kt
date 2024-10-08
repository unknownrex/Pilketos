package com.rexample.pilketos.model

import androidx.annotation.DrawableRes

data class AccountModel(
    val namaSiswa: String,
    val nisnSiswa: String,
    val kelasJurusan: String,
    val emailSiswa: String,
    val tanggalLahir: String,
    val passwordAccount: String,
    @DrawableRes val photoProfile: Int
)


