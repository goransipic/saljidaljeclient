package hr.goodapp.saljidaljeclient.components.sections.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

enum class MarginButton(val margin: String = "") {
    MB_5("mb-5")
}

@Composable
fun BackToTop(marginButton: MarginButton? = null) {
    A(
        href = "#top",
        attrs = {
            classes(
                "btn-scroll-top",
                *listOfNotNull(if (marginButton == null) null else MarginButton.MB_5.margin).toTypedArray()
            )
            attr("data-scroll", "")
        }
    ) {
        Span(attrs = { classes("btn-scroll-top-tooltip", "text-muted", "fs-sm" ,"me-2") }) {
            Text("Top")
        }
        I(attrs = { classes("btn-scroll-top-icon", "fi-chevron-up") })
    }
}