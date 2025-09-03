package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.*

@Composable
fun FiltersSidebar() {
    Div(attrs = { classes("col-lg-3", "pe-xl-4") }) {
        Div(attrs = {
            classes("offcanvas-lg", "offcanvas-start", "bg-dark")
            id("filters-sidebar")
        }) {
            // === Header (mobilno) ===
            Div(attrs = { classes("offcanvas-header", "bg-transparent", "d-flex", "d-lg-none", "align-items-center") }) {
                H2(attrs = { classes("h5", "text-light", "mb-0") }) { Text("Filtri") }
                Button(attrs = {
                    classes("btn-close", "btn-close-white")
                    attr("type", "button")
                    attr("data-bs-dismiss", "offcanvas")
                    attr("data-bs-target", "#filters-sidebar")
                })
            }

            // === Tabs header ===
            Div(attrs = { classes("offcanvas-header", "bg-transparent", "d-block", "border-bottom", "border-light", "pt-0", "pt-lg-4", "px-lg-0") }) {
                Ul(attrs = { classes("nav", "nav-tabs", "nav-tabs-light", "mb-0") }) {
                    Li(attrs = { classes("nav-item") }) {
                        A("#", attrs = { classes("nav-link") }) { Text("Novi") }
                    }
                    Li(attrs = { classes("nav-item") }) {
                        A("#", attrs = { classes("nav-link", "active") }) { Text("Rabljeni") }
                    }
                }
            }

            // === Body ===
            Div(attrs = { classes("offcanvas-body", "py-lg-4") }) {

                // --- Selection pills ---
                Div(attrs = { classes("pb-3", "mb-4", "border-bottom", "border-light") }) {
                    Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "mb-3") }) {
                        H3(attrs = { classes("h6", "text-light", "mb-0") }) { Text("Odabir") }
                        Button(attrs = {
                            classes("btn", "btn-link", "btn-light", "fw-normal", "fs-sm", "p-0")
                            attr("type", "button")
                        }) { Text("Obriši sve") }
                    }
                    Ul(attrs = { classes("nav", "nav-pills", "nav-pills-light", "flex-row", "fs-sm", "mx-0") }) {
                        listOf("Ispod 2019", "Crossover", "Limuzina", "SUV", "Dizel", "Benzin", "Hibrid").forEach { pill ->
                            Li(attrs = { classes("nav-item", "mb-2", "me-2") }) {
                                Button(attrs = { classes("nav-link", "px-3"); attr("type", "button") }) {
                                    Text(pill)
                                    I(attrs = { classes("fi-x", "fs-xxs", "ms-2") })
                                }
                            }
                        }
                    }
                }

                // --- Location ---
                SectionDropdown("Lokacija", "Odaberi lokaciju",
                    listOf("Chicago", "Dallas", "Los Angeles", "New York", "San Diego")
                )

                // --- Body Type ---
                CheckboxGroup("Tip karoserije", 11.cssRem, listOf(
                    Triple("sedan", "Limuzina", true),
                    Triple("suv", "SUV", true),
                    Triple("wagon", "Karavan", false),
                    Triple("crossover", "Crossover", true),
                    Triple("coupe", "Coupe", false),
                    Triple("pickup", "Pickup", false),
                    Triple("sport", "Sportski coupe", false),
                    Triple("compact", "Kompakt", false),
                    Triple("convertible", "Kabriolet", false),
                    Triple("mpv", "Obiteljski MPV", false),
                ))

                // --- Year ---
                Div(attrs = { classes("pb-4", "mb-2") }) {
                    H3(attrs = { classes("h6", "text-light", "pt-1") }) { Text("Godina") }
                    Div(attrs = { classes("d-flex", "align-items-center") }) {
                        Select(attrs = { classes("form-select", "form-select-light", "w-100") }) {
                            Option("", attrs = { attr("disabled", "true"); attr("selected", "true") }) { Text("Od") }
                            (2021 downTo 2010).forEach { Option(it.toString()) { Text(it.toString()) } }
                        }
                        Div(attrs = { classes("mx-2") }) { Text("—") }
                        Select(attrs = { classes("form-select", "form-select-light", "w-100") }) {
                            Option("", attrs = { attr("disabled", "true") }) { Text("Do") }
                            (2021 downTo 2010).forEach { year ->
                                if (year == 2019) Option(year.toString(), attrs = { attr("selected", "true") }) { Text(year.toString()) }
                                else Option(year.toString()) { Text(year.toString()) }
                            }
                        }
                    }
                }

                // --- Make & Model ---
                Div(attrs = { classes("pb-4", "mb-2") }) {
                    H3(attrs = { classes("h6", "text-light") }) { Text("Marka & Model") }
                    Select(attrs = { classes("form-select", "form-select-light", "mb-2") }) {
                        Option("", attrs = { attr("disabled", "true"); attr("selected", "true") }) { Text("Bilo koja marka") }
                        listOf("Audi", "Infiniti", "Honda", "Hyundai", "Lexus", "Mazda", "Mitsubishi",
                            "Mercedes-Benz", "Nissan", "Opel", "Renault", "Toyota").forEach {
                            Option(it) { Text(it) }
                        }
                    }
                    Select(attrs = { classes("form-select", "form-select-light", "mb-1") }) {
                        Option("", attrs = { attr("disabled", "true"); attr("selected", "true") }) { Text("Bilo koji model") }
                        listOf("Altima", "Juke", "Leaf", "Maxima", "Micra", "Murano", "Note", "Pathfinder", "Patrol").forEach {
                            Option(it) { Text(it) }
                        }
                    }
                }

                // --- Price ---
                Div(attrs = { classes("pb-4", "mb-2") }) {
                    H3(attrs = { classes("h6", "text-light") }) { Text("Cijena") }
                    Div(attrs = {
                        classes("range-slider", "range-slider-light", "mb-3")
                        attr("data-start-min", "25000")
                        attr("data-start-max", "65000")
                        attr("data-min", "4000")
                        attr("data-max", "100000")
                        attr("data-step", "1000")
                    }) {
                        Div(attrs = { classes("range-slider-ui") })
                        Div(attrs = { classes("d-flex", "align-items-center") }) {
                            Div(attrs = { classes("w-50", "pe-2") }) {
                                Input(InputType.Text, attrs = { classes("form-control", "form-control-light", "range-slider-value-min") })
                            }
                            Div(attrs = { classes("text-muted") }) { Text("—") }
                            Div(attrs = { classes("w-50", "ps-2") }) {
                                Input(InputType.Text, attrs = { classes("form-control", "form-control-light", "range-slider-value-max") })
                            }
                        }
                    }
                    Div(attrs = { classes("form-check", "form-switch", "form-switch-light") }) {
                        Input(InputType.Checkbox, attrs = { classes("form-check-input"); id("negotiated-price") })
                        Label(forId = "negotiated-price", attrs = { classes("form-check-label", "fs-sm") }) { Text("Dogovorena cijena") }
                    }
                }

                // --- Drivetrain ---
                CheckboxGroup("Pogon", null, listOf(
                    Triple("awd", "AWD/4WD", false),
                    Triple("front-wheel", "Prednji pogon", false),
                    Triple("rear-wheel", "Stražnji pogon", false),
                ))

                // --- Fuel Type ---
                CheckboxGroup("Gorivo", null, listOf(
                    Triple("diesel", "Dizel", true),
                    Triple("electric", "Električno", false),
                    Triple("gasoline", "Benzin", true),
                    Triple("hybrid", "Hibrid", true),
                    Triple("hydrogen", "Vodik", false),
                    Triple("plugin", "Plug-in Hibrid", false),
                ))

                // --- Transmission ---
                CheckboxGroup("Mjenjač", null, listOf(
                    Triple("auto", "Automatski", false),
                    Triple("manual", "Ručni", false),
                ))

                // --- Mileage ---
                Div(attrs = { classes("pb-4", "mb-2") }) {
                    H3(attrs = { classes("h6", "text-light", "pt-1") }) { Text("Kilometraža") }
                    Div(attrs = { classes("d-flex", "align-items-center") }) {
                        Input(InputType.Number, attrs = {
                            classes("form-control", "form-control-light", "w-100")
                            attr("min", "0")
                            attr("step", "500")
                            attr("placeholder", "Od")
                        })
                        Div(attrs = { classes("mx-2") }) { Text("—") }
                        Input(InputType.Number, attrs = {
                            classes("form-control", "form-control-light", "w-100")
                            attr("min", "0")
                            attr("step", "500")
                            attr("placeholder", "Do")
                        })
                    }
                }

                // --- Color ---
                CheckboxGroup("Boja", 11.cssRem, listOf(
                    Triple("amber", "Jantar", false),
                    Triple("azure", "Azur", false),
                    Triple("beige", "Bež", false),
                    Triple("black", "Crna", false),
                    Triple("blue", "Plava", false),
                    Triple("brown", "Smeđa", false),
                    Triple("camouflage", "Zelena maskirna", false),
                    Triple("charcoal", "Ugljena", false),
                    Triple("gray", "Siva", false),
                    Triple("green", "Zelena", false),
                    Triple("gold", "Zlatna", false),
                    Triple("purple", "Ljubičasta", false),
                    Triple("red", "Crvena", false),
                    Triple("white", "Bijela", false),
                    Triple("yellow", "Žuta", false),
                ))

                // --- Sellers ---
                CheckboxGroup("Prodavači", null, listOf(
                    Triple("dealers", "Samo trgovci", false),
                    Triple("private-sellers", "Samo privatni prodavači", false),
                ))
            }
        }
    }
}

