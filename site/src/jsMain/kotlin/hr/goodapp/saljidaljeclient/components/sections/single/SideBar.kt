package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.width
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*

@Composable
fun SideBar() {
    Div(attrs = { classes("sticky-top", "pt-5") }) {
        // Header badges + price
        Div(attrs = { classes("d-none", "d-md-block", "pt-5") }) {
            Div(attrs = { classes("d-flex", "mb-4") }) {
                Span(attrs = { classes("badge", "bg-info", "fs-base", "me-2") }) { Text("Rabljeno") }
                Span(attrs = {
                    classes("badge", "bg-success", "fs-base", "me-2")
                    attr("data-bs-toggle", "popover")
                    attr("data-bs-placement", "top")
                    attr("data-bs-trigger", "hover")
                    attr("data-bs-html", "true")
                    attr(
                        "data-bs-content",
                        """<div class="d-flex"><i class="fi-award mt-1 me-2"></i><div>Ovaj automobil je provjeren i<br>certificiran od strane Findera.</div></div>"""
                    )
                }) { Text("Certificirano") }
            }
            Div(attrs = { classes("h3", "text-light") }) { Text("$31,900") }

            Div(attrs = { classes("d-flex", "align-items-center", "text-light", "pb-4", "mb-2") }) {
                Div(attrs = { classes("text-nowrap", "border-end", "border-light", "pe-3", "me-3") }) {
                    I(attrs = { classes("fi-dashboard", "fs-lg", "opacity-70", "me-2") }) {}
                    Span(attrs = { classes("align-middle") }) { Text("25K milja") }
                }
                Div(attrs = { classes("text-nowrap") }) {
                    I(attrs = { classes("fi-map-pin", "fs-lg", "opacity-70", "me-2") }) {}
                    Span(attrs = { classes("align-middle") }) { Text("Chicago, IL 60603") }
                }
            }
        }

        // Seller card
        Div(attrs = { classes("card", "card-light", "card-body", "mb-4") }) {
            Div(attrs = { classes("text-light", "mb-2") }) { Text("Privatni prodavatelj") }

            A(attrs = { classes("d-flex", "align-items-center", "text-decoration-none", "mb-3"); href("car-finder-vendor.html") }) {
                Img(src = "img/avatars/33.jpg", attrs = { classes("rounded-circle"); width(48); alt("Devon Lane") })
                Div(attrs = { classes("ps-2") }) {
                    H5(attrs = { classes("text-light", "mb-0") }) { Text("Devon Lane") }
                    Span(attrs = { classes("star-rating") }) {
                        repeat(5) { i ->
                            I(attrs = { classes("star-rating-icon", "fi-star-filled", "active") }) {}
                        }
                    }
                    Span(attrs = { classes("fs-sm", "text-light", "opacity-70", "align-middle", "ms-1") }) { Text("(5 recenzija)") }
                }
            }

            A(attrs = { classes("text-light"); href("car-finder-vendor.html") }) { Text("Ostali oglasi ovog prodavatelja") }

            // Call / message buttons
            Div(attrs = { classes("pt-4", "mt-2") }) {
                Button(attrs = { classes("btn", "btn-outline-light", "btn-lg", "px-4", "mb-3"); type(ButtonType.Button) }) {
                    I(attrs = { classes("fi-phone", "me-2") }) {}
                    Text("(316) *** **** – pokaži")
                }
                Br {}
                A(attrs = { classes("btn", "btn-primary", "btn-lg"); href("#send-mail"); attr("data-bs-toggle", "collapse") }) {
                    I(attrs = { classes("fi-chat-left", "me-2") }) {}
                    Text("Pošalji poruku")
                }

                // Collapsible message form
                Div(attrs = { classes("collapse"); id("send-mail") }) {
                    Form(attrs = { classes("needs-validation", "pt-4"); attr("novalidate", "true") }) {
                        Div(attrs = { classes("mb-3") }) {
                            TextArea(attrs = {
                                classes("form-control", "form-control-light")
                                rows(5)
                                placeholder("Napišite svoju poruku")
                                required()
                            })
                            Div(attrs = { classes("invalid-feedback") }) { Text("Molimo unesite svoju poruku.") }
                        }
                        Button(attrs = { classes("btn", "btn-outline-primary"); type(ButtonType.Submit) }) { Text("Pošalji") }
                    }
                }
            }
        }

        // Subscription card
        Div(attrs = { classes("card", "card-body", "bg-transparent", "border-light") }) {
            H5(attrs = { classes("text-light") }) {
                Text("Pošaljite mi obavijesti o sniženjima cijena i novim oglasima za ove rezultate pretrage:")
            }

            Form(attrs = { classes("form-group", "form-group-light", "mb-3") }) {
                Div(attrs = { classes("input-group") }) {
                    Span(attrs = { classes("input-group-text") }) { I(attrs = { classes("fi-mail") }) {} }
                    Input(type = InputType.Email,attrs = {
                        classes("form-control")
                        type(InputType.Email)
                        placeholder("Vaša email adresa")
                        required()
                    })
                }
                Button(attrs = { classes("btn", "btn-primary"); type(ButtonType.Submit) }) { Text("Pretplati se") }
            }

            Div(attrs = { classes("form-check", "form-check-light") }) {
                Input(type = InputType.Checkbox,attrs = { classes("form-check-input"); id("subscription-agree") })
                Label(attrs = { classes("form-check-label", "fs-sm", "opacity-70");}, forId = "subscription-agree") {
                    Text("Slažem se primati obavijesti o sniženjima cijena ovog vozila i korisne informacije o kupnji.")
                }
            }
        }
    }
}