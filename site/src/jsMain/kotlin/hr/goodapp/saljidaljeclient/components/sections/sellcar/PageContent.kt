package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
fun PageContent() {
    Div(attrs = {
        classes("col-lg-8")
    }) {
        Breadcrumbs()
        PageTitleWithProgress(
            title = "Sell car",
            progress = 70
        )
        BasicInfo()
        Price()
        VehicleInformation()
        FeaturesSection()
        PhotosVideo()
        Location()
        Contacts()
    }
}