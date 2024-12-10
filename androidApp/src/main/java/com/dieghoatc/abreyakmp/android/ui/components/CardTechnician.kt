package com.dieghoatc.abreyakmp.android.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dieghoatc.abreyakmp.android.R
import com.dieghoatc.abreyakmp.android.data.model.TechnicalModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder


@Composable
fun CardTechnician(technician: TechnicalModel, navController: NavController) {
    println(technician)
    val technicalModelJson = Json.encodeToString(technician)
    val encodedModelJson = URLEncoder.encode(technicalModelJson, "UTF-8")

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFf8f8f8),
        ),
        modifier = Modifier.padding(6. dp),
        onClick = { navController.navigate("technical/$encodedModelJson") }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            ImageUser(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = technician.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "Localidad: ${technician.sector}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xffc2cad1)
            )
            Text(
                text = "Servicio: ${technician.service}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )

        }
    }

}

@Composable
fun ImageUser(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.user_icon),
        contentDescription = "user",
        modifier = modifier
    )
}
