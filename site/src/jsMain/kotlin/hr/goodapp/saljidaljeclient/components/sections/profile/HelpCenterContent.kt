package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.dom.*

@Composable
fun HelpCenterContent() {
    HeroSearch()
    FAQ()
    ContactUs()
}

@Composable
fun ContactUs() {
    Section(attrs = { classes("position-relative", "py-5") }) {
        // Overlay background
        Span(attrs = {
            classes("d-block", "position-absolute", "top-0", "left-0", "w-100", "h-100", "zindex-1")
            style {
                property(
                    "background",
                    "linear-gradient(26.21deg, rgba(93, 60, 242, 0.15) 0%, rgba(253, 86, 49, 0.15) 108.88%)"
                )
            }
        })

        // Overlay content
        Div(attrs = { classes("container", "position-relative", "zindex-5", "py-lg-5") }) {
            Div(attrs = { classes("col-lg-8", "col-md-10", "mx-auto", "px-0", "text-center") }) {
                H2(attrs = { classes("text-light") }) {
                    Text("Haven't found the answer? We can help.")
                }
                P(attrs = { classes("mb-4", "pb-3", "text-light", "opacity-70") }) {
                    Text("Contact us and we’ll get back to you as soon as possible.")
                }
                A(
                    href = "car-finder-contacts.html",
                    attrs = { classes("btn", "btn-lg", "btn-primary") }
                ) {
                    Text("Contact us")
                }
            }
        }
    }
}

