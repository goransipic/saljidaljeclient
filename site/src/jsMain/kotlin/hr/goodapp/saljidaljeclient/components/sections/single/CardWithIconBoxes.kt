package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun CardWithIconBoxes() {
    Div(attrs = { classes("card", "card-body", "p-4", "card-light", "mb-4") }) {
        Div(attrs = { classes("row", "row-cols-2", "row-cols-sm-4", "gx-3", "gx-xl-4", "gy-4") }) {
            IconBox("img/car-finder/icons/check.svg", "Checked and Certified by Finder")
            IconBox("img/car-finder/icons/steering-wheel.svg", "Single Owner")
            IconBox("img/car-finder/icons/driving-test.svg", "Well-Equipped")
            IconBox("img/car-finder/icons/accident.svg", "No Accident / Damage Reported")
        }
    }
}

@Composable
private fun IconBox(iconPath: String, text: String) {
    Div(attrs = { classes("col", "text-light", "text-center") }) {
        Div(attrs = { classes("d-table", "bg-dark", "rounded-3", "mx-auto", "p-3") }) {
            Img(src = iconPath, attrs = {
                attr("width", "48")
                attr("alt", "Icon")
            })
        }
        Div(attrs = { classes("fs-sm", "pt-2", "mt-1") }) {
            Text(text)
        }
    }
}