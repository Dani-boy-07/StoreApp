package com.adenikinju.storeapp.presentation.Screens

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.adenikinju.storeapp.R
import com.adenikinju.storeapp.data.models.storeitemsmodel
import com.adenikinju.storeapp.data.models.storeitemsmodelItem
import com.adenikinju.storeapp.presentation.components.allPadding
import com.adenikinju.storeapp.presentation.components.headerFontSize
import com.adenikinju.storeapp.presentation.components.horizontalPadding
import com.adenikinju.storeapp.presentation.components.verticalPadding
import com.adenikinju.storeapp.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        homeViewModel.getSingleItemApi(20)
    }
    val allItems = homeViewModel.storeItems.collectAsState().value
    val highRated = allItems.filter { it ->
        it.rating?.rate!! >= 4.0
    }
    val budgetFriendly = allItems.filter { it ->
        it.price!! <= 20.0
    }
    val singleItem = homeViewModel.storeItem.collectAsState().value
    LazyColumn(
        modifier = Modifier.fillMaxSize(1f)
    ) {
        item(1) {
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
            singleItem?.let { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color.Blue)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = item.image,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = "Item Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize(),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .background(Color(195, 197, 202, 190))
                    ) {}
                    Row(
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .background(Color.Transparent),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Explore our Fall Items",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = headerFontSize,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(vertical = verticalPadding))
            ComponentRow1(highRated, "Highly Rated")
            Spacer(modifier = Modifier.padding(vertical = verticalPadding))
            ComponentRow1(budgetFriendly, "Budget Friendly")
        }
    }


}

@Composable
fun ComponentRow1(rowItem: List<storeitemsmodelItem>, sectionName: String) {
    Row(
        modifier = Modifier
            .padding(horizontal = horizontalPadding)
    ) {
        Text(
            text = sectionName,
            fontWeight = FontWeight.Bold,
            fontSize = headerFontSize
        )
    }
    LazyRow(
        modifier = Modifier
            .padding(vertical = verticalPadding)
    ) {
        items(rowItem.size) { item ->
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .padding(horizontal = horizontalPadding)
            ) {
                Row(
                    modifier = Modifier
                        .height(200.dp)
                        .background(Color(248, 250, 252))
                        .fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = rowItem[item].image,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        modifier = Modifier
                            .fillMaxSize(.8f)
                            .background(Color.Transparent),
                        contentDescription = "Item Image",
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(
                    modifier = Modifier.padding(top = verticalPadding)
                ) {
                    Text(
                        text = rowItem[item].title.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                    )
                    Text(
                        text = "$${rowItem[item].price}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color(5, 150, 105)
                    )
                }
            }
        }

    }
}