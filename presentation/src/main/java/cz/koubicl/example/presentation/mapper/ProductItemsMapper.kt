package cz.koubicl.example.presentation.mapper

import cz.koubicl.example.domain.model.Products
import cz.koubicl.example.presentation.extensions.format
import cz.koubicl.example.presentation.model.ProductItemModel

class ProductItemsMapper : PresentationMapper<List<ProductItemModel>, Products> {

    override fun mapToPresentation(type: Products): List<ProductItemModel> {
        return type.products.map {
            ProductItemModel(
                it.imageUrl,
                it.name,
                it.brand.name,
                it.annotation,
                it.price.format(),
                it.reviewSummary.score
            )
        }
    }
}