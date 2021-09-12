package cz.koubicl.example.ui.home

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import cz.koubicl.example.R
import cz.koubicl.example.databinding.FragmentExampleBinding
import cz.koubicl.example.presentation.model.ProductItemModel
import cz.koubicl.example.ui.base.BaseFragment
import cz.koubicl.example.presentation.viewmodel.ExampleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExampleFragment : BaseFragment<ExampleViewModel, FragmentExampleBinding>(), ProductListener {
    override val layoutResource = R.layout.fragment_example
    override val toolbarTitle = "Example Application" // should be done via keys

    private val exampleViewModel by viewModel<ExampleViewModel>()

    override fun bindViewModel(viewBinding: FragmentExampleBinding, viewModel: ExampleViewModel) {
        viewBinding.vm = viewModel
    }

    override fun getViewModel() = exampleViewModel

    override fun onResume() {
        super.onResume()
        observeViewModel()
    }

    override fun addToCart(product: ProductItemModel) {
        val text = "Tried to add ${product.productName} into cart but it is not implemented yet."
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun observeViewModel() {
        exampleViewModel.productItems.observe(this, {
            val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            getViewBinding().exampleProductsRecycler.layoutManager = layoutManager
            getViewBinding().exampleProductsRecycler.adapter = ExampleProductsAdapter(it, layoutInflater, this)
        })
    }
}