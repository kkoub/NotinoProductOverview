package cz.koubicl.notino.ui.base

import androidx.databinding.ViewDataBinding
import cz.koubicl.notino.ui.databinding.DataBindingFragment
import cz.koubicl.notino.presentation.viewmodel.BaseViewModel

abstract class BaseFragment<VIEWMODEL : BaseViewModel, VIEWBINDING : ViewDataBinding> : DataBindingFragment<VIEWMODEL, VIEWBINDING>() {
    protected abstract val toolbarTitle: CharSequence
}