package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.width
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.src
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.dom.*

@Composable
fun BrandsSection() {
    val brands = listOf(
        "opel" to "Opel",
        "audi" to "Audi",
        "mercedes" to "Mercedes-Benz",
        "toyota" to "Toyota",
        "mazda" to "Mazda",
        "nissan" to "Nissan",
        "hyundai" to "Hyundai",
        "lexus" to "Lexus",
        "honda" to "Honda",
        "renault" to "Renault",
        "infiniti" to "Infiniti",
        "mitsubishi" to "Mitsubishi"
    )

    Div(attrs = {
        classes("container", "py-2", "py-sm-3")
    }) {
        Div(attrs = {
            classes("row", "g-2", "g-sm-4")
        }) {
            brands.forEach { (fileName, altText) ->
                Div(attrs = {
                    classes("col-3", "col-sm-2", "col-xl-1", "mb-4", "pb-2")
                }) {
                    A(attrs = {
                        classes("opacity-40", "opacity-transition", "d-table", "mx-auto")
                        href("#")
                    }) {
                        Img(attrs = {
                            width(86)
                            alt(altText)
                        }, src = "img/car-finder/brands/$fileName.svg")
                    }
                }
            }
        }
    }
}