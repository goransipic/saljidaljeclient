package hr.goodapp.saljidaljeclient.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.DefaultStyleSheet.attr
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun CustomFooter() {
    Footer(
        attrs = {
            classes("footer", "bg-faded-light")
        }
    ) {
        // Top border section
        Div({ classes("border-bottom", "border-light", "py-4") }) {
            Div({ classes("container", "d-sm-flex", "align-items-center", "justify-content-between") }) {
                A(href = "real-estate-home-v1.html", attrs = { classes("d-inline-block") }) {
                    Img(src = "/img/logo/logo-light.svg", alt = "logo") {
                        attr("width", "116")
                    }
                }

                Div({ classes("d-flex", "pt-3", "pt-sm-0") }) {
                    // Language Dropdown
                    Div({ classes("dropdown", "ms-n3") }) {
                        Button(attrs = {
                            classes("btn", "btn-light", "btn-link", "btn-sm", "dropdown-toggle", "fw-normal", "py-2")
                            attr("type", "button")
                            attr("data-bs-toggle", "dropdown")
                        }) {
                            I(attrs = { classes("fi-globe", "me-2") })
                            Text("Eng")
                        }
                        Div({ classes("dropdown-menu", "dropdown-menu-dark", "w-100") }) {
                            A("#", { classes("dropdown-item") }) { Text("Deutsch") }
                            A("#", { classes("dropdown-item") }) { Text("Français") }
                            A("#", { classes("dropdown-item") }) { Text("Español") }
                        }
                    }

                    // Location Dropdown
                    Div({ classes("dropdown") }) {
                        Button(attrs = {
                            classes("btn", "btn-light", "btn-link", "btn-sm", "dropdown-toggle", "fw-normal", "py-2", "pe-2")
                            attr("type", "button")
                            attr("data-bs-toggle", "dropdown")
                        }) {
                            I(attrs = { classes("fi-map-pin", "me-2") })
                            Text("New York")
                        }
                        Div({ classes("dropdown-menu", "dropdown-menu-dark", "dropdown-menu-sm-end") }) {
                            attr("style", "min-width: 7.5rem;")
                            A("#", { classes("dropdown-item") }) { Text("Chicago") }
                            A("#", { classes("dropdown-item") }) { Text("Dallas") }
                            A("#", { classes("dropdown-item") }) { Text("Los Angeles") }
                            A("#", { classes("dropdown-item") }) { Text("San Diego") }
                        }
                    }
                }
            }
        }

        // Main content container
        Div({ classes("container", "pt-4", "pb-3", "pt-lg-5", "pb-lg-4") }) {
            Div({ classes("row", "pt-2", "pt-lg-0") }) {
                // Column 1
                Div({ classes("col-lg-3", "pb-2", "mb-4") }) {
                    H3({ classes("h5", "text-light", "mb-2") }) { Text("Subscribe to our newsletter") }
                    P({ classes("fs-sm", "text-light", "opacity-70") }) { Text("Don’t miss any relevant offers!") }
                    Form(attrs = { classes("form-group", "form-group-light", "w-100") }) {
                        Div({ classes("input-group", "input-group-sm") }) {
                            Span({ classes("input-group-text") }) {
                                I(attrs = { classes("fi-mail") })
                            }
                            Input(type = InputType.Text, attrs = {
                                classes("form-control")
                                attr("placeholder", "Your email")
                            })
                        }
                        Button(attrs = {
                            classes("btn", "btn-primary", "btn-icon", "btn-sm")
                            attr("type", "button")
                        }) {
                            I(attrs = { classes("fi-send") })
                        }
                    }
                }

                // Column 2
                Div({ classes("col-lg-2", "col-md-3", "col-sm-6", "offset-xl-1", "mb-2", "mb-sm-4") }) {
                    H3({ classes("fs-base", "text-light") }) { Text("Buying & Selling") }
                    Ul({ classes("list-unstyled", "fs-sm") }) {
                        listOf("Find a car", "Sell your car", "Car dealers", "Compare cars", "Online car appraisal").forEach {
                            Li { A("#", { classes("nav-link-light") }) { Text(it) } }
                        }
                    }
                }

                // Column 3
                Div({ classes("col-lg-2", "col-md-3", "col-sm-6", "mb-2", "mb-sm-4") }) {
                    H3({ classes("fs-base", "text-light") }) { Text("About") }
                    Ul({ classes("list-unstyled", "fs-sm") }) {
                        listOf("About Finder", "Contact us", "FAQs & support", "Mobile app", "Blog").forEach {
                            Li { A("#", { classes("nav-link-light") }) { Text(it) } }
                        }
                    }
                }

                // Column 4
                Div({ classes("col-lg-2", "col-md-3", "col-sm-6", "mb-2", "mb-sm-4") }) {
                    H3({ classes("fs-base", "text-light") }) { Text("Profile") }
                    Ul({ classes("list-unstyled", "fs-sm") }) {
                        listOf("My account", "Wishlist", "My listings", "Add listing").forEach {
                            Li { A("#", { classes("nav-link-light") }) { Text(it) } }
                        }
                    }
                }

                // Column 5
                Div({ classes("col-xl-2", "col-lg-3", "col-sm-6", "col-md-3", "mb-2", "mb-sm-4") }) {
                    A("tel:4065550120", { classes("d-flex", "align-items-center", "text-decoration-none", "mb-2") }) {
                        I(attrs = { classes("fi-device-mobile", "me-2") })
                        Span({ classes("text-light") }) { Text("(406) 555-0120") }
                    }
                    A("mailto:example@email.com", { classes("d-flex", "align-items-center", "text-decoration-none", "mb-2") }) {
                        I(attrs = { classes("fi-mail", "me-2") })
                        Span({ classes("text-light") }) { Text("example@email.com") }
                    }
                    Div({ classes("d-flex", "flex-wrap", "pt-4") }) {
                        listOf("fi-facebook", "fi-twitter", "fi-telegram", "fi-messenger").forEach { icon ->
                            A("#", { classes("btn", "btn-icon", "btn-translucent-light", "btn-xs", "rounded-circle", "mb-2", "me-2") }) {
                                I(attrs = { classes(icon) })
                            }
                        }
                    }
                }
            }
        }

        // Bottom legal + links
        Div({ classes("container", "d-lg-flex", "align-items-center", "justify-content-between", "fs-sm", "pb-3") }) {
            Div({ classes("d-flex", "flex-wrap", "justify-content-center", "order-lg-2", "mb-3") }) {
                listOf("Terms of use", "Privacy policy", "Accessibility statement", "Interest based ads").forEach {
                    A("#", { classes(
                        *listOfNotNull(
                            "nav-link",
                            "nav-link-light",
                            "fw-normal",
                            if (it == "Interest based ads") "pe-0" else null
                        ).toTypedArray()
                    ) }) { Text(it) }
                }
            }
            P({ classes("text-center", "text-lg-start", "order-lg-1", "mb-lg-0") }) {
                Span({ classes("text-light", "opacity-50") }) { Text("© All rights reserved. Made by ") }
                A("https://createx.studio/", {
                    classes("nav-link-light", "fw-bold")
                    attr("target", "_blank")
                    attr("rel", "noopener")
                }) { Text("Createx Studio") }
            }
        }
    }
}