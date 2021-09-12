package cz.koubicl.example.ui.base

import androidx.databinding.ViewDataBinding
import cz.koubicl.example.ui.databinding.DataBindingFragment
import cz.koubicl.example.presentation.viewmodel.BaseViewModel

abstract class BaseFragment<VIEWMODEL : BaseViewModel, VIEWBINDING : ViewDataBinding> : DataBindingFragment<VIEWMODEL, VIEWBINDING>() {
    protected abstract val toolbarTitle: CharSequence
}