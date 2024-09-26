package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryApp()
        }
    }
}

@Composable
fun ArtGalleryApp() {
    var currentImageIndex by remember { mutableIntStateOf(0) }
    val images = listOf(
        R.drawable.ca004ab1e7fe616c00eb8757b8de15c6,
        R.drawable.leonardo_da_vinci___mona_lisa__louvre__paris_,
        R.drawable.pintura_la_joven_de_la_perla
    )
    val titles = listOf("La noche estrellada", "La Gioconda", "La joven de la perla")
    val authors = listOf("Vincent van Gogh", "Leonardo Da Vinci", "Johannes Vermeer")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(360.dp)
                .shadow(24.dp, shape = RoundedCornerShape(16.dp))
                .border(8.dp, Color.Black, shape = RoundedCornerShape(16.dp)) // Borde negro alrededor del marco blanco
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = images[currentImageIndex]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = titles[currentImageIndex],
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = authors[currentImageIndex], style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = { currentImageIndex = (currentImageIndex - 1 + images.size) % images.size },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { currentImageIndex = (currentImageIndex + 1) % images.size },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Next")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtGalleryApp()
}