/* ---------- Helpers ---------- */

// Dropdown section
@Composable
private fun SectionDropdown(title: String, placeholder: String, options: List<String>) {
    Div(attrs = { classes("pb-4", "mb-2") }) {
        H3(attrs = { classes("h6", "text-light") }) { Text(title) }
        Select(attrs = { classes("form-select", "form-select-light", "mb-2") }) {
            Option("", attrs = { attr("disabled", "true"); attr("selected", "true") }) { Text(placeholder) }
            options.forEach { Option(it) { Text(it) } }
        }
    }
}

// Checkbox group with optional scroll
@Composable
private fun CheckboxGroup(title: String, scrollHeight: CSSLengthOrPercentageValue?, items: List<Triple<String, String, Boolean>>) {
    Div(attrs = { classes("pb-4", "mb-2") }) {
        H3(attrs = { classes("h6", "text-light") }) { Text(title) }
        if (scrollHeight != null) {
            Div(attrs = {
                classes("overflow-auto")
                attr("data-simplebar", "")
                attr("data-simplebar-auto-hide", "false")
                attr("data-simplebar-inverse", "")
                attr("style", "height: $scrollHeight;")
            }) {
                items.forEach { (id, label, checked) ->
                    CheckboxItem(id, label, checked)
                }
            }
        } else {
            items.forEach { (id, label, checked) ->
                CheckboxItem(id, label, checked)
            }
        }
    }
}

@Composable
private fun CheckboxItem(id: String, label: String, checked: Boolean) {
    Div(attrs = { classes("form-check", "form-check-light") }) {
        Input(InputType.Checkbox, attrs = {
            classes("form-check-input")
            id(id)
            if (checked) attr("checked", "true")
        })
        Label(forId = id, attrs = { classes("form-check-label", "fs-sm") }) { Text(label) }
    }
}