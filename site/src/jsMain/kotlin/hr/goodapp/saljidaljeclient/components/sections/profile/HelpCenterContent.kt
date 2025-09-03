package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.dom.*

@Composable
fun HelpCenterContent() {
    HeroSearch()
    FAQ()
    ContactUs()
}

@Composable
fun ContactUs() {
    Section(attrs = { classes("position-relative", "py-5") }) {
        // Overlay background
        Span(attrs = {
            classes("d-block", "position-absolute", "top-0", "left-0", "w-100", "h-100", "zindex-1")
            style {
                property(
                    "background",
                    "linear-gradient(26.21deg, rgba(93, 60, 242, 0.15) 0%, rgba(253, 86, 49, 0.15) 108.88%)"
                )
            }
        })

        // Overlay content
        Div(attrs = { classes("container", "position-relative", "zindex-5", "py-lg-5") }) {
            Div(attrs = { classes("col-lg-8", "col-md-10", "mx-auto", "px-0", "text-center") }) {
                H2(attrs = { classes("text-light") }) {
                    Text("Niste pronašli odgovor? Mi vam možemo pomoći.")
                }
                P(attrs = { classes("mb-4", "pb-3", "text-light", "opacity-70") }) {
                    Text("Kontaktirajte nas i javit ćemo vam se što je prije moguće.")
                }
                A(
                    href = "car-finder-contacts.html",
                    attrs = { classes("btn", "btn-lg", "btn-primary") }
                ) {
                    Text("Kontaktirajte nas")
                }
            }
        }
    }
}

