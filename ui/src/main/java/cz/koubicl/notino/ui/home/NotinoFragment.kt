package cz.koubicl.notino.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import cz.koubicl.notino.R
import cz.koubicl.notino.databinding.FragmentNotinoBinding
import cz.koubicl.notino.ui.base.BaseFragment
import cz.koubicl.notino.presentation.viewmodel.NotinoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotinoFragment : BaseFragment<NotinoViewModel, FragmentNotinoBinding>() {
    override val layoutResource = R.layout.fragment_notino
    override val toolbarTitle = "Notino"

    private val notinoViewModel by viewModel<NotinoViewModel>()

    override fun bindViewModel(viewBinding: FragmentNotinoBinding, viewModel: NotinoViewModel) {
        viewBinding.vm = viewModel
    }

    override fun getViewModel() = notinoViewModel

    override fun onResume() {
        super.onResume()
        observeViewModel()
        setupRefresh()
    }

    private fun observeViewModel() {
        notinoViewModel.productItems.observe(this, {
            val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            getViewBinding().notinoProductsRecycler.layoutManager = layoutManager
            getViewBinding().notinoProductsRecycler.adapter = NotinoProductsAdapter(it, layoutInflater) { addToCart() }
        })

        notinoViewModel.isLoading.observe(this, {
            getViewBinding().notinoProductsRefresh.isRefreshing = it
        })
    }

    private fun addToCart() {
        Toast.makeText(context, "Not implemented yet.", Toast.LENGTH_SHORT).show()
    }

    private fun setupRefresh() {
        getViewBinding().notinoProductsRefresh.setOnRefreshListener {
            notinoViewModel.fetchProducts()
        }
    }
}