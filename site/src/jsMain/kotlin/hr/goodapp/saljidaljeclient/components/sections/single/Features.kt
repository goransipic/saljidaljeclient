package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun Features() {
    // Features heading
    H2(attrs = { classes("h4", "text-light", "pt-3", "mb-4") }) {
        Text("Features")
    }

    Div(attrs = { classes("accordion", "accordion-light") ; attr("id", "features") }) {

        // Exterior
        AccordionItem("exterior", "Exterior") {
            Ul {
                listOf(
                    "Alloy Wheels",
                    "Sunroof / Moonroof",
                    "Tinged glass",
                    "LED Headlights",
                    "Foldable Roof",
                    "Tow Hitch"
                ).forEach { Li { Text(it) } }
            }
        }

        // Interior
        AccordionItem("interior", "Interior", expanded = true) {
            Div(attrs = { classes("row") }) {
                val interiorCols = listOf(
                    listOf(
                        "Adjustable Steering Wheel",
                        "Auto-Dimming Rearview Mirror",
                        "Driver Adjustable Lumbar",
                        "Driver Illuminated Vanity Mirror",
                        "Universal Garage Door Opener",
                        "Steering Wheel Audio Controls"
                    ),
                    listOf(
                        "Heated Front Seats",
                        "Leather Seats",
                        "Leather Steering Wheel",
                        "Pass-Through Rear Seat",
                        "Passenger Adjustable Lumbar",
                        "Passenger Illuminated Visor Mirror"
                    )
                )
                interiorCols.forEach { colItems ->
                    Div(attrs = { classes("col-sm-6") }) {
                        Ul {
                            colItems.forEach { Li { Text(it) } }
                        }
                    }
                }
            }
        }

        // Safety
        AccordionItem("safety", "Safety") {
            Div(attrs = { classes("row") }) {
                val safetyCols = listOf(
                    listOf(
                        "Airbag: Driver",
                        "Airbag: Passenger",
                        "Adaptive Cruise Control",
                        "Blind Spot Monitor",
                        "Alarm",
                        "Antilock Brakes"
                    ),
                    listOf(
                        "Brake Assist",
                        "Lane Departure Warning",
                        "Stability Control",
                        "Fog Lights",
                        "Power Door Locks"
                    )
                )
                safetyCols.forEach { colItems ->
                    Div(attrs = { classes("col-sm-6") }) {
                        Ul {
                            colItems.forEach { Li { Text(it) } }
                        }
                    }
                }
            }
        }

        // Technology
        AccordionItem("technology", "Technology") {
            Div(attrs = { classes("row") }) {
                val techCols = listOf(
                    listOf(
                        "Multi-Zone A/C",
                        "Climate Control",
                        "Navigation System",
                        "Remote Start",
                        "Bluetooth",
                        "Remote Start"
                    ),
                    listOf(
                        "Apple CarPlay",
                        "Android Auto",
                        "Backup Camera",
                        "HomeLink",
                        "Keyless Start",
                        "Premium Sound System"
                    )
                )
                techCols.forEach { colItems ->
                    Div(attrs = { classes("col-sm-6") }) {
                        Ul {
                            colItems.forEach { Li { Text(it) } }
                        }
                    }
                }
            }
        }
    }
}

// Accordion item helper
@Composable
fun AccordionItem(
    id: String,
    header: String,
    expanded: Boolean = false,
    content: @Composable () -> Unit
) {
    Div(attrs = { classes("accordion-item") }) {
        H2(attrs = { classes("accordion-header"); attr("id", "heading$id") }) {
            Button(
                attrs = {
                    classes("accordion-button")
                    if (!expanded) classes("collapsed")
                    attr("type", "button")
                    attr("data-bs-toggle", "collapse")
                    attr("data-bs-target", "#$id")
                    attr("aria-expanded", expanded.toString())
                    attr("aria-controls", id)
                }
            ) { Text(header) }
        }
        Div(
            attrs = {
                classes("accordion-collapse", "collapse")
                if (expanded) classes("show")
                attr("id", id)
                attr("aria-labelledby", "heading$id")
                attr("data-bs-parent", "#features")
            }
        ) {
            Div(attrs = { classes("accordion-body", "fs-sm", "text-light", "opacity-70") }) {
                content()
            }
        }
    }
}