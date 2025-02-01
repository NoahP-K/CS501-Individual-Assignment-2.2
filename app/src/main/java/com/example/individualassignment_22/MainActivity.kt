package com.example.individualassignment_22

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.individualassignment_22.ui.theme.IndividualAssignment_22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualAssignment_22Theme {
                makeGallery()
            }
        }
    }
}

//Makes a unit of a photo and its caption
@Composable
fun makePhoto(caption: String, photo: Int){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = 200.dp)
            .fillMaxHeight()
            .padding(
                horizontal = 12.dp,
                vertical = 12.dp)
    ){
        Image(
            painter = painterResource(id = photo),
            contentDescription = caption,
            modifier = Modifier
                .size(180.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = caption,
            fontSize = 20.sp,
        )
    }
}

//Makes a row of captioned photos.
//Argument is an array of pairs which each contain a photo and its caption.
@Composable
fun photoRow(photos: Array<Pair<Int, String>>){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 280.dp)
    ) {
        for (item in photos) {
            makePhoto(item.second, item.first)
        }
    }
}

@Composable
fun makeGallery(){
    //A column of three rows, each with two photos in it
    Column{
        //Making the row elements
        val row1 = arrayOf(
            Pair(R.drawable.incognito, "Incognito"),
            Pair(R.drawable.lookout, "I Spy")
        )
        val row2 = arrayOf(
            Pair(R.drawable.freedom, "Freedom"),
            Pair(R.drawable.fruit_salad, "Fruit Salad")
        )
        val row3 = arrayOf(
            Pair(R.drawable.leftovers, "Leftovers"),
            Pair(R.drawable.lament, "Lament")
        )
        photoRow(row1)
        photoRow(row2)
        photoRow(row3)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    IndividualAssignment_22Theme {
        Card(
            modifier = Modifier.size(width = 412.dp, height = 915.dp)
        ) {
            makeGallery()
        }
    }
}