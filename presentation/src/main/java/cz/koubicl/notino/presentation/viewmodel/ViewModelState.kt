package cz.koubicl.notino.presentation.viewmodel

open class ViewModelState {
    object Initial : ViewModelState()
    object Loading : ViewModelState()
    object Ready : ViewModelState()
}
