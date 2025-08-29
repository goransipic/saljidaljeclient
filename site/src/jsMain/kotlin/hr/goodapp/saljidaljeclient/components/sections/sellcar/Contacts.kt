package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.role
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.required
import org.jetbrains.compose.web.dom.*

@Composable
fun Contacts() {
    Section(
        attrs = {
            classes("card", "card-light", "card-body", "border-0", "shadow-sm", "p-4", "mb-4")
            id("contacts")
        }
    ) {
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-phone", "text-primary", "fs-5", "mt-n1", "me-2") })
            Text("Contacts")
        }

        Div(attrs = { classes("row") }) {
            // First Name
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light") }, forId = "sc-fn") {
                    Text("First name")
                    Span(attrs = { classes("text-danger") }) { Text(" *") }
                }
                Input(type = InputType.Text, attrs = {
                    classes("form-control", "form-control-light")
                    id("sc-fn")
                    value("Devon")
                    placeholder("Enter your first name")
                    required()
                })
            }
            // Second Name
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); }, forId = "sc-sn") {
                    Text("Second name")
                    Span(attrs = { classes("text-danger") }) { Text(" *") }
                }
                Input(type = InputType.Text, attrs = {
                    classes("form-control", "form-control-light")
                    id("sc-sn")
                    value("Lane")
                    placeholder("Enter your second name")
                    required()
                })
            }
        }

        // Email and Phone
        Div(attrs = { classes("row") }) {
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light") }, forId = "sc-email") {
                    Text("Email")
                    Span(attrs = { classes("text-danger") }) { Text(" *") }
                }
                Input(type = InputType.Text, attrs = {
                    classes("form-control", "form-control-light")
                    id("sc-email")
                    value("devone_lane@email.com")
                    placeholder("Enter your email")
                })
            }
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light") }, forId = "sc-phone") {
                    Text("Phone number")
                    Span(attrs = { classes("text-danger") }) { Text(" *") }
                }
                Input(type = InputType.Tel, attrs = {
                    classes("form-control", "form-control-light")
                    id("sc-phone")
                    value("316-442-0597")
                    placeholder("000-000-0000")
                })
            }
        }

        Div {
            Label(attrs = {
                classes("form-label", "text-light")
                attr("for", "sc-website")
            }) {
                Text("Website")
            }
            Input(
                type = InputType.Text,
                attrs = {
                    classes("form-control", "form-control-light", "mb-3")
                    attr("id", "sc-website")
                    attr("placeholder", "Enter company name")
                }
            )
        }

        // Socials
        Div(attrs = { classes("text-light", "py-3") }) {
            Text("Social accounts")
        }

        Div(attrs = { classes("d-flex", "align-items-center", "mb-3") }) {
            Div(attrs = {
                classes(
                    "btn",
                    "btn-icon",
                    "btn-translucent-light",
                    "btn-xs",
                    "rounded-circle",
                    "pe-none",
                    "flex-shrink-0",
                    "me-3"
                )
            }) {
                I(attrs = { classes("fi-facebook") })
            }
            Input(
                type = InputType.Text,
                attrs = { classes("form-control", "form-control-light"); placeholder("Your Facebook account") })
        }

        // Collapsible extra socials
        Div(attrs = { classes("d-flex", "align-items-center", "mb-3") }) {
            Div(attrs = {
                classes(
                    "btn",
                    "btn-icon",
                    "btn-translucent-light",
                    "btn-xs",
                    "rounded-circle",
                    "pe-none",
                    "flex-shrink-0",
                    "me-3"
                )
            }) {
                I(attrs = { classes("fi-linkedin") })
            }
            Input(
                type = InputType.Text,
                attrs = { classes("form-control", "form-control-light"); placeholder("Your LinkedIn account") })
        }

        Div(attrs = { classes("d-flex", "align-items-center", "mb-3") }) {
            Div(attrs = {
                classes(
                    "btn",
                    "btn-icon",
                    "btn-translucent-light",
                    "btn-xs",
                    "rounded-circle",
                    "pe-none",
                    "flex-shrink-0",
                    "me-3"
                )
            }) {
                I(attrs = { classes("fi-twitter") })
            }
            Input(
                type = InputType.Text,
                attrs = { classes("form-control", "form-control-light"); placeholder("Your Twitter account") })
        }

        // Toggle button
        Div(attrs = { classes("collapse"); id("showMoreSocials") }) {
            // Instagram
            Div(attrs = { classes("d-flex", "align-items-center", "mb-3") }) {
                Div(attrs = {
                    classes(
                        "btn",
                        "btn-icon",
                        "btn-translucent-light",
                        "btn-xs",
                        "rounded-circle",
                        "pe-none",
                        "flex-shrink-0",
                        "me-3"
                    )
                }) {
                    I(attrs = { classes("fi-instagram") })
                }
                Input(type = InputType.Text, attrs = {
                    classes("form-control", "form-control-light")
                    placeholder("Your Instagram account")
                })
            }

            // Pinterest
            Div(attrs = { classes("d-flex", "align-items-center", "mb-3") }) {
                Div(attrs = {
                    classes(
                        "btn",
                        "btn-icon",
                        "btn-translucent-light",
                        "btn-xs",
                        "rounded-circle",
                        "pe-none",
                        "flex-shrink-0",
                        "me-3"
                    )
                }) {
                    I(attrs = { classes("fi-pinterest") }) // Bootstrap Icon
                }
                Input(type = InputType.Text, attrs = {
                    classes("form-control", "form-control-light")
                    placeholder("Your Pinterest account")
                })
            }
        }
        A(
            href = "#showMoreSocials",
            attrs = {
                classes(
                    "nav-link-light",
                    "collapse-label",
                    "collapsed",
                    "d-inline-block",
                    "fs-sm",
                    "fw-bold",
                    "pt-2",
                    "pb-3"
                )
                attr("data-bs-toggle", "collapse")
                attr("data-bs-label-collapsed", "Show more")
                attr("data-bs-label-expanded", "Show less")
                attr("role", "button")
                attr("aria-expanded", "false")
                attr("aria-controls", "showMoreSocials")
            }
        ) {
            I(attrs = { classes("fi-arrow-down", "me-2") })
            //Text("Show more")
        }
    }
    Div(attrs = { classes("d-sm-flex", "justify-content-between", "pt-2") }) {
        A(
            href = "#preview-modal",
            attrs = {
                classes("btn", "btn-outline-light", "btn-lg", "d-block", "mb-3", "mb-sm-2")
                attr("data-bs-toggle", "modal")
            }
        ) {
            I(attrs = { classes("fi-eye-on", "ms-n1", "me-2") })
            Text("Preview")
        }

        A(
            href = "car-finder-promotion.html",
            attrs = { classes("btn", "btn-primary", "btn-lg", "d-block", "mb-2") }
        ) {
            Text("Save and continue")
        }
    }
}