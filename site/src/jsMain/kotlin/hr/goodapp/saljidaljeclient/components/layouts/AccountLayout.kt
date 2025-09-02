package hr.goodapp.saljidaljeclient.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.data.getValue
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.common.Breadcrumb
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems
import org.jetbrains.compose.web.dom.Div

class AccountLayoutData(val title: SidebarItems)

@Composable
@Layout(".components.layouts.PageLayout")
fun AccountLayout(ctx: PageContext, content: @Composable () -> Unit) {
    val title = ctx.data.getValue<AccountLayoutData>().title.title

    Div(attrs = { classes("container", "pt-5", "pb-lg-4", "mt-5", "mb-sm-2") }) {
        Breadcrumb(title)
        Div (attrs = {classes("row")}) {
            content()
        }
    }
}