package cz.koubicl.notino.presentation.viewmodel

import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import cz.koubicl.notino.domain.interactor.GetProductsInteractor
import cz.koubicl.notino.domain.model.AmountValue
import cz.koubicl.notino.domain.model.Product
import cz.koubicl.notino.domain.model.Products
import cz.koubicl.notino.presentation.mapper.ProductItemsMapper
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class NotinoViewModelTest : ViewModelTest() {

    private val getProductsInteractor: GetProductsInteractor = mock()
    private val productItemsMapper: ProductItemsMapper = mock()

    @Before
    fun setup() {
        whenever(getProductsInteractor.getProducts()).thenReturn(Single.just(createProducts()))
        whenever(productItemsMapper.mapToPresentation(createProducts())).thenReturn(listOf())
    }

    @Test
    fun `when user enters the screen, products are fetched and productItems filled`() {
        //given

        // when
        val viewModel = createViewModel()
        viewModel.fetchProducts()

        // then
        verify(getProductsInteractor, once()).getProducts()
        viewModel.productItems.test().assertHasValue()
    }

    private fun createViewModel() = NotinoViewModel(getProductsInteractor, productItemsMapper)

    private fun createProducts() =
        Products(
            listOf(
                Product(
                    "1",
                    2,
                    3,
                    AmountValue(333, "CZK"),
                    "xxx",
                    Product.ProductBrand(
                        "2",
                        "xxx"
                    ),
                    "xxx",
                    "ks",
                    Product.ProductAttributes(
                        true,
                        "sdas223",
                        Product.ProductAttributes.ProductPackageSize(
                            1,
                            2,
                            3
                        )
                    ),
                    "abcd.ef",
                    Product.ProductAvailability(
                        "xxx",
                        null
                    ),
                    Product.ProductRating(
                        5
                    )
                )
            )
        )
}