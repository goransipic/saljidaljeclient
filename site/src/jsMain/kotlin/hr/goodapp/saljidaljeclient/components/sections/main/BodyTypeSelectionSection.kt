package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable

import org.jetbrains.compose.web.dom.*

@Composable
fun BodyTypeSelectionSection() {
    Section(attrs = { classes("container", "pb-5", "mb-md-4") }) {
        // Header row
        Div(attrs = { classes("d-sm-flex", "align-items-center", "justify-content-between", "mb-3", "mb-sm-4", "pb-sm-2") }) {
            H2(attrs = { classes("h3", "text-light", "mb-2", "mb-sm-0") }) { Text("Popular car body types") }
            A("car-finder-catalog-grid.html", attrs = { classes("btn", "btn-link", "btn-light", "fw-normal", "px-0") }) {
                Text("View all")
                I(attrs = { classes("fi-arrow-long-right", "fs-sm", "mt-0", "ps-1", "ms-2") })
            }
        }

        // Body type cards
        Div(attrs = { classes("row", "row-cols-2", "row-cols-sm-3", "row-cols-md-4", "row-cols-lg-5", "g-2", "g-md-4") }) {
            val bodyTypes = listOf(
                "Sedan" to "sedan.svg" to "car-finder-catalog-list.html",
                "SUV" to "suv.svg" to "car-finder-catalog-grid.html",
                "Wagon" to "wagon.svg" to "car-finder-catalog-list.html",
                "Crossover" to "crossover.svg" to "car-finder-catalog-grid.html",
                "Coupe" to "coupe.svg" to "car-finder-catalog-list.html",
                "Pickup" to "pickup.svg" to "car-finder-catalog-grid.html",
                "Sport Coupe" to "sport.svg" to "car-finder-catalog-list.html",
                "Compact" to "compact.svg" to "car-finder-catalog-grid.html",
                "Convertible" to "convertible.svg" to "car-finder-catalog-list.html",
                "Family MPV" to "mpv.svg" to "car-finder-catalog-grid.html"
            )

            bodyTypes.forEach { (nameToSrc, link) ->
                val (name, src) = nameToSrc
                Div(attrs = { classes("col") }) {
                    Div(attrs = { classes("card", "card-body", "card-light", "card-hover", "bg-transparent", "border-0", "px-0", "pt-0", "text-center") }) {
                        Img(
                            src = "img/car-finder/icons/$src",
                            alt = name,
                            attrs = { classes("d-block", "mx-auto", "mb-3"); attr("width", "160") }
                        )
                        A(link, attrs = { classes("nav-link-light", "stretched-link", "fw-bold") }) {
                            Text(name)
                        }
                    }
                }
            }
        }
    }
}