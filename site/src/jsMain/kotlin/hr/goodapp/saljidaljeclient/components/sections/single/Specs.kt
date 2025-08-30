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
            Text("Specifications")
        }

        Div(attrs = { classes("row", "text-light") }) {
            // Left Column
            Div(attrs = { classes("col-sm-6", "col-md-12", "col-lg-6") }) {
                Ul(attrs = { classes("list-unstyled") }) {
                    SpecItem("Manufacturing Year:", "2018")
                    SpecItem("Mileage:", "25K miles")
                    SpecItem("Body Type:", "Convertible")
                    SpecItem("Drivetrain:", "Front Wheel Drive")
                    SpecItem("Engine:", "2.5L Turbo 6 Cylinder")
                    SpecItem("Transmission:", "7-Speed Shiftable Automatic")
                }
            }

            // Right Column
            Div(attrs = { classes("col-sm-6", "col-md-12", "col-lg-6") }) {
                Ul(attrs = { classes("list-unstyled") }) {
                    SpecItem("Fuel Type:", "Gasoline")
                    SpecItemWithIcon("City MPG:", "20", "Verified by seller")
                    SpecItemWithIcon("Highway MPG:", "29", "Verified by seller")
                    SpecItem("Exterior Color:", "Aspen White")
                    SpecItem("Interior Color:", "Charcoal")
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