package hr.goodapp.saljidaljeclient

interface SearchRepository {
    suspend fun getModels(makeId: Int): ProductResponse
    suspend fun getSpecifications(categoryId: Int, commandType: String): ProductChildResponse
}