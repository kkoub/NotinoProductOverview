package cz.koubicl.notino.domain.model

class Products(
    val products: List<Product>
)

class Product(
    val id: String,
    val productId: Int,
    val masterId: Int,
    val price: AmountValue,
    val name: String,
    val brand: ProductBrand,
    val annotation: String,
    val orderUnit: String,
    val attributes: ProductAttributes,
    val imageUrl: String,
    val stockAvailability: ProductAvailability,
    val reviewSummary: ProductRating
) {
    class ProductBrand(
        val id: String,
        val name: String
    )

    class ProductAttributes(
        val master: Boolean,
        val ean: String,
        val packageSize: ProductPackageSize
    ) {

        class ProductPackageSize(
            val height: Int,
            val width: Int,
            val depth: Int
        )
    }

    class ProductAvailability(
        val code: String,
        val count: Int?
    )

    class ProductRating(
        val score: Int
    )
}