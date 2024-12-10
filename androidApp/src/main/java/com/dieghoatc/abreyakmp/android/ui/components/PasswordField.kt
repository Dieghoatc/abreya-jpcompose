package com.dieghoatc.abreyakmp.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dieghoatc.abreyakmp.android.R

@Composable
fun PasswordField(
    title:String,
    password: String,
    showPassword: Boolean,
    onTextFieldChanged: (String) -> Unit,
    onShowPassword: (Boolean) -> Unit
) {

    TextField(
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1,
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        label = { Text(title) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(color = Color(0xffD4B200)),
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onShowPassword(!showPassword) }) {
                Icon(
                    painter = if (showPassword) painterResource(id = R.drawable.eye_icon) else painterResource(id = R.drawable.eye_off_icon),
                    contentDescription = if (showPassword) "Hide password" else "Show password",
                    tint = if (showPassword) Color(0xffD4B200) else Color(0xFF836F00),
                    modifier = Modifier.size(16.dp)
                )
            }
        },
//        supportingText = {
//            if (showPassword) {
//                Text(
//                    text = "Hide password",
//                    color = Color(0xFF836F00),
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        },
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