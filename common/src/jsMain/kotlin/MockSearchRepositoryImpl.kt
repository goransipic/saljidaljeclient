import hr.goodapp.saljidaljeclient.ProductChildProperty
import hr.goodapp.saljidaljeclient.ProductChildResponse
import hr.goodapp.saljidaljeclient.ProductProperty
import hr.goodapp.saljidaljeclient.ProductResponse
import hr.goodapp.saljidaljeclient.SearchRepository

class MockSearchRepositoryImpl(

) : SearchRepository {

    override suspend fun getModels(makeId: Int): ProductResponse {
        // Return fake data
        return ProductResponse(
            productsCount = 3,
            properties = listOf(
                ProductProperty("Model A", "1", "1"),
                ProductProperty("Model B", "2", "2"),
                ProductProperty("Model C", "3", "3")
            )
        )
    }

    override suspend fun getSpecifications(categoryId: Int, commandType: String): ProductChildResponse {
        return when (commandType) {
            "BODY_TYPE" -> ProductChildResponse(
                productsCount = 2,
                properties = listOf(
                    ProductChildProperty(1, "Sedan"),
                    ProductChildProperty(2, "SUV")
                )
            )
            "LOCATIONS" -> ProductChildResponse(
                productsCount = 2,
                properties = listOf(
                    ProductChildProperty(1, "Europe"),
                    ProductChildProperty(2, "USA")
                )
            )
            else -> ProductChildResponse(
                productsCount = 0,
                properties = emptyList()
            )
        }
    }
}