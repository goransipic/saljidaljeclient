package hr.goodapp.saljidaljeclient.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.common.CustomFooter
import hr.goodapp.saljidaljeclient.components.sections.common.NavbarBar
import hr.goodapp.saljidaljeclient.components.sections.common.SignInModal
import hr.goodapp.saljidaljeclient.components.sections.common.SignupModal
import org.jetbrains.compose.web.dom.Main


class PageLayoutData(val title: String)

@Composable
@Layout
fun PageLayout(ctx: PageContext, content: @Composable () -> Unit) {
    //val data = ctx.data.getValue<PageLayoutData>()
    /*LaunchedEffect(data.title) {
        document.title = "Kobweb - ${data.title}"
    }*/
    Main(attrs = {classes("page-wrapper")}){
        SignInModal()
        SignupModal()
        NavbarBar()
        content()
    }
    CustomFooter()
}
