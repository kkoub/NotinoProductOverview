package cz.koubicl.example.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.koubicl.example.databinding.ItemProductBinding
import cz.koubicl.example.presentation.model.ProductItemModel

class ExampleProductsAdapter(
    private val products: List<ProductItemModel>,
    private val layoutInflater: LayoutInflater,
    private val productListener: ProductListener
) : RecyclerView.Adapter<ExampleProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(private var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductItemModel) {
            binding.item = item
            binding.addToCartButton.setOnClickListener { productListener.addToCart(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleProductsAdapter.ProductsViewHolder {
        return ProductsViewHolder(ItemProductBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) = holder.bind(products[position])

    override fun getItemCount() = products.size
}