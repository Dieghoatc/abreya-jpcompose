package com.dieghoatc.abreyakmp.android.ui.sreens.technical

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.dieghoatc.abreyakmp.android.data.model.TechnicalModel

@Composable
fun TechnicalScreen(technical : TechnicalModel) {
    println(technical)
    Column() {
        Text(text = technical.id)
        Text(text = technical.name)
        Text(text = technical.lastName)
        Text(text = technical.email)
        Text(text = technical.phoneNumber)
        Text(text = technical.sector)
        Text(text = technical.service)
        Text(text = technical.image)
    }
}