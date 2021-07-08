package cz.koubicl.notino.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.koubicl.notino.databinding.ItemProductBinding
import cz.koubicl.notino.presentation.model.ProductItemModel

class NotinoProductsAdapter(
    private val products: List<ProductItemModel>,
    private val layoutInflater: LayoutInflater,
    private val onAddToCartListener: (ProductItemModel) -> Unit
) : RecyclerView.Adapter<NotinoProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(private var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductItemModel) {
            binding.item = item
            binding.viewHolder = this
        }

        fun onAddToCardClicked(item: ProductItemModel) {
            onAddToCartListener(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotinoProductsAdapter.ProductsViewHolder {
        return ProductsViewHolder(ItemProductBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) = holder.bind(products[position])

    override fun getItemCount() = products.size
}