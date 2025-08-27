package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType

import org.jetbrains.compose.web.dom.*

@Composable
fun TopOffersSection() {
    Section(attrs = { classes("container", "pt-sm-1", "pb-5", "mb-md-4") }) {
        // Header
        Div(attrs = { classes("d-sm-flex", "align-items-center", "justify-content-between", "mb-4", "pb-sm-2") }) {
            H2(attrs = { classes("h3", "text-light", "mb-2", "mb-sm-0") }) { Text("Top offers") }
            A(
                href = "car-finder-catalog-list.html",
                attrs = { classes("btn", "btn-link", "btn-light", "fw-normal", "px-0") }) {
                Text("View all offers")
                I(attrs = { classes("fi-arrow-long-right", "fs-sm", "mt-0", "ps-1", "ms-2") })
            }
        }

        // Row
        Div(attrs = { classes("row") }) {
            // Left Column
            Div(attrs = { classes("col-lg-6") }) {
                // First Card
                Div(attrs = { classes("card", "card-light", "card-hover", "h-lg-100", "mb-4", "mb-lg-0") }) {
                    Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
                        A(href = "car-finder-single.html", attrs = { classes("img-overlay") }) {}
                        Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                            Span(attrs = { classes("d-table", "badge", "bg-info", "mb-1") }) { Text("New") }
                            Span(attrs = {
                                classes("d-table", "badge", "bg-success")
                                attr("data-bs-toggle", "popover")
                                attr("data-bs-placement", "bottom")
                                attr("data-bs-trigger", "hover")
                                attr("data-bs-html", "true")
                                attr(
                                    "data-bs-content",
                                    "<div class='d-flex'><i class='fi-award mt-1 me-2'></i><div>This car is checked and<br>certified by Finder.</div></div>"
                                )
                            }) { Text("Certified") }
                        }
                        Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                            Button(attrs = {
                                classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle")
                                attr("type", "button")
                                attr("data-bs-toggle", "tooltip")
                                attr("data-bs-placement", "left")
                                attr("title", "Add to Wishlist")
                            }) { I(attrs = { classes("fi-heart") }) {} }
                        }
                        Div(attrs = { classes("tns-carousel-inner") }) {
                            Img(src = "img/car-finder/catalog/17.jpg", alt = "Image")
                            Img(src = "img/car-finder/catalog/17.jpg", alt = "Image")
                        }
                    }
                    Div(attrs = { classes("card-body") }) {
                        Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                            Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text("2015") }
                            Div(attrs = { classes("form-check", "form-check-light") }) {
                                Input(
                                    type = InputType.Checkbox,
                                    attrs = { id("compare1"); classes("form-check-input") })
                                Label(
                                    forId = "compare1",
                                    attrs = { classes("form-check-label", "fs-sm") }) { Text("Compare") }
                            }
                        }
                        H3(attrs = { classes("h6", "mb-1") }) {
                            A(
                                href = "car-finder-single.html",
                                attrs = { classes("nav-link-light") }) { Text("Mercedes Benz Convertible Coupe") }
                        }
                        Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text("$25,800") }
                        Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                            I(attrs = { classes("fi-map-pin", "me-1") })
                            Text("New York")
                        }
                    }
                    Div(attrs = { classes("card-footer", "border-0", "pt-0") }) {
                        Div(attrs = { classes("border-top", "border-light", "pt-3") }) {
                            Div(attrs = { classes("row", "g-2") }) {
                                // Mileage
                                Div(attrs = { classes("col", "me-sm-1") }) {
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
                                                "fi-dashboard",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("48K mi") }
                                    }
                                }
                                // Gearbox
                                Div(attrs = { classes("col", "me-sm-1") }) {
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
                                                "fi-gearbox",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("Automatic") }
                                    }
                                }
                                // Fuel
                                Div(attrs = { classes("col") }) {
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
                                                "fi-petrol",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("Gasoline") }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Right Column
            Div(attrs = { classes("col-lg-6") }) {
                // Second Card (horizontal)
                Div(attrs = { classes("card", "card-light", "card-hover", "card-horizontal", "mb-4") }) {
                    Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
                        A(href = "car-finder-single.html", attrs = { classes("img-overlay") }) {}
                        Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                            Span(attrs = { classes("d-table", "badge", "bg-info") }) { Text("Used") }
                        }
                        Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                            Button(attrs = {
                                classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle")
                                attr("type", "button")
                                attr("data-bs-toggle", "tooltip")
                                attr("data-bs-placement", "left")
                                attr("title", "Add to Wishlist")
                            }) { I(attrs = { classes("fi-heart") }) {} }
                        }
                        Div(attrs = { classes("tns-carousel-inner", "position-absolute", "top-0", "h-100") }) {
                            Div(attrs = {
                                classes("bg-size-cover", "bg-position-center", "w-100", "h-100")
                                style { property("background-image", "url(img/car-finder/catalog/09.jpg)") }
                            })
                            Div(attrs = {
                                classes("bg-size-cover", "bg-position-center", "w-100", "h-100")
                                style { property("background-image", "url(img/car-finder/catalog/09.jpg)") }
                            })
                        }
                    }
                    Div(attrs = { classes("card-body") }) {
                        Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                            Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text("1995") }
                            Div(attrs = { classes("form-check", "form-check-light") }) {
                                Input(
                                    type = InputType.Checkbox,
                                    attrs = { id("compare2"); classes("form-check-input") })
                                Label(
                                    forId = "compare2",
                                    attrs = { classes("form-check-label", "fs-sm") }) { Text("Compare") }
                            }
                        }
                        H3(attrs = { classes("h6", "mb-1") }) {
                            A(
                                href = "car-finder-single.html",
                                attrs = { classes("nav-link-light") }) { Text("Ford Truck Lifted") }
                        }
                        Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text("$24,000") }
                        Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                            I(attrs = { classes("fi-map-pin", "me-1") })
                            Text("Chicago")
                        }
                        Div(attrs = { classes("border-top", "border-light", "mt-3", "pt-3") }) {
                            Div(attrs = { classes("row", "g-2") }) {
                                Div(attrs = { classes("col", "me-sm-1") }) {
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
                                                "fi-dashboard",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("278K mi") }
                                    }
                                }
                                Div(attrs = { classes("col", "me-sm-1") }) {
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
                                                "fi-gearbox",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("Manual") }
                                    }
                                }
                                Div(attrs = { classes("col") }) {
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
                                                "fi-petrol",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("Diesel") }
                                    }
                                }
                            }
                        }
                    }
                }

                // Third Card (horizontal)
                Div(attrs = { classes("card", "card-light", "card-hover", "card-horizontal") }) {
                    Div(attrs = { classes("tns-carousel-wrapper", "card-img-top", "card-img-hover") }) {
                        A(href = "car-finder-single.html", attrs = { classes("img-overlay") }) {}
                        Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                            Span(attrs = { classes("d-table", "badge", "bg-danger") }) { Text("New") }
                        }
                        Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                            Button(attrs = {
                                classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle")
                                attr("type", "button")
                                attr("data-bs-toggle", "tooltip")
                                attr("data-bs-placement", "left")
                                attr("title", "Add to Wishlist")
                            }) { I(attrs = { classes("fi-heart") }) {} }
                        }
                        Div(attrs = { classes("tns-carousel-inner", "position-absolute", "top-0", "h-100") }) {
                            Div(attrs = {
                                classes("bg-size-cover", "bg-position-center", "w-100", "h-100")
                                style { property("background-image", "url(img/car-finder/catalog/13.jpg)") }
                            })
                            Div(attrs = {
                                classes("bg-size-cover", "bg-position-center", "w-100", "h-100")
                                style { property("background-image", "url(img/car-finder/catalog/13.jpg)") }
                            })
                        }
                    }
                    Div(attrs = { classes("card-body") }) {
                        Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                            Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text("2018") }
                            Div(attrs = { classes("form-check", "form-check-light") }) {
                                Input(
                                    type = InputType.Checkbox,
                                    attrs = { id("compare3"); classes("form-check-input") })
                                Label(
                                    forId = "compare3",
                                    attrs = { classes("form-check-label", "fs-sm") }) { Text("Compare") }
                            }
                        }
                        H3(attrs = { classes("h6", "mb-1") }) {
                            A(
                                href = "car-finder-single.html",
                                attrs = { classes("nav-link-light") }) { Text("BMW 640 XI Gran Turismo") }
                        }
                        Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text("$43,500") }
                        Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                            I(attrs = { classes("fi-map-pin", "me-1") })
                            Text("San Francisco")
                        }
                        Div(attrs = { classes("border-top", "border-light", "mt-3", "pt-3") }) {
                            Div(attrs = { classes("row", "g-2") }) {
                                Div(attrs = { classes("col", "me-sm-1") }) {
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
                                                "fi-dashboard",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("10K mi") }
                                    }
                                }
                                Div(attrs = { classes("col", "me-sm-1") }) {
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
                                                "fi-gearbox",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("Automatic") }
                                    }
                                }
                                Div(attrs = { classes("col") }) {
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
                                                "fi-petrol",
                                                "d-block",
                                                "h4",
                                                "text-light",
                                                "mb-0",
                                                "mx-center"
                                            )
                                        })
                                        Span(attrs = { classes("fs-xs", "text-light") }) { Text("Gasoline") }
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