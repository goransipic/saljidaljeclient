package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun SortingAndPagination() {
    Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "py-2") }) {
        // Sorting + Compare
        Div(attrs = { classes("d-flex", "align-items-center", "me-sm-4") }) {
            Label(forId = "sorting2", attrs = { classes("fs-sm", "text-light", "me-2", "pe-1", "text-nowrap") }) {
                I(attrs = { classes("fi-arrows-sort", "mt-n1", "me-2") }) {}
                Text("Sortiraj po:")
            }
            Select(attrs = { classes("form-select", "form-select-light", "form-select-sm", "me-2", "me-sm-4") }) {
                Option(value = "") { Text("Najnoviji") }
                Option(value = "") { Text("Popularni") }
                Option(value = "") { Text("Cijena: Niska → Visoka") }
                Option(value = "") { Text("Cijena: Visoka → Niska") }
            }
            Div(attrs = {
                classes("d-none", "d-md-block", "border-end", "border-light")
                style { property("height", "1.25rem") }
            }) {}
            Div(attrs = { classes("d-none", "d-md-block", "fw-bold", "text-light", "opacity-70", "text-nowrap", "ps-md-4") }) {
                I(attrs = { classes("fi-switch-horizontal", "me-2") }) {}
                Span(attrs = { classes("align-middle") }) { Text("Usporedi (0)") }
            }
        }

        // Pagination
        Nav(attrs = { attr("aria-label", "Pagination") }) {
            Ul(attrs = { classes("pagination", "pagination-light", "mb-0") }) {
                Li(attrs = { classes("page-item", "d-sm-none", "text-nowrap") }) {
                    Span(attrs = { classes("page-link", "page-link-static") }) { Text("1 / 5") }
                }
                Li(attrs = { classes("page-item", "active", "d-none", "d-sm-block"); attr("aria-current", "page") }) {
                    Span(attrs = { classes("page-link") }) {
                        Text("1")
                        Span(attrs = { classes("visually-hidden") }) { Text("(current)") }
                    }
                }
                Li(attrs = { classes("page-item", "d-none", "d-sm-block") }) { A(href = "#", attrs = { classes("page-link") }) { Text("2") } }
                Li(attrs = { classes("page-item", "d-none", "d-sm-block") }) { A(href = "#", attrs = { classes("page-link") }) { Text("3") } }
                Li(attrs = { classes("page-item", "d-none", "d-sm-block") }) { Text("...") }
                Li(attrs = { classes("page-item", "d-none", "d-sm-block") }) { A(href = "#", attrs = { classes("page-link") }) { Text("8") } }
                Li(attrs = { classes("page-item") }) {
                    A(href = "#", attrs = { classes("page-link"); attr("aria-label", "Sljedeća") }) {
                        I(attrs = { classes("fi-chevron-right") }) {}
                    }
                }
            }
        }
    }
}