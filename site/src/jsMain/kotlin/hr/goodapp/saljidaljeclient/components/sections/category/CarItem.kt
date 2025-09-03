package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun CarItem(car: CarData) {
    Div(attrs = { classes("card", "card-light", "card-hover", "card-horizontal", "mb-4") }) {

        // Image carousel wrapper
        Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
            A(href = "car-finder-single.html", attrs = { classes("img-overlay") }) {}

            // Badge
            Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                Span(attrs = { classes("d-table", "badge", "bg-info") }) {
                    Text("Rabljeno")
                }
            }

            // Wishlist button overlay
            Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                Button(attrs = {
                    classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle")
                    attr("type", "button")
                    attr("data-bs-toggle", "tooltip")
                    attr("data-bs-placement", "left")
                    attr("title", "Dodaj u listu želja")
                }) {
                    I(attrs = { classes("fi-heart") })
                }
            }

            // Carousel inner
            Div(attrs = { classes("tns-carousel-inner", "position-absolute", "top-0", "h-100") }) {
                car.images.forEach { url ->
                    Div(attrs = {
                        classes("bg-size-cover", "bg-position-center", "w-100", "h-100")
                        style { property("background-image", "url($url)") }
                    })
                }
            }
        }

        // Card body
        Div(attrs = { classes("card-body") }) {

            // Year + compare checkbox
            Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                Span(attrs = { classes("fs-sm", "text-light", "me-3") }) {
                    Text(car.year.toString())
                }

                Div(attrs = { classes("form-check", "form-check-light") }) {
                    Input(type = InputType.Checkbox, attrs = {
                        classes("form-check-input")
                        id("compare1")
                    })
                    Label(forId = "compare1", attrs = { classes("form-check-label", "fs-sm") }) {
                        Text("Usporedi")
                    }
                }
            }

            // Car title
            H3(attrs = { classes("h6", "mb-1") }) {
                A(href = "car-finder-single.html", attrs = { classes("nav-link-light") }) {
                    Text(car.title)
                }
            }

            // Price
            Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) {
                Text(car.price)
            }

            // Location
            Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                I(attrs = { classes("fi-map-pin", "me-1") })
                Text(car.location)
            }

            // Features row
            Div(attrs = { classes("border-top", "border-light", "mt-3", "pt-3") }) {
                Div(attrs = { classes("row", "g-2") }) {
                    Feature("fi-dashboard", car.mileage)
                    Feature("fi-gearbox", car.gearbox)
                    Feature("fi-petrol", car.fuel)
                }
            }
        }
    }
}

@Composable
fun Feature(iconClass: String, label: String) {
    Div(attrs = { classes("col", "me-sm-1") }) {
        Div(attrs = { classes("bg-dark", "rounded", "text-center", "w-100", "h-100", "p-2") }) {
            I(attrs = { classes(iconClass, "d-block", "h4", "text-light", "mb-0", "mx-center") })
            Span(attrs = { classes("fs-xs", "text-light") }) { Text(label) }
        }
    }
}


