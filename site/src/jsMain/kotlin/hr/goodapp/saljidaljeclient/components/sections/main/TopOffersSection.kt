package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType

import org.jetbrains.compose.web.dom.*

@Composable
fun TopOffersSection() {
    Section(attrs = { classes("container", "pt-sm-1", "pb-5", "mb-md-4") }) {
        // Header row
        Div(attrs = { classes("d-sm-flex", "align-items-center", "justify-content-between", "mb-4", "pb-sm-2") }) {
            H2(attrs = { classes("h3", "text-light", "mb-2", "mb-sm-0") }) { Text("Top offers") }
            A(
                "car-finder-catalog-list.html",
                attrs = { classes("btn", "btn-link", "btn-light", "fw-normal", "px-0") }) {
                Text("View all offers")
                I(attrs = { classes("fi-arrow-long-right", "fs-sm", "mt-0", "ps-1", "ms-2") })
            }
        }

        // Offers row
        Div(attrs = { classes("row") }) {
            val offers = listOf(
                mapOf(
                    "year" to "2015",
                    "name" to "Mercedes Benz Convertible Coupe",
                    "price" to "$25,800",
                    "location" to "New York",
                    "mileage" to "48K mi",
                    "transmission" to "Automatic",
                    "fuel" to "Gasoline",
                    "image" to "17.jpg",
                    "badge1" to "New",
                    "badge2" to "Certified",
                    "link" to "car-finder-single.html"
                ),
                mapOf(
                    "year" to "1995",
                    "name" to "Ford Truck Lifted",
                    "price" to "$24,000",
                    "location" to "Chicago",
                    "mileage" to "278K mi",
                    "transmission" to "Manual",
                    "fuel" to "Diesel",
                    "image" to "09.jpg",
                    "badge1" to "Used",
                    "badge2" to "",
                    "link" to "car-finder-single.html"
                ),
                mapOf(
                    "year" to "2018",
                    "name" to "BMW 640 XI Gran Turismo",
                    "price" to "$43,500",
                    "location" to "San Francisco",
                    "mileage" to "10K mi",
                    "transmission" to "Automatic",
                    "fuel" to "Gasoline",
                    "image" to "13.jpg",
                    "badge1" to "New",
                    "badge2" to "",
                    "link" to "car-finder-single.html"
                )
            )

            offers.forEach { offer ->
                Div(attrs = { classes("col-lg-6") }) {
                    Div(attrs = {
                        classes(
                            "card",
                            "card-light",
                            "card-hover",
                            *(if (offer["name"] == "Mercedes Benz Convertible Coupe")
                                arrayOf("h-lg-100", "mb-4", "mb-lg-0")
                            else
                                arrayOf("card-horizontal", "mb-4"))
                        )
                    }) {
                        // Image carousel wrapper
                        Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
                            A(attrs = { classes("img-overlay"); attr("href", offer["link"]!!) }) {}
                            Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                                if (offer["badge1"]!!.isNotEmpty())
                                    Span(attrs = {
                                        classes(
                                            "d-table",
                                            "badge",
                                            if (offer["badge1"] == "New") "bg-info" else "bg-success",
                                            "mb-1"
                                        )
                                    }) { Text(offer["badge1"]!!) }
                                if (offer["badge2"]!!.isNotEmpty())
                                    Span(attrs = {
                                        classes(
                                            "d-table",
                                            "badge",
                                            "bg-success"
                                        )
                                    }) { Text(offer["badge2"]!!) }
                            }
                            Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                                Button(attrs = {
                                    classes(
                                        "btn",
                                        "btn-icon",
                                        "btn-light",
                                        "btn-xs",
                                        "text-primary",
                                        "rounded-circle"
                                    ); attr("type", "button")
                                }) {
                                    I(attrs = { classes("fi-heart") })
                                }
                            }
                            Div(attrs = { classes("tns-carousel-inner", "position-absolute", "top-0", "h-100") }) {
                                Div(attrs = {
                                    classes(
                                        "bg-size-cover",
                                        "bg-position-center",
                                        "w-100",
                                        "h-100"
                                    ); style {
                                    property(
                                        "background-image",
                                        "url(img/car-finder/catalog/${offer["image"]})"
                                    )
                                }
                                })
                                Div(attrs = {
                                    classes(
                                        "bg-size-cover",
                                        "bg-position-center",
                                        "w-100",
                                        "h-100"
                                    ); style {
                                    property(
                                        "background-image",
                                        "url(img/car-finder/catalog/${offer["image"]})"
                                    )
                                }
                                })
                            }
                        }

                        // Card body
                        Div(attrs = { classes("card-body") }) {
                            Div(attrs = {
                                classes(
                                    "d-flex",
                                    "align-items-center",
                                    "justify-content-between",
                                    "pb-1"
                                )
                            }) {
                                Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text(offer["year"]!!) }
                                Div(attrs = { classes("form-check", "form-check-light") }) {
                                    Input(
                                        type = InputType.Checkbox,
                                        attrs = {
                                            classes("form-check-input"); attr(
                                            "id",
                                            "compare${offers.indexOf(offer) + 1}"
                                        )
                                        })
                                    Label(attrs = {
                                        classes("form-check-label", "fs-sm"); attr(
                                        "for",
                                        "compare${offers.indexOf(offer) + 1}"
                                    )
                                    }) { Text("Compare") }
                                }
                            }
                            H3(attrs = { classes("h6", "mb-1") }) {
                                A(offer["link"]!!, attrs = { classes("nav-link-light") }) { Text(offer["name"]!!) }
                            }
                            Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text(offer["price"]!!) }
                            Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                                I(attrs = { classes("fi-map-pin", "me-1") })
                                Text(offer["location"]!!)
                            }
                        }

                        // Card footer
                        Div(attrs = { classes("card-footer", "border-0", "pt-0") }) {
                            Div(attrs = { classes("border-top", "border-light", "pt-3") }) {
                                Div(attrs = { classes("row", "g-2") }) {
                                    listOf(
                                        "mileage" to "fi-dashboard",
                                        "transmission" to "fi-gearbox",
                                        "fuel" to "fi-petrol"
                                    ).forEach { (key, icon) ->
                                        Div(attrs = {
                                            classes(
                                                *listOfNotNull(
                                                    "col",
                                                    if (key != "fuel") "me-sm-1" else null,
                                                ).toTypedArray()
                                            )
                                        }) {
                                            Div(attrs = {
                                                classes(
                                                    "bg-dark",
                                                    "rounded",
                                                    "text-center",
                                                    "w-100",
                                                    "h-100",
                                                    "p-2"
                                                )
                                            }) {
                                                I(attrs = {
                                                    classes(
                                                        icon,
                                                        "d-block",
                                                        "h4",
                                                        "text-light",
                                                        "mb-0",
                                                        "mx-center"
                                                    )
                                                })
                                                Span(attrs = { classes("fs-xs", "text-light") }) { Text(offer[key]!!) }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}