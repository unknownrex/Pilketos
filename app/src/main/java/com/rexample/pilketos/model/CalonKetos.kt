package com.rexample.pilketos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CalonKetos(
    val id: Int,
    @StringRes val nama: Int,
    @StringRes val kelasJurusan: Int,
    @DrawableRes val image: Int,
    @StringRes val visi: Int,
    @StringRes val misi: Int,
    val suaraMasuk: Float
)
