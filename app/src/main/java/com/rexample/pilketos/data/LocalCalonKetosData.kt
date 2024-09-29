package com.rexample.pilketos.data

import androidx.annotation.StringRes
import com.rexample.pilketos.R
import com.rexample.pilketos.model.CalonKetos

object LocalCalonKetosData {
    val defaultCalon = CalonKetos(
        id = 1,
        nama = R.string.calon1,
        kelasJurusan = R.string.kelas_jurusan,
        image = R.drawable.kaoruko_waguri,
        visi = R.string.default_visi,
        misi = R.string.dafault_misi,
        suaraMasuk = 00.00f
    )

    val allCalonKetos = listOf(
        CalonKetos(
            id = 1,
            nama = R.string.calon1,
            kelasJurusan = R.string.kelas_jurusan,
            image = R.drawable.kaoruko_waguri,
            visi = R.string.default_visi,
            misi = R.string.dafault_misi,
            suaraMasuk = 00.00f
        ),
        CalonKetos(
            id = 2,
            nama = R.string.calon2,
            kelasJurusan = R.string.kelas_jurusan,
            image = R.drawable.ryo_yamada,
            visi = R.string.default_visi,
            misi = R.string.dafault_misi,
            suaraMasuk = 00.00f
        ),
        CalonKetos(
            id = 1,
            nama = R.string.calon3,
            kelasJurusan = R.string.kelas_jurusan,
            image = R.drawable.nadeshiko_kagamihara,
            visi = R.string.default_visi,
            misi = R.string.dafault_misi,
            suaraMasuk = 00.00f
        )
    )
}