@Composable
private fun FAQ() {
    Section(attrs = { classes("container", "mb-5", "pt-1", "pb-2", "py-lg-5") }) {
        Div(attrs = { classes("row", "justify-content-center") }) {
            Div(attrs = { classes("col-lg-8", "col-md-10") }) {
                H2(attrs = { classes("h3", "mb-4", "pb-3", "text-light", "text-center") }) {
                    Text("Često postavljana pitanja")
                }

                // Nav tabs
                Div(attrs = { classes("overflow-auto", "mx-n2") }) {
                    Ul(attrs = {
                        classes(
                            "nav",
                            "nav-tabs",
                            "nav-tabs-light",
                            "nav-fill",
                            "flex-nowrap",
                            "mb-md-4",
                            "mb-3",
                            "text-nowrap"
                        ); attr("role", "tablist")
                    }) {
                        listOf("Opća pitanja", "Kupnja ili najam automobila", "Prodaja automobila").forEachIndexed { index, title ->
                            Li(attrs = { classes("nav-item", "w-100", "px-2") }) {
                                A(
                                    href = "#",
                                    attrs = {
                                        classes(
                                            *listOfNotNull(
                                                "nav-link",
                                                if (index == 0) "active" else null
                                            ).toTypedArray()
                                        )
                                    }
                                ) { Text(title) }
                            }
                        }
                    }
                }

                // Accordion
                Div(attrs = { classes("pt-3") }) {
                    Div(attrs = { classes("accordion", "accordion-light"); attr("id", "accordionFAQ") }) {

                        val faqs = listOf(
                            "Koliko košta prodaja automobila na Finderu?" to "Odgovor na hrvatskom primjer teksta...",
                            "Kako napraviti najbolje fotografije svog automobila?" to "Odgovor na hrvatskom primjer teksta...",
                            "Mogu li prodati vozilo ako živim izvan SAD-a?" to "Odgovor na hrvatskom primjer teksta...",
                            "Kako kupac stupi u kontakt sa mnom i izvrši plaćanje?" to "Odgovor na hrvatskom primjer teksta...",
                            "Tko piše opis mog automobila?" to "Odgovor na hrvatskom primjer teksta...",
                            "Postoje li pravila za komentare?" to "Odgovor na hrvatskom primjer teksta...",
                            "Koju valutu koristi Finder?" to "Odgovor na hrvatskom primjer teksta..."
                        )

                        faqs.forEachIndexed { index, faq ->
                            val headingId = "heading-${index + 1}"
                            val collapseId = "collapse-${index + 1}"

                            Div(attrs = { classes("accordion-item") }) {
                                H2(attrs = { classes("accordion-header"); attr("id", headingId) }) {
                                    Button(
                                        attrs = {
                                            classes(
                                                *listOfNotNull(
                                                    "accordion-button",
                                                    if (index != 0) "collapsed" else null
                                                ).toTypedArray()
                                            )
                                            type(ButtonType.Button)
                                            attr("data-bs-toggle", "collapse")
                                            attr("data-bs-target", "#$collapseId")
                                            attr("aria-expanded", if (index == 0) "true" else "false")
                                            attr("aria-controls", collapseId)
                                        }
                                    ) { Text(faq.first) }
                                }
                                Div(
                                    attrs = {
                                        classes(
                                            *listOfNotNull(
                                                "accordion-collapse",
                                                "collapse",
                                                if (index == 0) "show" else null
                                            ).toTypedArray()
                                        )
                                        attr("aria-labelledby", headingId)
                                        attr("data-bs-parent", "#accordionFAQ")
                                        attr("id", collapseId)
                                    }
                                ) {
                                    Div(attrs = { classes("accordion-body", "fs-sm", "text-light", "opacity-70") }) {
                                        Text(faq.second)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HeroSearch() {
    Section(attrs = { classes("position-relative", "mb-5", "pt-5", "pb-lg-5") }) {
        // Overlay bg
        Span(attrs = {
            classes("d-block", "position-absolute", "top-0", "start-0", "w-100", "h-100", "zindex-1")
            style {
                background("linear-gradient(26.21deg, rgba(93, 60, 242, 0.15) 0%, rgba(253, 86, 49, 0.15) 108.88%)")
            }
        })

        // Overlay content
        Div(attrs = { classes("container", "position-relative", "zindex-5", "py-5") }) {

            // Breadcrumb
            Nav(attrs = { classes("mb-3", "pt-md-3"); attr("aria-label", "Breadcrumb") }) {
                Ol(attrs = { classes("breadcrumb", "breadcrumb-light") }) {
                    Li(attrs = { classes("breadcrumb-item") }) {
                        A(href = "car-finder-home.html") { Text("Početna") }
                    }
                    Li(attrs = { classes("breadcrumb-item", "active"); attr("aria-current", "page") }) {
                        Text("Centar za pomoć")
                    }
                }
            }

            Div(attrs = { classes("col-lg-8", "col-md-10", "mx-auto", "px-0", "pt-2") }) {
                H1(attrs = { classes("mb-4", "pb-2", "text-center", "text-light") }) {
                    Text("Bok, kako vam možemo pomoći?")
                }

                // Search form
                Form(attrs = { classes("form-group", "form-group-light", "mb-4") }) {
                    Input(type = InputType.Text, attrs = {
                        classes("form-control", "form-control-lg")
                        placeholder("Što tražite?")
                    })
                    Button(attrs = {
                        classes(
                            "btn",
                            "btn-lg",
                            "btn-primary",
                            "px-sm-4",
                            "px-3"
                        ); type(ButtonType.Submit)
                    }) {
                        I(attrs = { classes("fi-search", "me-sm-2") })
                        Span(attrs = { classes("d-sm-inline", "d-none") }) { Text("Traži") }
                    }
                }

                // Popular sections
                Div(attrs = {
                    classes(
                        "d-flex",
                        "flex-md-row",
                        "flex-column",
                        "align-items-md-center",
                        "justify-content-md-center"
                    )
                }) {
                    Div(attrs = {
                        classes(
                            "pb-3",
                            "mb-2",
                            "me-2",
                            "flex-shrink-0",
                            "fw-bold",
                            "text-light",
                            "opacity-70"
                        )
                    }) {
                        Text("Popularne sekcije:")
                    }
                    Div(attrs = { classes("text-nowrap", "overflow-auto", "pb-3") }) {
                        Div {
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Opći upiti") }
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Jamstva i više") }
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Pitanja o računu") }
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Plaćanje i dokumentacija") }
                        }
                    }
                }
            }
        }
    }
}