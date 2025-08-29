package hr.goodapp.saljidaljeclient.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.common.Breadcrumb
import org.jetbrains.compose.web.dom.Div


@Composable
@Layout(".components.layouts.PageLayout")
fun AccountLayout(ctx: PageContext, content: @Composable () -> Unit) {
    Div(attrs = { classes("container", "pt-5", "pb-lg-4", "mt-5", "mb-sm-2") }) {
        Breadcrumb()
        Div (attrs = {classes("row")}) {
            content()
        }
    }
}