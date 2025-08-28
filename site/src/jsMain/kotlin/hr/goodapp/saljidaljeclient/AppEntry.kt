package hr.goodapp.saljidaljeclient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.isExporting
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import hr.goodapp.saljidaljeclient.styles.registerCustomStyles
import kotlinx.browser.document
import org.w3c.dom.HTMLBodyElement
import org.w3c.dom.HTMLElement

private const val COLOR_MODE_KEY = "saljidaljeclient:colorMode"

@InitSilk
fun initStyles(ctx: InitSilkContext) {
    ctx.stylesheet.registerCustomStyles()
    ctx.config.apply {
        if (AppGlobals.isExporting) { // this works with inserting page loading but i dont know how????
            val htmlString = """
                <!-- Page loading spinner-->
                <div class="page-loading active bg-dark">
                    <div class="page-loading-inner">
                        <div class="page-spinner"></div><span>Loading...</span>
                    </div>
                </div>
            """.trimIndent()
            val element = document.getElementById("_kobweb-root") as? HTMLElement
            element?.insertAdjacentHTML("afterbegin", htmlString)
        }
        if (AppGlobals.isExporting) {
            setBackgroundColor()
        }
    }
    ctx.stylesheet.registerStyleBase("html, body") { Modifier.fillMaxHeight() }
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    //KobwebApp {
    LaunchedEffect(Unit) {
        setBackgroundColor()
    }
    SilkApp {
        content()
    }

    //}
}

private fun setBackgroundColor() {
    val body = document.body as? HTMLBodyElement
    body?.classList?.add("bg-dark")
}
