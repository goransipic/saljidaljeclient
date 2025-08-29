package hr.goodapp.saljidaljeclient.pages.sellcar

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.sellcar.PageContent
import hr.goodapp.saljidaljeclient.components.sections.sellcar.ProgressOfCompletion
import org.jetbrains.compose.web.dom.*

@Composable
@Page("/")
@Layout(".components.layouts.PageLayout")
fun CarsPage() {
    Div(attrs = {
        classes("container", "mt-5", "mb-md-4", "py-5")
    }) {
        Div(attrs = {
            classes("row")
        }) {
            PageContent()
            ProgressOfCompletion()
        }
    }
}

