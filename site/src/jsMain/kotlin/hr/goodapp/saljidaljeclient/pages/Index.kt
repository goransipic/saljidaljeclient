package hr.goodapp.saljidaljeclient.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.main.BodyTypeSelectionSection
import hr.goodapp.saljidaljeclient.components.sections.main.BrandsSection
import hr.goodapp.saljidaljeclient.components.sections.main.CtaCarousel
import hr.goodapp.saljidaljeclient.components.sections.main.FeaturesSection
import hr.goodapp.saljidaljeclient.components.sections.main.HeroSearchSection
import hr.goodapp.saljidaljeclient.components.sections.main.LatestCarsSection
import hr.goodapp.saljidaljeclient.components.sections.main.LatestNewsSection
import hr.goodapp.saljidaljeclient.components.sections.main.MobileAppCta
import hr.goodapp.saljidaljeclient.components.sections.main.NavbarBar
import hr.goodapp.saljidaljeclient.components.sections.main.SignInModal
import hr.goodapp.saljidaljeclient.components.sections.main.SignupModal
import hr.goodapp.saljidaljeclient.components.sections.main.TopOffersSection

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
}
