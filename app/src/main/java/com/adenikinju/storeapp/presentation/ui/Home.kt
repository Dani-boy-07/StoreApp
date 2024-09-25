package com.adenikinju.storeapp.presentation.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.adenikinju.storeapp.data.screenItems.HomeSection
import com.adenikinju.storeapp.presentation.Screens.CategoryScreen
import com.adenikinju.storeapp.presentation.Screens.HomeScreen
import com.adenikinju.storeapp.presentation.Screens.ProfileScreen
import com.adenikinju.storeapp.presentation.Screens.SearchScreen
import com.adenikinju.storeapp.presentation.components.Bottombar

@Composable
fun Home(){
    val sectionState = remember { mutableStateOf(HomeSection.Home) }

    val navItems = HomeSection.entries.toTypedArray().toList()

    Scaffold(
        bottomBar = { Bottombar(
            items = navItems,
            currentSection = sectionState.value,
            onSectionSelected = {sectionState.value = it}
        ) },
        modifier = Modifier.padding(WindowInsets.navigationBars.asPaddingValues())
    ) { innerPadding ->
        Crossfade(
            targetState = sectionState.value,
            modifier =  Modifier.padding(innerPadding)
        ) { section ->
            when(section){
                HomeSection.Home -> HomeScreen()
                HomeSection.Search -> SearchScreen()
                HomeSection.Category -> CategoryScreen()
                HomeSection.Profile -> ProfileScreen()
            }
        }

    }
}