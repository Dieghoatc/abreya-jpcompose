package com.dieghoatc.abreyakmp.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(title: String, buttonEnable: Boolean, handleSubmit: () -> Unit) {
    Button(
        onClick = {handleSubmit()},
        shape = RoundedCornerShape(23.dp),
        border = BorderStroke(1.dp, Color(0xffD4B200)),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color(0xffD4B200),
            disabledContainerColor = Color.Transparent,
            contentColor = Color(0xFF000000),
            containerColor = Color(0xffD4B200),
        ),
        enabled = buttonEnable
    ) {
        Text(text = title)
    }
}