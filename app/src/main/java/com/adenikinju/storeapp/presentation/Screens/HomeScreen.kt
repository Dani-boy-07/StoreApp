package com.adenikinju.storeapp.presentation.Screens

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.adenikinju.storeapp.R
import com.adenikinju.storeapp.presentation.components.allPadding
import com.adenikinju.storeapp.presentation.components.headerFontSize
import com.adenikinju.storeapp.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val storeItems by homeViewModel.storeItems.collectAsState()

//    val singleItem = homeViewModel.getSingleItem(1)
    Log.e("singleItem", "singleitem: ${storeItems[1]}")
//    LaunchedEffect(Unit) {
//        val singleItem = homeViewModel.getSingleItem(1)
//    }
    Column(
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(all = allPadding),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Store4Live.",
                fontWeight = FontWeight.Bold,
                fontSize = headerFontSize
            )
            Row {
                Icon(
                    ImageVector.vectorResource(R.drawable.baseline_email_24),
                    contentDescription = "email"
                )
                Spacer(Modifier.padding(end = 5.dp))
                Icon(
                    ImageVector.vectorResource(R.drawable.baseline_notifications_24),
                    contentDescription = "notifications"
                )
            }
        }
//        singleItem?.let { item ->
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//            ) {
//                Image(
//                    painter = rememberImagePainter(
//                        data = item.image,
//                        builder = {
//                            crossfade(true)
//                        }
//                    ),
//                    contentDescription = "Item Image",
//                    modifier = Modifier
//                        .fillMaxSize()
//                )
//            }
//        }
    }

}