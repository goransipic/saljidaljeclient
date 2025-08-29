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
fun initNotificationsPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData(SidebarItems.NOTIFICATION))
}

@Composable
@Page("notifications")
@Layout(".components.layouts.AccountLayout")
fun NotificationsPage() {
    Content(SidebarItems.NOTIFICATION)
}