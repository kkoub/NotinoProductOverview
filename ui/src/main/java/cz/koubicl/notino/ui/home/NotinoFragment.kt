package cz.koubicl.notino.ui.home

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import cz.koubicl.notino.R
import cz.koubicl.notino.databinding.FragmentNotinoBinding
import cz.koubicl.notino.presentation.model.ProductItemModel
import cz.koubicl.notino.ui.base.BaseFragment
import cz.koubicl.notino.presentation.viewmodel.NotinoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotinoFragment : BaseFragment<NotinoViewModel, FragmentNotinoBinding>(), ProductListener {
    override val layoutResource = R.layout.fragment_notino
    override val toolbarTitle = "Notino" // should be done via keys

    private val notinoViewModel by viewModel<NotinoViewModel>()

    override fun bindViewModel(viewBinding: FragmentNotinoBinding, viewModel: NotinoViewModel) {
        viewBinding.vm = viewModel
    }

    override fun getViewModel() = notinoViewModel

    override fun onResume() {
        super.onResume()
        observeViewModel()
    }

    override fun addToCart(product: ProductItemModel) {
        val text = "Tried to add ${product.productName} into cart but it is not implemented yet."
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun observeViewModel() {
        notinoViewModel.productItems.observe(this, {
            val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            getViewBinding().notinoProductsRecycler.layoutManager = layoutManager
            getViewBinding().notinoProductsRecycler.adapter = NotinoProductsAdapter(it, layoutInflater, this)
        })
    }
}