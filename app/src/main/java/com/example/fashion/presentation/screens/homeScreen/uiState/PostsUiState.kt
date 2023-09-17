package com.example.fashion.presentation.screens.homeScreen.uiState

data class PostsUiState(
    var isLoading: Boolean = true,
    var posts: List<PostUiState> = emptyList(),
    var textSearch: String = "",
    var searchResult: List<PostUiState> = emptyList(),
    var isSearchBarActive : Boolean = false,
    var searchHistory:  MutableList<String> = mutableListOf ("Kotlin", "Jetpack Compose")
)
