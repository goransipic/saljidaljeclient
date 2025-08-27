package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun BackToTop() {
    A(
        href = "#top",
        attrs = {
            classes("btn-scroll-top")
            attr("data-scroll", "")
        }
    ) {
        Span(attrs = { classes("btn-scroll-top-tooltip", "text-muted", "fs-sm" ,"me-2") }) {
            Text("Top")
        }
        I(attrs = { classes("btn-scroll-top-icon", "fi-chevron-up") })
    }
}