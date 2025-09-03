package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun CarGallery() {
    Div(attrs = { classes("tns-carousel-wrapper") }) {

        // Slide count (top-left overlay)
        Div(attrs = { classes("tns-slides-count", "text-light") }) {
            I(attrs = { classes("fi-image", "fs-lg", "me-2") })
            Div(attrs = { classes("ps-1") }) {
                Span(attrs = { classes("tns-current-slide", "fs-5", "fw-bold") })
                Span(attrs = { classes("fs-5", "fw-bold") }) { Text("/") }
                Span(attrs = { classes("tns-total-slides", "fs-5", "fw-bold") })
            }
        }

        // Carousel inner
        Div(attrs = {
            classes("tns-carousel-inner")
            attr(
                "data-carousel-options",
                """{"navAsThumbnails": true, "navContainer": "#thumbnails", "gutter": 12,
                  "responsive": {"0":{"controls": false},"500":{"controls": true}}}"""
            )
        }) {
            listOf(
                "01.jpg", "02.jpg", "03.jpg", "04.jpg",
                "05.jpg", "06.jpg", "07.jpg", "08.jpg"
            ).forEach { img ->
                Div {
                    Img(
                        src = "img/car-finder/single/gallery/$img",
                        alt = "Slika",
                        attrs = { classes("rounded-3") }
                    )
                }
            }
        }
    }

    // Thumbnails list
    Ul(attrs = {
        classes("tns-thumbnails")
        id("thumbnails")
    }) {
        (1..8).forEach { index ->
            val filename = "img/car-finder/single/gallery/th" + index.toString().padStart(2, '0') + ".jpg"
            Li(attrs = { classes("tns-thumbnail") }) {
                Img(
                    src = filename,
                    alt = "Sličica"
                )
            }
        }

        // Video thumbnail
        Li(attrs = { classes("tns-thumbnail") }) {
            A(
                href = "https://www.youtube.com/watch?v=0ffN2hgKzOE",
                attrs = {
                    classes(
                        "d-flex", "flex-column", "align-items-center", "justify-content-center",
                        "w-100", "h-100", "bg-faded-light", "rounded", "text-light",
                        "text-decoration-none"
                    )
                    attr("data-bs-toggle", "lightbox")
                    attr("data-video", "true")
                }
            ) {
                I(attrs = { classes("fi-play-circle", "fs-5") })
                Span(attrs = { classes("opacity-70", "mt-1") }) { Text("Pusti video") }
            }
        }
    }
}