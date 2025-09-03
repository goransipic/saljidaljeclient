package hr.goodapp.saljidaljeclient.components.sections.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun Breadcrumb(title: String) {
    Nav(
        attrs = {
            classes("mb-4", "pt-md-3")
            attr("aria-label", "Breadcrumb")
        }
    ) {
        Ol(attrs = { classes("breadcrumb", "breadcrumb-light") }) {
            Li(attrs = { classes("breadcrumb-item") }) {
                A(href = "car-finder-home.html") {
                    Text("Početna")
                }
            }
            Li(attrs = { classes("breadcrumb-item") }) {
                A(href = "car-finder-account-info.html") {
                    Text("Račun")
                }
            }
            Li(
                attrs = {
                    classes("breadcrumb-item", "active")
                    attr("aria-current", "page")
                }
            ) {
                Text(title)
            }
        }
    }
}