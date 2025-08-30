package hr.goodapp.saljidaljeclient.components.sections.single

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun Seller() {
    Div(attrs = { classes("pb-4", "mb-3") }) {
        // Heading
        H2(attrs = { classes("h4", "text-light", "pt-4", "mt-3") }) {
            Text("Seller's Description")
        }

        // Short description
        P(attrs = { classes("text-light", "opacity-70", "mb-1") }) {
            Text(
                "Lorem tincidunt lectus vitae id vulputate diam quam. Imperdiet non scelerisque turpis sed etiam ultrices. " +
                        "Blandit mollis dignissim egestas consectetur porttitor. Vulputate dolor pretium, dignissim eu augue sit ut convallis. " +
                        "Lectus est, magna urna feugiat sed ultricies sed in lacinia. Fusce potenti sit id pharetra vel ornare. Vestibulum sed tellus ullamcorper arcu."
            )
        }

        // Collapsible extended description
        Div(attrs = {
            classes("collapse")
            attr("id", "seeMoreDescription")
        }) {
            P(attrs = { classes("text-light", "opacity-70", "mb-1") }) {
                Text(
                    "Asperiores eos molestias, aspernatur assumenda vel corporis ex, magni excepturi totam exercitationem quia inventore quod amet labore impedit quae distinctio? " +
                            "Officiis blanditiis consequatur alias, atque, sed est incidunt accusamus repudiandae tempora repellendus obcaecati delectus ducimus inventore tempore harum numquam autem eligendi culpa."
                )
            }
        }

        // Show more / Show less toggle
        A(
            attrs = {
                classes("collapse-label", "collapsed")
                attr("href", "#seeMoreDescription")
                attr("data-bs-toggle", "collapse")
                attr("data-bs-label-collapsed", "Show more")
                attr("data-bs-label-expanded", "Show less")
                attr("role", "button")
                attr("aria-expanded", "false")
                attr("aria-controls", "seeMoreDescription")
            }
        ) {}
    }
}