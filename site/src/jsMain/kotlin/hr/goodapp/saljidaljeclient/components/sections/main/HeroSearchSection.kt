package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import hr.goodapp.saljidaljeclient.DropdownProps
import hr.goodapp.saljidaljeclient.Option
import hr.goodapp.saljidaljeclient.SearchFormViewModel
import MockSearchRepositoryImpl
import org.jetbrains.compose.web.attributes.InputType

import org.jetbrains.compose.web.dom.*

@Composable
fun HeroSearchSection() {
    val viewModel = remember {
        SearchFormViewModel(
            repository = MockSearchRepositoryImpl(),
            dropdowns = listOf(
                DropdownProps(
                    name = "Make",
                    icon = "fi-car",
                    options = listOf(
                        Option(name = "Toyota", seoName = "toyota", id = 1),
                        Option(name = "BMW", seoName = "bmw", id = 2),
                        Option(name = "Mercedes", seoName = "mercedes", id = 3),
                        Option(name = "Opel", seoName = "mercedes", id = 4)
                    )
                ),
                DropdownProps(
                    name = "Make",
                    icon = "fi-car",
                    options = emptyList()
                ),
                DropdownProps(
                    name = "Make",
                    icon = "fi-car",
                    options = emptyList()
                ), DropdownProps(
                    name = "Make",
                    icon = "fi-car",
                    options = emptyList()
                )
            ),
        )
    }
    val state by viewModel.uiState.collectAsState()

    Section(attrs = {
        classes("bg-position-top-center", "bg-repeat-0", "pt-5")
        style {
            property("background-image", "url(img/car-finder/home/hero-bg.png)")
            property("background-size", "1920px 630px")
        }
    }) {
        Div(attrs = { classes("container", "pt-5") }) {
            Div(attrs = { classes("row", "pt-lg-4", "pt-xl-5") }) {
                // Left column (text)
                Div(attrs = { classes("col-lg-4", "col-md-5", "pt-3", "pt-md-4", "pt-lg-5") }) {
                    H1(attrs = { classes("display-4", "text-light", "pb-2", "mb-4", "me-md-n5") }) {
                        Text("Brzo do pravog auta")
                    }
                    P(attrs = { classes("fs-lg", "text-light", "opacity-70") }) {
                        Text("Finder je vodeće digitalno tržište za automobilsku industriju koje povezuje kupce vozila s prodavateljima.")
                    }
                }

                // Right column (image)
                Div(attrs = { classes("col-lg-8", "col-md-7", "pt-md-5") }) {
                    Img(
                        src = "img/car-finder/home/hero-img.png",
                        alt = "Automobil",
                        attrs = { classes("d-block", "mt-4", "ms-auto"); attr("width", "800") }
                    )
                }
            }
        }

        // Search + Tabs container
        Div(attrs = { classes("container", "mt-4", "mt-sm-3", "mt-lg-n3", "pb-5", "mb-md-4") }) {
            // Kartice
            Ul(attrs = { classes("nav", "nav-tabs", "nav-tabs-light", "mb-4") }) {
                Li(attrs = { classes("nav-item") }) {
                    A("#", attrs = { classes("nav-link", "active") }) { Text("Novi") }
                }
                Li(attrs = { classes("nav-item") }) {
                    A("#", attrs = { classes("nav-link") }) { Text("Rabljeni") }
                }
            }

            // Form
            Form(attrs = { classes("form-group", "form-group-light", "d-block") }) {
                Div(attrs = { classes("row", "g-0", "ms-lg-n2") }) {
                    // Ključne riječi input
                    Div(attrs = { classes("col-lg-2") }) {
                        Div(attrs = { classes("input-group", "border-end-lg", "border-light") }) {
                            Span(attrs = { classes("input-group-text", "text-muted", "ps-2", "ps-sm-3") }) {
                                I(attrs = { classes("fi-search") })
                            }
                            Input(type = InputType.Text, attrs = {
                                classes("form-control")
                                attr("name", "keywords")
                                attr("placeholder", "Ključne riječi...")
                            })
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-lg-none", "my-2") })

                    // Marka dropdown
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = {
                            classes("dropdown", "border-end-sm", "border-light")
                            attr("data-bs-toggle", "select")
                        }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-list", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text("Marka") }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "make") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.make.options.forEach { make ->
                                    Li {
                                        A("#", attrs = { onClick { it.preventDefault(); viewModel.selectMake(make) };  classes("dropdown-item") }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(make.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-sm-none", "my-2") })

                    // Model dropdown
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = {
                            classes("dropdown", "border-end-md", "border-light")
                            attr("data-bs-toggle", "select")
                        }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-list", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text("Model") }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "model") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.model.options.forEach { model ->
                                    Li {
                                        A("#", attrs = { onClick { it.preventDefault(); viewModel.selectModel(model) }; classes("dropdown-item") }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(model.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-md-none", "my-2") })

                    // Body type dropdown
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = {
                            classes("dropdown", "border-end-sm", "border-light")
                            attr("data-bs-toggle", "select")
                        }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-car", "fs-lg", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text("Karoserija") }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "type") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.bodyType.options.forEach { type ->
                                    Li {
                                        A("#", attrs = { onClick { it.preventDefault(); viewModel.selectBodyType(type) } ;classes("dropdown-item") }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(type.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-sm-none", "my-2") })

                    // Location dropdown
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = { classes("dropdown"); attr("data-bs-toggle", "select") }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-map-pin", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text("Lokacija") }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "location") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.location.options.forEach { loc ->
                                    Li {
                                        A("#", attrs = { onClick { it.preventDefault(); viewModel.selectLocation(loc) };classes("dropdown-item") }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(loc.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-lg-none", "my-2") })

                    // Search button
                    Div(attrs = { classes("col-lg-2") }) {
                        Button(attrs = {
                            classes("btn", "btn-primary", "w-100")
                            attr("type", "submit")
                        }) { Text("Pretraži") }
                    }
                }
            }
        }
    }
}