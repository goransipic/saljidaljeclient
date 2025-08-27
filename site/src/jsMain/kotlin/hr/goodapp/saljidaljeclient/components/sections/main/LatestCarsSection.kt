package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.DefaultStyleSheet.attr
import com.varabyte.kobweb.core.DefaultStyleSheet.type
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
fun LatestCarsSection() {
    val cars = listOf(
        mapOf(
            "year" to "2019",
            "name" to "Nissan 370Z Nismo",
            "price" to "$37,900",
            "location" to "New York",
            "mileage" to "16K mi",
            "transmission" to "Automatic",
            "fuel" to "Gasoline",
            "badge" to "Used",
            "img" to "img/car-finder/catalog/04.jpg"
        ),
        mapOf(
            "year" to "2017",
            "name" to "Ford Explorer XLT",
            "price" to "$26,950",
            "location" to "Kansas",
            "mileage" to "34K mi",
            "transmission" to "Manual",
            "fuel" to "Diesel",
            "badge" to "Used",
            "img" to "img/car-finder/catalog/08.jpg",
            "certified" to "Certified"
        ),
        mapOf(
            "year" to "2019",
            "name" to "Mazda MX-5 Miata Convertible",
            "price" to "$29,700",
            "location" to "Los Angeles",
            "mileage" to "18K mi",
            "transmission" to "Manual",
            "fuel" to "Gasoline",
            "badge" to "Used",
            "img" to "img/car-finder/catalog/03.jpg"
        ),
        mapOf(
            "year" to "2018",
            "name" to "Mercedes Benz C300 Sport",
            "price" to "$53,600",
            "location" to "San Francisco",
            "mileage" to "35K mi",
            "transmission" to "Automatic",
            "fuel" to "Hybrid",
            "badge" to "Used",
            "img" to "img/car-finder/catalog/02.jpg"
        )
    )

    Div(attrs = { classes("container", "pt-sm-5", "pt-4", "pb-3") }) {
        // Header
        Div(attrs = {
            classes(
                "d-sm-flex",
                "align-items-center",
                "justify-content-between",
                "mb-3",
                "mb-sm-4",
                "pb-2"
            )
        }) {
            H2(attrs = { classes("h3", "text-light", "mb-3", "mb-sm-0") }) {
                Text("Latest cars")
            }

            Div(attrs = { classes("d-flex", "align-items-center") }) {
                Ul(attrs = { classes("nav", "nav-tabs", "nav-tabs-light", "fs-sm", "me-4", "pe-2", "mb-0") }) {
                    listOf("New", "Used").forEachIndexed { i, tab ->
                        Li(attrs = { classes("nav-item") }) {
                            A(
                                href = "#",
                                attrs = {
                                    if (i == 1) classes("nav-link", "active")
                                    else classes("nav-link")
                                }
                            ) {
                                Text(tab)
                            }
                        }
                    }
                }
                A(attrs = {
                    classes(
                        "btn",
                        "btn-link",
                        "btn-light",
                        "fw-normal",
                        "px-0"
                    ); href("car-finder-catalog-grid.html")
                }) {
                    Text("View all")
                    I(attrs = { classes("fi-arrow-long-right", "fs-sm", "mt-0", "ps-1", "ms-2") })
                }
            }
        }

        // Carousel wrapper
        Div(attrs = {
            classes(
                "tns-carousel-wrapper",
                "tns-controls-outside-xxl",
                "tns-nav-outside",
                "tns-carousel-light"
            )
        }) {
            Div(attrs = {
                classes("tns-carousel-inner")
                attr(
                    "data-carousel-options",
                    """{"items": 3, "responsive": {"0": {"items":1,"gutter":16}, "500": {"items":2,"gutter":18}, "900": {"items":3,"gutter":20}, "1100": {"gutter":24}}}"""
                )
            }) {
                cars.forEach { car ->
                    Div {
                        Div(attrs = { classes("card", "card-light", "card-hover", "h-100") }) {
                            // Card image
                            Div(attrs = { classes("card-img-top", "card-img-hover") }) {
                                A(attrs = { classes("img-overlay"); href("car-finder-single.html") }) {}
                                Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                                    Span(attrs = { classes("d-table", "badge", "bg-info"); title(car["badge"]!!) }) {
                                        Text(car["badge"] ?: "")
                                    }
                                    car["certified"]?.let {
                                        Span(attrs = {
                                            classes("d-table", "badge", "bg-success")
                                            attr("data-bs-toggle", "popover")
                                            attr("data-bs-placement", "bottom")
                                            attr("data-bs-trigger", "hover")
                                            attr("data-bs-html", "true")
                                            attr(
                                                "data-bs-content",
                                                """<div class="d-flex"><i class="fi-award mt-1 me-2"></i><div>This car is checked and<br>certified by Finder.</div></div>"""
                                            )
                                        }) {
                                            Text(it)
                                        }
                                    }
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
                                        ); type(
                                        ButtonType.Button
                                    )
                                    }) {
                                        I(attrs = { classes("fi-heart") })
                                    }
                                }
                                Img(src = car["img"]!!, attrs = { alt("Image") })
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
                                    Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text(car["year"] ?: "") }
                                    Div(attrs = { classes("form-check", "form-check-light") }) {
                                        Input(
                                            type = InputType.Checkbox,
                                            attrs = { classes("form-check-input"); id("compare${cars.indexOf(car) + 4}") })
                                        Label(attrs = {
                                            classes(
                                                "form-check-label",
                                                "fs-sm"
                                            ); attr ("for","compare${cars.indexOf(car) + 4}")
                                        }) {
                                            Text("Compare")
                                        }
                                    }
                                }
                                H3(attrs = { classes("h6", "mb-1") }) {
                                    A(attrs = { classes("nav-link-light"); href("car-finder-single.html") }) {
                                        Text(
                                            car["name"] ?: ""
                                        )
                                    }
                                }
                                Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text(car["price"] ?: "") }
                                Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                                    I(attrs = { classes("fi-map-pin", "me-1") })
                                    Text(car["location"] ?: "")
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
                                        ).forEach { (key, iconClass) ->
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
                                                            iconClass,
                                                            "d-block",
                                                            "h4",
                                                            "text-light",
                                                            "mb-0",
                                                            "mx-center"
                                                        )
                                                    })
                                                    Span(attrs = { classes("fs-xs", "text-light") }) {
                                                        Text(
                                                            car[key] ?: ""
                                                        )
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
    }
}