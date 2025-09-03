package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun SortingAndView() {
    Div(attrs = { classes("d-sm-flex", "align-items-center", "justify-content-between", "pb-4", "mb-2") }) {
        // Lijeva strana: sort opcija + usporedi
        Div(attrs = { classes("d-flex", "align-items-center", "me-sm-4") }) {
            Label(forId = "sorting1", attrs = {
                classes("fs-sm", "text-light", "me-2", "pe-1", "text-nowrap")
            }) {
                I(attrs = { classes("fi-arrows-sort", "mt-n1", "me-2") })
                Text("Sortiraj po:")
            }

            Select(attrs = {
                classes("form-select", "form-select-light", "form-select-sm", "me-sm-4")
                id("sorting1")
            }) {
                Option(value = "") { Text("Najnoviji") }
                Option(value = "") { Text("Popularni") }
                Option(value = "") { Text("Cijena: Niska → Visoka") }
                Option(value = "") { Text("Cijena: Visoka → Niska") }
            }

            Div(attrs = {
                classes("d-none", "d-md-block", "border-end", "border-light")
                style { property("height", "1.25rem") }
            })

            Div(attrs = {
                classes("d-none", "d-sm-block", "fw-bold", "text-light", "opacity-70", "text-nowrap", "ps-md-4")
            }) {
                I(attrs = { classes("fi-switch-horizontal", "me-2") })
                Span(attrs = { classes("align-middle") }) {
                    Text("Usporedi (0)")
                }
            }
        }

        // Desna strana: prikaz (lista/grid)
        Div(attrs = { classes("d-none", "d-sm-flex") }) {
            A(href = "car-finder-catalog-list.html", attrs = {
                classes("nav-link", "nav-link-light", "px-2", "active")
                attr("data-bs-toggle", "tooltip")
                attr("title", "Prikaz liste")
            }) {
                I(attrs = { classes("fi-list") })
            }
            A(href = "car-finder-catalog-grid.html", attrs = {
                classes("nav-link", "nav-link-light", "px-2")
                attr("data-bs-toggle", "tooltip")
                attr("title", "Prikaz mreže")
            }) {
                I(attrs = { classes("fi-grid") })
            }
        }
    }
}