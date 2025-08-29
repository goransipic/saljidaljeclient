package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.style.KobwebComposeStyleSheet.attr
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.*

@Composable
fun BasicInfo() {
    Section(attrs = {
        classes("card", "card-light", "card-body", "border-0", "shadow-sm", "p-4", "mb-4")
        id("basic-info")
    }) {
        // Heading
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-info-circle", "text-primary", "fs-5", "mt-n1", "me-2") })
            Text("Basic info")
        }

        // Title field
        Div(attrs = { classes("mb-3") }) {
            Label(forId = "sc-title", attrs = { classes("form-label", "text-light") }) {
                Text("Title ")
                Span(attrs = { classes("text-danger") }) { Text("*") }
            }
            Input(type = InputType.Text, attrs = {
                classes("form-control", "form-control-light")
                id("sc-title")
                placeholder("Title for your property")
                value("Mercedes-Benz E 400 Cabriolet")
                attr("required", "true")
            })
            Span(attrs = { classes("form-text", "text-light", "opacity-50") }) {
                Text("48 characters left")
            }
        }

        // Vehicle condition
        Div(attrs = { classes("row") }) {
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(forId = "sc-condition", attrs = { classes("form-label", "text-light") }) {
                    Text("Vehicle condition ")
                    Span(attrs = { classes("text-danger") }) { Text("*") }
                }
                Select(attrs = {
                    classes("form-select", "form-select-light")
                    id("sc-condition")
                    attr("required", "true")
                }) {
                    Option(value = "") {
                        attr("disabled", "true")
                        attr("hidden", "true")
                        Text("Choose condition")
                    }
                    Option(value = "Used") { Text("Used") }
                    Option(value = "New") { Text("New") }
                }
            }
        }

        // Seller type
        Div(attrs = { classes("form-label", "text-light", "fw-bold", "pt-3", "pb-2") }) {
            Text("Are you listing on Finder as part of a company?")
        }

        // Radio: Dealer
        Div(attrs = { classes("form-check", "form-check-light") }) {
            Input(type = InputType.Radio, attrs = {
                classes("form-check-input")
                id("sc-dealer")
                name("sc-seller-type")
            })
            Label(forId = "sc-dealer", attrs = { classes("form-check-label") }) {
                Text("I am a registered dealer")
            }
        }

        // Radio: Individual
        Div(attrs = { classes("form-check", "form-check-light") }) {
            Input(type = InputType.Radio, attrs = {
                classes("form-check-input")
                id("sc-individual")
                name("sc-seller-type")
                attr("checked", "true")
            })
            Label(forId = "sc-individual", attrs = { classes("form-check-label") }) {
                Text("I am a private seller")
            }
        }
    }
}