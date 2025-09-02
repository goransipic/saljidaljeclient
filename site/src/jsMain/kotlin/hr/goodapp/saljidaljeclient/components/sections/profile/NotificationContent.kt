package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.forId
import org.jetbrains.compose.web.dom.*

@Composable
fun NotificationContent() {
    Div(attrs = { classes("col-lg-8", "col-md-7", "mb-5") }) {
        H1(attrs = { classes("h2", "text-light") }) { Text("Notifications") }
        P(attrs = { classes("text-light", "pt-1", "mb-4") }) {
            Text("Get real-time vehicle updates, price drop alerts, helpful shopping information and more.")
        }

        Div(attrs = { classes("py-2"); id("notification-settings") }) {

            // New vehicles alerts
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("New vehicles alerts") }
                    P(attrs = { classes("fs-sm", "text-light", "mb-0") }) {
                        Span(attrs = { classes("opacity-70") }) { Text("New vehicles that match your ") }
                        A(href = "car-finder-account-wishlist.html", attrs = { classes("text-light") }) { Text("Wishlist") }
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("new-vehicles"); defaultChecked() })
                    Label(attrs = { classes("form-check-label");}, forId = "new-vehicles") {}
                }
            }

            // Vehicle status updates
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Vehicle status updates") }
                    P(attrs = { classes("fs-sm", "text-light", "mb-0") }) {
                        Span(attrs = { classes("opacity-70") }) { Text("Updates like price changes and off-market status on your ") }
                        A(href = "car-finder-account-wishlist.html", attrs = { classes("text-light") }) { Text("Wishlist") }
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("vehicle-update"); defaultChecked() })
                    Label(attrs = { classes("form-check-label") }, forId = "vehicle-update") {}
                }
            }

            // Finder recommendations
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Finder recommendations") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("Vehicles we think you'll like. These recommendations may be slightly outside your search criteria")
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("finder-recomendation") })
                    Label(attrs = { classes("form-check-label");  }, forId = "finder-recomendation") {}
                }
            }

            // Featured news
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Featured news") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("News and tips you may be interested in")
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("featured-news"); defaultChecked() })
                    Label(attrs = { classes("form-check-label");  }, forId = "featured-news") {}
                }
            }

            // Finder extras
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Finder extras") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("Occasional notifications about new features to make finding the perfect car easy")
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("extras") })
                    Label(attrs = { classes("form-check-label");  }, forId = "extras") {}
                }
            }

        }

        // Enable/disable all
        Div(attrs = { classes("border-top", "border-light", "pt-4") }) {
            Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                Input(type = InputType.Checkbox, attrs = {
                    classes("form-check-input");
                    id("all-notifications");
                    defaultChecked()
                    // you can add data attribute like:
                    attr("data-master-checkbox-for", "#notification-settings")
                })
                Label(attrs = { classes("form-check-label");}, forId = "all-notifications") {
                    Text("Enable / disable all notifications")
                }
            }
        }
    }
}