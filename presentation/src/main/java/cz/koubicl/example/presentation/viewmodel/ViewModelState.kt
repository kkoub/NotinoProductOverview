package cz.koubicl.example.presentation.viewmodel

sealed class ViewModelState {
    object Initial : ViewModelState()
    object Loading : ViewModelState()
    object Ready : ViewModelState()
}
