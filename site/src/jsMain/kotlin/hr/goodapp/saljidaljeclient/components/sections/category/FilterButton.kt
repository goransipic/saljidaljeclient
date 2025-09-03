package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Text

@Composable
fun FilterButton() {
    Button(
        attrs = {
            classes("btn", "btn-primary", "btn-sm", "w-100", "rounded-0", "fixed-bottom", "d-lg-none")
            style { property("height", "48px") }
            attr("type", "button")
            attr("data-bs-toggle", "offcanvas")
            attr("data-bs-target", "#filters-sidebar")
        }
    ) {
        I(attrs = { classes("fi-filter", "me-2") })  // <i class="fi-filter me-2"></i>
        Text("Filtri")
    }
}