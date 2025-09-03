package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.Element
import org.w3c.dom.HTMLSpanElement

@Composable
fun Specs() {
    Div(attrs = {
        classes("py-3", "mb-3")
    }) {
        H2(attrs = {
            classes("h4", "text-light", "mb-4")
        }) {
            Text("Specifikacije")
        }

        Div(attrs = { classes("row", "text-light") }) {
            // Left Column
            Div(attrs = { classes("col-sm-6", "col-md-12", "col-lg-6") }) {
                Ul(attrs = { classes("list-unstyled") }) {
                    SpecItem("Godina proizvodnje:", "2018")
                    SpecItem("Kilometraža:", "25K milja")
                    SpecItem("Tip karoserije:", "Kabriolet")
                    SpecItem("Pogon:", "Prednji pogon")
                    SpecItem("Motor:", "2.5L Turbo 6-cilindarski")
                    SpecItem("Mjenjač:", "7-stupanjski automatski s ručnim izborom")
                }
            }

            // Right Column
            Div(attrs = { classes("col-sm-6", "col-md-12", "col-lg-6") }) {
                Ul(attrs = { classes("list-unstyled") }) {
                    SpecItem("Vrsta goriva:", "Benzin")
                    SpecItemWithIcon("Potrošnja u gradu:", "20", "Provjereno od prodavatelja")
                    SpecItemWithIcon("Potrošnja na autocesti:", "29", "Provjereno od prodavatelja")
                    SpecItem("Boja eksterijera:", "Aspen bijela")
                    SpecItem("Boja interijera:", "Ugljen")
                    SpecItem("VIN:", "2VW821AU9JM754284")
                }
            }
        }
    }
}

@Composable
private fun SpecItem(label: String, value: String) {
    Li(attrs = { classes("mb-2") }) {
        Strong { Text(label) }
        Span(attrs = { classes("opacity-70", "ms-1") }) { Text(value) }
    }
}

@Composable
private fun SpecItemWithIcon(label: String, value: String, tooltip: String) {
    Li(attrs = { classes("mb-2") }) {
        Strong { Text(label) }
        Span(attrs = { classes("opacity-70", "ms-1") }) { Text(value) }
        I(attrs = {
            classes("fi-alert-circle", "fs-sm", "text-primary", "ms-2")
            attr("data-bs-toggle", "tooltip")
            attr("title", tooltip)
        })
    }
}

@Composable
fun Strong(
    attrs: AttrBuilderContext<HTMLSpanElement>? = null,
    content: ContentBuilder<HTMLSpanElement>? = null
) = TagElement(elementBuilder = Strong, applyAttrs = attrs, content = content)

private open class ElementBuilderImplementation<TElement : Element>(private val tagName: String) : ElementBuilder<TElement> {
    private val el: Element by lazy { document.createElement(tagName) }
    @Suppress("UNCHECKED_CAST")
    override fun create(): TElement = el.cloneNode() as TElement
}

private val Strong: ElementBuilder<HTMLSpanElement> = ElementBuilderImplementation("span")