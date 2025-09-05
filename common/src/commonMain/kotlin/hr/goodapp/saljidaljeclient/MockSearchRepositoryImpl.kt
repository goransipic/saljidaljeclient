package hr.goodapp.saljidaljeclient

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class MockSearchRepositoryImpl(
    private val baseUrl: String = "http://localhost:8080",
    private val httpClient: HttpClient = provideHttpClient()
) : SearchRepository {

    override suspend fun getModels(makeId: Int): ProductResponse {
        // Return fake data
        val response: String = httpClient.get("https://saljidalje.hr").bodyAsText()
        println(response)
        return ProductResponse(
            productsCount = 3,
            properties = listOf(
                ProductProperty("Model A", "1", "1a"),
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