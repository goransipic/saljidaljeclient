package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun PageTitle() {
    Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-4", "mb-2") }) {
        H1(attrs = { classes("text-light", "me-3", "mb-0") }) {
            Text("Rabljeni automobili")
        }
        Div(attrs = { classes("text-light") }) {
            I(attrs = { classes("fi-car", "fs-lg", "me-2") })
            Span(attrs = { classes("align-middle") }) {
                Text("249 ponuda")
            }
        }
    }
}