package com.adenikinju.storeapp.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.contentColorFor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adenikinju.storeapp.data.screenItems.HomeSection


val verticalPadding = 15.dp
val horizontalPadding = 15.dp
val bottomBarHeight = 50.dp
val allPadding = 15.dp
val headerFontSize = 20.sp

@Composable
fun Bottombar(
    items: List<HomeSection>,
    currentSection: HomeSection,
    onSectionSelected: (HomeSection) -> Unit
){
    BottomNavigation(
        modifier = Modifier
            .height(bottomBarHeight),
        backgroundColor = MaterialTheme.colorScheme.background,
//        contentColor = contentColorFor(MaterialTheme.colorScheme.background)
    ) {
        items.forEach { section ->
            val selected = section == currentSection
            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = { Icon(ImageVector.vectorResource(iconRes), contentDescription = null) },
                selected = selected,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}