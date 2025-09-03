package hr.goodapp.saljidaljeclient.components.sections.profile

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun ReviewsContent() {
    Div(attrs = { classes("col-lg-8", "col-md-7", "mb-5") }) {
        H1(attrs = { classes("h2", "text-light") }) {
            Text("Recenzije")
        }
        P(attrs = { classes("text-light", "pt-1", "mb-4") }) {
            Text("Recenzije koje ste primili bit će vidljive ovdje i na vašem javnom profilu.")
        }
        NavTabs()
        TabsContent()
    }
}

@Composable
private fun TabsContent() {
    Div(attrs = {
        classes("tab-content", "pt-2")
    }) {
        ReviewsAboutYouTab()
        ReviewsByYouTab()
    }
}

@Composable
private fun ReviewsAboutYouTab() {
    Div({
        classes("tab-pane", "fade", "show", "active")
        attr("id", "reviews-about-you")
        attr("role", "tabpanel")
    }) {
        Div({
            classes(
                "d-flex",
                "flex-sm-row",
                "flex-column",
                "align-items-sm-center",
                "align-items-stretch",
                "justify-content-between",
                "pb-4",
                "mb-2",
                "mb-md-3"
            )
        }) {
            H3({
                classes("h4", "mb-sm-0")
            }) {
                I({
                    classes("fi-star-filled", "mt-n1", "me-2", "lead", "align-middle", "text-warning")
                })
                Span({
                    classes("text-light")
                }) {
                    Text("4,9 (32 recenzije)")
                }
            }

            Div({
                classes("d-flex", "align-items-center", "ms-sm-4")
            }) {
                Label(attrs = {
                    classes("fs-sm", "text-light", "me-2", "pe-1", "text-nowrap")
                    attr("for", "review-sorting1")
                }) {
                    I({
                        classes("fi-arrows-sort", "mt-n1", "me-2")
                    })
                    Text("Sortiraj po:")
                }

                Select({
                    classes("form-select", "form-select-light", "form-select-sm")
                    attr("id", "review-sorting1")
                }) {
                    Option(value = "") { Text("Najnovije") }
                    Option(value = "") { Text("Najstarije") }
                    Option(value = "") { Text("Popularno") }
                    Option(value = "") { Text("Najbolja ocjena") }
                    Option(value = "") { Text("Najniža ocjena") }
                }
            }
        }
        ReviewItem(
            avatar = "/img/avatars/06.jpg",
            name = "Kathryn Murphy",
            date = "17. siječnja 2021",
            stars = 5,
            text = "Elementum ut quam tincidunt egestas vitae elit, hendrerit. Ullamcorper nulla amet lobortis elit, nibh condimentum enim. Aliquam felis nisl tellus sodales lectus dictum tristique proin vitae. Odio fermentum viverra tortor quis.",
            likes = 3,
            dislikes = 0
        )

        ReviewItem(
            avatar = "/img/avatars/14.png",
            name = "Darrell Steward",
            date = "1. prosinca 2020",
            stars = 4,
            text = "Vel dictum nunc ut tristique. Egestas diam amet, ut proin hendrerit. Dui accumsan at phasellus tempus consequat dignissim tellus sodales.",
            likes = 0,
            dislikes = 1
        )

        ReviewItem(
            avatar = "/img/avatars/05.jpg",
            name = "Floyd Miles",
            date = "28. listopada 2020",
            stars = 5,
            text = "Viverra nunc blandit sapien non imperdiet sit. Purus tempus elementum aliquam eu urna. A aenean duis non egestas at libero porttitor integer eget. Sed dictum lobortis laoreet gravida.",
            likes = 2,
            dislikes = 1
        )

        ReviewItem(
            avatar = "/img/avatars/04.jpg",
            name = "Ralph Edwards",
            date = "14. rujna 2020",
            stars = 4,
            text = "Elementum nisl, egestas nam consectetur nisl, at pellentesque cras. Non sed ac vivamus dolor dignissim ut. Nisl sapien blandit pulvinar sagittis donec sociis ipsum arcu est. Tempus, rutrum morbi scelerisque tempor mi. Etiam urna, cras bibendum leo nec faucibus velit. Tempor lectus dignissim at auctor integer neque quam amet.",
            likes = 0,
            dislikes = 0
        )

        ReviewsPagination()
    }
}

