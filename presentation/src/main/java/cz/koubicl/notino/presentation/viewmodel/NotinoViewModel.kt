package cz.koubicl.notino.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import cz.koubicl.notino.domain.interactor.GetProductsInteractor
import cz.koubicl.notino.presentation.mapper.ProductItemsMapper
import cz.koubicl.notino.presentation.model.ProductItemModel

class NotinoViewModel(
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
            .onError { }
            .observe()
    }
}