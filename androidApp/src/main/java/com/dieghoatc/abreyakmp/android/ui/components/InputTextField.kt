package com.dieghoatc.abreyakmp.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun InputTextField(title: String, value: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = {onTextFieldChanged(it)},
        label = { Text(text = title)},
        maxLines = 1,
        singleLine = true,

        textStyle = TextStyle(color = Color(0xffD4B200)),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            cursorColor = Color(0xffD4B200),
            unfocusedLabelColor = Color(0xFF836F00),
            unfocusedIndicatorColor = Color(0xFF836F00),
            focusedIndicatorColor = Color(0xffD4B200),
            focusedLabelColor = Color(0xFF836F00),
        )
    )
}
