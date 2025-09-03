package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.core.rememberPageContext
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.*

@Composable
fun Sidebar(sidebarItems: SidebarItems, onClicked: (SidebarItems, SyntheticMouseEvent) -> Unit) {
    Aside(attrs = { classes("col-lg-4", "col-md-5", "pe-xl-4", "mb-5") }) {
        AccountNav(sidebarItems, onClicked)
    }
}

@Composable
private fun AccountNav(sidebarItems: SidebarItems, onClicked: (SidebarItems, SyntheticMouseEvent) -> Unit) {
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
            Text("Prodaj auto")
        }
        A(
            href = "#account-nav",
            attrs = {
                classes("btn", "btn-outline-light", "d-block", "d-md-none", "w-100", "mb-3")
                attr("data-bs-toggle", "collapse")
            }
        ) {
            I(attrs = { classes("fi-align-justify", "me-2") })
            Text("Meni")
        }
        // Collapsible navigation
        Div(attrs = { classes("collapse", "d-md-block", "mt-3"); id("account-nav") }) {
            Div(attrs = { classes("card-nav") }) {
                var itemClicked by remember(sidebarItems) { mutableStateOf(sidebarItems) }
                A(
                    href = SidebarItems.PERSONAL_INFO.url,
                    attrs = {
                        onClick {
                            onClicked(
                                SidebarItems.PERSONAL_INFO,
                                it
                            )
                        }; classes(
                        *listOfNotNull(
                            "card-nav-link",
                            if (itemClicked == SidebarItems.PERSONAL_INFO) "active" else null
                        ).toTypedArray()
                    )
                    }) {
                    I(attrs = {
                        classes("fi-user", "me-2")
                    })
                    Text("Osobni podaci")
                }
                A(href = SidebarItems.PASSWORD_SECURITY.url, attrs = {
                    onClick { it ->
                        onClicked(SidebarItems.PASSWORD_SECURITY, it)
                    }; classes(
                    *listOfNotNull(
                        "card-nav-link",
                        if (itemClicked == SidebarItems.PASSWORD_SECURITY) "active" else null
                    ).toTypedArray()
                )
                }) {
                    I(attrs = {
                        classes("fi-lock", "me-2")
                    })
                    Text("Lozinka i sigurnost")
                }
                A(href = SidebarItems.CARS.url, attrs = {
                    onClick {
                        onClicked(SidebarItems.CARS, it)
                    }; classes(
                    *listOfNotNull(
                        "card-nav-link",
                        if (itemClicked == SidebarItems.CARS) "active" else null
                    ).toTypedArray()
                )
                }) {
                    I(attrs = { classes("fi-car", "me-2") })
                    Text("Moji automobili")
                }
                A(
                    href = SidebarItems.WHISH_LIST.url,
                    attrs = {
                        onClick {
                            onClicked(
                                SidebarItems.WHISH_LIST,
                                it
                            )
                        }; classes(
                        *listOfNotNull(
                            "card-nav-link",
                            if (itemClicked == SidebarItems.WHISH_LIST) "active" else null
                        ).toTypedArray()
                    )
                    }) {
                    I(attrs = { classes("fi-heart", "me-2") })
                    Text("Lista želja")
                    Span(attrs = { classes("badge", "bg-faded-light", "ms-2") }) {
                        Text("4")
                    }
                }
                A(
                    href = SidebarItems.REVIEWS.url,
                    attrs = {
                        onClick { onClicked(SidebarItems.REVIEWS, it) }; classes(
                        *listOfNotNull(
                            "card-nav-link",
                            if (itemClicked == SidebarItems.REVIEWS) "active" else null
                        ).toTypedArray()
                    )
                    }) {
                    I(attrs = { classes("fi-star", "me-2") })
                    Text("Recenzije")
                }
                A(
                    href = SidebarItems.NOTIFICATION.url,
                    attrs = {
                        onClick {
                            onClicked(
                                SidebarItems.NOTIFICATION,
                                it
                            )
                        }; classes(
                        *listOfNotNull(
                            "card-nav-link",
                            if (itemClicked == SidebarItems.NOTIFICATION) "active" else null
                        ).toTypedArray()
                    )
                    }) {
                    I(attrs = { classes("fi-bell", "me-2") })
                    Text("Obavijesti")
                }
                val ctx = rememberPageContext()
                A(href = "/profile/help-center", attrs = { onClick {
                    it.preventDefault()
                    ctx.router.navigateTo("/profile/help-center")
                };classes("card-nav-link") }) {
                    I(attrs = { classes("fi-help", "me-2") })
                    Text("Pomoć")
                }

                A(
                    href = "/",
                    attrs = {
                        onClick {
                            it.preventDefault();
                            ctx.router.navigateTo("/")
                        }; classes("card-nav-link")
                    }) {
                    I(attrs = { classes("fi-logout", "me-2") })
                    Text("Odjava")
                }
            }
        }
    }
}





