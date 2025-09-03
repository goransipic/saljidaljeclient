package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
fun PasswordSecurityContent() {
    Div(attrs = {
        classes("col-lg-8", "col-md-7", "mb-5")
    }) {
        H1(attrs = { classes("h2", "text-light") }) { Text("Lozinka i sigurnost") }
        P(attrs = { classes("text-light", "pt-1") }) {
            Text("Upravljajte postavkama lozinke i osigurajte svoj račun.")
        }

        H2(attrs = { classes("h5", "text-light") }) { Text("Lozinka") }

        Form(attrs = {
            classes("needs-validation", "pb-4")
            attr("novalidate", "true")
        }) {
            Div(attrs = { classes("row", "align-items-end", "mb-2") }) {
                Div(attrs = { classes("col-sm-6", "mb-2") }) {
                    Label(attrs = {
                        classes("form-label", "text-light")
                        attr("for", "account-password")
                    }) { Text("Trenutna lozinka") }

                    Div(attrs = { classes("password-toggle") }) {
                        Input(type = InputType.Password, attrs = {
                            classes("form-control", "form-control-light")
                            id("account-password")
                            attr("required", "true")
                        })
                        Label(attrs = {
                            classes("password-toggle-btn")
                            attr("aria-label", "Prikaži/sakrij lozinku")
                        }) {
                            Input(type = InputType.Checkbox, attrs = { classes("password-toggle-check") })
                            Span(attrs = { classes("password-toggle-indicator") })
                        }
                    }
                }

                Div(attrs = { classes("col-sm-6", "mb-2") }) {
                    A(href = "#", attrs = { classes("d-inline-block", "text-light", "mb-2") }) {
                        Text("Zaboravljena lozinka?")
                    }
                }
            }

            Div(attrs = { classes("row", "mb-2") }) {
                Div(attrs = { classes("col-sm-6", "mb-3") }) {
                    Label(attrs = {
                        classes("form-label", "text-light")
                        attr("for", "account-password-new")
                    }) { Text("Nova lozinka") }

                    Div(attrs = { classes("password-toggle") }) {
                        Input(type = InputType.Password, attrs = {
                            classes("form-control", "form-control-light")
                            id("account-password-new")
                            attr("required", "true")
                        })
                        Label(attrs = {
                            classes("password-toggle-btn")
                            attr("aria-label", "Prikaži/sakrij lozinku")
                        }) {
                            Input(type = InputType.Checkbox, attrs = { classes("password-toggle-check") })
                            Span(attrs = { classes("password-toggle-indicator") })
                        }
                    }
                }

                Div(attrs = { classes("col-sm-6", "mb-3") }) {
                    Label(attrs = {
                        classes("form-label", "text-light")
                        attr("for", "account-password-confirm")
                    }) { Text("Potvrdi lozinku") }

                    Div(attrs = { classes("password-toggle") }) {
                        Input(type = InputType.Password, attrs = {
                            classes("form-control", "form-control-light")
                            id("account-password-confirm")
                            attr("required", "true")
                        })
                        Label(attrs = {
                            classes("password-toggle-btn")
                            attr("aria-label", "Prikaži/sakrij lozinku")
                        }) {
                            Input(type = InputType.Checkbox, attrs = { classes("password-toggle-check") })
                            Span(attrs = { classes("password-toggle-indicator") })
                        }
                    }
                }
            }

            Button(attrs = {
                classes("btn", "btn-outline-primary")
                type(ButtonType.Submit)
            }) {
                Text("Ažuriraj lozinku")
            }
        }

        Div(attrs = { classes("border-top", "border-light", "pt-4", "mt-3") })

        H2(attrs = { classes("h5", "text-light", "pt-2", "mb-4") }) {
            Text("Gdje ste prijavljeni")
        }

        // Example device entry
        Div(attrs = { classes("d-flex", "border-bottom", "border-light", "pb-3", "mb-3") }) {
            I(attrs = { classes("fi-device-desktop", "fs-5", "text-light", "me-1") })
            Div(attrs = { classes("ps-2", "text-light") }) {
                Div(attrs = { classes("fw-bold", "mb-1") }) { Text("Mac – New York, SAD") }
                Span(attrs = { classes("d-inline-block", "fs-sm", "border-end", "border-light", "pe-2", "me-2") }) {
                    Span(attrs = { classes("opacity-70") }) { Text("Chrome") }
                }
                Span(attrs = { classes("fs-sm", "fw-bold", "text-success") }) { Text("Aktivno sada") }
            }
        }

        A(href = "#", attrs = { classes("nav-link", "nav-link-light", "px-0", "mt-4") }) {
            Text("Odjavi se sa svih sesija")
        }
    }
}