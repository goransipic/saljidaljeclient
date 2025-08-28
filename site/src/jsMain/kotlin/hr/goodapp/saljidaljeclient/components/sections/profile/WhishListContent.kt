package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.style.KobwebComposeStyleSheet.id
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
fun WishlistContent() {
    Div(attrs = { classes("col-lg-8", "col-md-7", "mb-5") }) {
        // Header
        Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "mb-4", "pb-2") }) {
            H1(attrs = { classes("h2", "text-light", "mb-0") }) {
                Text("Wishlist")
                Span(attrs = { classes("badge", "bg-faded-light", "fs-base", "align-middle", "ms-3") }) { Text("4") }
            }
            A(href = "#", attrs = { classes("nav-link-light", "fw-bold") }) {
                I(attrs = { classes("fi-x", "fs-xs", "mt-n1", "me-2") })
                Text("Clear all")
            }
        }

        // Example items
        WishlistCard(
            year = "1995",
            title = "Ford Truck Lifted",
            price = "$24,000",
            location = "New Jersey",
            mileage = "278K mi",
            gearbox = "Manual",
            fuel = "Diesel",
            imageUrls = listOf("/img/car-finder/catalog/09.jpg", "/img/car-finder/catalog/09.jpg"),
            compareId = "compare1"
        )

        WishlistCard(
            year = "2018",
            title = "Mercedes Benz C300 Sport",
            price = "$53,600",
            location = "San Francisco",
            mileage = "35K mi",
            gearbox = "Automatic",
            fuel = "Hybrid",
            imageUrls = listOf("/img/car-finder/catalog/10.jpg", "/img/car-finder/catalog/10.jpg"),
            compareId = "compare2"
        )

        WishlistCard(
            year = "2019",
            title = "Mazda MX-5 Miata Convertible",
            price = "$29,700",
            location = "Los Angeles",
            mileage = "18K mi",
            gearbox = "Manual",
            fuel = "Gasoline",
            imageUrls = listOf("/img/car-finder/catalog/11.jpg", "/img/car-finder/catalog/11.jpg"),
            compareId = "compare3"
        )

        WishlistCard(
            year = "2016",
            title = "Nissan 370Z Nismo",
            price = "$31,200",
            location = "New York",
            mileage = "16K mi",
            gearbox = "Automatic",
            fuel = "Gasoline",
            imageUrls = listOf("/img/car-finder/catalog/12.jpg", "/img/car-finder/catalog/12.jpg"),
            compareId = "compare4"
        )
    }
}

// Item Composable
@Composable
fun WishlistCard(
    year: String,
    title: String,
    price: String,
    location: String,
    mileage: String,
    gearbox: String,
    fuel: String,
    imageUrls: List<String>,
    compareId: String
) {
    Div(attrs = { classes("card", "card-light", "card-hover", "card-horizontal", "mb-4") }) {
        // Carousel wrapper
        Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
            A(href = "car-finder-single.html", attrs = { classes("img-overlay") }) {}
            Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                Span(attrs = { classes("d-table", "badge", "bg-info") }) { Text("Used") }
            }
            Div(attrs = { classes("position-absolute", "end-0", "top-0", "pt-3", "pe-3", "zindex-5") }) {
                Button(attrs = {
                    classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle", "shadow-sm")
                    type(ButtonType.Button)
                    attr("data-bs-toggle", "tooltip")
                    attr("data-bs-placement", "left")
                    attr("title", "Remove from Wishlist")
                }) {
                    I(attrs = { classes("fi-heart-filled") })
                }
            }
            Div(attrs = { classes("tns-carousel-inner", "position-absolute", "top-0", "h-100") }) {
                imageUrls.forEach { url ->
                    Div(attrs = {
                        classes("bg-size-cover", "bg-position-center", "w-100", "h-100")
                        style { property("background-image", "url($url)") }
                    }) {}
                }
            }
        }

        // Card body
        Div(attrs = { classes("card-body") }) {
            Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text(year) }
                Div(attrs = { classes("form-check", "form-check-light") }) {
                    Input(attrs = { classes("form-check-input"); id(compareId) },  type = InputType.Checkbox )
                    Label(forId = compareId, attrs = { classes("form-check-label", "fs-sm") }) { Text("Compare") }
                }
            }
            H3(attrs = { classes("h6", "mb-1") }) {
                A(href = "car-finder-single.html", attrs = { classes("nav-link-light") }) { Text(title) }
            }
            Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text(price) }
            Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                I(attrs = { classes("fi-map-pin", "me-1") })
                Text(location)
            }

            // Specs row
            Div(attrs = { classes("border-top", "border-light", "mt-3", "pt-3") }) {
                Div(attrs = { classes("row", "g-2") }) {
                    listOf(
                        mileage to "fi-dashboard",
                        gearbox to "fi-gearbox",
                        fuel to "fi-petrol"
                    ).forEach { (value, icon) ->
                        Div(attrs = { classes("col", "me-sm-1") }) {
                            Div(attrs = { classes("bg-dark", "rounded", "text-center", "w-100", "h-100", "p-2") }) {
                                I(attrs = { classes(icon, "d-block", "h4", "text-light", "mb-0", "mx-center") })
                                Span(attrs = { classes("fs-xs", "text-light") }) { Text(value) }
                            }
                        }
                    }
                }
            }
        }
    }
}