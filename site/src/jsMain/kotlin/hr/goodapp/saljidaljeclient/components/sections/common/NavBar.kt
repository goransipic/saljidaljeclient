package hr.goodapp.saljidaljeclient.components.sections.common

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.rememberPageContext
import hr.goodapp.saljidaljeclient.components.widgets.CostumeLink
import org.jetbrains.compose.web.dom.*

@Composable
fun NavbarBar() {
    Header(attrs = {
        classes("navbar", "navbar-expand-lg", "navbar-dark", "fixed-top")
        attr("data-scroll-header", "")
    }) {
        Div(attrs = { classes("container") }) {
            // Brand
            val ctx = rememberPageContext()
            A(
                href = "/",
                attrs = { onClick { it.preventDefault(); ctx.router.navigateTo("/") }; classes("navbar-brand", "me-3", "me-xl-4") }
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
                Text("Prijava")
            }

            A("/sell-car", attrs = { onClick {
                it.preventDefault()
                ctx.router.navigateTo("/sell-car")
            }
                classes("btn", "btn-primary", "btn-sm", "ms-2", "order-lg-3")
            }) {
                I(attrs = { classes("fi-plus", "me-2") })
                Text("Prodaj auto")
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
                            Text("Demo primjeri")
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
                            Li { A("real-estate-home-v1.html", attrs = { classes("dropdown-item") }) { Text("Demo nekretnine") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("car-finder-home.html", attrs = { classes("dropdown-item") }) { Text("Demo tražilica auta") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("job-board-home-v1.html", attrs = { classes("dropdown-item") }) { Text("Demo poslovi") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("city-guide-home-v1.html", attrs = { classes("dropdown-item") }) { Text("Demo vodič kroz grad") } }
                            Li(attrs = { classes("dropdown-divider") })
                            Li { A("index.html", attrs = { classes("dropdown-item") }) { Text("Glavna stranica") } }
                            Li { A("components/typography.html", attrs = { classes("dropdown-item") }) { Text("Komponente") } }
                            Li { A("docs/dev-setup.html", attrs = { classes("dropdown-item") }) { Text("Dokumentacija") } }
                        }
                    }

                    // Home link
                    Li(attrs = { classes("nav-item", "active") }) {
                        CostumeLink(href = "/", attrs = { classes("nav-link") }){ Text("Početna") }
                    }

                    // Catalog dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = {
                            classes("nav-link", "dropdown-toggle")
                            attr("data-bs-toggle", "dropdown")
                            attr("role", "button")
                            attr("aria-expanded", "false")
                        }) { Text("Katalog") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            Li { CostumeLink("/category", attrs = { classes("dropdown-item") }) { Text("Popis vozila") } }
//                            Li { A("car-finder-catalog-grid.html", attrs = { classes("dropdown-item") }) { Text("Mrežni prikaz") } }
                            Li { CostumeLink("/single", attrs = { classes("dropdown-item") }) { Text("Detalji vozila") } }
                        }
                    }

                    // Account dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = { classes("nav-link", "dropdown-toggle"); attr("data-bs-toggle", "dropdown"); attr("role","button"); attr("aria-expanded","false") }) { Text("Račun") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            listOf(
                                "Osobni podaci" to "/profile",
                                "Lozinka i sigurnost" to "/profile/password-security",
                                "Moji auti" to "/profile/cars",
                                "Lista želja" to "/profile/wish-list",
                                "Recenzije" to "/profile/reviews",
                                "Obavijesti" to "/profile/notifications",
                                "Prijava" to "signin-dark.html",
                                "Registracija" to "signup-dark.html"
                            ).forEach { (label, href) ->
                                CostumeLink(href, attrs = { classes("dropdown-item") }) { Text(label) }
                            }
                        }
                    }

                    // Vendor dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = { classes("nav-link", "dropdown-toggle"); attr("data-bs-toggle","dropdown"); attr("role","button"); attr("aria-expanded","false") }) { Text("Prodavač") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            listOf(
                                "Prodaj auto" to "car-finder-sell-car.html",
                                "Promocija oglasa" to "car-finder-promotion.html",
                                "Stranica prodavača" to "car-finder-vendor.html"
                            ).forEach { (label, href) ->
                                Li { A(href, attrs = { classes("dropdown-item") }) { Text(label) } }
                            }
                        }
                    }

                    // Pages dropdown
                    Li(attrs = { classes("nav-item", "dropdown") }) {
                        A("#", attrs = { classes("nav-link", "dropdown-toggle"); attr("data-bs-toggle","dropdown"); attr("role","button"); attr("aria-expanded","false") }) { Text("Stranice") }
                        Ul(attrs = { classes("dropdown-menu", "dropdown-menu-dark") }) {
                            Li { A("car-finder-about.html", attrs = { classes("dropdown-item") }) { Text("O nama") } }
                            Li(attrs = { classes("dropdown", "dropend") }) {
                                A("#", attrs = { classes("dropdown-item","dropdown-toggle"); attr("data-bs-toggle","dropdown") }) { Text("Blog") }
                                Ul(attrs = { classes("dropdown-menu","dropdown-menu-dark") }) {
                                    Li { A("car-finder-blog.html", attrs = { classes("dropdown-item") }) { Text("Blog mreža") } }
                                    Li { A("car-finder-blog-single.html", attrs = { classes("dropdown-item") }) { Text("Jedan članak") } }
                                }
                            }
                            Li { A("car-finder-contacts.html", attrs = { classes("dropdown-item") }) { Text("Kontakt") } }
                            Li { A("car-finder-help-center.html", attrs = { classes("dropdown-item") }) { Text("Centar za pomoć") } }
                            Li { A("car-finder-404.html", attrs = { classes("dropdown-item") }) { Text("404 Stranica nije pronađena") } }
                        }
                    }

                    // Mobile sign in
                    Li(attrs = { classes("nav-item", "d-lg-none") }) {
                        A("#signin-modal", attrs = { classes("nav-link"); attr("data-bs-toggle","modal") }) {
                            I(attrs = { classes("fi-user","me-2") })
                            Text("Prijava")
                        }
                    }
                }
            }
        }
    }
}