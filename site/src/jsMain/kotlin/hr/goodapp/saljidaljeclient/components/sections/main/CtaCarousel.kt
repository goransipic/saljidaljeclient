package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.width
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.dom.*

@Composable
fun CtaCarousel() {
    Section(attrs = { classes("container", "pt-4", "pb-5", "py-sm-5") }) {
        Div(attrs = { classes("tns-carousel-wrapper") }) {
            Div(
                attrs = {
                    classes("tns-carousel-inner", "d-block", "d-md-flex")
                    attr(
                        "data-carousel-options",
                        """{"controlsContainer": "#external-controls", "nav": false, "gutter": 20, "autoHeight": true}"""
                    )
                }
            ) {
                // Slide 1
                Div {
                    Div(attrs = { classes("card", "card-body", "p-sm-5", "card-light", "h-100") }) {
                        Div(attrs = { classes("row", "align-items-center", "py-3", "py-sm-0") }) {
                            Div(attrs = {
                                classes(
                                    "col-md-4",
                                    "col-xl-3",
                                    "mb-4",
                                    "pb-3",
                                    "mb-md-0",
                                    "pb-md-0",
                                    "text-center",
                                    "text-md-start"
                                )
                            }) {
                                H2(attrs = { classes("text-light") }) { Text("Auto Market") }
                                P(attrs = { classes("fs-lg", "text-light", "opacity-70", "pb-md-4") }) {
                                    Text("Odaberi najbolje za svoj automobil!")
                                }
                                A(href = "car-finder-catalog-grid.html", attrs = { classes("btn", "btn-primary") }) {
                                    Text("Idi u trgovinu")
                                    I(attrs = { classes("fi-chevron-right", "fs-sm", "ms-2") }) {}
                                }
                            }
                            Div(attrs = { classes("col-md-8", "col-xl-9") }) {
                                Div(attrs = {
                                    classes(
                                        "row",
                                        "row-cols-2",
                                        "row-cols-lg-4",
                                        "gy-4",
                                        "gx-3",
                                        "gx-sm-4"
                                    )
                                }) {
                                    listOf(
                                        "Navlake za sjedala" to "01.png",
                                        "Gume" to "02.png",
                                        "Felge" to "03.png",
                                        "Dječja sjedala" to "04.png"
                                    ).forEach { (label, img) ->
                                        A(
                                            href = "#",
                                            attrs = { classes("col", "text-light", "text-decoration-none") }) {
                                            Img(src = "img/car-finder/categories/$img", attrs = {
                                                classes("d-block", "mb-2", "mx-auto")
                                                width(168)
                                            }, alt = label)
                                            Div(attrs = { classes("fw-bold", "text-center", "pt-1") }) { Text(label) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Slide 2
                Div {
                    Div(attrs = { classes("card", "card-body", "p-sm-5", "card-light", "h-100") }) {
                        Div(attrs = { classes("row", "align-items-center", "py-3", "py-sm-0") }) {
                            Div(attrs = {
                                classes(
                                    "col-md-6",
                                    "mb-4",
                                    "pb-3",
                                    "mb-md-0",
                                    "pb-md-0",
                                    "text-center",
                                    "text-md-start"
                                )
                            }) {
                                H2(attrs = { classes("text-light") }) { Text("Prodaja auta u 24h") }
                                P(attrs = { classes("fs-lg", "text-light", "opacity-70", "pb-md-4") }) {
                                    Text("Izračunaj vrijednost svog auta i odaberi kako želiš prodati.")
                                }
                                A(href = "car-finder-sell-car.html", attrs = { classes("btn", "btn-primary") }) {
                                    Text("Prodaj moj auto")
                                    I(attrs = { classes("fi-chevron-right", "fs-sm", "ms-2") }) {}
                                }
                            }
                            Div(attrs = { classes("col-md-6") }) {
                                Div(attrs = {
                                    classes(
                                        "row",
                                        "row-cols-sm-3",
                                        "row-cols-md-2",
                                        "row-cols-lg-3",
                                        "gy-4",
                                        "gx-3",
                                        "gx-sm-4"
                                    )
                                }) {
                                    listOf(
                                        "Provjereni kupci" to "buyers.svg",
                                        "Pametni alati" to "tools.svg",
                                        "Ponuda koju zaslužuješ" to "handshake.svg"
                                    ).forEach { (label, img) ->
                                        Div(attrs = { classes("col") }) {
                                            Div(attrs = {
                                                classes(
                                                    "d-table",
                                                    "bg-dark",
                                                    "rounded-3",
                                                    "p-4",
                                                    "mx-auto",
                                                    "mb-3"
                                                )
                                            }) {
                                                Img(
                                                    src = "img/car-finder/icons/$img",
                                                    attrs = { classes("d-block", "m-sm-2"); width(56); },
                                                    alt = label
                                                )
                                            }
                                            Div(attrs = { classes("fw-bold", "text-center") }) { Text(label) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // External carousel controls
        Div(attrs = {
            classes("tns-carousel-controls", "tns-carousel-light", "pt-4", "pb-2"); id("external-controls")
        }) {
            Button(attrs = {
                classes("me-3"); type(ButtonType.Button)
            }) { I(attrs = { classes("fi-chevron-left") }) {} }
            Button(attrs = { type(ButtonType.Button) }) { I(attrs = { classes("fi-chevron-right") }) {} }
        }
    }
}