@Composable
private fun ReviewsByYouTab() {
    Div({
        classes("tab-pane", "fade")
        attr("id", "reviews-by-you")
        attr("role", "tabpanel")
    }) {
        // Header with sorting
        Div({
            classes(
                "d-flex",
                "flex-sm-row",
                "flex-column",
                "align-items-sm-center",
                "align-items-stretch",
                "justify-content-between",
                "pb-4",
                "mb-2",
                "mb-md-3"
            )
        }) {
            H3({
                classes("h4", "text-light", "mb-sm-0")
            }) { Text("3 recenzije") }

            Div({ classes("d-flex", "align-items-center", "ms-sm-4") }) {
                Label(attrs = {
                    classes("fs-sm", "text-light", "me-2", "pe-1", "text-nowrap")
                    attr("for", "review-sorting2")
                }) {
                    I({ classes("fi-arrows-sort", "mt-n1", "me-2") })
                    Text("Sortiraj po:")
                }

                Select({
                    classes("form-select", "form-select-light", "form-select-sm")
                    attr("id", "review-sorting2")
                }) {
                    Option("") { Text("Najnovije") }
                    Option("") { Text("Najstarije") }
                    Option("") { Text("Popularno") }
                    Option("") { Text("Najbolja ocjena") }
                    Option("") { Text("Najniža ocjena") }
                }
            }
        }

        ReviewCard(
            Review(
                itemFor = "Ford Truck Lifted",
                date = "13. siječnja 2021",
                text = "Elementum ut quam tincidunt egestas vitae elit, hendrerit. Ullamcorper nulla amet lobortis elit, nibh condimentum enim. Aliquam felis nisl tellus sodales lectus dictum tristique proin vitae. Odio fermentum viverra tortor quis.",
                stars = 2,
                likes = 2,
                dislikes = 1
            )
        )
        ReviewCard(
            Review(
                itemFor = "Mercedes Benz C300 Sport",
                date = "10. prosinca 2020",
                text = "Vel dictum nunc ut tristique. Egestas diam amet, ut proin hendrerit. Dui accumsan at phasellus tempus consequat dignissim tellus sodales.",
                stars = 4,
                likes = 4,
                dislikes = 2
            )
        )
        ReviewCard(
            Review(
                itemFor = "BMW 640 XI Gran Turismo",
                date = "24. listopada 2020",
                text = "Viverra nunc blandit sapien non imperdiet sit. Purus tempus elementum aliquam eu urna. A aenean duis non egestas at libero porttitor integer eget. Sed dictum lobortis laoreet gravida.",
                stars = 5,
                likes = 2,
                dislikes = 0
            )
        )
    }
}

data class Review(
    val itemFor: String? = null, // optional "For:" field
    val date: String,
    val text: String,
    val stars: Int, // 0..5
    val likes: Int = 0,
    val dislikes: Int = 0
)


@Composable
fun ReviewCard(review: Review) {
    Div({ classes("mb-4", "pb-4", "border-bottom", "border-light") }) {
        // Header
        Div({ classes("d-flex", "justify-content-between", "mb-3") }) {
            Div({ classes("pe-2") }) {
                H6({ classes("text-light", "mb-0") }) {
                    review.itemFor?.let {
                        Span({ classes("fw-normal", "opacity-70", "me-1") }) { Text("Za:") }
                        Text(it)
                    }
                }
                Div({ classes("text-light") }) {
                    Span({ classes("star-rating") }) {
                        repeat(review.stars) { I({ classes("star-rating-icon", "fi-star-filled", "active") }) {} }
                        repeat(5 - review.stars) { I({ classes("star-rating-icon", "fi-star") }) {} }
                    }
                }
            }
            Span({ classes("text-light", "fs-sm", "opacity-50") }) { Text(review.date) }
        }

        // Review text
        P({ classes("text-light", "opacity-70") }) { Text(review.text) }

        // Likes/Dislikes
        Div({ classes("d-flex", "align-items-center") }) {
            Button({ classes("btn-like", "btn-light"); attr("type", "button") }) {
                I({ classes("fi-like") }) {}
                Span { Text("(${review.likes})") }
            }
            Div({ classes("border-end", "border-light", "me-1") }) { Text("\u00A0") }
            Button({ classes("btn-dislike", "btn-light"); attr("type", "button") }) {
                I({ classes("fi-dislike") }) {}
                Span { Text("(${review.dislikes})") }
            }
        }
    }
}


