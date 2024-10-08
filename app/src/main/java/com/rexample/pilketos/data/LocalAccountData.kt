package com.rexample.pilketos.data

import com.rexample.pilketos.R
import com.rexample.pilketos.model.AccountModel

object LocalAccountData {
    val defaultAccount = AccountModel(
        namaSiswa = "Lorem Ipsum Dolor",
        kelasJurusan = "XI - PPLG 2",
        nisnSiswa = "0012345678",
        emailSiswa = "examplemail33@gmail.com",
        tanggalLahir = "01 - 03 - 2006",
        passwordAccount = "Admin123",
        photoProfile = R.drawable.photo_profile
    )
}