@Composable
private fun FAQ() {
    Section(attrs = { classes("container", "mb-5", "pt-1", "pb-2", "py-lg-5") }) {
        Div(attrs = { classes("row", "justify-content-center") }) {
            Div(attrs = { classes("col-lg-8", "col-md-10") }) {
                H2(attrs = { classes("h3", "mb-4", "pb-3", "text-light", "text-center") }) {
                    Text("Frequently Asked Questions")
                }

                // Nav tabs
                Div(attrs = { classes("overflow-auto", "mx-n2") }) {
                    Ul(attrs = {
                        classes(
                            "nav",
                            "nav-tabs",
                            "nav-tabs-light",
                            "nav-fill",
                            "flex-nowrap",
                            "mb-md-4",
                            "mb-3",
                            "text-nowrap"
                        ); attr("role", "tablist")
                    }) {
                        listOf("General questions", "Buy or rent cars", "Sell cars").forEachIndexed { index, title ->
                            Li(attrs = { classes("nav-item", "w-100", "px-2") }) {
                                A(
                                    href = "#",
                                    attrs = {
                                        classes(
                                            *listOfNotNull(
                                                "nav-link",
                                                if (index == 0) "active" else null
                                            ).toTypedArray()
                                        )
                                    }
                                ) { Text(title) }
                            }
                        }
                    }
                }

                // Accordion
                Div(attrs = { classes("pt-3") }) {
                    Div(attrs = { classes("accordion", "accordion-light"); attr("id", "accordionFAQ") }) {

                        val faqs = listOf(
                            "How much does it cost to sell a car on Finder?" to "Aut dolores nemo rem commodi neque voluptatem molestiae cupiditate unde consequatur impedit, enim rerum eum ipsam. Eligendi, blanditiis ad? Laboriosam, distinctio nemo, culpa suscipit tenetur at est quis commodi similique impedit illum non dignissimos et cum aut, asperiores fugiat unde. Possimus autem iusto fugit ipsa natus, fugiat libero. Nemo sed nisi error.",
                            "How do I take the best pictures of my car?" to "Porta mi integer lectus cras augue amet tellus. Mus in justo orci est urna facilisis vitae. Sem sagittis potenti scelerisque justo, etiam pharetra. In augue egestas nec rhoncus. Lectus tincidunt phasellus eu in erat eget id egestas nec. Purus massa blandit nibh ut sed tellus. Sit cras aliquam velit tellus leo. Sed vulputate erat dui eros, viverra. Cursus et nulla turpis sit. Egestas at non elementum non. Molestie nunc, diam etiam diam. Ac et turpis vestibulum porta.",
                            "Can I sell a vehicle if I live outside of the United States?" to "Delectus perferendis libero ad sapiente unde cupiditate vero error autem ex sed culpa beatae vel, alias amet quam officiis repudiandae ab nobis! Animi ullam obcaecati praesentium at officia quos doloremque nihil aperiam debitis quasi placeat atque, amet laborum illo voluptates autem totam in mollitia! At, autem, ipsum quam minima doloribus distinctio aspernatur id et, cum reiciendis iste officia. Architecto tempore deserunt voluptates?",
                            "How does the buyer get in contact with me and make payment?" to "Impedit iusto cum vitae pariatur. Veritatis totam neque, libero non odio doloremque sequi ut, delectus optio cumque rerum illum? Libero corrupti neque magnam aliquam tempora debitis at voluptate alias, facilis ipsa dignissimos repellendus quaerat soluta dolorem ad ipsam nemo quisquam voluptatum quibusdam dolorum. Labore qui saepe ducimus iure fuga accusamus, commodi quod ex sed excepturi corrupti! Ducimus natus repellendus placeat mollitia harum nostrum similique earum qui ratione?",
                            "Who writes the listing description for my car?" to "Facere unde eveniet explicabo quidem, quaerat, nesciunt, minus in vel incidunt natus qui recusandae neque laudantium est vitae ipsam? Dolores natus nesciunt culpa accusantium tempora, recusandae, debitis, labore maxime a optio similique rem nam fuga vel doloremque suscipit repellendus veritatis necessitatibus. Architecto sit qui dolorum nihil ea!",
                            "Are there rules to follow in the comments?" to "Perspiciatis iste atque in quis recusandae libero maxime, quo sed itaque, totam quaerat earum dolorum accusantium? Optio quidem aliquam corporis, nesciunt nobis incidunt numquam debitis cumque quisquam eum veniam quae eaque voluptates totam culpa aperiam sapiente minima sint sit facere dolorum excepturi ab odit? Adipisci exercitationem distinctio dolores obcaecati eligendi explicabo, ipsa dicta, tempore, enim molestias excepturi nihil vel! Quas, culpa.",
                            "What currency does Finder use?" to "Dolores assumenda dolorem saepe, consequatur praesentium alias numquam accusantium explicabo distinctio omnis voluptatum eum enim aspernatur vel, minus optio dolore ratione quasi sunt. Ab distinctio laborum dolore explicabo hic omnis iste quibusdam minus mollitia ad voluptate suscipit accusantium, laudantium sapiente? Aperiam est minus veniam explicabo repellendus id velit sit adipisci quam in!"
                        )

                        faqs.forEachIndexed { index, faq ->
                            val headingId = "heading-${index + 1}"
                            val collapseId = "collapse-${index + 1}"

                            Div(attrs = { classes("accordion-item") }) {
                                H2(attrs = { classes("accordion-header"); attr("id", headingId) }) {
                                    Button(
                                        attrs = {
                                            classes(
                                                *listOfNotNull(
                                                    "accordion-button",
                                                    if (index != 0) "collapsed" else null
                                                ).toTypedArray()
                                            )
                                            type(ButtonType.Button)
                                            attr("data-bs-toggle", "collapse")
                                            attr("data-bs-target", "#$collapseId")
                                            attr("aria-expanded", if (index == 0) "true" else "false")
                                            attr("aria-controls", collapseId)
                                        }
                                    ) { Text(faq.first) }
                                }
                                Div(
                                    attrs = {
                                        classes(
                                            *listOfNotNull(
                                                "accordion-collapse",
                                                "collapse",
                                                if (index == 0) "show" else null
                                            ).toTypedArray()
                                        )
                                        attr("aria-labelledby", headingId)
                                        attr("data-bs-parent", "#accordionFAQ")
                                        attr("id", collapseId)
                                    }
                                ) {
                                    Div(attrs = { classes("accordion-body", "fs-sm", "text-light", "opacity-70") }) {
                                        Text(faq.second)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HeroSearch() {
    Section(attrs = { classes("position-relative", "mb-5", "pt-5", "pb-lg-5") }) {
        // Overlay bg
        Span(attrs = {
            classes("d-block", "position-absolute", "top-0", "start-0", "w-100", "h-100", "zindex-1")
            style {
                background("linear-gradient(26.21deg, rgba(93, 60, 242, 0.15) 0%, rgba(253, 86, 49, 0.15) 108.88%)")
            }
        })

        // Overlay content
        Div(attrs = { classes("container", "position-relative", "zindex-5", "py-5") }) {

            // Breadcrumb
            Nav(attrs = { classes("mb-3", "pt-md-3"); attr("aria-label", "Breadcrumb") }) {
                Ol(attrs = { classes("breadcrumb", "breadcrumb-light") }) {
                    Li(attrs = { classes("breadcrumb-item") }) {
                        A(href = "car-finder-home.html") { Text("Home") }
                    }
                    Li(attrs = { classes("breadcrumb-item", "active"); attr("aria-current", "page") }) {
                        Text("Help center")
                    }
                }
            }

            Div(attrs = { classes("col-lg-8", "col-md-10", "mx-auto", "px-0", "pt-2") }) {
                H1(attrs = { classes("mb-4", "pb-2", "text-center", "text-light") }) {
                    Text("Hello, what can we do for you?")
                }

                // Search form
                Form(attrs = { classes("form-group", "form-group-light", "mb-4") }) {
                    Input(type = InputType.Text, attrs = {
                        classes("form-control", "form-control-lg")
                        placeholder("What are you looking for?")
                    })
                    Button(attrs = {
                        classes(
                            "btn",
                            "btn-lg",
                            "btn-primary",
                            "px-sm-4",
                            "px-3"
                        ); type(ButtonType.Submit)
                    }) {
                        I(attrs = { classes("fi-search", "me-sm-2") })
                        Span(attrs = { classes("d-sm-inline", "d-none") }) { Text("Search") }
                    }
                }

                // Popular sections
                Div(attrs = {
                    classes(
                        "d-flex",
                        "flex-md-row",
                        "flex-column",
                        "align-items-md-center",
                        "justify-content-md-center"
                    )
                }) {
                    Div(attrs = {
                        classes(
                            "pb-3",
                            "mb-2",
                            "me-2",
                            "flex-shrink-0",
                            "fw-bold",
                            "text-light",
                            "opacity-70"
                        )
                    }) {
                        Text("Popular sections:")
                    }
                    Div(attrs = { classes("text-nowrap", "overflow-auto", "pb-3") }) {
                        Div {
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("General inquiries") }
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Warranties & more") }
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Account questions") }
                            A(
                                href = "#",
                                attrs = {
                                    classes(
                                        "btn",
                                        "btn-xs",
                                        "btn-translucent-light",
                                        "fw-normal",
                                        "mb-2",
                                        "me-2"
                                    )
                                }) { Text("Payment & Documentation") }
                        }
                    }
                }
            }
        }
    }
}