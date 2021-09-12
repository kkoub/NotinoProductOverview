package cz.koubicl.example.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import cz.koubicl.example.domain.interactor.GetProductsInteractor
import cz.koubicl.example.presentation.mapper.ProductItemsMapper
import cz.koubicl.example.presentation.model.ProductItemModel

class ExampleViewModel(
    private val getProductsInteractor: GetProductsInteractor,
    private val productItemsMapper: ProductItemsMapper
) : BaseViewModel() {

    val productItems = MutableLiveData<List<ProductItemModel>>()

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        getProductsInteractor.getProducts()
            .onSuccess {
                val products = productItemsMapper.mapToPresentation(it)
                productItems.postValue(products)
            }
            // TODO error logic handling
            .onError {}
            .observe()
    }
}