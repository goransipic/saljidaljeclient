package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun LatestNewsSection() {
    Section(
        attrs = {
            classes("container", "pb-4", "pb-sm-5", "mb-2", "mb-md-4")
        }
    ) {
        Div(attrs = { classes("d-sm-flex", "align-items-center", "justify-content-between", "mb-3", "mb-sm-4", "pb-sm-2") }) {
            H2(attrs = { classes("h3", "text-light", "mb-2", "mb-sm-0") }) {
                Text("Najnovije vijesti")
            }
            A(
                href = "car-finder-blog.html",
                attrs = { classes("btn", "btn-link", "btn-light", "fw-normal", "px-0") }
            ) {
                Text("Idi na blog")
                I(attrs = { classes("fi-arrow-long-right", "fs-sm", "mt-0", "ps-1", "ms-2") })
            }
        }

        Div(attrs = { classes("tns-carousel-wrapper", "tns-nav-outside", "tns-carousel-light") }) {
            Div(attrs = {
                classes("tns-carousel-inner")
                attr(
                    "data-carousel-options",
                    """{"items":3,"controls":false,"responsive":{"0":{"items":1,"gutter":16},"500":{"items":2,"gutter":18},"900":{"items":3,"gutter":20},"1100":{"gutter":24}}}"""
                )
            }) {
                NewsItem(
                    img = "img/car-finder/blog/04.jpg",
                    category = "Događanja",
                    title = "Top 10 događanja klasičnih automobila",
                    authorImg = "img/avatars/08.jpg",
                    author = "Jacob Jones",
                    date = "8. svibnja",
                    comments = "Nema komentara"
                )

                NewsItem(
                    img = "img/car-finder/blog/05.jpg",
                    category = "Inspiracija",
                    title = "5 predviđanja iz prošlosti o budućnosti",
                    authorImg = "img/avatars/09.jpg",
                    author = "Guy Hawkins",
                    date = "25. travnja",
                    comments = "6 komentara"
                )

                NewsItem(
                    img = "img/car-finder/blog/06.jpg",
                    category = "Test vožnje",
                    title = "Ova godina je sve o novom Harley Davidsonu",
                    authorImg = "img/avatars/12.jpg",
                    author = "Ralph Edwards",
                    date = "12. ožujka",
                    comments = "2 komentara"
                )
            }
        }
    }
}

@Composable
fun NewsItem(
    img: String,
    category: String,
    title: String,
    authorImg: String,
    author: String,
    date: String,
    comments: String
) {
    Div {
        Article {
            A(href = "car-finder-blog-single.html", attrs = { classes("d-block", "rounded-3", "overflow-hidden") }) {
                Img(src = img, alt = "Slika", attrs = { classes("d-block") })
            }
            Div(attrs = { classes("py-3") }) {
                A(href = "#", attrs = { classes("fs-xs", "text-uppercase", "text-decoration-none") }) {
                    Text(category)
                }
                H3(attrs = { classes("text-light", "fs-base", "pt-1") }) {
                    A(href = "car-finder-blog-single.html", attrs = { classes("nav-link") }) {
                        Text(title)
                    }
                }
                A(href = "#", attrs = { classes("d-flex", "align-items-center", "text-decoration-none") }) {
                    Img(src = authorImg, alt = "Avatar", attrs = { classes("rounded-circle"); attr("width", "44") })
                    Div(attrs = { classes("ps-2") }) {
                        H6(attrs = { classes("fs-sm", "text-light", "lh-base", "mb-1") }) { Text(author) }
                        Div(attrs = { classes("d-flex", "fs-xs", "text-light", "opacity-60") }) {
                            Span(attrs = { classes("me-2", "pe-1") }) {
                                I(attrs = { classes("fi-calendar-alt", "me-1") })
                                Text(date)
                            }
                            Span {
                                I(attrs = { classes("fi-chat-circle", "me-1") })
                                Text(comments)
                            }
                        }
                    }
                }
            }
        }
    }
}