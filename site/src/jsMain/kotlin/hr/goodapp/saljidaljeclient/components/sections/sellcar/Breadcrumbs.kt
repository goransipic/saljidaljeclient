package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ol
import org.jetbrains.compose.web.dom.Text

@Composable
fun Breadcrumbs() {
    Nav(attrs = {
        classes("mb-3", "pt-md-3")
        attr("aria-label", "Breadcrumb")
    }) {
        Ol(attrs = { classes("breadcrumb", "breadcrumb-light") }) {
            Li(attrs = { classes("breadcrumb-item") }) {
                A(href = "car-finder-home.html") {
                    Text("Home")
                }
            }
            Li(attrs = {
                classes("breadcrumb-item", "active")
                attr("aria-current", "page")
            }) {
                Text("Sell car")
            }
        }
    }
}