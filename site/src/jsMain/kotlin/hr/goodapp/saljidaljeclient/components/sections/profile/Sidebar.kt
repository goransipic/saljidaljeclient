package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import hr.goodapp.saljidaljeclient.components.layouts.SidebarItems
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.*

@Composable
fun Sidebar(sidebarItems: SidebarItems, onClicked: (SidebarItems) -> Unit) {
    Aside(attrs = { classes("col-lg-4", "col-md-5", "pe-xl-4", "mb-5") }) {
        AccountNav(sidebarItems,onClicked)
    }
}

@Composable
private fun AccountNav(sidebarItems: SidebarItems, onClicked: (SidebarItems) -> Unit) {
    Div(attrs = { classes("card", "card-body", "card-light", "border-0", "shadow-sm", "pb-1", "me-lg-1") }) {
        // Top profile row
        Div(attrs = { classes("d-flex", "d-md-block", "d-lg-flex", "align-items-start", "pt-lg-2", "mb-4") }) {
            Img(
                src = "/img/avatars/01.jpg",
                attrs = {
                    classes("rounded-circle")
                    attr("width", "48")
                    attr("alt", "Robert Fox")
                }
            )
            Div(attrs = { classes("pt-md-2", "pt-lg-0", "ps-3", "ps-md-0", "ps-lg-3") }) {
                H2(attrs = { classes("fs-lg", "text-light", "mb-0") }) {
                    Text("Robert Fox")
                }
                Span(attrs = { classes("star-rating") }) {
                    repeat(5) {
                        I(attrs = { classes("star-rating-icon", "fi-star-filled", "active") })
                    }
                }
                Ul(attrs = { classes("list-unstyled", "fs-sm", "mt-3", "mb-0") }) {
                    Li {
                        A(
                            href = "tel:3025550107",
                            attrs = { classes("nav-link-light", "fw-normal") }
                        ) {
                            I(attrs = { classes("fi-phone", "opacity-60", "me-2") })
                            Text("(302) 555-0107")
                        }
                    }
                    Li {
                        A(
                            href = "mailto:robert_fox@email.com",
                            attrs = { classes("nav-link-light", "fw-normal") }
                        ) {
                            I(attrs = { classes("fi-mail", "opacity-60", "me-2") })
                            Text("robert_fox@email.com")
                        }
                    }
                }
            }
        }

        // Action buttons
        A(href = "car-finder-sell-car.html", attrs = { classes("btn", "btn-primary", "btn-lg", "w-100", "mb-3") }) {
            I(attrs = { classes("fi-plus", "me-2") })
            Text("Sell car")
        }
        A(
            href = "#account-nav",
            attrs = {
                classes("btn", "btn-outline-light", "d-block", "d-md-none", "w-100", "mb-3")
                attr("data-bs-toggle", "collapse")
            }
        ) {
            I(attrs = { classes("fi-align-justify", "me-2") })
            Text("Menu")
        }
        // Collapsible navigation
        Div(attrs = { classes("collapse", "d-md-block", "mt-3"); id("account-nav") }) {
            Div(attrs = { classes("card-nav") }) {
                var isActive by remember(sidebarItems) { mutableStateOf(sidebarItems) }
                A(href = "#", attrs = { onClick { onClicked(SidebarItems.PERSONAL_INFO) }; classes(*listOfNotNull("card-nav-link", if (isActive == SidebarItems.PERSONAL_INFO) "active" else null).toTypedArray()) }) {
                    I(attrs = {
                        classes("fi-user", "me-2")
                    })
                    Text("Personal Info")
                }
                A(href = "#", attrs = { onClick { onClicked(SidebarItems.PASSWORD_SECURITY) };  classes(*listOfNotNull("card-nav-link", if (isActive == SidebarItems.PASSWORD_SECURITY) "active" else null).toTypedArray()) }) {
                    I(attrs = {
                        classes("fi-lock", "me-2")
                    })
                    Text("Password & Security")
                }
                A(href = "#", attrs = { onClick { onClicked(SidebarItems.CARS)}; classes(*listOfNotNull("card-nav-link", if (isActive == SidebarItems.CARS) "active" else null).toTypedArray()) }) {
                    I(attrs = { classes("fi-car", "me-2") })
                    Text("My Cars")
                }
                A(href = "#", attrs = { onClick { onClicked(SidebarItems.WHISH_LIST)}; classes(*listOfNotNull("card-nav-link", if (isActive == SidebarItems.WHISH_LIST) "active" else null).toTypedArray()) }) {
                    I(attrs = { classes("fi-heart", "me-2") })
                    Text("Wishlist")
                    Span(attrs = { classes("badge", "bg-faded-light", "ms-2") }) {
                        Text("4")
                    }
                }
                A(href = "car-finder-account-reviews.html", attrs = { classes("card-nav-link") }) {
                    I(attrs = { classes("fi-star", "me-2") })
                    Text("Reviews")
                }
                A(href = "car-finder-account-notifications.html", attrs = { classes("card-nav-link") }) {
                    I(attrs = { classes("fi-bell", "me-2") })
                    Text("Notifications")
                }
                A(href = "car-finder-help-center.html", attrs = { classes("card-nav-link") }) {
                    I(attrs = { classes("fi-help", "me-2") })
                    Text("Help")
                }
                A(href = "signin-dark.html", attrs = { classes("card-nav-link") }) {
                    I(attrs = { classes("fi-logout", "me-2") })
                    Text("Sign Out")
                }
            }
        }
    }
}





