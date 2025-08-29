package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun Location() {
    Section(attrs = {
        classes("card", "card-light", "card-body", "border-0", "shadow-sm", "p-4", "mb-4"); attr(
        "id",
        "location"
    )
    }) {
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-map-pin", "text-primary", "fs-5", "mt-n1", "me-2") }) {}
            Text("Location")
        }

        // Country / State
        Div(attrs = { classes("row") }) {
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for", "sc-country") }) {
                    Text("Country / region *")
                }
                Select(attrs = {
                    classes("form-select", "form-select-light"); attr("id", "sc-country"); attr(
                    "required",
                    "true"
                )
                }) {
                    Option(value = "", attrs = { attr("disabled", "true") }) { Text("Choose country") }
                    listOf("Australia", "Belgium", "Canada", "Germany", "United States").forEach { country ->
                        Option(
                            value = country,
                            attrs = { if (country == "United States") attr("selected", "true") }) { Text(country) }
                    }
                }
            }
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for", "sc-state") }) {
                    Text("State *")
                }
                Select(attrs = {
                    classes("form-select", "form-select-light"); attr("id", "sc-state"); attr(
                    "required",
                    "true"
                )
                }) {
                    Option(value = "", attrs = { attr("disabled", "true") }) { Text("Choose state") }
                    listOf(
                        "Alabama",
                        "California",
                        "Florida",
                        "Georgia",
                        "Illinois",
                        "Indiana",
                        "Kansas"
                    ).forEach { state ->
                        Option(value = state, attrs = { if (state == "Illinois") attr("selected", "true") }) {
                            Text(
                                state
                            )
                        }
                    }
                }
            }
        }

        // City / Zip
        Div(attrs = { classes("row") }) {
            Div(attrs = { classes("col-sm-8", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for", "sc-city") }) {
                    Text("City *")
                }
                Select(attrs = {
                    classes("form-select", "form-select-light"); attr("id", "sc-city"); attr(
                    "required",
                    "true"
                )
                }) {
                    Option(value = "", attrs = { attr("disabled", "true") }) { Text("Choose city") }
                    listOf("Chicago", "Dallas", "Los Angeles", "New York", "San Diego").forEach { city ->
                        Option(value = city, attrs = { if (city == "Chicago") attr("selected", "true") }) { Text(city) }
                    }
                }
            }
            Div(attrs = { classes("col-sm-4", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for", "sc-zip") }) {
                    Text("Zip code *")
                }
                Input(
                    type = InputType.Text,
                    attrs = {
                        classes("form-control", "form-control-light"); attr("id", "sc-zip"); attr(
                        "placeholder",
                        "Enter Zip code"
                    ); attr("value", "60603"); attr("required", "true")
                    })
            }
        }

        // Street address
        Div(attrs = { classes("mb-3") }) {
            Label(attrs = { classes("form-label", "text-light"); attr("for", "ap-address") }) {
                Text("Street address *")
            }
            Input(
                type = InputType.Text,
                attrs = {
                    classes("form-control", "form-control-light"); attr("id", "ap-address"); attr(
                    "value",
                    "1904 S Michigan Avenue"
                ); attr("required", "true")
                })
        }

        // Map
        Div(attrs = { classes("form-label", "text-light", "fw-bold", "pt-3", "pb-2") }) { Text("Display on the map") }
        Div(attrs = { classes("interactive-map", "rounded-3"); attr("style", "height: 250px") }) {
            // You can integrate a Compose map library here (e.g., Google Maps or Mapbox)
        }
    }
}