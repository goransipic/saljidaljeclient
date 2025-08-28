package hr.goodapp.saljidaljeclient.components.sections.profile.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import hr.goodapp.saljidaljeclient.components.layouts.SidebarItems
import hr.goodapp.saljidaljeclient.components.sections.profile.CarsContent
import hr.goodapp.saljidaljeclient.components.sections.profile.PasswordSecurityContent
import hr.goodapp.saljidaljeclient.components.sections.profile.PersonalInfoContent
import hr.goodapp.saljidaljeclient.components.sections.profile.Sidebar
import hr.goodapp.saljidaljeclient.components.sections.profile.WishlistContent
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Text

@Composable
fun Content(sidebarItems: SidebarItems) {
    var item by remember { mutableStateOf(sidebarItems) }
    Sidebar(item) {
        item = it
    }
    when(item) {
        SidebarItems.PERSONAL_INFO -> PersonalInfoContent()
        SidebarItems.PASSWORD_SECURITY -> PasswordSecurityContent()
        SidebarItems.CARS -> CarsContent()
        SidebarItems.WHISH_LIST -> WishlistContent()
    }

}

// Helper function for a field
@Composable
fun fieldBlock(
    label: String,
    value: String,
    collapseId: String,
    inputType: InputType<String> = InputType.Text,
    placeholder: String? = null,
    isSelect: Boolean = false,
    withBorder: Boolean = true,
    selectOptions: List<String> = emptyList()
) {
    Div(attrs = {
        if (withBorder){
            classes("border-bottom", "border-light", "pb-3", "mb-3")
        }
    }) {
        Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between") }) {
            Div(attrs = { classes("pe-2", "opacity-70") }) {
                Label(attrs = { classes("form-label", "fw-bold", "text-light") }) { Text(label) }
                Div(attrs = { classes("text-light"); id("$collapseId-value") }) { Text(value) }
            }
            Div(attrs = { attr("data-bs-toggle", "tooltip"); attr("title", "Edit") }) {
                A(href = "#$collapseId-collapse", attrs = {
                    classes("nav-link", "nav-link-light", "py-0")
                    attr("data-bs-toggle", "collapse")
                }) {
                    I(attrs = { classes("fi-edit") })
                }
            }
        }
        Div(attrs = {
            classes("collapse")
            id("$collapseId-collapse")
            attr("data-bs-parent", "#personal-info")
        }) {
            if (isSelect) {
                Select(attrs = {
                    classes("form-select", "form-select-light", "mt-3")
                    attr("data-bs-binded-element", "#$collapseId-value")
                }) {
                    Option(
                        value = "",
                        attrs = { attr("value", ""); attr("disabled", "true"); attr("selected", "true") }) {
                        Text("Select your $label")
                    }
                    selectOptions.forEach { opt ->
                        Option(value = "Demo") { Text(opt) }
                    }
                }
            } else {
                Input(type = inputType, attrs = {
                    classes("form-control", "form-control-light", "mt-3")
                    attr("data-bs-binded-element", "#$collapseId-value")
                    attr("data-bs-unset-value", "Not specified")
                    placeholder?.let { attr("placeholder", it) }
                    value(value)
                })
            }
        }
    }
}