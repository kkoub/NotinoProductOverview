package cz.koubicl.example.domain.mapper

import cz.koubicl.example.domain.model.AmountValue
import cz.koubicl.example.domain.model.Product
import cz.koubicl.example.domain.model.Products
import cz.koubicl.example.remote.model.GetProductsResponse

class ProductsMapper : ModelMapper<GetProductsResponse, Products> {
    override fun fromResponse(response: GetProductsResponse): Products {
        return Products(
            response.products.map { product ->
                Product(
                    product.id,
                    AmountValue(product.price.value, product.price.currency),
                    product.name,
                    Product.ProductBrand(
                        product.brand.id,
                        product.brand.name
                    ),
                    product.annotation,
                    Product.OrderUnit.getByType(product.orderUnit),
                    product.imageUrl,
                    Product.ProductAvailability(
                        product.stockAvailability.available,
                        product.stockAvailability.count
                    ),
                    Product.ProductRating(
                        product.reviewSummary.score
                    )
                )
            })
    }
}