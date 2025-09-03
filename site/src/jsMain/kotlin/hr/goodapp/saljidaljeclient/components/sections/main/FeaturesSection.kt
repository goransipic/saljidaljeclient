package hr.goodapp.saljidaljeclient.components.sections.main

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.width
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.dom.*

@Composable
fun FeaturesSection() {
    Div(attrs = { classes("container", "pt-4", "pt-md-5") }) {
        // Header
        Div(attrs = { classes("d-sm-flex", "align-items-center", "justify-content-between") }) {
            H2(attrs = { classes("h3", "text-light", "mb-2", "mb-sm-0") }) {
                Text("Što čini Finder posebnim?")
            }
            A(href = "#",attrs = { classes("btn", "btn-link", "btn-light", "fw-normal", "px-0")}) {
                Text("Kako prodati aute na Finderu")
                I(attrs = { classes("fi-arrow-long-right", "fs-sm", "mt-0", "ps-1", "ms-2") })
            }
        }

        Div(attrs = { classes("row") }) {
            // Left column features
            Div(attrs = { classes("col-md-5", "col-lg-4", "offset-lg-1", "pt-4", "mt-2", "pt-md-5", "mt-md-3") }) {
                listOf(
                    Triple("fi-file", "Više od 1 milijun oglasa", "To je više nego što ćete naći na bilo kojem drugom većem online tržištu automobila u SAD-u."),
                    Triple("fi-search", "Personalizirana pretraga", "Naša moćna pretraga olakšava personaliziranje rezultata tako da vidite samo automobile i značajke koje vas zanimaju."),
                    Triple("fi-settings", "Neprestana inovacija", "Naš tim stalno razvija nove funkcionalnosti koje proces kupnje i prodaje automobila čine jednostavnijim.")
                ).forEach { (iconClass, title, desc) ->
                    Div(attrs = { classes("d-flex", "pb-4", "pb-md-5", "mb-2") }) {
                        I(attrs = { classes(iconClass, "lead", "text-primary", "mt-1", "order-md-2") })
                        Div(attrs = { classes("text-md-end", "ps-3", "ps-md-0", "pe-md-3", "order-md-1") }) {
                            H3(attrs = { classes("h6", "text-light", "mb-1") }) {
                                Text(title)
                            }
                            P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                                Text(desc)
                            }
                        }
                    }
                }
            }

            // Center illustration
            Div(attrs = { classes("col-md-2", "d-none", "d-md-block") }) {
                Div(attrs = {
                    classes("position-relative", "mx-auto", "h-100")
                    style { maxWidth("5rem"); minHeight("26rem") }
                }) {
                    Div(attrs = {
                        classes("rellax", "content-overlay", "pt-5")
                        attr("data-rellax-percentage", "0.5")
                    }) {
                        Img(src = "img/car-finder/home/car.svg",attrs = { classes("pt-3", "mt-5"); alt("Automobil") })
                    }
                    Div(attrs = { classes("position-absolute", "top-0", "start-50", "translate-middle-x", "h-100", "overflow-hidden") }) {
                        Img(src = "img/car-finder/home/road-line.svg", attrs = {  width(2); alt("Linija ceste") })
                    }
                }
            }

            // Right column features
            Div(attrs = { classes("col-md-5", "col-lg-4", "pt-md-5", "mt-md-3") }) {
                listOf(
                    Triple("fi-info-circle", "Vrijedni uvidi", "Pružamo besplatan pristup ključnim informacijama poput recenzija trgovaca, tržišne vrijednosti i padova cijena."),
                    Triple("fi-users", "Fokus na korisniku", "Usredotočeni smo na izgradnju najtransparentnijeg i najpouzdanijeg iskustva za naše korisnike, a to smo dokazali i trgovcima."),
                    Triple("fi-calculator", "Online procjena auta", "Odredite parametre svog automobila kako biste odredili njegovu tržišnu vrijednost na temelju sličnih vozila na Finderu.")
                ).forEach { (iconClass, title, desc) ->
                    Div(attrs = { classes("d-flex", "pb-4", "pb-md-5", "mb-2") }) {
                        I(attrs = { classes(iconClass, "lead", "text-primary", "mt-1") })
                        Div(attrs = { classes("ps-3") }) {
                            H3(attrs = { classes("h6", "text-light", "mb-1") }) {
                                Text(title)
                            }
                            P(attrs = { classes("fs-sm", "text-light", "opacity-70", "mb-0") }) {
                                Text(desc)
                            }
                        }
                    }
                }
            }
        }
    }
}