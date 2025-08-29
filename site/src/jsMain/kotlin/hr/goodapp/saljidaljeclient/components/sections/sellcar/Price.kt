package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.min
import org.jetbrains.compose.web.attributes.step
import org.jetbrains.compose.web.dom.*

@Composable
fun Price() {
    Section(attrs = {
        classes("card", "card-light", "card-body", "border-0", "shadow-sm", "p-4", "mb-4")
        id("price")
    }) {
        // Heading
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-cash", "text-primary", "fs-5", "mt-n1", "me-2") })
            Text("Price")
        }

        // Label
        Label(forId = "sc-price", attrs = { classes("form-label", "text-light") }) {
            Text("Price ")
            Span(attrs = { classes("text-danger") }) { Text("*") }
        }

        // Currency + Price input
        Div(attrs = { classes("d-sm-flex", "mb-2") }) {
            Select(attrs = { classes("form-select", "form-select-light", "w-25", "me-2", "mb-2") }) {
                Option(value = "usd") { Text("$") }  // $
                Option(value = "eur") { Text("€") } // €
                Option(value = "gbp") { Text("£") }  // £
                Option(value = "jpy") { Text("¥") }  // ¥
            }

            Input(type = InputType.Number, attrs = {
                classes("form-control", "form-control-light", "w-100", "me-2", "mb-2")
                id("sc-price")
                min("200")
                step(50)
                value("31900")
                attr("required", "true")
            })
        }

        // Negotiated price toggle
        Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
            Input(type = InputType.Checkbox, attrs = {
                classes("form-check-input")
                id("negotiated-price")
            })
            Label(forId = "negotiated-price", attrs = { classes("form-check-label") }) {
                Text("Negotiated price")
            }
        }
    }
}