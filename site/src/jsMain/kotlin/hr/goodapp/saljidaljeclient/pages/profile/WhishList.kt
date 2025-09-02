package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.layouts.AccountLayoutData
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content


@InitRoute
fun initWhishListPage(ctx: InitRouteContext) {
    ctx.data.add(AccountLayoutData(SidebarItems.WHISH_LIST))
}

@Composable
@Page("wish-list")
@Layout(".components.layouts.AccountLayout")
fun WhishlistPage() {
    Content(SidebarItems.WHISH_LIST)
}