package com.adenikinju.storeapp.data.screenItems

import com.adenikinju.storeapp.R

enum class HomeSection(
    val icon: Int,
    val selectedIcon: Int
) {
    Home(R.drawable.home, R.drawable.home_filled),
    Search(R.drawable.search, R.drawable.search_filled),
    Category(R.drawable.category, R.drawable.category_filled),
    Profile(R.drawable.profile, R.drawable.profile_filled),
}