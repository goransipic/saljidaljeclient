package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.layouts.PageLayoutData
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems


@InitRoute
fun initReviewsPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData(SidebarItems.REVIEWS))
}

@Page("reviews")
@Layout(".components.layouts.AccountLayout")
@Composable
fun ReviewsPage() {
    Content(SidebarItems.REVIEWS)
}