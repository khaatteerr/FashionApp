package com.example.fashion.presentation.screens.homeScreen.uiState

sealed class HomeUiEvent {
    data class SearchTextChanged(var text: String) : HomeUiEvent()
    object Search : HomeUiEvent()
    data class SearchBarActive(val active : Boolean):HomeUiEvent()
    data class AddToHistory(val searchText: String):HomeUiEvent()
    object ClearOrCloseSearchBar :HomeUiEvent()

 }
