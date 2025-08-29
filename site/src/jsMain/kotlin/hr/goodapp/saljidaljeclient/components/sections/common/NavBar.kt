package hr.goodapp.saljidaljeclient.components.sections.common

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.rememberPageContext
import org.jetbrains.compose.web.dom.*

@Composable
fun NavbarBar() {
    Header(attrs = {
        classes("navbar", "navbar-expand-lg", "navbar-dark", "fixed-top")
        attr("data-scroll-header", "")
    }) {
        Div(attrs = { classes("container") }) {
            // Brand
            A(
                href = "/",
                attrs = { classes("navbar-brand", "me-3", "me-xl-4") }
            ) {
                Img(
                    src = "/img/logo/logo-light.svg",
                    alt = "Finder",
                    attrs = { attr("width", "116"); classes("d-block") }
                )
            }

            // Toggler
            Button(attrs = {
                classes("navbar-toggler", "ms-auto")
                attr("type", "button")
                attr("data-bs-toggle", "collapse")
                attr("data-bs-target", "#navbarNav")
                attr("aria-controls", "navbarNav")
                attr("aria-expanded", "false")
                attr("aria-label", "Toggle navigation")
            }) {
                Span(attrs = { classes("navbar-toggler-icon") })
            }

            // Sign in + Sell car
            A("#signin-modal", attrs = {
                classes("btn", "btn-link", "btn-light", "btn-sm", "d-none", "d-lg-block", "order-lg-3")
                attr("data-bs-toggle", "modal")
            }) {
                I(attrs = { classes("fi-user", "me-2") })
                Text("Sign in")
            }
            val ctx = rememberPageContext()
            A("/sell-car", attrs = { onClick {
                it.preventDefault()
                ctx.router.navigateTo("/sell-car")
            }
                classes("btn", "btn-primary", "btn-sm", "ms-2", "order-lg-3")
            }) {
                I(attrs = { classes("fi-plus", "me-2") })
                Text("Sell car")
            }

            // Collapse section
            Div(attrs = {
                classes("collapse", "navbar-collapse", "order-lg-2")
                id("navbarNav")
            }) {
                Ul(attrs = {
                    classes("navbar-nav", "navbar-nav-scroll")
                    style { property("max-height", "35rem") }
                }) {
                    // Demos dropdown
                    Li(attrs = { classes("nav-item", "dropdown", "me-lg-2") }) {
                        A("#", attrs = {
                            classes("nav-link", "dropdown-toggle", "align-items-center", "pe-lg-4")
                            attr("data-bs-toggle", "dropdown")
                            attr("role", "button")
                            attr("aria-expanded", "false")
                        }) {
                            I(attrs = { classes("fi-layers", "me-2") })
                            Text("Demos")
                            Span(attrs = {
                                classes(
                                    "d-none", "d-lg-block", "position-absolute",
                                    "top-50", "end-0", "translate-middle-y",
                                    "border-end", "border-light"
                                )
                                style { property("width", "1px"); property("height", "30px") }
                            })
                        }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            Li { A("real-estate-home-v1.html", attrs = { classes("dropdown-item") }) { Text("Real Estate Demo") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("car-finder-home.html", attrs = { classes("dropdown-item") }) { Text("Car Finder Demo") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("job-board-home-v1.html", attrs = { classes("dropdown-item") }) { Text("Job Board Demo") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("city-guide-home-v1.html", attrs = { classes("dropdown-item") }) { Text("City Guide Demo") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("index.html", attrs = { classes("dropdown-item") }) { Text("Main Page") } }
                            Li { A("components/typography.html", attrs = { classes("dropdown-item") }) { Text("Components") } }
                            Li { A("docs/dev-setup.html", attrs = { classes("dropdown-item") }) { Text("Documentation") } }
                        }
                    }

                    // Home link
                    Li(attrs = { classes("nav-item", "active") }) {
                        A("car-finder-home.html", attrs = { classes("nav-link") }) { Text("Home") }
                    }

                    // Catalog dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = {
                            classes("nav-link", "dropdown-toggle")
                            attr("data-bs-toggle", "dropdown")
                            attr("role", "button")
                            attr("aria-expanded", "false")
                        }) { Text("Catalog") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            Li { A("car-finder-catalog-list.html", attrs = { classes("dropdown-item") }) { Text("List View") } }
                            Li { A("car-finder-catalog-grid.html", attrs = { classes("dropdown-item") }) { Text("Grid View") } }
                            Li { A("car-finder-single.html", attrs = { classes("dropdown-item") }) { Text("Car Single Page") } }
                        }
                    }

                    // Account dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = { classes("nav-link", "dropdown-toggle"); attr("data-bs-toggle", "dropdown"); attr("role","button"); attr("aria-expanded","false") }) { Text("Account") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            listOf(
                                "Personal Info" to "car-finder-account-info.html",
                                "Password & Security" to "car-finder-account-security.html",
                                "My Cars" to "car-finder-account-cars.html",
                                "Wishlist" to "car-finder-account-wishlist.html",
                                "Reviews" to "car-finder-account-reviews.html",
                                "Notifications" to "car-finder-account-notifications.html",
                                "Sign In" to "signin-dark.html",
                                "Sign Up" to "signup-dark.html"
                            ).forEach { (label, href) ->
                                Li { A(href, attrs = { classes("dropdown-item") }) { Text(label) } }
                            }
                        }
                    }

                    // Vendor dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = { classes("nav-link", "dropdown-toggle"); attr("data-bs-toggle","dropdown"); attr("role","button"); attr("aria-expanded","false") }) { Text("Vendor") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            listOf(
                                "Sell Car" to "car-finder-sell-car.html",
                                "Ad Promotion Page" to "car-finder-promotion.html",
                                "Vendor Page" to "car-finder-vendor.html"
                            ).forEach { (label, href) ->
                                Li { A(href, attrs = { classes("dropdown-item") }) { Text(label) } }
                            }
                        }
                    }

                    // Pages dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = { classes("nav-link", "dropdown-toggle"); attr("data-bs-toggle","dropdown"); attr("role","button"); attr("aria-expanded","false") }) { Text("Pages") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            Li { A("car-finder-about.html", attrs = { classes("dropdown-item") }) { Text("About") } }
                            Li(attrs = { classes("dropdown", "dropend") }) {
                                A("#", attrs = { classes("dropdown-item","dropdown-toggle"); attr("data-bs-toggle","dropdown") }) { Text("Blog") }
                                Ul(attrs = { classes("dropdown-menu","dropdown-menu-dark") }) {
                                    Li { A("car-finder-blog.html", attrs = { classes("dropdown-item") }) { Text("Blog Grid") } }
                                    Li { A("car-finder-blog-single.html", attrs = { classes("dropdown-item") }) { Text("Single Post") } }
                                }
                            }
                            Li { A("car-finder-contacts.html", attrs = { classes("dropdown-item") }) { Text("Contacts") } }
                            Li { A("car-finder-help-center.html", attrs = { classes("dropdown-item") }) { Text("Help Center") } }
                            Li { A("car-finder-404.html", attrs = { classes("dropdown-item") }) { Text("404 Not Found") } }
                        }
                    }

                    // Mobile sign in
                    Li(attrs = { classes("nav-item", "d-lg-none") }) {
                        A("#signin-modal", attrs = { classes("nav-link"); attr("data-bs-toggle","modal") }) {
                            I(attrs = { classes("fi-user","me-2") })
                            Text("Sign in")
                        }
                    }
                }
            }
        }
    }
}