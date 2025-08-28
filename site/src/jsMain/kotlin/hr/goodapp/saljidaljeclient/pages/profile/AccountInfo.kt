package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.common.Breadcrumb
import hr.goodapp.saljidaljeclient.components.sections.profile.Sidebar
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
@Page("index")
@Layout(".components.layouts.PageLayout")
fun AccountInfo() {
    Div(attrs = { classes("container", "pt-5", "pb-lg-4", "mt-5", "mb-sm-2") }) {
        Breadcrumb()
        Div (attrs = {classes("row")}) {
            Sidebar()
            Content()
        }
    }
}

@Composable
fun Content() {
    Div(attrs = { classes("col-lg-8", "col-md-7", "mb-5") }) {
        H1(attrs = { classes("h2", "text-light") }) { Text("Personal Info") }
        Div(attrs = { classes("text-light", "mb-2", "pt-1") }) {
            Text("Your personal info is 50% completed")
        }

        // Progress bar
        Div(attrs = { classes("progress", "progress-light", "mb-4"); style { property("height", ".25rem") } }) {
            Div(attrs = {
                classes("progress-bar", "bg-warning")
                attr("role", "progressbar")
                style { property("width", "50%") }
                attr("aria-valuenow", "50")
                attr("aria-valuemin", "0")
                attr("aria-valuemax", "100")
            })
        }

        Div(attrs = { classes("row", "pt-2") }) {
            // Left column (personal info fields)
            Div(attrs = { classes("col-lg-9", "col-md-12", "col-sm-8", "mb-2", "mb-m-4") }) {
                Div(attrs = { classes("border", "border-light", "rounded-3", "p-3", "mb-4"); id("personal-info") }) {
                    // Fields
                    fieldBlock("Full name", "Robert Fox", "name")
                    fieldBlock(
                        "Gender",
                        "Not specified",
                        "gender",
                        isSelect = true,
                        selectOptions = listOf("Male", "Female")
                    )
                    fieldBlock("Email", "robert_fox@email.com", "email", InputType.Email)
                    fieldBlock("Phone number", "(302) 555-0107", "phone")
                    fieldBlock("Address", "Not specified", "address", withBorder = false ,placeholder = "Enter address")
                }
            }

            // Right column (profile picture + info)
            Div(attrs = { classes("col-lg-3", "col-md-12", "col-sm-4", "mb-4") }) {
                Input(type = InputType.File, attrs = {
                    classes("file-uploader", "border-light", "bg-faded-light")
                    attr("accept", "image/png, image/jpeg")
                    attr(
                        "data-label-idle",
                        """<i class="d-inline-block fi-camera-plus fs-2 text-light text-muted mb-2"></i><br><span class="fw-bold text-light opacity-70">Change picture</span>"""
                    )
                    attr("data-style-panel-layout", "compact")
                    attr("data-image-preview-height", "160")
                    attr("data-image-crop-aspect-ratio", "1:1")
                    attr("data-image-resize-target-width", "200")
                    attr("data-image-resize-target-height", "200")
                })
                Div(attrs = { classes("pt-4", "pb-2", "py-lg-5") }) {
                    H6(attrs = { classes("text-light", "mb-2") }) { Text("Who can see my profile?") }
                    P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                        Text("Your profile is private. No one else will see it until a reservation is confirmed.")
                    }
                }
            }
        }

        // Action buttons
        Div(attrs = { classes("row") }) {
            Div(attrs = { classes("col-lg-9") }) {
                Div(attrs = { classes("d-flex", "align-items-center", "justify-content-between", "pb-1") }) {
                    Button(attrs = { classes("btn", "btn-primary"); type(ButtonType.Button) }) { Text("Save changes") }
                    Button(attrs = {
                        classes(
                            "btn",
                            "btn-link",
                            "btn-light",
                            "btn-sm",
                            "px-0"
                        ); type(ButtonType.Button)
                    }) {
                        I(attrs = { classes("fi-trash", "me-2") })
                        Text("Delete account")
                    }
                }
            }
        }
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
