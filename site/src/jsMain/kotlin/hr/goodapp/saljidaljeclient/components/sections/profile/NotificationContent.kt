package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.forId
import org.jetbrains.compose.web.dom.*

@Composable
fun NotificationContent() {
    Div(attrs = { classes("col-lg-8", "col-md-7", "mb-5") }) {
        H1(attrs = { classes("h2", "text-light") }) { Text("Obavijesti") }
        P(attrs = { classes("text-light", "pt-1", "mb-4") }) {
            Text("Primajte obavijesti o novim vozilima, padovima cijena, korisnim informacijama pri kupnji i više.")
        }

        Div(attrs = { classes("py-2"); id("notification-settings") }) {

            // Obavijesti o novim vozilima
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Obavijesti o novim vozilima") }
                    P(attrs = { classes("fs-sm", "text-light", "mb-0") }) {
                        Span(attrs = { classes("opacity-70") }) { Text("Nova vozila koja odgovaraju vašem ") }
                        A(href = "car-finder-account-wishlist.html", attrs = { classes("text-light") }) { Text("Popisu želja") }
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("new-vehicles"); defaultChecked() })
                    Label(attrs = { classes("form-check-label") }, forId = "new-vehicles") {}
                }
            }

            // Ažuriranja statusa vozila
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Ažuriranja statusa vozila") }
                    P(attrs = { classes("fs-sm", "text-light", "mb-0") }) {
                        Span(attrs = { classes("opacity-70") }) { Text("Promjene cijena i status izvan tržišta za vaš ") }
                        A(href = "car-finder-account-wishlist.html", attrs = { classes("text-light") }) { Text("Popis želja") }
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("vehicle-update"); defaultChecked() })
                    Label(attrs = { classes("form-check-label") }, forId = "vehicle-update") {}
                }
            }

            // Preporuke Findera
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Preporuke Findera") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("Vozila za koja mislimo da će vam se svidjeti. Ove preporuke mogu biti blago izvan vaših kriterija pretraživanja")
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("finder-recomendation") })
                    Label(attrs = { classes("form-check-label") }, forId = "finder-recomendation") {}
                }
            }

            // Istaknute vijesti
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Istaknute vijesti") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("Vijesti i savjeti koji bi vas mogli zanimati")
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("featured-news"); defaultChecked() })
                    Label(attrs = { classes("form-check-label") }, forId = "featured-news") {}
                }
            }

            // Dodatne Finder obavijesti
            Div(attrs = { classes("d-flex", "justify-content-between", "mb-4") }) {
                Div(attrs = { classes("me-2") }) {
                    H6(attrs = { classes("text-light", "mb-1") }) { Text("Dodatne Finder obavijesti") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("Povremene obavijesti o novim funkcijama kako bi vam olakšali pronalazak savršenog automobila")
                    }
                }
                Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                    Input(type = InputType.Checkbox, attrs = { classes("form-check-input"); id("extras") })
                    Label(attrs = { classes("form-check-label") }, forId = "extras") {}
                }
            }

        }

        // Omogući/onemogući sve
        Div(attrs = { classes("border-top", "border-light", "pt-4") }) {
            Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                Input(type = InputType.Checkbox, attrs = {
                    classes("form-check-input")
                    id("all-notifications")
                    defaultChecked()
                    attr("data-master-checkbox-for", "#notification-settings")
                })
                Label(attrs = { classes("form-check-label") }, forId = "all-notifications") {
                    Text("Omogući / onemogući sve obavijesti")
                }
            }
        }
    }
}