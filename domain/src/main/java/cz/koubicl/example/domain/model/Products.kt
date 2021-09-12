package cz.koubicl.example.domain.model

class Products(
    val products: List<Product>
)

class Product(
    val id: Int,
    val price: AmountValue,
    val name: String,
    val brand: ProductBrand,
    val annotation: String,
    val orderUnit: OrderUnit,
    val imageUrl: String,
    val stockAvailability: ProductAvailability,
    val reviewSummary: ProductRating
) {
    class ProductBrand(
        val id: String,
        val name: String
    )

    enum class OrderUnit(type: String) {
        KG("kg"), KS("ks");

        companion object {
            fun getByType(type: String) = values().firstOrNull{ it.name == type } ?: KS
        }
    }

    class ProductAvailability(
        val available: Boolean = false,
        val count: Int?
    )

    class ProductRating(
        val score: Int
    )
}