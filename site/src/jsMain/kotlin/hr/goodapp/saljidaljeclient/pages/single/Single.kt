package hr.goodapp.saljidaljeclient.pages.single

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.single.BreadCrumb
import hr.goodapp.saljidaljeclient.components.sections.single.CarGallery
import hr.goodapp.saljidaljeclient.components.sections.single.CardWithIconBoxes
import hr.goodapp.saljidaljeclient.components.sections.single.Features
import hr.goodapp.saljidaljeclient.components.sections.single.RelatedPostsCarousel
import hr.goodapp.saljidaljeclient.components.sections.single.Seller
import hr.goodapp.saljidaljeclient.components.sections.single.SideBar
import hr.goodapp.saljidaljeclient.components.sections.single.Specs
import hr.goodapp.saljidaljeclient.components.sections.single.TitleAndSharing
import org.jetbrains.compose.web.dom.Div

@Composable
@Page("/")
@Layout(".components.layouts.PageLayout")
fun SinglePage()  {
    Div(attrs = {
        classes("container", "mt-5", "mb-md-4", "py-5")
    }) {
        BreadCrumb()
        TitleAndSharing()
        Div(attrs = {
            classes("row")
        }) {
            Div(attrs = {
                classes("col-md-7")
            }) {
                CarGallery()
                Specs()
                CardWithIconBoxes()
                Features()
                Seller()

            }
            Div(attrs = { classes("col-md-5", "pt-5","pt-md-0"); style { property("margin-top", "-6rem") } }) {
                SideBar()
            }
        }
        RelatedPostsCarousel()
    }
}