@Composable
private fun ReviewsPagination() {
    Nav({
        classes("mt-2")
        attr("aria-label", "Reviews pagination")
    }) {
        Ul({
            classes("pagination", "pagination-light")
        }) {
            // Mobile view: 1 / 5
            Li({
                classes("page-item", "d-sm-none")
            }) {
                Span({
                    classes("page-link", "page-link-static")
                }) {
                    Text("1 / 5")
                }
            }

            // Active page (desktop)
            Li({
                classes("page-item", "active", "d-none", "d-sm-block")
                attr("aria-current", "page")
            }) {
                Span({
                    classes("page-link")
                }) {
                    Text("1")
                    Span({
                        classes("visually-hidden")
                    }) {
                        Text("(current)")
                    }
                }
            }

            // Other pages
            Li({ classes("page-item", "d-none", "d-sm-block") }) {
                A(attrs = {
                    classes("page-link")
                    attr("href", "#")
                }) { Text("2") }
            }
            Li({ classes("page-item", "d-none", "d-sm-block") }) {
                A(attrs = {
                    classes("page-link")
                    attr("href", "#")
                }) { Text("3") }
            }
            Li({ classes("page-item", "d-none", "d-sm-block") }) {
                Span { Text("...") }
            }
            Li({ classes("page-item", "d-none", "d-sm-block") }) {
                A(attrs = {
                    classes("page-link")
                    attr("href", "#")
                }) { Text("8") }
            }

            // Next button
            Li({ classes("page-item") }) {
                A(attrs = {
                    classes("page-link")
                    attr("href", "#")
                    attr("aria-label", "Next")
                }) {
                    I({ classes("fi-chevron-right") })
                }
            }
        }
    }
}

@Composable
private fun ReviewItem(
    avatar: String,
    name: String,
    date: String,
    stars: Int,
    text: String,
    likes: Int,
    dislikes: Int
) {
    Div({ classes("mb-4", "pb-4", "border-bottom", "border-light") }) {
        // Header
        Div({ classes("d-flex", "justify-content-between", "mb-3") }) {
            Div({ classes("d-flex", "align-items-center", "pe-2") }) {
                Img(attrs = {
                    classes("rounded-circle", "me-1")
                    attr("width", "48")
                    attr("alt", "Avatar")
                }, src = avatar)

                Div({ classes("ps-2") }) {
                    H6({ classes("fs-base", "text-light", "mb-0") }) { Text(name) }

                    Div({ classes("text-light") }) {
                        Span({ classes("star-rating") }) {
                            // Render filled stars
                            for (i in 1..stars) {
                                I({ classes("star-rating-icon", "fi-star-filled", "active") })
                            }
                        }
                    }
                }
            }

            Span({ classes("text-light", "fs-sm", "opacity-50") }) { Text(date) }
        }

        // Review text
        P({ classes("text-light", "opacity-70") }) {
            Text(text)
        }

        // Likes/Dislikes
        Div({ classes("d-flex", "align-items-center") }) {
            Button({ classes("btn-like", "btn-light"); attr("type", "button") }) {
                I({ classes("fi-like") })
                Span { Text("($likes)") }
            }
            Div({ classes("border-end", "border-light", "me-1") }) { Text("\u00A0") }
            Button({ classes("btn-dislike", "btn-light"); attr("type", "button") }) {
                I({ classes("fi-dislike") })
                Span { Text("($dislikes)") }
            }
        }
    }
}


@Composable
private fun NavTabs() {
    Ul(
        attrs = {
            classes(
                "nav", "nav-tabs", "nav-tabs-light",
                "flex-column", "flex-sm-row",
                "align-items-stretch", "align-items-sm-start",
                "border-bottom", "border-light", "mb-4"
            )
            attr("role", "tablist")
        }
    ) {
        Li(attrs = { classes("nav-item", "me-sm-3", "mb-3") }) {
            A(
                href = "#reviews-about-you",
                attrs = {
                    classes("nav-link", "text-center", "active")
                    attr("data-bs-toggle", "tab")
                    attr("role", "tab")
                    attr("aria-controls", "reviews-about-you")
                    attr("aria-selected", "true")
                }
            ) {
                Text("Recenzije o vama")
            }
        }
        Li(attrs = { classes("nav-item", "mb-3") }) {
            A(
                href = "#reviews-by-you",
                attrs = {
                    classes("nav-link", "text-center")
                    attr("data-bs-toggle", "tab")
                    attr("role", "tab")
                    attr("aria-controls", "reviews-by-you")
                    attr("aria-selected", "false")
                }
            ) {
                Text("Recenzije koje ste napisali")
            }
        }
    }
}