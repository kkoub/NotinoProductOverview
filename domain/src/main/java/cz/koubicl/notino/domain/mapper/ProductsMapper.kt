package cz.koubicl.notino.domain.mapper

import cz.koubicl.notino.domain.model.AmountValue
import cz.koubicl.notino.domain.model.Product
import cz.koubicl.notino.domain.model.Products
import cz.koubicl.notino.remote.model.GetProductsResponse

class ProductsMapper : ModelMapper<GetProductsResponse, Products> {
    override fun fromResponse(response: GetProductsResponse): Products {
        return Products(
            response.products.map { product ->
                Product(
                    product.id,
                    product.productId,
                    product.masterId,
                    AmountValue(product.price.value, product.price.currency),
                    product.name,
                    Product.ProductBrand(
                        product.brand.id,
                        product.brand.name
                    ),
                    product.annotation,
                    product.orderUnit,
                    Product.ProductAttributes(
                        product.attributes.master,
                        product.attributes.ean,
                        Product.ProductAttributes.ProductPackageSize(
                            product.attributes.packageSize.height,
                            product.attributes.packageSize.width,
                            product.attributes.packageSize.depth
                        )
                    ),
                    product.imageUrl,
                    Product.ProductAvailability(
                        product.stockAvailability.code,
                        product.stockAvailability.count
                    ),
                    Product.ProductRating(
                        product.reviewSummary.score
                    )
                )
            })
    }
}