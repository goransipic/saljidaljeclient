package hr.goodapp.saljidaljeclient.components.sections.profile.common

import androidx.compose.runtime.*
import com.varabyte.kobweb.core.rememberPageContext
import hr.goodapp.saljidaljeclient.components.sections.profile.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun Content(sidebarItems: SidebarItems) {
    val ctx = rememberPageContext() // Get the router
    var item by remember(sidebarItems) { mutableStateOf(sidebarItems) }

    Sidebar(item) { menuItem,event ->
        event.preventDefault()
        item = menuItem
        ctx.router.navigateTo(menuItem.url)
    }
    when(item) {
        SidebarItems.PERSONAL_INFO -> PersonalInfoContent()
        SidebarItems.PASSWORD_SECURITY -> PasswordSecurityContent()
        SidebarItems.CARS -> CarsContent()
        SidebarItems.WHISH_LIST -> WishlistContent()
        SidebarItems.REVIEWS -> ReviewsContent()
        SidebarItems.NOTIFICATION -> NotificationContent()
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
            Div(attrs = { attr("data-bs-toggle", "tooltip"); attr("title", "Uredi") }) {
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
                        Text("Odaberite $label")
                    }
                    selectOptions.forEach { opt ->
                        Option(value = "Demo") { Text(opt) }
                    }
                }
            } else {
                Input(type = inputType, attrs = {
                    classes("form-control", "form-control-light", "mt-3")
                    attr("data-bs-binded-element", "#$collapseId-value")
                    attr("data-bs-unset-value", "Nije navedeno")
                    placeholder?.let { attr("placeholder", it) }
                    value(value)
                })
            }
        }
    }
}