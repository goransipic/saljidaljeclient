package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun TitleAndSharing() {
    Div(attrs = {
        classes(
            "d-sm-flex",
            "align-items-end",
            "align-items-md-center",
            "justify-content-between",
            "position-relative",
            "mb-4"
        )
        style { property("z-index", "1025") }
    }) {
        // Left section (title + details)
        Div(attrs = { classes("me-3") }) {
            H1(attrs = { classes("h2", "text-light", "mb-md-0") }) {
                Text("Mercedes-Benz E 400 Kabriolet")
            }

            // Mobile details
            Div(attrs = { classes("d-md-none") }) {
                // Price + badges
                Div(attrs = { classes("d-flex", "align-items-center", "mb-3") }) {
                    Div(attrs = { classes("h3", "mb-0", "text-light") }) { Text("$31,900") }
                    Div(attrs = { classes("text-nowrap", "ps-3") }) {
                        Span(attrs = { classes("badge", "bg-info", "fs-base", "me-2") }) { Text("Rabljeno") }
                        Span(attrs = {
                            classes("badge", "bg-success", "fs-base", "me-2")
                            attr("data-bs-toggle", "popover")
                            attr("data-bs-placement", "bottom")
                            attr("data-bs-trigger", "hover")
                            attr("data-bs-html", "true")
                            attr(
                                "data-bs-content",
                                """<div class="d-flex"><i class="fi-award mt-1 me-2"></i><div>Ovaj automobil je provjeren i<br>certificiran od strane Findera.</div></div>"""
                            )
                        }) {
                            Text("Certificirano")
                        }
                    }
                }

                // Mileage + location
                Div(attrs = { classes("d-flex", "flex-wrap", "align-items-center", "text-light", "mb-2") }) {
                    Div(attrs = { classes("text-nowrap", "border-end", "border-light", "pe-3", "me-3") }) {
                        I(attrs = { classes("fi-dashboard", "fs-lg", "opacity-70", "me-2") })
                        Span(attrs = { classes("align-middle") }) { Text("25K milja") }
                    }
                    Div(attrs = { classes("text-nowrap") }) {
                        I(attrs = { classes("fi-map-pin", "fs-lg", "opacity-70", "me-2") })
                        Span(attrs = { classes("align-middle") }) { Text("Chicago, IL 60603") }
                    }
                }
            }
        }

        // Right section (wishlist + share)
        Div(attrs = { classes("text-nowrap", "pt-3", "pt-sm-0") }) {
            Button(attrs = {
                classes("btn", "btn-icon", "btn-translucent-light", "btn-xs", "rounded-circle", "mb-sm-2")
                attr("type", "button")
                attr("data-bs-toggle", "tooltip")
                attr("title", "Dodaj u listu želja")
            }) {
                I(attrs = { classes("fi-heart") })
            }

            Div(attrs = {
                classes("dropdown", "d-inline-block")
                attr("data-bs-toggle", "tooltip")
                attr("title", "Podijeli")
            }) {
                Button(attrs = {
                    classes("btn", "btn-icon", "btn-translucent-light", "btn-xs", "rounded-circle", "ms-2", "mb-sm-2")
                    attr("type", "button")
                    attr("data-bs-toggle", "dropdown")
                }) {
                    I(attrs = { classes("fi-share") })
                }
                Div(attrs = { classes("dropdown-menu", "dropdown-menu-dark", "dropdown-menu-end", "my-1") }) {
                    Button(attrs = { classes("dropdown-item"); attr("type", "button") }) {
                        I(attrs = { classes("fi-facebook", "fs-base", "opacity-75", "me-2") })
                        Text("Facebook")
                    }
                    Button(attrs = { classes("dropdown-item"); attr("type", "button") }) {
                        I(attrs = { classes("fi-twitter", "fs-base", "opacity-75", "me-2") })
                        Text("Twitter")
                    }
                    Button(attrs = { classes("dropdown-item"); attr("type", "button") }) {
                        I(attrs = { classes("fi-instagram", "fs-base", "opacity-75", "me-2") })
                        Text("Instagram")
                    }
                }
            }
        }
    }
}