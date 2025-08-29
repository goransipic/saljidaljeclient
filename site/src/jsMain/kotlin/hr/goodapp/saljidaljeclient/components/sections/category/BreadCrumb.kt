package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun BreadCrumb() {
    Nav(attrs = {
        classes("mb-3", "pt-md-2", "pt-lg-4")
        attr("aria-label", "Breadcrumb")
    }) {
        Ol(attrs = { classes("breadcrumb", "breadcrumb-light") }) {
            Li(attrs = { classes("breadcrumb-item") }) {
                A(href = "car-finder-home.html") { Text("Home") }
            }
            Li(attrs = {
                classes("breadcrumb-item", "active")
                attr("aria-current", "page")
            }) {
                Text("Used cars")
            }
        }
    }
}