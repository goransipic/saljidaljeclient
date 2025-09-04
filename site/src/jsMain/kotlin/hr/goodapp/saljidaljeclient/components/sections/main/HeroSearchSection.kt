package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import hr.goodapp.saljidaljeclient.DropdownProps
import hr.goodapp.saljidaljeclient.Option
import hr.goodapp.saljidaljeclient.SearchFormViewModel
import MockSearchRepositoryImpl
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.attributes.InputType

import org.jetbrains.compose.web.dom.*
import kotlin.collections.listOfNotNull

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
                    A(
                        "#",
                        attrs = {
                            onClick { it.preventDefault(); viewModel.setActiveTab("Novi") }
                            classes(
                                "nav-link",
                                *listOfNotNull(if (state.activeTab == "Novi") "active" else null).toTypedArray()
                            )
                        }) { Text("Novi") }
                }
                Li(attrs = { classes("nav-item") }) {
                    A(
                        "#",
                        attrs = {
                            onClick { it.preventDefault(); viewModel.setActiveTab("Rabljeni") }
                            classes(
                                "nav-link",
                                *listOfNotNull(if (state.activeTab == "Rabljeni") "active" else null).toTypedArray()
                            )
                        }) { Text("Rabljeni") }
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
                    var make by remember { mutableStateOf("Marka") }
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = {
                            classes("dropdown", "border-end-sm", "border-light")
                            /*attr("data-bs-toggle", "select")*/
                        }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-list", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text(make) }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "make") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.make.options.forEach { option ->
                                    Li {
                                        A(
                                            "#",
                                            attrs = {
                                                onClick {
                                                    viewModel.selectMake(option); make = option.name
                                                }; classes("dropdown-item")
                                            }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(option.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-sm-none", "my-2") })

                    // Model dropdown
                    var model by remember(make) { mutableStateOf("Model") }
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = {
                            classes("dropdown", "border-end-md", "border-light")
                            /*attr("data-bs-toggle", "select")*/
                        }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-list", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text(model) }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "model") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.model.options.forEach { option ->
                                    Li {
                                        A(
                                            "#",
                                            attrs = {
                                                onClick {
                                                    viewModel.selectModel(option); model = option.name
                                                }; classes("dropdown-item")
                                            }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(option.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-md-none", "my-2") })

                    // Body type dropdown
                    var body by remember(make) { mutableStateOf("Marka") }
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = {
                            classes("dropdown", "border-end-sm", "border-light")
                            /*attr("data-bs-toggle", "select")*/
                        }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-car", "fs-lg", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text(body) }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "type") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.bodyType.options.forEach { type ->
                                    Li {
                                        A(
                                            "#",
                                            attrs = {
                                                onClick {
                                                    viewModel.selectBodyType(type); body = type.name
                                                }; classes("dropdown-item")
                                            }) {
                                            Span(attrs = { classes("dropdown-item-label") }) { Text(type.name) }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Hr(attrs = { classes("hr-light", "d-sm-none", "my-2") })

                    // Location dropdown
                    var location by remember(make) { mutableStateOf("Lokacija") }
                    Div(attrs = { classes("col-lg-2", "col-md-3", "col-sm-6") }) {
                        Div(attrs = { classes("dropdown"); /*attr("data-bs-toggle", "select")*/ }) {
                            Button(attrs = {
                                classes("btn", "btn-link", "dropdown-toggle", "ps-2", "ps-sm-3")
                                attr("type", "button")
                                attr("data-bs-toggle", "dropdown")
                            }) {
                                I(attrs = { classes("fi-map-pin", "me-2") })
                                Span(attrs = { classes("dropdown-toggle-label") }) { Text(location) }
                            }
                            Input(type = InputType.Hidden, attrs = { attr("name", "location") })
                            Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                                state.location.options.forEach { loc ->
                                    Li {
                                        A(
                                            "#",
                                            attrs = {
                                                onClick {
                                                    viewModel.selectLocation(loc); location = loc.name
                                                }; classes("dropdown-item")
                                            }) {
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
                        }) {
                            val count = if (state.productCount != null) " (${state.productCount})" else ""
                            Text("Pretraži$count")
                        }
                    }
                }
            }
        }
    }
}