package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun VehicleInformation() {
    Section(attrs = {
        classes("card", "card-light", "card-body", "border-0", "shadow-sm", "p-4", "mb-4")
        attr("id", "vehicle-info")
    }) {
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-car", "text-primary", "fs-5", "mt-n1", "me-2") })
            Text("Vehicle information")
        }

        Div(attrs = { classes("row", "pb-2") }) {
            // Make
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light") ; attr("for", "sc-make") }) {
                    Text("Make *")
                }
                Select(attrs = { classes("form-select", "form-select-light"); attr("id", "sc-make") }) {
                    Option(value = "",attrs = { attr("value",""); attr("disabled", "true"); attr("hidden","true") }) { Text("Select make") }
                    Option(value = "",attrs = { attr("value","Acura") }) { Text("Acura") }
                    Option(value = "",attrs = { attr("value","BMW") }) { Text("BMW") }
                    Option(value = "",attrs = { attr("value","Citroen") }) { Text("Citroen") }
                    Option(value = "",attrs = { attr("value","Lexus") }) { Text("Lexus") }
                    Option(value = "",attrs = { attr("value","Mercedes-Benz"); attr("selected","true") }) { Text("Mercedes-Benz") }
                    Option(value = "",attrs = { attr("value","Nissan") }) { Text("Nissan") }
                    Option(value = "",attrs = { attr("value","Toyota") }) { Text("Toyota") }
                }
            }

            // Model
            Div(attrs = { classes("col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for","sc-model") }) { Text("Model *") }
                Select(attrs = { classes("form-select", "form-select-light"); attr("id","sc-model") }) {
                    Option(value = "",attrs = { attr("value",""); attr("disabled","true"); attr("hidden","true") }) { Text("Select model") }
                    Option(value = "",attrs = { attr("value","A-Class") }) { Text("A-Class") }
                    Option(value = "",attrs = { attr("value","B-Class") }) { Text("B-Class") }
                    Option(value = "",attrs = { attr("value","C-Class") }) { Text("C-Class") }
                    Option(value = "",attrs = { attr("value","E 220") }) { Text("E 220") }
                    Option(value = "",attrs = { attr("value","E 400"); attr("selected","true") }) { Text("E 400") }
                    Option(value = "",attrs = { attr("value","GLS 550") }) { Text("GLS 550") }
                    Option(value = "",attrs = { attr("value","GLE-Class") }) { Text("GLE-Class") }
                    Option(value = "",attrs = { attr("value","ML 350") }) { Text("ML 350") }
                    Option(value = "",attrs = { attr("value","Viano") }) { Text("Viano") }
                }
            }

            // Year
            Div(attrs = { classes("col-md-3", "col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for","sc-year") }) { Text("Year *") }
                Select(attrs = { classes("form-select", "form-select-light"); attr("id","sc-year") }) {
                    Option(value = "",attrs = { attr("value",""); attr("disabled","true"); attr("hidden","true") }) { Text("Select year") }
                    Option(value = "",attrs = { attr("value","2021") }) { Text("2021") }
                    Option(value = "",attrs = { attr("value","2020") }) { Text("2020") }
                    Option(value = "",attrs = { attr("value","2019") }) { Text("2019") }
                    Option(value = "",attrs = { attr("value","2018"); attr("selected","true") }) { Text("2018") }
                    Option(value = "",attrs = { attr("value","2017") }) { Text("2017") }
                    Option(value = "",attrs = { attr("value","2016") }) { Text("2016") }
                    Option(value = "",attrs = { attr("value","2015") }) { Text("2015") }
                    Option(value = "",attrs = { attr("value","2014") }) { Text("2014") }
                    Option(value = "",attrs = { attr("value","2013") }) { Text("2013") }
                }
            }

            // Mileage
            Div(attrs = { classes("col-md-3", "col-sm-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for","sc-mileage") }) { Text("Mileage *") }
                Input(type = InputType.Number, attrs = {
                    classes("form-control", "form-control-light")
                    attr("id","sc-mileage")
                    attr("min","200")
                    attr("step","100")
                    attr("value","25000")
                    attr("placeholder","Enter mileage")
                })
            }

            // VIN
            Div(attrs = { classes("col-md-6", "mb-3") }) {
                Label(attrs = { classes("form-label", "text-light"); attr("for","sc-vin") }) { Text("VIN") }
                Input(type = InputType.Text, attrs = {
                    classes("form-control", "form-control-light")
                    attr("id","sc-vin")
                    attr("value","2VW821AU9JM754284")
                    attr("placeholder","Enter VIN code")
                })
            }
        }

        // Additional vehicle details
        Div(attrs = { classes("border-top", "border-light", "mt-2", "pt-4") }) {
            Div(attrs = { classes("row", "pb-2") }) {
                Div(attrs = { classes("col-md-6") }) {
                    val vehicleFields = listOf(
                        VehicleField("Body type", "sc-body", listOf("Compact","Convertible","Crossover","Coupe","Family MPV","Pickup","Sedan","SUV","Wagon"), "Convertible"),
                        VehicleField("Fuel type", "sc-fuel", listOf("Gasoline","Diesel","Hybrid","Electric"), "Gasoline"),
                        VehicleField("Engine", "sc-engine", listOf("1.5 Turbo 3 Cylinder Engine","2.4L 4 Cylinder Engine","3.5L 4 Cylinder Engine","2.5L Turbo 6 Cylinder"), "2.5L Turbo 6 Cylinder"),
                        VehicleField("Transmission", "sc-transmission", listOf("Manual","Automatic"), "Automatic"),
                        VehicleField("Drivetrain", "sc-drivetrain", listOf("Front Wheel Drive","Rear Wheel Drive","All Wheel Drive"), "Front Wheel Drive")
                    )

                    vehicleFields.forEach { field ->
                        Label(attrs = { classes("form-label","text-light"); attr("for", field.id) }) { Text("${field.label} *") }
                        Select(attrs = { classes("form-select","form-select-light","mb-3"); attr("id", field.id) }) {
                            Option(value = "", attrs = { attr("disabled","true"); attr("hidden","true") }) { Text("Select ${field.label}") }
                            field.options.forEach { item ->
                                Option(value = "", attrs = { attr("value", item); if(item == field.selected) attr("selected","true") }) { Text(item) }
                            }
                        }
                    }

                    // Color
                    Label(attrs = { classes("form-label", "text-light"); attr("for","sc-color") }) { Text("Color") }
                    Input(type = InputType.Text, attrs = {
                        classes("form-control","form-control-light","mb-3")
                        attr("id","sc-color")
                        attr("value","Aspen White")
                        attr("placeholder","Enter color")
                    })
                }
            }
        }

        // Description
        Div(attrs = { classes("border-top","border-light","mt-2","pt-4") }) {
            Label(attrs = { classes("form-label","text-light"); attr("for","sc-description") }) { Text("Description") }
            TextArea(attrs = { classes("form-control","form-control-light"); attr("id","sc-description"); attr("rows","5"); attr("placeholder","Describe your vehicle") })
            Span(attrs = { classes("form-text","text-light","opacity-50") }) { Text("3000 characters left") }
        }
    }
}

data class VehicleField(
    val label: String,
    val id: String,
    val options: List<String>,
    val selected: String
)