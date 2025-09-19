package hr.goodapp.saljidaljeclient.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.main.*

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    HeroSearchSection()
    BodyTypeSelectionSection()
    TopOffersSection()
    BrandsSection()
    FeaturesSection()
    LatestCarsSection()
    CtaCarousel()
    MobileAppCta()
    LatestNewsSection()
    //BackToTop()
}
