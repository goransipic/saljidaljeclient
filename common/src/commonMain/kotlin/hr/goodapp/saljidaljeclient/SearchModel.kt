package hr.goodapp.saljidaljeclient

import kotlinx.serialization.Serializable

@Serializable
data class Option(
    val name: String,
    val seoName: String? = null,
    val id: Int
)

@Serializable
data class DropdownProps(
    val name: String,
    val icon: String,
    val options: List<Option>
)

@Serializable
data class ProductResponse(
    val productsCount: Int? = null,
    val properties: List<ProductProperty>
)

@Serializable
data class ProductProperty(
    val text: String,
    val value: String,
    val seoName: String
)

@Serializable
data class ProductChildResponse(
    val productsCount: Int? = null,
    val properties: List<ProductChildProperty>
)

@Serializable
data class ProductChildProperty(
    val id: Int,
    val name: String
)