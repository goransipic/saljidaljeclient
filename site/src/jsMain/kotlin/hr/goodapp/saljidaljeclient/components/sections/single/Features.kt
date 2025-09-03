package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun Features() {
    // Features heading
    H2(attrs = { classes("h4", "text-light", "pt-3", "mb-4") }) {
        Text("Značajke")
    }

    Div(attrs = { classes("accordion", "accordion-light"); attr("id", "features") }) {

        // Exterior
        AccordionItem("exterior", "Vanjski dio") {
            Ul {
                listOf(
                    "Alu naplatci",
                    "Krov / Sunroof",
                    "Tonirana stakla",
                    "LED prednja svjetla",
                    "Sklopivi krov",
                    "Kuka za vuču"
                ).forEach { Li { Text(it) } }
            }
        }

        // Interior
        AccordionItem("interior", "Unutrašnjost", expanded = true) {
            Div(attrs = { classes("row") }) {
                val interiorCols = listOf(
                    listOf(
                        "Podesivi volan",
                        "Retrovizor s automatskim zatamnjivanjem",
                        "Podesiva lumbalna potpora vozača",
                        "Osvijetljeno ogledalo vozača",
                        "Universalni otvarač garažnih vrata",
                        "Kontrole audio sustava na volanu"
                    ),
                    listOf(
                        "Grijana prednja sjedala",
                        "Kožna sjedala",
                        "Kožni volan",
                        "Sjedalo s prolazom straga",
                        "Podesiva lumbalna potpora suvozača",
                        "Osvijetljeno ogledalo suvozača"
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
        AccordionItem("safety", "Sigurnost") {
            Div(attrs = { classes("row") }) {
                val safetyCols = listOf(
                    listOf(
                        "Zračni jastuk: Vozač",
                        "Zračni jastuk: Suvozač",
                        "Adaptivni tempomat",
                        "Monitor mrtvog kuta",
                        "Alarm",
                        "ABS kočnice"
                    ),
                    listOf(
                        "Pomoć pri kočenju",
                        "Upozorenje za napuštanje trake",
                        "Kontrola stabilnosti",
                        "Maglenke",
                        "Električno zaključavanje vrata"
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
        AccordionItem("technology", "Tehnologija") {
            Div(attrs = { classes("row") }) {
                val techCols = listOf(
                    listOf(
                        "Višezonska klima",
                        "Klima kontrola",
                        "Navigacijski sustav",
                        "Daljinsko paljenje",
                        "Bluetooth",
                        "Daljinsko paljenje"
                    ),
                    listOf(
                        "Apple CarPlay",
                        "Android Auto",
                        "Kamera za vožnju unatrag",
                        "HomeLink",
                        "Pokretanje bez ključa",
                        "Premium audio sustav"
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
            ) {
                Text(header)
            }
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