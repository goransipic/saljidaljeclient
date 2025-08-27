package hr.goodapp.saljidaljeclient.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import com.varabyte.kobweb.compose.dom.RawHtml
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.CustomFooter
import hr.goodapp.saljidaljeclient.components.sections.main.NavbarBar
import hr.goodapp.saljidaljeclient.components.sections.main.SignInModal
import hr.goodapp.saljidaljeclient.components.sections.main.SignupModal
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Main
import org.w3c.dom.HTMLScriptElement


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
    // Add JS at the end of body
    // Add JS at the bottom of the body

    // Add JS at the bottom of the body
    LaunchedEffect(Unit) {
        val scripts = listOf(
            "vendor/bootstrap/dist/js/bootstrap.bundle.min.js",
            "vendor/simplebar/dist/simplebar.min.js",
            "vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js",
            "vendor/tiny-slider/dist/min/tiny-slider.js",
            "vendor/jarallax/dist/jarallax.min.js",
            "vendor/rellax/rellax.min.js",
            "js/theme.min.js"
        )

        scripts.forEach { src ->
            val script = document.createElement("script") as HTMLScriptElement
            script.src = src
            //script.defer = true
            document.body?.appendChild(script)
        }
    }
}
