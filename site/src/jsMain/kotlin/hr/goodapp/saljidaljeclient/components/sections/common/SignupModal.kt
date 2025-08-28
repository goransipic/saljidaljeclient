package hr.goodapp.saljidaljeclient.components.sections.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*

@Composable
fun SignupModal() {
    Div({
        id("signup-modal")
        attr("tabindex", "-1")
        attr("aria-hidden", "true")
        classes("modal", "fade")
    }) {
        Div({
            classes("modal-dialog", "modal-lg", "modal-dialog-centered", "p-2", "my-0", "mx-auto")
            style { property("max-width", "950px") }
        }) {
            Div({ classes("modal-content", "bg-dark", "border-light") }) {
                Div({ classes("modal-body", "px-0", "py-2", "py-sm-0") }) {

                    // close button
                    Button(attrs = {
                        classes("btn-close", "btn-close-white", "position-absolute", "top-0", "end-0", "mt-3", "me-3")
                        type(ButtonType.Button)
                        attr("data-bs-dismiss", "modal")
                    })

                    Div({ classes("row", "mx-0", "align-items-center") }) {
                        // Left side
                        Div({ classes("col-md-6", "border-end-md", "border-light", "p-4", "p-sm-5") }) {
                            H2({ classes("h3", "text-light", "mb-4", "mb-sm-5") }) {
                                Text("Join Finder.")
                                Br()
                                Text("Get premium benefits:")
                            }

                            Ul({ classes("list-unstyled", "mb-4", "mb-sm-5") }) {
                                Li({ classes("d-flex", "mb-2") }) {
                                    I({ classes("fi-check-circle", "text-primary", "mt-1", "me-2") })
                                    Span({ classes("text-light") }) { Text("Add and promote your listings") }
                                }
                                Li({ classes("d-flex", "mb-2") }) {
                                    I({ classes("fi-check-circle", "text-primary", "mt-1", "me-2") })
                                    Span({ classes("text-light") }) { Text("Easily manage your wishlist") }
                                }
                                Li({ classes("d-flex", "mb-0") }) {
                                    I({ classes("fi-check-circle", "text-primary", "mt-1", "me-2") })
                                    Span({ classes("text-light") }) { Text("Leave reviews") }
                                }
                            }

                            Img(src = "/img/signin-modal/signup-dark.svg", alt = "Illustration") {
                                classes("d-block", "mx-auto")
                                attr("width", "344")
                            }

                            Div({ classes("text-light", "mt-sm-4", "pt-md-3") }) {
                                Span({ classes("opacity-60") }) { Text("Already have an account? ") }
                                A(href = "#signin-modal", attrs = {
                                    classes("text-light")
                                    attr("data-bs-toggle", "modal")
                                    attr("data-bs-dismiss", "modal")
                                }) { Text("Sign in") }
                            }
                        }

                        // Right side
                        Div({ classes("col-md-6", "px-4", "pt-2", "pb-4", "px-sm-5", "pb-sm-5", "pt-md-5") }) {
                            A("#", attrs = { classes("btn", "btn-outline-info", "w-100", "mb-3") }) {
                                I({ classes("fi-google", "fs-lg", "me-1") })
                                Text("Sign in with Google")
                            }
                            A("#", attrs = { classes("btn", "btn-outline-info", "w-100", "mb-3") }) {
                                I({ classes("fi-facebook", "fs-lg", "me-1") })
                                Text("Sign in with Facebook")
                            }

                            Div({ classes("d-flex", "align-items-center", "py-3", "mb-3") }) {
                                Hr({ classes("hr-light", "w-100") })
                                Div({ classes("text-light", "opacity-70", "px-3") }) { Text("Or") }
                                Hr({ classes("hr-light", "w-100") })
                            }

                            Form(attrs = {
                                classes("needs-validation")
                                attr("novalidate", "")
                            }) {
                                // Name
                                Div({ classes("mb-4") }) {
                                    Label(forId = "signup-name", attrs = { classes("form-label", "text-light") }) { Text("Full name") }
                                    Input(InputType.Text) {
                                        classes("form-control", "form-control-light")
                                        id("signup-name")
                                        placeholder("Enter your full name")
                                        required()
                                    }
                                }

                                // Email
                                Div({ classes("mb-4") }) {
                                    Label(forId = "signup-email", attrs = { classes("form-label", "text-light") }) { Text("Email address") }
                                    Input(InputType.Email) {
                                        classes("form-control", "form-control-light")
                                        id("signup-email")
                                        placeholder("Enter your email")
                                        required()
                                    }
                                }

                                // Password
                                Div({ classes("mb-4") }) {
                                    Label(forId = "signup-password", attrs = { classes("form-label", "text-light") }) {
                                        Text("Password ")
                                        Span({ classes("fs-sm", "opacity-50") }) { Text("min. 8 char") }
                                    }
                                    Div({ classes("password-toggle") }) {
                                        Input(InputType.Password) {
                                            classes("form-control", "form-control-light")
                                            id("signup-password")
                                            attr("minlength", "8")
                                            required()
                                        }
                                        Label(attrs = {
                                            classes("password-toggle-btn")
                                            attr("aria-label", "Show/hide password")
                                        }) {
                                            Input(InputType.Checkbox) { classes("password-toggle-check") }
                                            Span({ classes("password-toggle-indicator") })
                                        }
                                    }
                                }

                                // Confirm Password
                                Div({ classes("mb-4") }) {
                                    Label(forId = "signup-password-confirm", attrs = { classes("form-label", "text-light") }) { Text("Confirm password") }
                                    Div({ classes("password-toggle") }) {
                                        Input(InputType.Password) {
                                            classes("form-control", "form-control-light")
                                            id("signup-password-confirm")
                                            attr("minlength", "8")
                                            required()
                                        }
                                        Label(attrs = {
                                            classes("password-toggle-btn")
                                            attr("aria-label", "Show/hide password")
                                        }) {
                                            Input(InputType.Checkbox) { classes("password-toggle-check") }
                                            Span({ classes("password-toggle-indicator") })
                                        }
                                    }
                                }

                                // Terms
                                Div({ classes("form-check", "form-check-light", "mb-4") }) {
                                    Input(InputType.Checkbox) {
                                        classes("form-check-input")
                                        id("agree-to-terms")
                                        required()
                                    }
                                    Label(forId = "agree-to-terms", attrs = { classes("form-check-label") }) {
                                        Span({ classes("opacity-70") }) { Text("By joining, I agree to the") }
                                        Text(" ")
                                        A("#", attrs = { classes("text-light") }) { Text("Terms of use") }
                                        Text(" ")
                                        Span({ classes("opacity-70") }) { Text("and") }
                                        Text(" ")
                                        A("#", attrs = { classes("text-light") }) { Text("Privacy policy") }
                                    }
                                }

                                Button(attrs = {
                                    classes("btn", "btn-primary", "btn-lg", "w-100")
                                    type(ButtonType.Submit)
                                }) { Text("Sign up") }
                            }
                        }
                    }
                }
            }
        }
    }
}