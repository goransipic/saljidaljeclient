package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.layouts.PageLayoutData
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content


@InitRoute
fun initPasswordSecurityPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData(SidebarItems.PASSWORD_SECURITY))
}

@Composable
@Page("password-security")
@Layout(".components.layouts.AccountLayout")
fun PasswordSecurityPage() {
    Content(SidebarItems.PASSWORD_SECURITY)
}