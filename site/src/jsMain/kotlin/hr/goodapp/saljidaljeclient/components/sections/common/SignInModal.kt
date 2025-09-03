package hr.goodapp.saljidaljeclient.components.sections.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun SignInModal() {
    Div({ classes("modal", "fade"); id("signin-modal"); attr("tabindex", "-1"); attr("aria-hidden", "true") }) {
        Div({ classes("modal-dialog", "modal-lg", "modal-dialog-centered", "p-2", "my-0", "mx-auto"); style { property("max-width", "950px") } }) {
            Div({ classes("modal-content", "bg-dark", "border-light") }) {
                Div({ classes("modal-body", "px-0", "py-2", "py-sm-0") }) {
                    Button(attrs = {
                        classes("btn-close", "btn-close-white", "position-absolute", "top-0", "end-0", "mt-3", "me-3")
                        attr("type", "button")
                        attr("data-bs-dismiss", "modal")
                    })

                    Div({ classes("row", "mx-0", "align-items-center") }) {
                        // LEFT SIDE
                        Div({ classes("col-md-6", "border-end-md", "border-light", "p-4", "p-sm-5") }) {
                            H2({ classes("h3", "text-light", "mb-4", "mb-sm-5") }) {
                                Text("Pozdrav! ")
                                Br()
                                Text("Dobrodošli natrag.")
                            }
                            Img(src = "/img/signin-modal/signin-dark.svg", alt = "Ilustracija") {
                                classes("d-block", "mx-auto")
                                attr("width", "344")
                            }
                            Div({ classes("text-light", "mt-4", "mt-sm-5") }) {
                                Span({ classes("opacity-60") }) { Text("Nemate račun? ") }
                                A("#signup-modal", {
                                    classes("text-light")
                                    attr("data-bs-toggle", "modal")
                                    attr("data-bs-dismiss", "modal")
                                }) { Text("Registrirajte se ovdje") }
                            }
                        }

                        // RIGHT SIDE
                        Div({ classes("col-md-6", "px-4", "pt-2", "pb-4", "px-sm-5", "pb-sm-5", "pt-md-5") }) {
                            A("#", { classes("btn", "btn-outline-info", "w-100", "mb-3") }) {
                                I({ classes("fi-google", "fs-lg", "me-1") })
                                Text("Prijava putem Google-a")
                            }
                            A("#", { classes("btn", "btn-outline-info", "w-100", "mb-3") }) {
                                I({ classes("fi-facebook", "fs-lg", "me-1") })
                                Text("Prijava putem Facebook-a")
                            }

                            Div({ classes("d-flex", "align-items-center", "py-3", "mb-3") }) {
                                Hr({ classes("hr-light", "w-100") })
                                Div({ classes("text-light", "opacity-70", "px-3") }) { Text("Ili") }
                                Hr({ classes("hr-light", "w-100") })
                            }

                            Form(attrs = { classes("needs-validation"); attr("novalidate", "") }) {
                                // Email
                                Div({ classes("mb-4") }) {
                                    Label(attrs = { classes("form-label", "text-light", "mb-2"); attr("for", "signin-email") }) {
                                        Text("Email adresa")
                                    }
                                    Input(InputType.Email) {
                                        classes("form-control", "form-control-light")
                                        id("signin-email")
                                        attr("placeholder", "Unesite svoj email")
                                        attr("required", "")
                                    }
                                }

                                // Password
                                Div({ classes("mb-4") }) {
                                    Div({ classes("d-flex", "align-items-center", "justify-content-between", "mb-2") }) {
                                        Label(attrs = { classes("form-label", "text-light", "mb-0"); attr("for", "signin-password") }) {
                                            Text("Lozinka")
                                        }
                                        A("#", { classes("fs-sm", "text-light") }) { Text("Zaboravili ste lozinku?") }
                                    }

                                    Div({ classes("password-toggle") }) {
                                        Input(InputType.Password) {
                                            classes("form-control", "form-control-light")
                                            id("signin-password")
                                            attr("placeholder", "Unesite lozinku")
                                            attr("required", "")
                                        }
                                        Label(attrs ={ classes("password-toggle-btn"); attr("aria-label", "Prikaži/sakrij lozinku") }) {
                                            Input(InputType.Checkbox) { classes("password-toggle-check") }
                                            Span({ classes("password-toggle-indicator") })
                                        }
                                    }
                                }

                                Button(attrs = {
                                    classes("btn", "btn-primary", "btn-lg", "w-100")
                                    attr("type", "submit")
                                }) {
                                    Text("Prijava")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}