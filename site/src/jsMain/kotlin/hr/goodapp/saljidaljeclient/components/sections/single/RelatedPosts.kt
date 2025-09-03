package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
fun RelatedPostsCarousel() {
    H2(attrs = { classes("h3", "text-light", "pt-5", "pb-3", "mt-md-4") }) {
        Text("Možda će vas zanimati")
    }

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
                """{"items": 3, "responsive": {"0":{"items":1,"gutter":16},"500":{"items":2,"gutter":18},"900":{"items":3,"gutter":20}, "1100":{"gutter":24}}}"""
            )
        }) {
            val cars = listOf(
                RelatedCar(
                    year = "2020", title = "Mazda MX-5 Miata Cabriolet", price = "$29,700",
                    location = "Los Angeles", img = "img/car-finder/catalog/03.jpg",
                    mileage = "18K mi", transmission = "Manual", fuel = "Benzin", badge = "Novo", badgeColor = "bg-danger"
                ),
                RelatedCar(
                    year = "2018", title = "BMW 640 XI Gran Turismo", price = "$43,500",
                    location = "San Francisco", img = "img/car-finder/catalog/05.jpg",
                    mileage = "10K mi", transmission = "Automatski", fuel = "Benzin", badge = "Rabljeno", badgeColor = "bg-info",
                    certified = true
                ),
                RelatedCar(
                    year = "2019", title = "Nissan 370Z Nismo", price = "$37,900",
                    location = "New York", img = "img/car-finder/catalog/04.jpg",
                    mileage = "16K mi", transmission = "Automatski", fuel = "Benzin", badge = "Rabljeno", badgeColor = "bg-info"
                ),
                RelatedCar(
                    year = "2017", title = "Ford Explorer XLT", price = "$26,950",
                    location = "Kansas", img = "img/car-finder/catalog/08.jpg",
                    mileage = "34K mi", transmission = "Manual", fuel = "Dizel", badge = "Rabljeno", badgeColor = "bg-info"
                )
            )

            for ((index, car) in cars.withIndex()) {
                Div {
                    Div(attrs = { classes("card", "card-light", "card-hover", "h-100") }) {
                        // Card image
                        Div(attrs = { classes("card-img-top", "card-img-hover") }) {
                            A(attrs = { classes("img-overlay"); href("#") }) {}
                            Div(attrs = { classes("position-absolute", "start-0", "top-0", "pt-3", "ps-3") }) {
                                Span(attrs = { classes("d-table", car.badgeColor) }) { Text(car.badge) }
                                if (car.certified == true) {
                                    Span(attrs = {
                                        classes("d-table", "badge", "bg-success")
                                        attr("data-bs-toggle", "popover")
                                        attr("data-bs-placement", "bottom")
                                        attr("data-bs-trigger", "hover")
                                        attr("data-bs-html", "true")
                                        attr(
                                            "data-bs-content",
                                            """<div class="d-flex"><i class="fi-award mt-1 me-2"></i><div>Ovaj automobil je provjeren i<br>certificiran od strane Findera.</div></div>"""
                                        )
                                    }) { Text("Certificirano") }
                                }
                            }
                            Div(attrs = { classes("content-overlay", "end-0", "top-0", "pt-3", "pe-3") }) {
                                Button(attrs = {
                                    classes("btn", "btn-icon", "btn-light", "btn-xs", "text-primary", "rounded-circle")
                                    type(ButtonType.Button)
                                    attr("data-bs-toggle", "tooltip")
                                    attr("data-bs-placement", "left")
                                    attr("title", "Dodaj u listu želja")
                                }) { I(attrs = { classes("fi-heart") }) {} }
                            }
                            Img(attrs = { alt("Slika") }, src = car.img)
                        }

                        // Card body
                        Div(attrs = { classes("card-body") }) {
                            Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                                Span(attrs = { classes("fs-sm", "text-light", "me-3") }) { Text(car.year) }
                                Div(attrs = { classes("form-check", "form-check-light") }) {
                                    Input(type = InputType.Checkbox,attrs = { classes("form-check-input"); id("compare${index + 1}") })
                                    Label(attrs = { classes("form-check-label", "fs-sm"); }, forId = "compare${index + 1}") { Text("Usporedi") }
                                }
                            }
                            H3(attrs = { classes("h6", "mb-1") }) {
                                A(attrs = { classes("nav-link-light"); href("#") }) { Text(car.title) }
                            }
                            Div(attrs = { classes("text-primary", "fw-bold", "mb-1") }) { Text(car.price) }
                            Div(attrs = { classes("fs-sm", "text-light", "opacity-70") }) {
                                I(attrs = { classes("fi-map-pin", "me-1") }) {}
                                Text(car.location)
                            }
                        }

                        // Card footer
                        Div(attrs = { classes("card-footer", "border-0", "pt-0") }) {
                            Div(attrs = { classes("border-top", "border-light", "pt-3") }) {
                                Div(attrs = { classes("row", "g-2") }) {
                                    Div(attrs = { classes("col", "me-sm-1") }) {
                                        Div(attrs = { classes("bg-dark", "rounded", "text-center", "w-100", "h-100", "p-2") }) {
                                            I(attrs = { classes("fi-dashboard", "d-block", "h4", "text-light", "mb-0", "mx-center") }) {}
                                            Span(attrs = { classes("fs-xs", "text-light") }) { Text(car.mileage) }
                                        }
                                    }
                                    Div(attrs = { classes("col", "me-sm-1") }) {
                                        Div(attrs = { classes("bg-dark", "rounded", "text-center", "w-100", "h-100", "p-2") }) {
                                            I(attrs = { classes("fi-gearbox", "d-block", "h4", "text-light", "mb-0", "mx-center") }) {}
                                            Span(attrs = { classes("fs-xs", "text-light") }) { Text(car.transmission) }
                                        }
                                    }
                                    Div(attrs = { classes("col") }) {
                                        Div(attrs = { classes("bg-dark", "rounded", "text-center", "w-100", "h-100", "p-2") }) {
                                            I(attrs = { classes("fi-petrol", "d-block", "h4", "text-light", "mb-0", "mx-center") }) {}
                                            Span(attrs = { classes("fs-xs", "text-light") }) { Text(car.fuel) }
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

data class RelatedCar(
    val year: String,
    val title: String,
    val price: String,
    val location: String,
    val img: String,
    val mileage: String,
    val transmission: String,
    val fuel: String,
    val badge: String,
    val badgeColor: String,
    val certified: Boolean? = false
)