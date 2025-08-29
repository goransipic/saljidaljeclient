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
            Text("Features")
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
            Text("Interior")
        }

        // Visible checkboxes
        Div(attrs = { classes("row") }) {
            val columns = listOf(
                listOf("ac" to "Multi-zone A/C", "heated-seats" to "Heated front seats"),
                listOf("navi" to "Navigation system", "leather-seats" to "Leather seats"),
                listOf("wipers" to "Intermittent wipers", "memory-seat" to "Memory seat")
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
                    listOf("premium-sound" to "Premium sound system", "bluetooth" to "Bluetooth"),
                    listOf("usb" to "USB port", "leather-wheel" to "Leather steering wheel"),
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
                attr("data-bs-label-collapsed", "Show more")
                attr("data-bs-label-expanded", "Show less")
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
            Text("Exterior")
        }

        Div(attrs = { classes("row") }) {
            // First column
            Div(attrs = { classes("col-sm-4") }) {
                listOf(
                    "alloy-wheels" to "Alloy wheels",
                    "sunroof" to "Sunroof / moonroof"
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
                    "panoramic-roof" to "Panoramic roof",
                    "tinted-glass" to "Tinted glass"
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
            Text("Safety")
        }

        // Visible checkboxes
        Div(attrs = { classes("row") }) {
            val columns = listOf(
                listOf("airbag-driver" to "Airbag: driver", "airbag-pasenger" to "Airbag: passenger"),
                listOf("alarm" to "Alarm", "antilock" to "Antilock brakes"),
                listOf("stability-control" to "Stability control", "fog-lights" to "Fog lights")
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
                    listOf("adaptive-cruise" to "Adaptive cruise control", "blind-monitor" to "Blind spot monitor"),
                    listOf("brake-assist" to "Brake assist", "lane-warning" to "Lane departure warning")
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
                attr("data-bs-label-collapsed", "Show more")
                attr("data-bs-label-expanded", "Show less")
                attr("role", "button")
                attr("aria-expanded", "false")
                attr("aria-controls", "moreSafety")
            }
        ) {}
    }
}

