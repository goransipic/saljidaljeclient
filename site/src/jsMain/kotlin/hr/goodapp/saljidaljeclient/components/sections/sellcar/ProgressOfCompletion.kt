package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun ProgressOfCompletion() {
    Aside(attrs = {
        classes("col-lg-3", "offset-lg-1", "d-none", "d-lg-block")
    }) {
        Div(attrs = { classes("sticky-top", "pt-5") }) {
            H6(attrs = { classes("text-light", "pt-5", "mt-3", "mb-2") }) {
                Text("80% sadržaja popunjeno")
            }

            // Progress bar
            Div(attrs = {
                classes("progress", "progress-light", "mb-4")
                style { property("height", ".25rem") }
            }) {
                Div(attrs = {
                    classes("progress-bar", "bg-success")
                    attr("role", "progressbar")
                    style { property("width", "80%") }
                    attr("aria-valuenow", "80")
                    attr("aria-valuemin", "0")
                    attr("aria-valuemax", "100")
                })
            }

            // Navigation checklist
            Ul(attrs = { classes("list-unstyled") }) {
                SidebarItem("#basic-info", "Osnovne informacije", completed = true)
                SidebarItem("#price", "Cijena", completed = true)
                SidebarItem("#vehicle-info", "Podaci o vozilu", completed = true)
                SidebarItem("#features", "Karakteristike", completed = false)
                SidebarItem("#photos", "Fotografije / video", completed = false)
                SidebarItem("#location", "Lokacija", completed = true)
                SidebarItem("#contacts", "Kontakt", completed = true)
            }
        }
    }
}

@Composable
private fun SidebarItem(href: String, label: String, completed: Boolean) {
    Li(attrs = { classes("d-flex", "align-items-center") }) {
        I(attrs = {
            val iconClasses = buildList {
                add("fi-check")
                add("me-2")
                if (completed) add("text-primary")
                else {
                    add("text-light")
                    add("opacity-60")
                }
            }
            classes(*iconClasses.toTypedArray())
        })
        A(href, attrs = {
            classes("nav-link-light", "ps-1")
            attr("data-scroll", "")
            attr("data-scroll-offset", "20")
        }) {
            Text(label)
        }
    }
}