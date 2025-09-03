package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun FeaturesSection() {
    Section(attrs = {
        classes("card", "card-light", "card-body", "border-0", "shadow-sm", "p-4", "mb-4")
        attr("id", "features")
    }) {
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-check-circle", "text-primary", "fs-5", "mt-n1", "me-2") })
            Text("Značajke")
        }
        Exterior()
        Interior()
        SafetyFeatures()
    }
}
@Composable
private fun Interior() {
    Div(attrs = { classes("mb-4") }) {
        Label(attrs = { classes("form-label", "d-block", "text-light", "fw-bold", "mb-2", "pb-1") }) {
            Text("Unutrašnjost")
        }

        // Visible checkboxes
        Div(attrs = { classes("row") }) {
            val columns = listOf(
                listOf("ac" to "Višezonska klima", "heated-seats" to "Grijana prednja sjedala"),
                listOf("navi" to "Navigacijski sustav", "leather-seats" to "Kožna sjedala"),
                listOf("wipers" to "Interval brisača", "memory-seat" to "Sjedalo s memorijom")
            )
            columns.forEach { colItems ->
                Div(attrs = { classes("col-sm-4") }) {
                    colItems.forEach { (id, labelText) ->
                        Div(attrs = { classes("form-check", "form-check-light") }) {
                            Input(type = InputType.Checkbox, attrs = {
                                classes("form-check-input")
                                attr("id", id)
                            })
                            Label(attrs = {
                                classes("form-check-label")
                                attr("for", id)
                            }) { Text(labelText) }
                        }
                    }
                }
            }
        }

        // Collapsible extra checkboxes
        Div(attrs = { classes("collapse"); attr("id", "moreInterior") }) {
            Div(attrs = { classes("row") }) {
                val moreColumns = listOf(
                    listOf("premium-sound" to "Premium audio sustav", "bluetooth" to "Bluetooth"),
                    listOf("usb" to "USB priključak", "leather-wheel" to "Kožni upravljač"),
                    listOf("apple-play" to "Apple CarPlay", "android-auto" to "Android Auto")
                )
                moreColumns.forEach { colItems ->
                    Div(attrs = { classes("col-sm-4") }) {
                        colItems.forEach { (id, labelText) ->
                            Div(attrs = { classes("form-check", "form-check-light") }) {
                                Input(type = InputType.Checkbox, attrs = {
                                    classes("form-check-input")
                                    attr("id", id)
                                })
                                Label(attrs = {
                                    classes("form-check-label")
                                    attr("for", id)
                                }) { Text(labelText) }
                            }
                        }
                    }
                }
            }
        }

        // Collapse toggle link
        A(
            href = "#moreInterior",
            attrs = {
                classes("collapse-label", "collapsed", "fs-sm")
                attr("data-bs-toggle", "collapse")
                attr("data-bs-label-collapsed", "Prikaži više")
                attr("data-bs-label-expanded", "Prikaži manje")
                attr("role", "button")
                attr("aria-expanded", "false")
                attr("aria-controls", "moreInterior")
            }
        ) {}
    }
}

@Composable
private fun Exterior() {
    Div(attrs = { classes("mb-4") }) {
        Label(attrs = { classes("form-label", "d-block", "text-light", "fw-bold", "mb-2", "pb-1") }) {
            Text("Vanjski dio")
        }

        Div(attrs = { classes("row") }) {
            // First column
            Div(attrs = { classes("col-sm-4") }) {
                listOf(
                    "alloy-wheels" to "Aluminijski naplatci",
                    "sunroof" to "Krov / pomični krov"
                ).forEach { (id, labelText) ->
                    Div(attrs = { classes("form-check", "form-check-light") }) {
                        Input(type = InputType.Checkbox, attrs = {
                            classes("form-check-input")
                            attr("id", id)
                        })
                        Label(attrs = {
                            classes("form-check-label")
                            attr("for", id)
                        }) { Text(labelText) }
                    }
                }
            }

            // Second column
            Div(attrs = { classes("col-sm-4") }) {
                listOf(
                    "panoramic-roof" to "Panoramski krov",
                    "tinted-glass" to "Zatmnjeno staklo"
                ).forEach { (id, labelText) ->
                    Div(attrs = { classes("form-check", "form-check-light") }) {
                        Input(type = InputType.Checkbox, attrs = {
                            classes("form-check-input")
                            attr("id", id)
                        })
                        Label(attrs = {
                            classes("form-check-label")
                            attr("for", id)
                        }) { Text(labelText) }
                    }
                }
            }
        }
    }
}

@Composable
private fun SafetyFeatures() {
    Div(attrs = { classes("mb-4") }) {
        Label(attrs = { classes("form-label", "d-block", "text-light", "fw-bold", "mb-2", "pb-1") }) {
            Text("Sigurnost")
        }

        // Visible checkboxes
        Div(attrs = { classes("row") }) {
            val columns = listOf(
                listOf("airbag-driver" to "Zračni jastuk: vozač", "airbag-pasenger" to "Zračni jastuk: suvozač"),
                listOf("alarm" to "Alarm", "antilock" to "ABS kočnice"),
                listOf("stability-control" to "Kontrola stabilnosti", "fog-lights" to "Maglenke")
            )
            columns.forEach { colItems ->
                Div(attrs = { classes("col-sm-4") }) {
                    colItems.forEach { (id, labelText) ->
                        Div(attrs = { classes("form-check", "form-check-light") }) {
                            Input(type = InputType.Checkbox, attrs = {
                                classes("form-check-input")
                                attr("id", id)
                            })
                            Label(attrs = {
                                classes("form-check-label")
                                attr("for", id)
                            }) { Text(labelText) }
                        }
                    }
                }
            }
        }

        // Collapsible extra checkboxes
        Div(attrs = { classes("collapse"); attr("id", "moreSafety") }) {
            Div(attrs = { classes("row") }) {
                val moreColumns = listOf(
                    listOf("adaptive-cruise" to "Adaptivni tempomat", "blind-monitor" to "Monitor mrtvog kuta"),
                    listOf("brake-assist" to "Pomoć pri kočenju", "lane-warning" to "Upozorenje za izlazak iz trake")
                )
                moreColumns.forEach { colItems ->
                    Div(attrs = { classes("col-sm-4") }) {
                        colItems.forEach { (id, labelText) ->
                            Div(attrs = { classes("form-check", "form-check-light") }) {
                                Input(type = InputType.Checkbox, attrs = {
                                    classes("form-check-input")
                                    attr("id", id)
                                })
                                Label(attrs = {
                                    classes("form-check-label")
                                    attr("for", id)
                                }) { Text(labelText) }
                            }
                        }
                    }
                }
            }
        }

        // Collapse toggle link
        A(
            href = "#moreSafety",
            attrs = {
                classes("collapse-label", "collapsed", "fs-sm")
                attr("data-bs-toggle", "collapse")
                attr("data-bs-label-collapsed", "Prikaži više")
                attr("data-bs-label-expanded", "Prikaži manje")
                attr("role", "button")
                attr("aria-expanded", "false")
                attr("aria-controls", "moreSafety")
            }
        ) {}
    }
}

