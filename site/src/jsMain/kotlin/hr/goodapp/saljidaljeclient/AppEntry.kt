package hr.goodapp.saljidaljeclient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp
import kotlinx.browser.document
import org.w3c.dom.HTMLBodyElement

private const val COLOR_MODE_KEY = "saljidaljeclient:colorMode"

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    LaunchedEffect(Unit) {
        val body = document.body as? HTMLBodyElement
        body?.classList?.add("bg-dark")
    }
    //KobwebApp {
        content()
    //}
}
