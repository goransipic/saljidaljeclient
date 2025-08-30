package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun BreadCrumb() {
    Nav(attrs = {
        classes("mb-3", "pt-md-3")
        attr("aria-label", "Breadcrumb")
    }) {
        Ol(attrs = { classes("breadcrumb", "breadcrumb-light") }) {
            Li(attrs = { classes("breadcrumb-item") }) {
                A(href = "car-finder-home.html") { Text("Home") }
            }
            Li(attrs = { classes("breadcrumb-item") }) {
                A(href = "car-finder-catalog-grid.html") { Text("Used cars") }
            }
            Li(attrs = {
                classes("breadcrumb-item", "active")
                attr("aria-current", "page")
            }) {
                Text("Mercedes-Benz E 400 Cabriolet")
            }
        }
    }
}