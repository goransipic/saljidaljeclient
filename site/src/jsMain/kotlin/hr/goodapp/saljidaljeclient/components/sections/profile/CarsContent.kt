package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.role
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
fun CarsContent() {
    Div(attrs = { classes("col-lg-8", "col-md-7", "mb-5") }) {
        // Header
        Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "mb-3") }) {
            H1(attrs = { classes("h2", "text-light", "mb-0") }) { Text("My Cars") }
            A(href = "#", attrs = { classes("nav-link-light", "fw-bold") }) {
                I(attrs = { classes("fi-trash", "mt-n1", "me-2") })
                Text("Delete all")
            }
        }
        P(attrs = { classes("text-light", "pt-1", "mb-4") }) {
            Text("Here you can see your car offers and edit them easily.")
        }

        // Nav Tabs
        Ul(attrs = { classes("nav", "nav-tabs", "nav-tabs-light", "border-bottom", "border-light", "mb-4"); role("tablist") }) {
            Li(attrs = { classes("nav-item", "mb-3") }) {
                A(href = "#", attrs = { classes("nav-link", "active"); role("tab"); attr("aria-selected", "true") }) {
                    I(attrs = { classes("fi-file", "fs-base", "me-2") })
                    Text("Published")
                }
            }
            Li(attrs = { classes("nav-item", "mb-3") }) {
                A(href = "#", attrs = { classes("nav-link"); role("tab"); attr("aria-selected", "false") }) {
                    I(attrs = { classes("fi-file-clean", "fs-base", "me-2") })
                    Text("Drafts")
                }
            }
            Li(attrs = { classes("nav-item", "mb-3") }) {
                A(href = "#", attrs = { classes("nav-link"); role("tab"); attr("aria-selected", "false") }) {
                    I(attrs = { classes("fi-archive", "fs-base", "me-2") })
                    Text("Archived")
                }
            }
        }

        // Example items
        CarCard(
            year = "2017",
            title = "Toyota GT86",
            price = "$16,000",
            location = "Chicago",
            mileage = "32K mi",
            gearbox = "Manual",
            fuel = "Gasoline",
            imageUrls = listOf("/img/car-finder/catalog/14.jpg", "/img/car-finder/catalog/14.jpg"),
            contextMenuId = "contextMenu1"
        )

        CarCard(
            year = "2019",
            title = "Volkswagen GTI S",
            price = "$20,000",
            location = "San Francisco",
            mileage = "25K mi",
            gearbox = "Automatic",
            fuel = "Hybrid",
            imageUrls = listOf("/img/car-finder/catalog/15.jpg", "/img/car-finder/catalog/15.jpg"),
            contextMenuId = "contextMenu2"
        )

        CarCard(
            year = "2017",
            title = "Ford Explorer XLT",
            price = "$26,950",
            location = "Kansas",
            mileage = "47K mi",
            gearbox = "Manual",
            fuel = "Diesel",
            imageUrls = listOf("/img/car-finder/catalog/16.jpg", "/img/car-finder/catalog/16.jpg"),
            contextMenuId = "contextMenu3"
        )
    }
}

// Car Item Composable
@Composable
private fun CarCard(
    year: String,
    title: String,
    price: String,
    location: String,
    mileage: String,
    gearbox: String,
    fuel: String,
    imageUrls: List<String>,
    contextMenuId: String
) {
    Div(attrs = { classes("card", "card-light", "card-hover", "card-horizontal", "mb-4") }) {
        // Carousel wrapper
        Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
            A(href = "car-finder-single.html", attrs = { classes("img-overlay") }) {}
            Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                Span(attrs = { classes("d-table", "badge", "bg-info") }) { Text("Used") }
            }
            Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                Button(attrs = {
                    classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle")
                    type(ButtonType.Button)
                    attr("data-bs-toggle", "tooltip")
                    attr("data-bs-placement", "left")
                    attr("title", "Add to Wishlist")
                }) {
                    I(attrs = { classes("fi-heart") })
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
        Div(attrs = { classes("card-body", "position-relative") }) {
            // Dropdown menu
            Div(attrs = { classes("dropdown", "position-absolute", "zindex-5", "top-0", "end-0", "mt-3", "me-3") }) {
                Button(attrs = {
                    classes("btn", "btn-icon", "btn-translucent-light", "btn-xs", "rounded-circle")
                    type(ButtonType.Button)
                    id(contextMenuId)
                    attr("data-bs-toggle", "dropdown")
                    attr("aria-expanded", "false")
                }) {
                    I(attrs = { classes("fi-dots-vertical") })
                }
                Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark", "my-1"); attr("aria-labelledby", contextMenuId) }) {
                    listOf("Edit" to "fi-edit", "Promote" to "fi-flame", "Deactivate" to "fi-power", "Delete" to "fi-trash").forEach { (text, icon) ->
                        Li {
                            Button(attrs = { classes("dropdown-item"); type(ButtonType.Button) }) {
                                I(attrs = { classes(icon, "me-2") })
                                Text(text)
                            }
                        }
                    }
                }
            }

            Div(attrs = { classes("fs-sm", "text-light", "pb-1") }) { Text(year) }
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